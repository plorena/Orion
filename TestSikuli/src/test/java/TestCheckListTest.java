
import Framework.Annotation.Entites.TestCheckList;
import Framework.GUITestServiceProvider;
import Framework.Annotation.Entites.Jira;
import Framework.TestProviderBase;
import Framework.Annotation.Entites.UserStoryInfo;
import org.junit.Test;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

@UserStoryInfo(sprint = "N/A", priority = UserStoryInfo.Priority.MEDIUM)
public class TestCheckListTest extends TestProviderBase {


    GUITestServiceProvider gui;
    Screen screen;

    public TestCheckListTest()
    {
         screen = new Screen();
         gui = new GUITestServiceProvider(screen, "C:\\Orion\\TestSikuli\\src\\test\\US001", "C:\\Failed\\");
    }



    @Test
    @TestCheckList(Codes = "000",
            Thèmes = "Connexion  000-01 | Connexion 000-02",
            Scenarios = "Se connecter | Se déconnecter",
            typeClient = TestCheckList.TypeClient.UCM,
            prérequis = "Utilisateur/pw",
            Chemin = "clic sur icône de connextion",
            Résultat_attendu = "l'application s'ouvre | l'application se ferme")
    public void Connexion_000() {
        Screen s = new Screen();
        try
        {
            gui.Login();
            gui.Logout();
        }
        catch(Exception e)
        {
            super.HandleException(screen, gui, e);
        }
    }



    @Test
    @TestCheckList(Codes = "010",
            Thèmes = "Version 010-01",
            Scenarios = "Version de l''aplication",
            typeClient = TestCheckList.TypeClient.UCM,
            Chemin = "Système > CD > Version du système",
            Résultat_attendu = "Le PDF s'ouvre et le numéro de version est celui de la version testée")
    public void Version010_01() {

        Screen s = new Screen();

        try
        {
            gui.Login();
            s.click(gui.img("item_systeme"));
            s.rightClick(gui.img("item_systeme"));
            s.wait(gui.img("submenu_systeme"));
            s.click(gui.img("version_systeme"));
            s.exists(gui.img("version_3846"), 10);
            gui.FermerFenetre();
            gui.Logout();
        }
        catch(Exception e)
        {
            super.HandleException(screen, gui, e);
        }
    }


    @Test
    @TestCheckList(Codes = "010",
            Thèmes = "Version 010-01",
            Scenarios = "Version de l''aplication",
            typeClient = TestCheckList.TypeClient.UCM,
            Chemin = "Menu>onglet \"aide\">A propos de>Feature details> ",
            Résultat_attendu = "La version du Front est celle de la version testée si le Front a été mis à jour")
    public void Version010_02() {

        Screen s = new Screen();

        try
        {
            gui.Login();
            s.click(gui.img("item_systeme"));
            s.rightClick(gui.img("item_systeme"));
            s.wait(gui.img("submenu_systeme"));
            s.click(gui.img("version_systeme"));
            s.exists(gui.img("version_3846"), 10);
            gui.FermerFenetre();
            gui.Logout();
        }
        catch(Exception e)
        {
            super.HandleException(screen, gui, e);
        }
    }


    @Test
    @TestCheckList(Codes = "020",
            Thèmes = "Affichage 020-05",
            Scenarios = "Clic sur une sociéte",
            typeClient = TestCheckList.TypeClient.UCM,
            Chemin = "clic aleatorie",
            Résultat_attendu = "L'affichage est positionné sur l'onglet Directory (ou le planning complété, non grisé)\n")
    public void affichage020_05() {

            try
            {
                gui.Login();
                screen.click(gui.img("item_societes.png"));
                screen.wait(gui.img("contenu_societes.png"));
                screen.doubleClick(gui.img("item_eglise.png"));
                gui.Logout();
            }
            catch(Exception e)
            {
                super.HandleException(screen, gui, e);
            }
        }

