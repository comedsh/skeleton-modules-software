package com.fenghua.auto.backend.core.utills.mail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 简单邮件（不带附件的邮件）发送器
 */
public class SimpleMailSender {
	//定义邮件的一些全局属性
	public static String mailServerHost;
	public static String mailServerPort;
	public static String userName;
	public static String password;
	public static String fromAddress;
	public static String toAddress;
	public static boolean validate;
	
	static{		
		Properties p = new Properties();
		mailServerHost = p.getProperty("auto007.smtp.host");
		mailServerPort = p.getProperty("auto007.smtp.port");
		userName = p.getProperty("auto007.mail.sender");
		password = p.getProperty("auto007.mail.pwd");
		fromAddress = p.getProperty("auto007.mail.sender");
		validate = true;
	}
	/**
	 * 无CC的service
	 * @param toAddress
	 * @param subject
	 * @param content
	 * @return
	 * @throws MessagingException
	 */
	public static boolean sendHtmlMail(String toAddress, String subject, String content) throws MessagingException {
		
		// 判断是否需要身份认证
		MailAuthenticator authenticator = null;
		// 如果需要身份认证，则创建一个密码验证器
		if (validate) {
			authenticator = new MailAuthenticator(userName,password);
		}
		Properties p = new Properties();
		p.put("mail.smtp.host", SimpleMailSender.mailServerHost);
		p.put("mail.smtp.port", SimpleMailSender.mailServerPort);
		p.put("mail.smtp.auth", validate ? "true" : "false");
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getInstance(p, authenticator);
		
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(SimpleMailSender.fromAddress);
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			if(toAddress!=null){
				// 创建邮件的接收者地址，并设置到邮件消息中
				Address to = new InternetAddress(toAddress);
				// Message.RecipientType.TO属性表示接收者的类型为TO
				mailMessage.setRecipient(Message.RecipientType.TO, to);
			}
			// 设置邮件消息的主题
			mailMessage.setSubject(subject);
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());

			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容
			html.setContent(content, "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			mailMessage.saveChanges();
			// 发送邮件
			Transport.send(mailMessage);
			//Transport.send(mailMessage, mailInfo.getUserName(),mailInfo.getPassword());
			return true;
		} catch (MessagingException ex) {
			throw ex;
		}
	}
	/**
	 * 有CC的service
	 * @param addrArray
	 * @param toAddress
	 * @param subject
	 * @param content
	 * @return
	 * @throws MessagingException
	 */
	public static boolean sendHtmlMail(Address[] addrArray, String toAddress, String subject, String content) throws MessagingException {
		
		// 判断是否需要身份认证
		MailAuthenticator authenticator = null;
		// 如果需要身份认证，则创建一个密码验证器
		if (validate) {
			authenticator = new MailAuthenticator(userName,password);
		}
		Properties p = new Properties();
		p.put("mail.smtp.host", SimpleMailSender.mailServerHost);
		p.put("mail.smtp.port", SimpleMailSender.mailServerPort);
		p.put("mail.smtp.auth", validate ? "true" : "false");
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getInstance(p, authenticator);
		
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(fromAddress);
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			if(toAddress!=null){
				// 创建邮件的接收者地址，并设置到邮件消息中
				Address to = new InternetAddress(toAddress);
				// Message.RecipientType.TO属性表示接收者的类型为TO
				mailMessage.setRecipient(Message.RecipientType.TO, to);
			}
			if (addrArray.length > 0) {
				mailMessage.setRecipients(Message.RecipientType.CC, addrArray);
			}
			// 设置邮件消息的主题
			mailMessage.setSubject(subject);
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容
			html.setContent(content, "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			mailMessage.saveChanges();
			// 发送邮件
			Transport.send(mailMessage);
			//Transport.send(mailMessage, mailInfo.getUserName(),mailInfo.getPassword());
			return true;
		} catch (MessagingException ex) {
			throw ex;
		}
	}

	/**
	 * 以文本格式发送邮件
	 * 
	 * @param mailInfo
	 *            待发送的邮件的信息
	 * @throws MessagingException 
	 */
	public static boolean sendTextMail(MailSenderInfo mailInfo) throws MessagingException {
		// 判断是否需要身份认证
		MailAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// 如果需要身份认证，则创建一个密码验证器
			authenticator = new MailAuthenticator(mailInfo.getUserName(),mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(mailInfo.getToAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// 设置邮件消息的主要内容
			String mailContent = mailInfo.getContent();
			mailMessage.setText(mailContent);
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			throw ex;
		}
	}
	/**
	 * 以HTML格式发送邮件
	 * 
	 * @param mailInfo
	 *            待发送的邮件信息
	 * @throws MessagingException 
	 */
	public static boolean sendHtmlMail(MailSenderInfo mailInfo) throws MessagingException {
		// 判断是否需要身份认证
		MailAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		// 如果需要身份认证，则创建一个密码验证器
		if (mailInfo.isValidate()) {
			authenticator = new MailAuthenticator(mailInfo.getUserName(),mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getInstance(pro, authenticator);
		
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			if(mailInfo.getToAddress()!=null){
				// 创建邮件的接收者地址，并设置到邮件消息中
				Address to = new InternetAddress(mailInfo.getToAddress());
				// Message.RecipientType.TO属性表示接收者的类型为TO
				mailMessage.setRecipient(Message.RecipientType.TO, to);
			}
			
			mailMessage.setRecipients(Message.RecipientType.CC, mailInfo.getCcList());
			mailMessage.setRecipients(Message.RecipientType.BCC, mailInfo.getBccList());
			
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());

			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容
			html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);

			// 设置信件的附件(用本地上的文件作为附件)
			if(mailInfo.getAttachFileNames() != null){
				for(String file: mailInfo.getAttachFileNames()){
					html = new MimeBodyPart();
					FileDataSource fds = new FileDataSource(file);
					DataHandler dh = new DataHandler(fds);
					html.setFileName(file.substring(file.lastIndexOf("/")+1));
					html.setDataHandler(dh);
					mainPart.addBodyPart(html);
				}
			}

			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			mailMessage.saveChanges();

			// 发送邮件
			Transport.send(mailMessage);
			//Transport.send(mailMessage, mailInfo.getUserName(),mailInfo.getPassword());
			return true;
		} catch (MessagingException ex) {
			throw ex;
		}
	}
}