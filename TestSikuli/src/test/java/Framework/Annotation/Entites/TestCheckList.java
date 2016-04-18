package Framework.Annotation.Entites;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by paul.lorena on 18/04/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestCheckList {
    // 000 | 010 | 020
    public String Codes	() ;
    // Conexion | Version | Affichage
    public String Thèmes();
    // Se connecter | Se desconnecter
    public String Scenarios();
    // Test ciblé pour le
    public TypeClient typeClient ();
    public String prérequis();
    public String Chemin();
    public String Résultat_attendu();
    public String Exemple_dossiers();

    public enum TypeClient {
        UCM, AUTRESCLIENTS
    }

}
