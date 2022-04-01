package com.smart.aspectj.function;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smart.NaughtyStudent;
import com.smart.Student;
import org.testng.annotations.*;
public class PointcutFunTest {

	@Test
	public void pointcut(){
		String configPath = "com/smart/aspectj/fun/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Student naiveStudent = (Student) ctx.getBean("naiveStudent");
		Student naughtyStudent = (Student) ctx.getBean("naughtyStudent");
		naiveStudent.examine("math");
		naiveStudent.play("halo");
		naughtyStudent.examine("math");
		naughtyStudent.play("halo");
		((NaughtyStudent) naughtyStudent).joke("Microsoft", 1);

		
		//-----@args test------//
//		StudentManager wm = (StudentManager)ctx.getBean("waiterManager");
//		NaiveStudent waiter3 = new NaiveStudent();
//		NaiveStudent waiter4 = (NaiveStudent) ctx.getBean("naiveStudent");
//		NaiveStudent waiter5 = new NaiveChildWaiter();
//		wm.addNaiveStudent(waiter3);
//		wm.addStudent(waiter4);
//		wm.addNaiveStudent(waiter5);
		
		//---------@within()------------//
//		naughtyStudent.examine("Tom");
//		((NaughtyStudent)naughtyStudent).joke("Tom", 1);
//		naiveStudent.examine("John");
//		((NaiveStudent)naiveStudent).smile("John",2);

		//--------在引入Seller接口增强时，使用this() --------//
//		naiveStudent.examine("John");
//		naiveStudent.play("John");
//		((Seller)naiveStudent).sell("Beer", "John");
		
	}
}
