package service;

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
    public static void sendEmail() throws MessagingException {
        final Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.ym.163.com");
        props.put("mail.user", "yuheng.du@jumacc.com");
        props.put("mail.password", "dyh1990");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
        Session mailSession = Session.getInstance(props, authenticator);
        // �����ʼ���Ϣ
        MimeMessage message = new MimeMessage(mailSession);
        // ���÷�����
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);

        // �����ռ���
        InternetAddress to = new InternetAddress("d380896882@gmail.com");
        message.setRecipient(RecipientType.TO, to);

        // ���ó���
//        InternetAddress cc = new InternetAddress("luo_aaaaa@yeah.net");
//        message.setRecipient(RecipientType.CC, cc);

//        // �������ͣ��������ռ��˲��ܿ������͵��ʼ���ַ
//        InternetAddress bcc = new InternetAddress("aaaaa@163.com");
//        message.setRecipient(RecipientType.CC, bcc);

        // �����ʼ�����
        message.setSubject("�����ʼ�");

        // �����ʼ���������
        message.setContent("<a href='http://www.fkjava.org'>���Ե�HTML�ʼ�</a>", "text/html;charset=UTF-8");

        // �����ʼ�
        Transport.send(message);
    }
}
