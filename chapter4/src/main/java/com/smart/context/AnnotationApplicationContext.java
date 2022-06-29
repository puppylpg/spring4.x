package com.smart.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.smart.Car;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApplicationContext {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);


		/**
		 * 那些{@link org.springframework.beans.factory.config.BeanPostProcessor}等得被声明为bean
		 * 然后就不用再有注册他们到容器的动作了。
		 *
		 * 而{@link org.springframework.beans.factory.BeanFactory}必须有手动add bean post processor的调用动作
		 */
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/context/beans.xml");
		Car car =ctx.getBean("car",Car.class);
	}
}
