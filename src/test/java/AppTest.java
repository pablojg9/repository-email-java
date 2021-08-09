import org.junit.Test;
import send.email.EmailSend;

public class AppTest {

  @Test
    public void testEmail() {

      StringBuilder stringBuilder = new StringBuilder();

      stringBuilder.append("testando html");

        try {
            EmailSend emailSend = new EmailSend(
                    "pablodeveloper2@gmail.com",
                    "Pablo Junior",
                    "Projeto feito em java",
                    stringBuilder.toString());

            emailSend.sendEmail(true);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
