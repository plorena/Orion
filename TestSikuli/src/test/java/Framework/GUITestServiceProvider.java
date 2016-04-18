package Framework;

import Framework.Annotation.AnnotationFactory;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by paul.lorena on 13/04/2016.
 */
public class GUITestServiceProvider {

    private String pathIMGS;
    private String pathIMGSFailed;
    private Screen s;

    public GUITestServiceProvider()
    {
        s = new Screen();
    }

    public GUITestServiceProvider(Screen screen , String pathImages, String pathIMGS_Failed)
    {
        s = screen;
        pathIMGS =  pathImages;
        pathIMGSFailed = pathIMGS_Failed;
    }

    public void Login() throws  org.sikuli.script.FindFailed, InterruptedException{

        try
        {
            s.exists(img("cessedefonctionner"));
            LoginInternal();
        }
        catch(Exception e)
        {
            s.click(img("fermerleprogramme"));
            LoginInternal();

        }
    }

    private void LoginInternal() throws org.sikuli.script.FindFailed {
        if(s.exists(img("start_formatech"))!=null) {
            s.click(img("start_formatech"));
            AttendrePourImage(4.0, "login_buttons");
            s.type("manager");
            s.type(Key.ENTER);
            AttendrePourImage("menu");
        }else
            org.junit.Assert.assertNull("Icone pour lancer ForHRM n''a pas été trouvé",s.exists(img("start_formatech")) );
    }


    public void Logout() throws org.sikuli.script.FindFailed, InterruptedException {
        s.click(img("logout"));
        s.wait(5.0);
        clicker("logout");
        FermerFenetre();
    }


    public void FermerFenetre() throws org.sikuli.script.FindFailed {
        s.type(Key.F4 , org.sikuli.script.KeyModifier.ALT  );
    }

    public String img(String img)
    {
        if (! img.toLowerCase().contains(".png"))
            img = img + ".png";

        return  pathIMGS + "\\" + img;
    }

    public void AttendrePourImage(String image) throws org.sikuli.script.FindFailed {
        s.wait(2.0);
        s.wait(img(image));
    }

    public void AttendrePourImage(double waitTime, String image) throws org.sikuli.script.FindFailed {
        s.wait(waitTime);
        s.wait(img(image));
    }

    public void encoderNumero(String numberString)
    {

        char[] digits = numberString.toCharArray();
        int i = 0;
        int number = 0;
        while( i < digits.length)
        {
            number = Character.getNumericValue(digits[i]);
            EncoderNumeroInternal(number);
            i=i+1;
        }

    }

    public void encoderNumero(int numero)
    {
        String numberString = Integer.toString(numero);
        char[] digits = numberString.toCharArray();
        int i = 0;
        int number = 0;
        while( i < digits.length)
        {
            number = Character.getNumericValue(digits[i]);
            EncoderNumeroInternal(number);
            i=i+1;
        }

    }

    public void clicker(String image) throws org.sikuli.script.FindFailed {
        s.wait(img(image));
        s.click(img(image));
    }

    private void EncoderNumeroInternal(int numero)
    {
        switch (numero) {
            case 1: s.type(Key.NUM1);
                break;
            case 2:  s.type(Key.NUM2);
                break;
            case 3:  s.type(Key.NUM3);
                break;
            case 4:  s.type(Key.NUM4);
                break;
            case 5:  s.type(Key.NUM5);
                break;
            case 6:  s.type(Key.NUM6);
                break;
            case 7:  s.type(Key.NUM7);
                break;
            case 8:  s.type(Key.NUM8);
                break;
            case 9:  s.type(Key.NUM9);
                break;
            case 0: s.type(Key.NUM0);
                break;
        }
    }



    public void CaptureScreenException(Screen s, Class<?> clase , String nameofTest,  Exception e)  {


        ScreenImage file = s.capture(s.getBounds());
        String stringFile = file.getFile();
        File file_ = new File(stringFile);

        BufferedImage bf = s.capture().getImage();

        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
        Date date = new Date();
        String dateTimeval = dateFormat.format(date);

        File file1 = new File(pathIMGSFailed + dateTimeval + ".png");
        try {
            ImageIO.write(bf, "png", file1);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            AnnotationFactory annotationFactory = new AnnotationFactory();
            String getMetaInfo = annotationFactory.getInfo(clase, nameofTest);
            org.junit.Assert.fail( e.getMessage() + ". Voici le screenshot : " + stringFile + " ****MetaInfo****" + getMetaInfo);
        }
        catch(java.lang.Exception exx){}

    }



    public void CaptureScreenException(Screen s, Exception e) {
    }
}
