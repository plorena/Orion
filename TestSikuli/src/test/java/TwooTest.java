
import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

@UserStoryInfo(sprint = "87", priority = UserStoryInfo.Priority.HIGH)
public class TwooTest extends TOTO {


    GUITestServiceProvider guiTest;
    Screen s;

    public TwooTest()
    {
         s = new Screen();
         guiTest = new GUITestServiceProvider(s, "C:\\root\\TestSikuli\\src\\test\\US001", "C:\\Failed\\");
    }




    @Test
    @Jira(Ticket="FORMATECH-18062; FORMATECH-18611")
    public void testItemSocietes0001() {

            try
            {
                guiTest.Login();
                s.click(guiTest.img("item_societes.png"));
                s.wait(guiTest.img("contenu_societes.png"));
                s.doubleClick(guiTest.img("item_eglise.png"));
                guiTest.Logout();

            }
            catch(Exception e)
            {
                guiTest.CaptureScreenException(s, e);
            }
            finally {

            }
        }

    @Test
    public void testLoginLogOut0001() {

        Screen s = new Screen();

            try
            {
                guiTest.Login();
                guiTest.Logout();

            }
            catch(Exception e)
            {
                guiTest.CaptureScreenException(s, e);
            }
            finally {

            }
    }

    @Test
    public void testSocietes_051_SousSelectionTravailleurs() {

        Screen s = new Screen();

        try
        {
            guiTest.Login();

            s.click(guiTest.img("item_societes"));
            s.click(guiTest.img("sousfleche_Societes"));

            s.click(guiTest.img("societe_institutsm"));
            s.click(guiTest.img("sousfleche_societe_institutsm"));


            s.click(guiTest.img("item_travailleurs_signalitique"));
            s.click(guiTest.img("sousfleche_travailleurs_signalitique"));

            guiTest.Logout();


        }
        catch(Exception e)
        {
            org.junit.Assert.fail(e.getMessage());

        }
        finally {

        }

    }

    @Test
    public void testVersionApplication_010() {

        Screen s = new Screen();

            try
            {
                for(int i=1; i<11; i++) {
                    guiTest.Login();
                    s.click(guiTest.img("item_systeme"));
                    s.rightClick(guiTest.img("item_systeme"));
                    s.wait(guiTest.img("submenu_systeme"));
                    s.click(guiTest.img("version_systeme"));
                    s.exists(guiTest.img("version_3846"), 10);
                    guiTest.FermerFenetre();
                    guiTest.Logout();
                }

            }
            catch(Exception e)
            {
                guiTest.CaptureScreenException(s, e);

            }
            finally {
                try {
                    guiTest.FermerFenetre();
                } catch (FindFailed findFailed) {
                    findFailed.printStackTrace();
                }
            }

    }



    @Test
    public void testVersionApplication_011() {

        Screen s = new Screen();

        try
        {
            guiTest.Login();

            s.click(guiTest.img("item_systeme"));
            s.rightClick(guiTest.img("item_systeme"));
            s.wait(guiTest.img("submenu_systeme"));
            s.click(guiTest.img("version_systeme"));
            s.exists(guiTest.img("version_3846"), 10);
            guiTest.FermerFenetre();
            guiTest.Logout();

        }
        catch(Exception e)
        {

            guiTest.CaptureScreenException(s, e);

        }
        finally {

        }

    }

    @Test
    public void testVersionApplication_012() {

        Screen s = new Screen();

        try
        {
            guiTest.Login();

            s.click(guiTest.img("item_systeme"));
            s.rightClick(guiTest.img("item_systeme"));
            s.wait(guiTest.img("submenu_systeme"));
            s.click(guiTest.img("version_systeme"));
            s.exists(guiTest.img("version_3846"), 10);
            guiTest.FermerFenetre();
            guiTest.Logout();

        }
        catch(Exception e)
        {
            guiTest.CaptureScreenException(s, e);

        }
        finally {

        }

    }


    @Test
    public void testSocietes_049() {

        Screen s = new Screen();

        try
        {
            guiTest.Login();

            guiTest.clicker("item_societes");

            s.rightClick(guiTest.img("item_societes"));
            s.wait(guiTest.img("submenu_societes"));
            s.click(guiTest.img("nouveau_societe"));
            guiTest.AttendrePourImage("creation_societe");


            guiTest.encoderNumero("13042016");


            s.click(guiTest.img("code_employeur"));
            guiTest.encoderNumero(1);


            s.click(guiTest.img("button_suivant"));
            s.wait(guiTest.img("return_code_999"));
            s.click(guiTest.img("button_ok"));


            s.click(guiTest.img("code_employeur"));
            guiTest.encoderNumero(99563);

            s.click(guiTest.img("button_suivant"));

            s.wait(guiTest.img("creation_employeur_criteres"));
            s.click(guiTest.img("button_chercher"));

            s.wait(guiTest.img("resultat_recherche"));
            guiTest.clicker("0176_AGH");
            s.click(guiTest.img("check_0176"));
            s.click(guiTest.img("button_suivant"));
            s.click(guiTest.img("button_suivant"));
            s.click(guiTest.img("button_suivant"));

            s.type("PoC Paul Lorena");
            s.click(guiTest.img("button_suivant"));
            s.click(guiTest.img("button_suivant"));


            guiTest.encoderNumero("003");
            guiTest.clicker("003_societe");

            s.click(guiTest.img("button_suivant"));
            s.click(guiTest.img("button_suivant"));

            s.type("Sint Gommarusstraat");
            s.type(Key.TAB);
            s.type(Key.TAB);
            guiTest.encoderNumero(66);
            s.type(Key.TAB);
            guiTest.encoderNumero(66);
            s.type(Key.TAB);
            s.type(Key.TAB);

            guiTest.encoderNumero(2800);

            s.type(Key.ENTER);
            s.click(guiTest.img("button_ok"));

            s.click(guiTest.img("button_suivant"));
            s.click(guiTest.img("button_suivant"));
            s.click(guiTest.img("button_suivant"));


            guiTest.encoderNumero(2);
            s.click(guiTest.img("button_suivant"));
            guiTest.encoderNumero("13042016");


            s.click(guiTest.img("button_suivant"));
            s.click(guiTest.img("button_suivant"));
            s.click(guiTest.img("button_suivant"));
            s.click(guiTest.img("button_suivant"));
            s.click(guiTest.img("button_suivant"));

            s.click(guiTest.img("button_ok"));
            s.click(guiTest.img("button_annuler"));

            guiTest.Logout();

        }
        catch(Exception e)
        {
            guiTest.CaptureScreenException(s, e);

        }
        finally {

        }

    }


}