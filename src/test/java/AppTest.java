import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AppTest {

    private final String user = "pablodeveloper2@gmail.com";
    private final String password = "arma1234";

    @Test
    public void testEmail() {
        try {
            Properties properties = new Properties();

            properties.put("mail.smtp.auth", "true"); //Autorização
            properties.put("mail.smtp.starttls", "true"); // Autenticação
            properties.put("mail.smtp.host", "stmp.gmail.com"); //Servidor gmail Google
            properties.put("mail.smtp.port", "465"); // Porta do servidor
            properties.put("mail.smtp.socketFactory.port", "465"); // Espeficifa a porta do Socket
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // Classe do Socket de conexão ao SMTP.

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });

            Address[] toUser = InternetAddress.parse("pablodeveloper2@gmail.com");

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(user));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
