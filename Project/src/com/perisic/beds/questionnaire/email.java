package com.perisic.beds.questionnaire;

//import java.net.PasswordAuthentication;
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.swing.JOptionPane;
//
//public class email {

//	public static void main(String[] args) {
//		
//	
//	 Properties props = new Properties();
//     props.put("mail.smtp.host","smtp.gmail.com");
//     props.put("mail.smtp.socketFactory.port", "465");
//     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//     props.put("mail.smtp.auth", "true");
//     props.put("mail.smtp.port", "465");
//     
//     Session session=Session.getDefaultInstance(props,
//             
//             new javax.mail.Authenticator(){
//                 protected PasswordAuthentication getPasswordAuthentication(){
//                     return new PasswordAuthentication("questionnaire@gmail.com", "que123");
//                 }
//             }
//             
//             );
//     
//     try{
//         Message message= new MimeMessage(session);
//         message.setFrom(new InternetAddress("questionnaire@gmail.com"));
//         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email_tb.getText()));
//         message.setSubject("Questionnaire");
//         message.setText(prnt.getText());
//         Transport.send(message);
//         JOptionPane.showMessageDialog(null, "e-mail sent Succesfully");
//     }
//     catch(Exception e){
//         JOptionPane.showMessageDialog(null, e);
//     }
// }
	import javax.mail.*;
	import javax.mail.internet.*;
	import java.util.*;

	public class email {

	   final String senderEmailID = "imandissanayake@gmail.com";
	final String senderPassword = "19981102Flash";
	final String emailSMTPserver = "smtp.gmail.com";
	final String emailServerPort = "465";
	String receiverEmailID = null;
	static String emailSubject = "Questionnaire Report";
	static String emailBody = ":)";

	//public SendEmail(){}

	  public void SendEmail(){
	   
	  // Receiver Email Address
	  this.receiverEmailID="imannowitzki@gmail.com";
	  // Subject
	  this.emailSubject="Questionnaire Report";
	  // Body
	  this.emailBody=":)";
	  Properties props = new Properties();
	  props.put("mail.smtp.user",senderEmailID);
	  props.put("mail.smtp.host", emailSMTPserver);
	  props.put("mail.smtp.port", emailServerPort);
	  props.put("mail.smtp.starttls.enable", "true");
	  props.put("mail.smtp.auth", "true");
	  props.put("mail.smtp.socketFactory.port", emailServerPort);
	  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	  props.put("mail.smtp.socketFactory.fallback", "false");
	  SecurityManager security = System.getSecurityManager();
	  try {                
		  
	  Authenticator auth = new SMTPAuthenticator();
	  Session session = Session.getInstance(props, auth);
	  MimeMessage msg = new MimeMessage(session);
	  Multipart emailContent = new MimeMultipart();
	  MimeBodyPart textBodyPart = new MimeBodyPart();
	  textBodyPart.setText("My multipart text");
	  msg.setText(emailBody);
	  msg.setSubject(emailSubject);
	  msg.setFrom(new InternetAddress(senderEmailID));
	  msg.addRecipient(Message.RecipientType.TO,
	  new InternetAddress(receiverEmailID));
	  MimeBodyPart pdfAttachment = new MimeBodyPart();
		pdfAttachment.attachFile("F:\\test.pdf");
		
		//Attach body parts
		emailContent.addBodyPart(textBodyPart);
		
		emailContent.addBodyPart(pdfAttachment);
	  Transport.send(msg);
	  System.out.println("Message send Successfully:)"); }
	  
	  catch (Exception mex){
	  mex.printStackTrace();
	  } 
	  }
	  public class SMTPAuthenticator extends javax.mail.Authenticator
	  {
	  public PasswordAuthentication getPasswordAuthentication()
	  {
	  return new PasswordAuthentication(senderEmailID, senderPassword);
	  }
	  }
	     }

