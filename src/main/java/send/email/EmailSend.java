package send.email;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import java.util.Properties;

public class EmailSend {
    private static final String USER = "pablodeveloper2@gmail.com";
    private static final String PASSWORD = "";

    private String listDestinatarios = "";
    private String nameRemetente = "";
    private String assuntoEmail = "";
    private String textoEmail = "";

    public EmailSend(String listDestinatarios, String nameRemetente, String assuntoEmail, String textoEmail) {
        this.listDestinatarios = listDestinatarios;
        this.nameRemetente = nameRemetente;
        this.assuntoEmail = assuntoEmail;
        this.textoEmail = textoEmail;
    }

    public void sendEmail() {
        try{
            Properties properties = new Properties();

            properties.put("mail.smtp.ssl.trust", "*"); //Autenticar ssl
            properties.put("mail.smtp.auth", "true"); //Autorização
            properties.put("mail.smtp.starttls", "true"); // Autenticação
            properties.put("mail.smtp.host", "smtp.gmail.com"); //Servidor gmail Google
            properties.put("mail.smtp.port", "465"); // Porta do servidor
            properties.put("mail.smtp.socketFactory.port", "465"); // Espeficifa a porta do Socket
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // Classe do Socket de conexão ao SMTP.

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USER, PASSWORD);
                }
            });

            Address[] toUser = InternetAddress.parse(listDestinatarios);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USER, nameRemetente));
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assuntoEmail);
            message.setText(textoEmail);

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
