package frames;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeListener extends WindowAdapter implements ActionListener{
    LoginFrame lf;
    WelcomeFrame wf;
    public WelcomeListener(LoginFrame lf){
        this.lf=lf;
    }
    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Computer Science")){
            System.out.println("Inside Compute Science");
        }
        else if(cmd.equals("Physics")){
            System.out.println("Inside Physics");
        }
        else if(cmd.equals("Logout")){
            //System.out.println("Inside Logout");
            System.out.println("Logging you out!");
            wf.setVisible(false);
            lf.userNameF.setText("");
            lf.passwordF.setText("");
            lf.setVisible(true);
        }
        else if(cmd.equals("Add Subject")){
            System.out.println("Inside Add Subject");
        }
        else if(cmd.equals("Remove Subject")){
            System.out.println("Inside Remove Subject");
        }
    }
    public void windowClosing(WindowEvent we){
        System.out.println("Logging you out!");
        wf.setVisible(false);
        lf.userNameF.setText("");
        lf.passwordF.setText("");
        lf.setVisible(true);
    }

    public void addFrames(WelcomeFrame wf){
        this.wf=wf;
    }
}
