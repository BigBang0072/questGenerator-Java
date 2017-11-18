package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class LoginListener extends WindowAdapter implements ActionListener{
    LoginFrame lf;
    WelcomeFrame wf;

    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Login To Profile")){
            System.out.println("Login Action Listened!!!");
            //Have to add few more conditional to check password.
            lf.setVisible(false);
            wf.setVisible(true);
        }
        else if(cmd.equals("New Registration")){
            System.out.println("New Registration Clicked");
            lf.setVisible(false);
            wf.setVisible(true);
        }
    }
    public void windowClosing(WindowEvent we){
        System.out.println("Bye,Bye!!");
        System.exit(0);
    }
    public void addFrames(LoginFrame lf,WelcomeFrame wf){
        this.lf=lf;
        this.wf=wf;
    }
}
