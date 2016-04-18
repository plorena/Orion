package Framework.Annotation.Entites;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Jira {

    //Ticket(s) JIRA : "FORMATECH-18012 ; FORMATECH-184748"
    public String Ticket() ;


}