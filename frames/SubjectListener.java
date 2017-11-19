package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class SubjectListener extends WindowAdapter implements ActionListener,ItemListener{
    LoginFrame lf;
    WelcomeFrame wf;
    SubjectFrame sf;
    String user;
    int typeQ=1;//1:MCQ, 2:True/Flase, 3:Fill in the Blanks

    public SubjectListener(LoginFrame lf,WelcomeFrame wf,String user){
        this.lf=lf;
        this.wf=wf;
        this.user=user;
    }
    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Insert!!")){
            if(typeQ==1){//MCQ
                System.out.println("Inside Insert(MCQ)!!");
                MCQListener mIsner=new MCQListener(sf,user);
                MCQFrame mf=new MCQFrame(user,mIsner);
                mIsner.addFrames(mf);
                sf.setVisible(false);
                mf.setVisible(true);
            }
            else if(typeQ==2){//True/False
                System.out.println("Inside Insert (True/False)");
                FillListener fIsner=new FillListener(sf);
                FillFrame ff=new FillFrame(user,fIsner);
                fIsner.addFrames(ff);
                sf.setVisible(false);
                ff.setVisible(true);
            }
            else if(typeQ==3){
                System.out.println("Inside Fill in the Blanks!!");
                TfListener tIsner=new TfListener(sf);
                TfFrame tf=new TfFrame(user,tIsner);
                tIsner.addFrames(tf);
                sf.setVisible(false);
                tf.setVisible(true);
            }
        }
        else if(cmd.equals("Modify!!")){
            System.out.println("Inside Modify!!");
            //Have to establsh database connection in the constructor itself
            //according to user name.
            //also accroding to type of question load the appropraite database.
            int quesNoTemp=20;
            //We may have to give teh data base handle for it iterate
            ModifyListener moIsner=new ModifyListener(sf);
            ModifyFrame mof=new ModifyFrame(user,quesNoTemp,moIsner);
            moIsner.addFrames(mof);
            sf.setVisible(false);
            mof.setVisible(true);
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
            lf.msgF.setText("For registring Fill the details and then click New Registation");
            lf.setVisible(true);
        }
    }
    public void itemStateChanged(ItemEvent selected){
        try{
            Checkbox cbSelected=(Checkbox)selected.getItemSelectable();
            String cbTag=cbSelected.getLabel();
            if(cbTag.equals("MCQ")){
                System.out.println("MCQ Clicked");
                typeQ=1;
            }
            else if(cbTag.equals("True/False")){
                System.out.println("True/False Selected");
                typeQ=2;
            }
            else if(cbTag.equals("Fill in Blanks")){
                System.out.println("Fill in the Blanks Selected");
                typeQ=3;
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
