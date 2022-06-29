package com.smart.context;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smart.Car;

@Configuration
public class Beans {

	@Bean(name = "car")
	public Car buildCar(@Qualifier("brand") String brand) {
		Car car = new Car();
		car.setBrand(brand);
		car.setMaxSpeed(200);
		return car;
	}

	@Bean(name = "brand")
	public String brand() {
		return "红旗CA72";
	}

	@Bean(name = "myBeanPostProcessor")
	public BeanPostProcessor beanPostProcessor() {
		return new MyBeanPostProcessor();
	}

	@Bean(name = "myBeanFactoryPostProcessor")
	public BeanFactoryPostProcessor beanFactoryPostProcessor() {
		return new MyBeanFactoryPostProcessor();
	}
}
