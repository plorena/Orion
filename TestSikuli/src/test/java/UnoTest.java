
import org.junit.Test;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@UserStoryInfo(sprint = "87", priority = UserStoryInfo.Priority.HIGH)
public class UnoTest extends TOTO {



    public UnoTest()
    {
        s = new Screen();
        guiTest = new GUITestServiceProvider(s, "C:\\root\\TestSikuli\\src\\test\\US001", "C:\\Failed\\");
    }

    @Test
    @Jira(Ticket="FORMATECH-1111; FORMATECH-2222")
    public void t() throws Exception {

        try
        {
            String nameMEthod =  new Object(){}.getClass().getEnclosingMethod().getName();
           // guiTest.CaptureScreenException(s, getClass(), nameMEthod, new Exception());
        super.HandleException(nameMEthod, this);
        }
        catch(Exception e)
        {
            guiTest.CaptureScreenException(s, getClass(), "ddddd", e);

        }
        finally {

        }
    }

    @Test
    public void test001()
    {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
        Date date = new Date();
        String dateTimeval = dateFormat.format(date);
    }

}