package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import frames.filehandle.*;

public class ExportListener extends WindowAdapter implements ActionListener{
    //Instance Varaible
    SubjectFrame sf;
    ExportFrame efQues;
    ExportFrame efSoln;
    String user;
    int typeQ,quesReq;
    DatabaseHandler dbms;
    int[] randSeq;

    public ExportListener(SubjectFrame sf,String user,int quesReq,int typeQ,DatabaseHandler dbms){
        this.sf=sf;
        this.user=user;
        this.quesReq=quesReq;
        this.typeQ=typeQ;
        this.dbms=dbms;
    }

    public void fillTheQuestionPaper(){
        int quesTotal=dbms.database.filled[typeQ-1];//Exclusive of that value
        randSeq=new int[quesReq];
        getRandomSeq(quesReq,quesTotal,randSeq);

        for(int i=0;i<quesReq;i++){
            Panel pQTemp=new Panel(new GridBagLayout());
            Panel pSTemp=new Panel(new GridBagLayout());
            GridBagConstraints constraint=new GridBagConstraints();
            pQTemp.setBackground(Color.cyan);
            pSTemp.setBackground(Color.cyan);

            if(typeQ==1){//MCQ
                String quest=dbms.database.mcq[randSeq[i]].quest;
                String optA=dbms.database.mcq[randSeq[i]].optA;
                String optB=dbms.database.mcq[randSeq[i]].optB;
                String optC=dbms.database.mcq[randSeq[i]].optC;
                String optD=dbms.database.mcq[randSeq[i]].optD;
                String ans=dbms.database.mcq[randSeq[i]].ans;

                Label questL=new Label("Ques No "+i+":   "+quest);
                Label optAL=new Label("Option (a) "+optA);
                Label optBL=new Label("Option (b) "+optB);
                Label optCL=new Label("Option (c) "+optC);
                Label optDL=new Label("Option (d) "+optD);

                constraint.gridx=0;
                constraint.gridy=1;
                pQTemp.add(questL,constraint);
                constraint.gridx=0;
                constraint.gridy=2;
                pQTemp.add(optAL,constraint);
                constraint.gridx=0;
                constraint.gridy=3;
                pQTemp.add(optBL,constraint);
                constraint.gridx=0;
                constraint.gridy=4;
                pQTemp.add(optCL,constraint);
                constraint.gridx=0;
                constraint.gridy=5;
                pQTemp.add(optDL,constraint);

                constraint.gridx=0;
                constraint.gridy=i;
                constraint.weightx=0;
                constraint.weighty=0.25;
                efQues.paneCF.add(pQTemp,constraint);

                Label ansL=new Label("Solution "+i+":   "+ans);
                pSTemp.add(ansL);
                constraint.gridx=0;
                constraint.gridy=i;
                constraint.weightx=0;
                constraint.weighty=0.25;
                efSoln.paneCF.add(pSTemp,constraint);
            }
            else if(typeQ==2){//TRue/False
                String quest=dbms.database.tf[randSeq[i]].quest;
                String ans=dbms.database.tf[randSeq[i]].ans;

                Label questL=new Label("Ques No "+i+":   "+quest);
                pQTemp.add(questL);

                constraint.gridx=0;
                constraint.gridy=i;
                constraint.weightx=0;
                constraint.weighty=0.25;
                efQues.paneCF.add(pQTemp,constraint);

                Label ansL=new Label("Solution "+i+":   "+ans);
                pSTemp.add(ansL);
                constraint.gridx=0;
                constraint.gridy=i;
                constraint.weightx=0;
                constraint.weighty=0.25;
                efSoln.paneCF.add(pSTemp,constraint);
            }
            else if(typeQ==3){//Fill in the Balnks
                String bQuest=dbms.database.fill[randSeq[i]].beforeQuest;
                String aQuest=dbms.database.fill[randSeq[i]].afterQuest;
                String ans=dbms.database.fill[randSeq[i]].ans;

                Label questL=new Label("Ques No "+i+":   "+bQuest+"______"+aQuest);
                pQTemp.add(questL);

                constraint.gridx=0;
                constraint.gridy=i;
                constraint.weightx=0;
                constraint.weighty=0.25;
                efQues.paneCF.add(pQTemp,constraint);

                Label ansL=new Label("Solution "+i+":   "+ans);
                pSTemp.add(ansL);
                constraint.gridx=0;
                constraint.gridy=i;
                constraint.weightx=0;
                constraint.weighty=0.25;
                efSoln.paneCF.add(pSTemp,constraint);
            }
        }
    }

