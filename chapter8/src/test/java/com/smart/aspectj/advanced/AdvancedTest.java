package com.smart.aspectj.advanced;

import com.smart.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;

public class AdvancedTest {

    @Test
	public void advance() {
		String configPath = "com/smart/aspectj/advanced/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Student naiveStudent = (Student) ctx.getBean("naiveStudent");
		Student naughtyStudent = (Student) ctx.getBean("naughtyStudent");
		naiveStudent.examine("math");
		naiveStudent.play("halo");
		naughtyStudent.examine("math");
		naughtyStudent.play("halo");
		
        //--通过joinPoint接口访问连接点上下文信息
//		naiveStudent.examine("John");
		
		//--绑定连接点参数
//		((NaiveStudent)naiveStudent).smile("John",2);
		
		//--绑定代理对象
		naiveStudent.examine("John");
		
		//--绑定类注解
//		((NaiveStudent)naiveStudent).examine("John");

		//绑定返回值
//		SmartSeller seller = (SmartSeller) ctx.getBean("seller");
//		seller.sell("Beer","John");	
		
		//绑定异常
//		SmartSeller seller = (SmartSeller) ctx.getBean("seller");
//		seller.checkBill(2);
//		seller.checkBill(1);
	}
}
