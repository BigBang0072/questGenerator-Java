package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import frames.filehandle.*;

public class LoginListener extends WindowAdapter implements ActionListener{
    LoginFrame lf;
    WelcomeFrame wf;
    LoginManager logManager;

    public LoginListener(){
        logManager=new LoginManager();
    }

    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Login To Profile")){
            System.out.println("Login Action Listened!!!");
            String reqUserName=lf.userNameF.getText();
            String reqPassword=lf.passwordF.getText();
            //This conditional chek will be done from database of user.
            boolean token=logManager.authenticateLogin(reqUserName,reqPassword);
            if(token){
                lf.setVisible(false);
                WelcomeListener wIsner=new WelcomeListener(lf,reqUserName);
                wf=new WelcomeFrame(reqUserName,wIsner);
                wIsner.addFrames(wf);
                //handler of Welcome Frame.
                wf.setVisible(true);
            }
            else{
                lf.msgF.setText("Wrong Password !!. Please try again.");
                lf.setVisible(false);
                lf.setVisible(true);//refresh
            }
        }
        else if(cmd.equals("New Registration")){
            System.out.println("New Registration Clicked");
            //lf.setVisible(false);
            String reqUserName=lf.userNameF.getText();
            String reqPassword=lf.passwordF.getText();
            //Have to add the the new User to database and initialize its directory.
            boolean token=logManager.checkNameAvailable(reqUserName);
            if(token){
                logManager.addUser(reqUserName,reqPassword);
                logManager.saveCredentails();
                WelcomeListener wIsner=new WelcomeListener(lf,reqUserName);
                wf=new WelcomeFrame(reqUserName,wIsner);
                wIsner.addFrames(wf);
                //wf's handler will be defined here
                lf.setVisible(false);
                wf.setVisible(true);
            }
            else{
                lf.msgF.setText("UserName not Available.Try other");
                lf.setVisible(false);
                lf.setVisible(true);//refresh
            }
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
