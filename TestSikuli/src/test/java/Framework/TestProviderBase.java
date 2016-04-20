package Framework;

import Framework.Annotation.Entites.Jira;
import Framework.Annotation.Entites.TestCheckList;
import Framework.Annotation.Entites.UserStoryInfo;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static java.lang.Thread.*;

/**
 * Created by paul.lorena on 18/04/2016.
 */
public class TestProviderBase {

    // Handle the exception and generate an output with the screenshot and the Test Metadata
    public String getMetaTestData(String nomDeMethode) throws NoSuchMethodException {

        String message = "";

        Class<?> c = this.getClass();

        // Process @Framework.Annotation.Entites.UserStoryInfo
        if (c.isAnnotationPresent(UserStoryInfo.class)) {
            Annotation annotation = c.getAnnotation(UserStoryInfo.class);
            UserStoryInfo testerInfo = (UserStoryInfo) annotation;
            message = message + " Priorité : " + testerInfo.priority();
            message = message + " Sprint # : " + testerInfo.sprint();
        }


        Method method = c.getMethod(nomDeMethode);

        // Process @Framework.Annotation.Entites.Jira
        if(method.isAnnotationPresent(Jira.class)) {
            Jira jira = method.getAnnotation(Jira.class);
            message = message + " Ticket(s) Jira : " + jira.Ticket();
        }

        // Process @TestCheckList
        if (method.isAnnotationPresent(TestCheckList.class)) {
            Annotation annotation = method.getAnnotation(TestCheckList.class);
            TestCheckList info = (TestCheckList) annotation;
            message = message + " Codes : " + info.Codes();
            message = message + " Thèmes : " + info.Thèmes();
            message = message + " Scenarios : " + info.Scenarios();
            message = message + " Prérequis : " + info.prérequis();
            message = message + " Chemin : " + info.Chemin();
            message = message + " Résultat_attendu : " + info.Résultat_attendu();
            message = message + " Exemple_dossiers : " + info.Exemple_dossiers();
        }


        return message;
    }

// Handle the exception and generate an output with the screenshot and the Test Metadata
    public void HandleException(Screen screen, GUITestServiceProvider gui, Exception e)
    {

       String strMethod = currentThread().getStackTrace()[2].getMethodName();


        String metaDataTestInfo ="";
        try {
             metaDataTestInfo = getMetaTestData(strMethod);
        } catch (NoSuchMethodException e1) {
             metaDataTestInfo = "Impossible de recupérer meta test data. Détail erreur : " + e.getMessage();
        }

        gui.CaptureScreenException(screen,  metaDataTestInfo,  e );
    }

}
