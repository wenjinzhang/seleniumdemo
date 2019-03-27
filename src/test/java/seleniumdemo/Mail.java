package seleniumdemo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {
    private String host;
    private String from;
    private String to;
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private String username="wenjinzhang0421@gmail.com";
    private String password="jinshao320";

    public Mail() {

    }

    public Mail(String host, String from, String to) {
        this.from = from;
        this.to = to;
    }

    public boolean sendEmail(){
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject("Hello shicai");
            message.setText("Hello shicai你最美");
            Transport.send(message);
            System.out.println("Sent message successfully....");
            return true;
        }catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }

    }


    public static void main(String args[]){
            Mail mail = new Mail("smtp.gmail.com", "wenjinzhang0421@gmail.com", "shicaifan412@gmail.com");
            mail.sendEmail();

    }

}
