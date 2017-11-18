package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class SubjectListener extends WindowAdapter implements ActionListener,ItemListener{
    LoginFrame lf;
    WelcomeFrame wf;
    SubjectFrame sf;
    String user;

    public SubjectListener(LoginFrame lf,WelcomeFrame wf,String user){
        this.lf=lf;
        this.wf=wf;
        this.user=user;
    }
    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Insert!!")){
            System.out.println("Inside Insert!!");
        }
        else if(cmd.equals("Modify!!")){
            System.out.println("Inside Modify!!");
        }
        else if(cmd.equals("Generate!!")){
            System.out.println("Inside Generate!!");
        }
        else if(cmd.equals("Delete!!")){
            System.out.println("Inside Delete");
        }
        else if(cmd.equals("Go Back")){
            System.out.println("Inside Go Back!!");
            sf.setVisible(false);
            wf.setVisible(true);
        }
        else if(cmd.equals("Logout")){
            System.out.println("Logging you out of here!!");
            sf.setVisible(false);
            lf.userNameF.setText("");
            lf.passwordF.setText("");
            lf.setVisible(true);
        }
    }
    public void itemStateChanged(ItemEvent selected){
        try{
            Checkbox cbSelected=(Checkbox)selected.getItemSelectable();
            String cbTag=cbSelected.getLabel();
            if(cbTag.equals("MCQ")){
                System.out.println("MCQ Clicked");
            }
            else if(cbTag.equals("True/False")){
                System.out.println("True/False Selected");
            }
            else if(cbTag.equals("Fill in Blanks")){
                System.out.println("Fill in the Blanks Selected");
            }
        }
        catch(Exception e){
            Label lbSelected=(Label)selected.getItemSelectable();
            System.out.println("Label Selected, Not Checkbox");
        }
    }
    public void windowClosing(WindowEvent we){
        System.out.println("Returning you to the Subject Window");
        sf.setVisible(false);
        wf.setVisible(true);
    }
    public void addFrames(SubjectFrame sf){
        this.sf=sf;
    }
}
