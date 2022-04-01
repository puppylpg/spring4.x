package com.smart.resource;

import com.smart.ioc.GeLi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.Set;

public class EncodedResourceExample {

	/**
	 * Spring的各种{@link ResourceLoader}：
	 *
	 * 没有ClassPathResourceLoader。用的是{@link DefaultResourceLoader}，根据classpath的前缀，
	 * 通过{@link DefaultResourceLoader#getResource(String)}返回{@link ClassPathResource}。
	 * {@link ClassPathResource#getInputStream()}使用的是{@link sun.misc.Launcher.AppClassLoader#getResource(String)}去load的。
	 *
	 * {@link FileSystemResourceLoader}继承了{@link DefaultResourceLoader}，所以也能解析classpath前缀，
	 * 在解析不出之后，使用{@link FileSystemResourceLoader#getResourceByPath(String)}替换了
	 * {@link DefaultResourceLoader#getResourceByPath(String)}去解析为{@link ClassPathResource}的策略，转而解析为{@link FileSystemResource}。
	 * {@link FileSystemResource#getInputStream()}使用的是{@link FileInputStream#FileInputStream(File)}。
	 *
	 * 注意：如果有任何非classpath开头的前缀（比如file:），最终都会按照{@link UrlResource}去解析，但如果不注册，可能不识别该protocol。
	 * {@link UrlResource#getInputStream()}是去打开网络连接获取InputStream。
	 *
	 * 注意，{@link FileSystemResourceLoader}如果最终返回了{@link FileSystemResource}，只有两种resource路径能读成功：
	 * 1. 绝对路径，还得是双斜杠开头，这样被spring干掉一个之后还能剩一个；
	 * 2. 相对于当前vm工作目录的相对路径，即工程所在的文件夹（可以使用`System.getProperty("user.dir")`获得）。
	 *
	 * 所以说，相应的{@link ResourceLoader}和相应的{@link Resource}是类型关联的。
	 *
	 *
	 * {@link ClassPathXmlApplicationContext}和{@link FileSystemXmlApplicationContext}最终都先用{@link PathMatchingResourcePatternResolver}
	 * 去解析，发现不符合之后再用{@link DefaultResourceLoader}去解析。后者把file:前缀搞成了合法协议，所以成功返回了{@link UrlResource}。
	 * 参见：{@link org.springframework.beans.factory.support.AbstractBeanDefinitionReader#loadBeanDefinitions(String, Set)}
	 *
	 *
	 * {@link PathMatchingResourcePatternResolver}里面默认是{@link DefaultResourceLoader}，所以：
	 * {@link PathMatchingResourcePatternResolver#getResource(String)} <=> {@link DefaultResourceLoader#getResource(String)}
	 * {@link PathMatchingResourcePatternResolver#getResources(String)}才是发挥功能的新方法。
	 * 这个方法是{@link ResourcePatternResolver}引入的。
	 *
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {
		Resource res = new ClassPathResource("conf/file1.txt");
		Resource res1 = new ClassPathResource("classpath:com/smart/resource/filexxx.txt");
		Resource res2 = new ClassPathResource("file:conf/file1.txt");
		Resource res3 = new ClassPathResource("classpath*:conf/file1.txt");
		Resource res4 = new ClassPathResource("/conf/file1.txt");
		Resource res5 = new ClassPathResource("conf///../../file1.txt");
		Resource res6 = new ClassPathResource("/classpath://conf/file1.txt");

		// 使用的是DefaultResourceLoader
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource r = resolver.getResource("conf/file1.txt");
		System.out.println(FileCopyUtils.copyToString(new InputStreamReader(r.getInputStream())));
		EncodedResource encRes = new EncodedResource(r, "UTF-8");
		String content = FileCopyUtils.copyToString(encRes.getReader());
		System.out.println(content);

		ResourceLoader fileLoader = new FileSystemResourceLoader();
		// UrlResource 只能是http之类的
//        Resource fileResource = fileLoader.getResource("file:conf/file1.txt");
		// FileSystemResource: java.io.FileNotFoundException: conf/file1.txt (没有那个文件或目录)
//        Resource fileResource = fileLoader.getResource("conf/file1.txt");
		// 这个也是可以的，毕竟FileSystemResourceLoader继承了DefaultResourceLoader
//        Resource fileResource = fileLoader.getResource("classpath:conf/file1.txt");
		// 这个也不行，因为开头的/被删了。。。所以绝对路径被修改了。。。
//        Resource fileResource = fileLoader.getResource("//home/pichu/Codes/Java/others/Spring4.x/chapter4/src/main/resources/conf/file1.txt");
		// 阔以
//        Resource fileResource = fileLoader.getResource("//home/pichu/Codes/Java/others/Spring4.x/chapter4/src/main/resources/conf/file1.txt");
		// 阔以
//        Resource fileResource = fileLoader.getResource("src/main/resources/conf/file1.txt");
		Resource fileResource = fileLoader.getResource("target/classes/conf/file1.txt");
		System.out.println(System.getProperty("user.dir"));
		System.out.println(FileCopyUtils.copyToString(new InputStreamReader(fileResource.getInputStream())));


//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:moAttack.xml");
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("file:target/classes/moAttack.xml");
		GeLi geLi = applicationContext.getBean(GeLi.class);
		System.out.println(geLi);

	}

}
