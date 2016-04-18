import Framework.Annotation.AnnotationFactory;
import Framework.Annotation.Entites.Jira;
import Framework.Annotation.Entites.UserStoryInfo;
import org.junit.Test;

/**
 * Created by paul.lorena on 18/04/2016.
 */
@UserStoryInfo(sprint = "87", priority = UserStoryInfo.Priority.HIGH)
public class AnnotationFactoryUnitTest0003 {

    @Test
    @Jira(Ticket="FORMATECH-12345; FORMATECH-18078")
    public void testMethodAnnotationFactory0001() throws Exception {

        AnnotationFactory annotationFactory = new AnnotationFactory();
        String str = annotationFactory.getInfo(getClass(), "testMethodAnnotationFactory0001");
        org.junit.Assert.assertEquals("FORMATECH-12345; FORMATECH-18078 Priorité : HIGH Sprint # : 87" , str);
    }

    @Test
    public void testMethodAnnotationFactory0002() throws Exception {

        AnnotationFactory annotationFactory = new AnnotationFactory();
        String str = annotationFactory.getInfo(getClass(), "testMethodAnnotationFactory0002");
        org.junit.Assert.assertEquals(" Priorité : HIGH Sprint # : 87" , str);
    }
}
