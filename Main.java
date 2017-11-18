import frames.*;
import java.lang.*;


public class Main{
    public static void main(String args[]){
        LoginListener lIsner=new LoginListener();;
        LoginFrame lf=new LoginFrame(lIsner);
        WelcomeFrame wf=new WelcomeFrame("Kalpana");
        lIsner.addFrames(lf,wf);
        lf.setVisible(true);
    }
}
