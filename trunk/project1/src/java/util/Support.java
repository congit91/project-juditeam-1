/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Admin
 */
public class Support {

    public static void sendFeedBackMail(String email, String fullName, String title, String content) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(util.Constants.FROM_EMAIL, util.Constants.PASSWORD_EMAIL);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(util.Constants.FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(util.Constants.TO_EMAIL));
            String subject = "Phản hồi từ người dùng.";
            message.setSubject(subject);
            String contents = "Họ và tên: " + fullName
                    + "\nEmail: " + email
                    + "\nTiêu đề: " + title
                    + "\nNội dung" + content;
            message.setContent(contents, "text/html; charset=UTF-8");
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
