import org.junit.Test;

import java.util.Properties;

public class AppTest {

    @Test
    public void testEmail() {

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true"); //Autorização
        properties.put("mail.smtp.starttls", "true"); // Autenticação
        properties.put("mail.smtp.host", "stmp.gmail.com"); //Servidor gmail Google
        properties.put("mail.smtp.port", "465"); // Porta do servidor
        properties.put("mail.smtp.socketFactory.port", "465");



    }
}
