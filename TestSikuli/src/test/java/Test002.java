

import Framework.GUITestServiceProvider;
import Framework.Jira;
import Framework.TestProviderBase;
import Framework.UserStoryInfo;
import org.junit.Test;
import org.sikuli.script.Screen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@UserStoryInfo(sprint = "87", priority = UserStoryInfo.Priority.HIGH)
public class Test002 extends TestProviderBase {



    public Test002()
    {
        s = new Screen();
        guiTest = new GUITestServiceProvider(s, "C:\\Orion\\TestSikuli\\src\\test\\US001", "C:\\Failed\\");

    }

    @Test
    @Jira(Ticket="FORMATECH-1111; FORMATECH-2222")
    public void testPourVerifierViaReflexionAnnotation000() throws Exception {

        try
        {
            super.HandleException(s, this, new Exception());
        }
        catch(Exception e)
        {
            guiTest.CaptureScreenException(s, getClass(), "ddddd", e);

        }
        finally {

        }
    }

}