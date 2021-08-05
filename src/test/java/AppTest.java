import org.junit.Test;
import send.email.EmailSend;

public class AppTest {

  @Test
    public void testEmail() {
        try {
            EmailSend emailSend = new EmailSend(
                    "pablodeveloper2@gmail.com",
                    "Pablo Junior",
                    "Projeto feito em java",
                    "Projeto feito em java com dependencia em javax mail developer pablo junior ");

            emailSend.sendEmail();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