    @Test
    @Jira(Ticket="FORMATECH-2222; FORMATECH-3333")
    @Framework.Annotation.Entites.TestCheckList(Codes = "010-01",
            Thèmes = "Version de l''aplication",
            Scenarios = "Se connecter",
            typeClient = Framework.Annotation.Entites.TestCheckList.TypeClient.UCM,
            prérequis = "--",
            Chemin = "Système > CD > Version du système",
            Résultat_attendu = "Le PDF s'ouvre et le numéro de version est celui de la version testée",
            Exemple_dossiers = "--")
    public void testLoginLogOut0001() {
        Screen s = new Screen();
            try
            {
                gui.Login();
                gui.Logout();
            }
            catch(Exception e)
            {
                super.HandleException(screen, gui, e);
            }
    }

    @Test
    @Jira(Ticket = "FORMATECH-15463")
    public void testSocietes_051_SousSelectionTravailleurs() {

        Screen s = new Screen();

        try
        {
            gui.Login();

            s.click(gui.img("item_societes"));
            s.click(gui.img("sousfleche_Societes"));

            s.click(gui.img("societe_institutsm"));
            s.click(gui.img("sousfleche_societe_institutsm"));


            s.click(gui.img("item_travailleurs_signalitique"));
            s.click(gui.img("sousfleche_travailleurs_signalitique"));


            gui.Logout();


        }
        catch(Exception e)
        {
            super.HandleException(screen, gui, e);
        }
    }








    @Test
    @Jira(Ticket = "FORMATECH-15463")
    public void testSocietes_049() {

        Screen s = new Screen();

        try
        {
            gui.Login();

            gui.clicker("item_societes");

            s.rightClick(gui.img("item_societes"));
            s.wait(gui.img("submenu_societes"));
            s.click(gui.img("nouveau_societe"));
            gui.AttendrePourImage("creation_societe");


            gui.encoderNumero("13042016");


            s.click(gui.img("code_employeur"));
            gui.encoderNumero(1);


            s.click(gui.img("button_suivant"));
            s.wait(gui.img("return_code_999"));
            s.click(gui.img("button_ok"));


            s.click(gui.img("code_employeur"));
            gui.encoderNumero(99563);

            s.click(gui.img("button_suivant"));

            s.wait(gui.img("creation_employeur_criteres"));
            s.click(gui.img("button_chercher"));

            s.wait(gui.img("resultat_recherche"));
            gui.clicker("0176_AGH");
            s.click(gui.img("check_0176"));
            s.click(gui.img("button_suivant"));
            s.click(gui.img("button_suivant"));
            s.click(gui.img("button_suivant"));

            s.type("PoC Paul Lorena");
            s.click(gui.img("button_suivant"));
            s.click(gui.img("button_suivant"));


            gui.encoderNumero("003");
            gui.clicker("003_societe");

            s.click(gui.img("button_suivant"));
            s.click(gui.img("button_suivant"));

            s.type("Sint Gommarusstraat");
            s.type(Key.TAB);
            s.type(Key.TAB);
            gui.encoderNumero(66);
            s.type(Key.TAB);
            gui.encoderNumero(66);
            s.type(Key.TAB);
            s.type(Key.TAB);

            gui.encoderNumero(2800);

            s.type(Key.ENTER);
            s.click(gui.img("button_ok"));

            s.click(gui.img("button_suivant"));
            s.click(gui.img("button_suivant"));
            s.click(gui.img("button_suivant"));


            gui.encoderNumero(2);
            s.click(gui.img("button_suivant"));
            gui.encoderNumero("13042016");


            s.click(gui.img("button_suivant"));
            s.click(gui.img("button_suivant"));
            s.click(gui.img("button_suivant"));
            s.click(gui.img("button_suivant"));
            s.click(gui.img("button_suivant"));

            s.click(gui.img("button_ok"));
            s.click(gui.img("button_annuler"));

            gui.Logout();

        }
        catch(Exception e)
        {
            super.HandleException(screen, gui, e);
        }
    }


}