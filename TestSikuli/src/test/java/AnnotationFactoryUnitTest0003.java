import Framework.Annotation.Entites.Jira;
import Framework.Annotation.Entites.UserStoryInfo;
import Framework.TestProviderBase;
import org.junit.Test;

/**
 * Created by paul.lorena on 18/04/2016.
 */
@UserStoryInfo(sprint = "87", priority = UserStoryInfo.Priority.HIGH)
public class AnnotationFactoryUnitTest0003 {

    @Test
    @Jira(Ticket="FORMATECH-12345; FORMATECH-18078")
    public void testMethodAnnotationFactory0001() throws Exception {

        TestProviderBase annotationFactory = new TestProviderBase();
        String str = annotationFactory.getMetaTestData("testMethodAnnotationFactory0001");
        org.junit.Assert.assertEquals("FORMATECH-12345; FORMATECH-18078 Priorité : HIGH Sprint # : 87" , str);
    }

    @Test
    public void testMethodAnnotationFactory0002() throws Exception {

        TestProviderBase annotationFactory = new TestProviderBase();
        String str = annotationFactory.getMetaTestData("testMethodAnnotationFactory0002");
        org.junit.Assert.assertEquals(" Priorité : HIGH Sprint # : 87" , str);
    }
}
