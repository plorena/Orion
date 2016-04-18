package Framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by paul.lorena on 18/04/2016.
 */
public class AnnotationFactory
{
    public String getInfo(Class<?> classe, String nameOfTest) throws java.lang.Exception {

        String message = "";

        Method method = classe.getMethod(nameOfTest);

        // Process @Framework.Jira
        if(method.isAnnotationPresent(Jira.class)) {
            Jira jira = method.getAnnotation(Jira.class);
            message = message + jira.Ticket();
        }

        // Process @Framework.UserStoryInfo
        if (classe.isAnnotationPresent(UserStoryInfo.class)) {
            Annotation annotation = classe.getAnnotation(UserStoryInfo.class);
            UserStoryInfo testerInfo = (UserStoryInfo) annotation;
            message = message + " Priorité : " + testerInfo.priority();
            message = message + " Sprint # : " + testerInfo.sprint();
        }


        return message;
    }

}
