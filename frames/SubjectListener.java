package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import frames.filehandle.*;

public class SubjectListener extends WindowAdapter implements ActionListener,ItemListener{
    LoginFrame lf;
    WelcomeFrame wf;
    SubjectFrame sf;
    String user,subject;
    //Checkbox cbSelected;
    int typeQ=1;//1:MCQ, 2:True/Flase, 3:Fill in the Blanks
    File path;
    //This is the final resting place of the data base.(origin)
    DatabaseHandler dbms;

    public SubjectListener(LoginFrame lf,WelcomeFrame wf,String user,String subject){
        this.lf=lf;
        this.wf=wf;
        this.user=user;
        String restPath=wf.restPathF.getText();
        //User added to the path
        String fullPath="/home/abhinav/Desktop/OOPMiniProject/questGenerator-Java/"+restPath;
        File tempDir=new File(fullPath);
        if(tempDir.exists()){
            //else the user defined path will be used to read and write the Question Bank
            System.out.println("User-given Path taken");
            path=new File(fullPath+"/"+user);
            path.mkdirs();
        }
        else{
            //our default path.

            System.out.println("Default Taken");
            //user-name added to the path(now we have directory of user)
            path=new File("/home/abhinav/Desktop/OOPMiniProject/questGenerator-Java/Database"+"/"+user);
            path.mkdirs();
        }
        //database Linked
        dbms=new DatabaseHandler(subject,path);//database read the subject obj from the "user" directory
    }
    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Insert!!")){
            int actionFlag=1;
            if(typeQ==1){//MCQ
                System.out.println("Inside Insert(MCQ)!!");
                MCQListener mIsner=new MCQListener(sf,user,dbms,actionFlag,-1);
                MCQFrame mf=new MCQFrame(user,mIsner);
                mIsner.addFrames(mf);
                sf.setVisible(false);
                mf.setVisible(true);
            }
            else if(typeQ==3){//True/False
                System.out.println("Inside Fill in the Blanks!!");
                FillListener fIsner=new FillListener(sf,user,dbms,actionFlag,-1);
                FillFrame ff=new FillFrame(user,fIsner);
                fIsner.addFrames(ff);
                sf.setVisible(false);
                ff.setVisible(true);
            }
            else if(typeQ==2){
                System.out.println("Inside Insert (True/False)");
                TfListener tIsner=new TfListener(sf,user,dbms,actionFlag,-1);//default ques num invalid
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

            //We may have to give teh data base handle for it iterate
            int totalQNow=dbms.database.filled[typeQ-1];
            ModifyListener moIsner=new ModifyListener(sf,user,typeQ,dbms);
            ModifyFrame mof=new ModifyFrame(user,totalQNow,moIsner);
            moIsner.addFrames(mof);
            moIsner.fillTheQuestionList();
            sf.setVisible(false);
            mof.setVisible(true);
        }
        else if(cmd.equals("Generate!!")){
            System.out.println("Inside Generate!!");
            //We may hae to give the file handle to both Listener and
            //Frame for initial construction. Also a random number gen is
            //needed.
            int quesNoTemp=Integer.parseInt(sf.quesNumF.getText());//Have to take this input from gui.
            int quesNoAvbl=dbms.database.filled[typeQ-1];
            //and hanfle when it exceeds the total max.
            if(quesNoAvbl<quesNoTemp){
                sf.quesNumLF.setText("Given Number Exceeds Available Question in Bank!");
                sf.setVisible(false);
                sf.setVisible(true);//refreshing.
            }
            else{
                ExportListener eIsner=new ExportListener(sf,quesNoTemp,typeQ,dbms);
                ExportFrame efQues=new ExportFrame(user,quesNoTemp,eIsner);
                ExportFrame efSoln=new ExportFrame(user,quesNoTemp,eIsner);
                efSoln.viewF.setLabel("View Question");
                eIsner.addFrames(efQues,efSoln);
                eisner.fillTheQuestionPaper();
                sf.setVisible(false);
                efQues.setVisible(true);
            }
        }
        else if(cmd.equals("Delete!!")){
            System.out.println("Inside Delete");
            //Same task as Modify
            int quesNoTemp=20;
            DeleteListener dIsner=new DeleteListener(sf,typeQ,dbms);
            DeleteFrame df=new DeleteFrame(user,quesNoTemp,dIsner);
            dIsner.addFrames(df);
            dIsner.fillTheQuestionList();
            sf.setVisible(false);
            df.setVisible(true);
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
