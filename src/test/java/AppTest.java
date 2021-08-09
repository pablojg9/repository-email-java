import org.junit.Test;
import send.email.EmailSend;

public class AppTest {

  @Test
    public void testEmail() {

      StringBuilder stringBuilder = new StringBuilder();

      stringBuilder.append("<h1>Seja Bem-Vindo</h1><br/></br>");
      stringBuilder.append("<a target=\"_blank\" href=\"https://github.com/pablojg9\">MEU GITHUB</a>");

      stringBuilder.append("<p style=\"color: #ccc\">Um texto aparece aqui. Texto falando sobre <strong>JAVA</strong> onde a linguagem de " +
              "programação podemos fazer de tudo.</p>");


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
