package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import frames.filehandle.*;

public class ModifyListener extends WindowAdapter implements ActionListener,ItemListener{
    //Instance Varaible
    SubjectFrame sf;
    ModifyFrame mf;
    int quesNo=-1;
    int typeQ;
    String user;
    DatabaseHandler dbms;

    public ModifyListener(SubjectFrame sf,String user,int typeQ,DatabaseHandler dbms){
        this.sf=sf;
        this.typeQ=typeQ;
        this.dbms=dbms;
        this.user=user;
        //Generating the display of all the question string
        //cant do in constructor. mf is not added.
    }
    public void fillTheQuestionList(){
        int totalQNow=dbms.database.filled[typeQ-1];
        System.out.println("Total Question now in type :"+typeQ+" is: "+totalQNow);
        for(int i=1;i<=totalQNow;i++){
            if(i<10){
                if(typeQ==1){
                    mf.questListF.add("0"+i+" "+dbms.database.mcq[i-1].quest);
                }
                else if(typeQ==2){
                    mf.questListF.add("0"+i+" "+dbms.database.tf[i-1].quest);
                }
                else{
                    mf.questListF.add("0"+i+" "+dbms.database.fill[i-1].beforeQuest+" "+dbms.database.fill[i-1].afterQuest);
                }
            }
            else{
                if(typeQ==1){
                    mf.questListF.add(i+" "+dbms.database.mcq[i-1].quest);
                }
                else if(typeQ==2){
                    mf.questListF.add(i+" "+dbms.database.tf[i-1].quest);
                }
                else{
                    mf.questListF.add(i+" "+dbms.database.fill[i-1].beforeQuest+" "+dbms.database.fill[i-1].afterQuest);
                }
            }
        }
    }
    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Cancel")){
            System.out.println("Returning you to the Subject Window!!");
            mf.setVisible(false);
            sf.setVisible(true);
        }
        else if(cmd.equals("Modify")){
            if(quesNo==-1){
                mf.msgF.setText("Please Select one of the Question");
                mf.setVisible(false);
                mf.setVisible(true);
            }
            else{
                System.out.println("Inside the Modify Block");
                //here we have to instatate the approprate frame
                //initialized with the previous texts and then update.
                //save to database
                if(typeQ==1){//MCQ
                    String quest=dbms.database.mcq[quesNo].quest;
                    String optA=dbms.database.mcq[quesNo].optA;
                    String optB=dbms.database.mcq[quesNo].optB;
                    String optC=dbms.database.mcq[quesNo].optC;
                    String optD=dbms.database.mcq[quesNo].optD;
                    String ans=dbms.database.mcq[quesNo].ans;
                    int opt=-1;
                    if(ans.equals("a.")){
                        opt=0;
                    }
                    else if(ans.equals("b.")){
                        opt=1;
                    }
                    else if(ans.equals("c.")){
                        opt=2;
                    }
                    else if(ans.equals("d.")){
                        opt=3;
                    }
                    System.out.println("Gifing qNum to MCisner"+" "+quesNo);
                    MCQListener mCIsner=new MCQListener(sf,user,dbms,3,quesNo);
                    MCQFrame mCf=new MCQFrame(user,mCIsner);
                    mCf.questF.setText(quest);
                    mCf.optAF.setText(optA);
                    mCf.optBF.setText(optB);
                    mCf.optCF.setText(optC);
                    mCf.optDF.setText(optD);
                    mCf.optListF.select(opt);
                    mCIsner.addFrames(mCf);

                    mf.setVisible(false);
                    mCf.setVisible(true);
                }
                else if(typeQ==2){//Tf Ques
                    String quest=dbms.database.tf[quesNo].quest;
                    String ans=dbms.database.tf[quesNo].ans;
                    int opt=-1;
                    if(ans.equals("True")){
                        opt=0;
                    }
                    else if(ans.equals("False")){
                        opt=1;
                    }
                    TfListener tIsner=new TfListener(sf,user,dbms,3,quesNo);
                    TfFrame tf=new TfFrame(user,tIsner);
                    tf.questF.setText(quest);
                    tf.optListF.select(opt);

                    tIsner.addFrames(tf);
                    mf.setVisible(false);
                    tf.setVisible(true);
                }

            }
        }
    }
    public void itemStateChanged(ItemEvent changed){
        try{
            List listTemp=(List)changed.getItemSelectable();
            quesNo=listTemp.getSelectedIndex();
            System.out.println("The question number selected is: "+quesNo);
        }
        catch(Exception e){
            System.out.println("Error in converting to List object (SEE)");
        }
    }

    public void windowClosing(WindowEvent we){
        System.out.println("Returning you to subject Window");
        mf.setVisible(false);
        sf.setVisible(true);
    }

    public void addFrames(ModifyFrame mf){
        this.mf=mf;
    }

}
