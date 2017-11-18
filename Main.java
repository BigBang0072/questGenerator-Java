import frames.*;
import java.lang.*;


public class Main{
    public static void main(String args[]){
        LoginListener lIsner=new LoginListener();;
        LoginFrame lf=new LoginFrame(lIsner);
        lIsner.addFrames(lf);
        lf.setVisible(true);
    }
}
