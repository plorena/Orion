import org.omg.CORBA.Object;
import org.sikuli.script.Screen;

/**
 * Created by paul.lorena on 18/04/2016.
 */
public class TOTO {

    GUITestServiceProvider guiTest;
    Screen s;

    public void HandleException(String methodName, TOTO obj)
    {
        String strMethod = obj.getClass().getEnclosingMethod().getName();
        guiTest.CaptureScreenException(s, getClass(), methodName, new Exception(){} );
    }
}
