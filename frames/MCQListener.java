package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import frames.filehandle.*;

public class MCQListener extends WindowAdapter implements ActionListener,ItemListener{
    SubjectFrame sf;
    MCQFrame mf;
    String user;
    String ans="";
    int actionFlag;//1:for insert, 3:Modify, 4:delete
    int quesNum;//Which question to perform action on if ^flag=3/4
    DatabaseHandler dbms; //DataFrame Reference fo the user created in the subject window.

    public MCQListener(SubjectFrame sf,String user,DatabaseHandler dbms,int actionFlag,int quesNum){
        this.sf=sf;
        this.user=user;
        this.dbms=dbms;
        this.actionFlag=actionFlag;
        //System.out.println("inside misner "+quesNum);
        this.quesNum=quesNum;//for insert put -1 default
    }
    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Add to Question Bank")){
            System.out.println("Inside Add Button");
            String quest=mf.questF.getText();
            String optA=mf.optAF.getText();
            String optB=mf.optBF.getText();
            String optC=mf.optCF.getText();
            String optD=mf.optDF.getText();
            if(quest.equals("") || optA.equals("") || optB.equals("") || optD.equals("") || ans.equals("")){
                System.out.println("Please enter all the fields");
                mf.msgF.setText("Enter all the fields first!!");
                mf.setVisible(false);
                mf.setVisible(true);
            }
            else{
                System.out.println("Adding the question to Question Bank");
                //link with the database
                if(actionFlag==1){
                    dbms.database.addMCQQuest(quest,optA,optB,optC,optD,ans);//Aha just in one sweep
                    dbms.writeUserDatabase();
                    System.out.println(quest);
                    System.out.println(optA);
                    System.out.println(optB);
                    System.out.println(optC);
                    System.out.println(optD);
                    mf.setVisible(false);
                    sf.setVisible(true);
                }
                else if(actionFlag==3){
                    //System.out.println("Sending to user function Qnum: "+quesNum);
                    dbms.database.modifyMCQQuest(quesNum,quest,optA,optB,optC,optD,ans);
                    //Jahan change wahn save the database. #AAJ ka anrraa
                    dbms.writeUserDatabase();
                    mf.setVisible(false);
                    sf.setVisible(true);
                }
            }
        }
        else if(cmd.equals("Cancel")){
            System.out.println("Cancelled!!");
            mf.setVisible(false);
            sf.setVisible(true);
        }
    }
    public void itemStateChanged(ItemEvent selected){
        try{
            List listTemp=(List)selected.getItemSelectable();
            ans=listTemp.getSelectedItem();
            System.out.println("The selected item is : "+ans);
        }
        catch(Exception e){
            System.out.println("There is some error in item object conversion!!");
        }
    }

    public void windowClosing(WindowEvent we){
        System.out.println("Returing 'you' to the Subject Window ");
        mf.setVisible(false);
        sf.setVisible(true);
    }

    public void addFrames(MCQFrame mf){
        this.mf=mf;
    }
}
