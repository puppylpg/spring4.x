package com.smart.event;

import org.springframework.context.ApplicationListener;

public class MailSendListener implements ApplicationListener<MailSendEvent>{

	public void onApplicationEvent(MailSendEvent event) {
		System.out.println("MailSendListener:事件来自" + event.getSource());
		System.out.println("MailSendListener:向" + event.getTo() + "发送完一封邮件");
	}
}
