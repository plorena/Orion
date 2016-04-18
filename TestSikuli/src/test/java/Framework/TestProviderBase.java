package Framework;

import org.sikuli.script.Screen;

import static java.lang.Thread.*;

/**
 * Created by paul.lorena on 18/04/2016.
 */
public abstract class TestProviderBase {

    public GUITestServiceProvider guiTest;
    public Screen s;


    public void HandleException(Screen screen, TestProviderBase testProviderBase, Exception e)
    {
       String strMethod = currentThread().getStackTrace()[2].getMethodName();
        guiTest.CaptureScreenException(screen, getClass(), strMethod, e );
    }
}