    private void getRandomSeq(int quesReq,int quesTotal,int[] randSeq){
        Random rand=new Random();
        int count=0;
        for(int i=0;i<quesReq;i++){
            randSeq[i]=0;
        }
        while(count!=quesReq){
            int temp=rand.nextInt(quesTotal);
            int flag=0;
            for(int i=0;i<count;i++){
                if(temp==randSeq[i]){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                randSeq[count]=temp;
                count++;
            }
        }
        for(int i=0;i<quesReq;i++){
            System.out.println("Rand :"+randSeq[i]);
        }
    }

    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Back")){
            System.out.println("Exiting you to subject Window");
            efQues.setVisible(false);
            efSoln.setVisible(false);
            sf.setVisible(true);
        }
        else if(cmd.equals("View Solution")){
            System.out.println("Switching to the Solution Window");
            efQues.setVisible(false);
            efSoln.setVisible(true);
        }
        else if(cmd.equals("View Question")){
            System.out.println("Switching to the Question Window");
            efSoln.setVisible(false);
            efQues.setVisible(true);
        }
        else if(cmd.equals("Export Soln to File")){
            System.out.println("have to export File to the System.");
            System.out.println("have to export file to the System");
            //File Dialogue has to come.
            String restPath=sf.extraAddF.getText();
            //Default path start from desktop for good visulisation
            String fullPath="/home/abhinav/Desktop/"+restPath;
            File dir=new File(fullPath);
            if(dir.exists()){
                System.out.println("path of saving QSolution is: "+fullPath);
            }
            else{
                dir.mkdirs();
                System.out.println("The path didnt existed so directory created at: "+fullPath);
            }
            ExportHandle exHandle=new ExportHandle(dbms,randSeq,typeQ,dir);
            exHandle.writeSolutionToFile();
        }
        else if(cmd.equals("Export Ques to File")){
            System.out.println("have to export file to the System");
            //File Dialogue has to come.
            String restPath=sf.extraAddF.getText();
            //Default path start from desktop for good visulisation
            String fullPath="/home/abhinav/Desktop/"+restPath;
            File dir=new File(fullPath);
            if(dir.exists()){
                System.out.println("path of saving QPapers is: "+fullPath);
            }
            else{
                dir.mkdirs();
                System.out.println("The path didnt existed so directory created at: "+fullPath);
            }
            ExportHandle exHandle=new ExportHandle(dbms,randSeq,typeQ,dir);
            exHandle.writeQuestionToFile();
        }
        else if(cmd.equals("Reshuffle")){
            //AHve to reshuffle the random number array to get hte
            //new question from bank
            //Undisplaying the earlier frames
            System.out.println("Reshuffling");
            efQues.setVisible(false);
            efSoln.setVisible(false);
            //Creating new Frame, cuz its appending Panel on the same frame
            efQues=new ExportFrame(user,quesReq,this);
            efSoln=new ExportFrame(user,quesReq,this);
            efSoln.viewF.setLabel("View Question");
            this.fillTheQuestionPaper();
            efQues.setVisible(false);
            efSoln.setVisible(false);
            efQues.setVisible(true);
        }
    }


    public void windowClosing(WindowEvent we){
        System.out.println("Exiting you to Subject Window");
        efQues.setVisible(false);
        efSoln.setVisible(false);
        sf.setVisible(true);
    }

    public void addFrames(ExportFrame efQues,ExportFrame efSoln){
        this.efQues=efQues;
        this.efSoln=efSoln;
    }
}
