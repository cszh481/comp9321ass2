package service;

import dto.User;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by icmonkeypc on 2015/10/2.
 */
public class SendEmail {
    public static void sendEmail(String toAddress, String title, String Content) throws MessagingException {
        final Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.user", "a781796392@hotmail.com");
        props.put("mail.password", "COMP_1992");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        Session mailSession = Session.getInstance(props, authenticator);
        MimeMessage message = new MimeMessage(mailSession);
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);
        InternetAddress to = new InternetAddress(toAddress);
        message.setRecipient(RecipientType.TO, to);
        message.setSubject(title);
        message.setContent(Content, "text/html;charset=UTF-8");
        Transport.send(message);
    }
    public static void sendRegistMail(User user) throws MessagingException {
        String to = user.getEmail();
        String title = "Verify account";
        String content = "<p>\n" +
                "Hi, Dear "+user.getUsername()+"!\n" +
                "<br>\n" +
                "</br>\n" +
                "Help us secure your account by verifying your email \n" +
                "<a href=\"http://localhost:8080/control?uuid="+ user.getUuid() +"&action=verify"+"\" target=\"_top\">http://localhost:8080/emailConfim.jsp?uuid="+ user.getUuid() +"&action=verify</a>\n" +
                "</p>";
        sendEmail(to,title,content);
    }
    public static void sendSellMail(User user) throws MessagingException {
        String to = user.getEmail();
        String title = "New Order!!";
        String content = "<p>\n" +
                "Congratulation, Sir!\n" +
                "<br>\n" +
                "</br>\n" +
                "</p>";
        sendEmail(to,title,content);
    }
}
