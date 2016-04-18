import Framework.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.sikuli.script.Screen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUITestServiceProviderUnitTest0001 extends TestProviderBase {

    public GUITestServiceProviderUnitTest0001()
    {
        s = new Screen();
        guiTest = new GUITestServiceProvider(s, "C:\\Orion\\TestSikuli\\src\\test\\US001", "C:\\Failed\\");

    }

    @Test
    public void testPourVerifierViaReflexionAnnotation000() throws Exception {

            super.HandleException(s, this, new Exception());

    }


}