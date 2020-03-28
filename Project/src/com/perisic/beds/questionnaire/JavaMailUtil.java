package com.perisic.beds.questionnaire;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMailUtil {

	public static void sendMail(String recepient) throws Exception{
		
		Properties props = new Properties();
		
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
//		String myAccountEmail = "postmaster.wedevelop@gmail.com";
//		String password = "vmlwkkvaogkplvgl";
		String myAccountEmail = "imandissanayake12@gmail.com";
		String password = "19981102Flash";
		
		Session session = Session.getInstance(props,new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});
		 Multipart emailContent = new MimeMultipart();
		 MimeBodyPart pdfAttachment = new MimeBodyPart();
		 MimeBodyPart textBodyPart = new MimeBodyPart();
		  
		    textBodyPart.setText("My multipart text");
			pdfAttachment.attachFile("E:\test.pdf");
			
			emailContent.addBodyPart(pdfAttachment);
			emailContent.addBodyPart(textBodyPart);
			
		
		Message message = prepareMessage(session,myAccountEmail, recepient);
		Transport.send(message);
		System.out.println("Message sent successfully");
	}

	private static Message prepareMessage(Session session,String myAccountEmail,String recepient) {
		// TODO Auto-generated method stub
		try{
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(myAccountEmail));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
		message.setSubject("Test");
		message.setText("Hey");
		 
		Multipart emailContent = new MimeMultipart();
		 
		MimeBodyPart textBodyPart = new MimeBodyPart();
		  
		    textBodyPart.setText("My multipart text");
		
			String filename = "E:\\test.pdf";
			DataSource source = new FileDataSource(filename);
			textBodyPart.setDataHandler(new DataHandler(source));
			textBodyPart.setFileName(filename);
			
			
			emailContent.addBodyPart(textBodyPart);
			message.setContent(emailContent);
			return message;
			
		}catch(Exception e){
			System.out.println("Fail");
		}
		return null;
	}
	
	
}
