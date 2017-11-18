package frames;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeListener extends WindowAdapter implements ActionListener{
    LoginFrame lf;
    WelcomeFrame wf;
    String user;

    public WelcomeListener(LoginFrame lf,String user){
        this.lf=lf;
        this.user=user;
    }

    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Computer Science")){
            System.out.println("Inside Compute Science");
            //handler of subject frame
            SubjectListener sIsner=new SubjectListener(lf,wf,user);
            SubjectFrame sf=new SubjectFrame(user,"Computer Science",sIsner);
            sIsner.addFrames(sf);
            wf.setVisible(false);
            sf.setVisible(true);
        }
        else if(cmd.equals("Physics")){
            System.out.println("Inside Physics");
            //handle of subject frame will come;
            SubjectListener sIsner=new SubjectListener(lf,wf,user);
            SubjectFrame sf=new SubjectFrame(user,"Physics",sIsner);
            sIsner.addFrames(sf);
            wf.setVisible(false);
            sf.setVisible(true);
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
