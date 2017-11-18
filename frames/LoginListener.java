package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class LoginListener extends WindowAdapter implements ActionListener{
    LoginFrame lf;
    WelcomeFrame wf;
    //Later read from the database.
    String user="Kalpana";
    String password="deyKay";//Currently just hardcoding

    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Login To Profile")){
            System.out.println("Login Action Listened!!!");
            String reqUserName=lf.userNameF.getText();
            String reqPassword=lf.passwordF.getText();
            //This conditional chek will be done from database of user.
            if(reqUserName.equals(user) && reqPassword.equals(password)){
                lf.setVisible(false);
                WelcomeListener wIsner=new WelcomeListener(lf,reqUserName);
                wf=new WelcomeFrame(reqUserName,wIsner);
                wIsner.addFrames(wf);
                //handler of Welcome Frame.
                wf.setVisible(true);
            }
        }
        else if(cmd.equals("New Registration")){
            System.out.println("New Registration Clicked");
            lf.setVisible(false);
            String reqUserName=lf.userNameF.getText();
            String reqPassword=lf.passwordF.getText();
            //Have to add the the new User to database and initialize its directory.
            WelcomeListener wIsner=new WelcomeListener(lf,reqUserName);
            wf=new WelcomeFrame(reqUserName,wIsner);
            wIsner.addFrames(wf);
            //wf's handler will be defined here
            wf.setVisible(true);
        }
    }
    public void windowClosing(WindowEvent we){
        System.out.println("Bye,Bye!!");
        System.exit(0);
    }
    public void addFrames(LoginFrame lf){
        this.lf=lf;
    }
}
