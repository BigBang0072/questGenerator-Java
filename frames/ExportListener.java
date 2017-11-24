package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import frames.filehandle.*;

public class ExportListener extends WindowAdapter implements ActionListener{
    //Instance Varaible
    SubjectFrame sf;
    ExportFrame efQues;
    ExportFrame efSoln;
    int typeQ,quesReq;
    DatabaseHandler dbms;

    public ExportListener(SubjectFrame sf,int quesReq,int typeQ,DatabaseHandler dbms){
        this.sf=sf;
        this.quesReq=quesReq;
        this.typeQ=typeQ;
        this.dbms=dbms;
    }

    public void fillTheQuestionPaper(){
        int quesTotal=dbms.database.filled[typeQ-1];//Exclusive of that value
        int[] randSeq=new int[quesReq];
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

                Label questL=new Label(quest);
                Label optAL=new Label("a. "+optA);
                Label optBL=new Label("b. "+optB);
                Label optCL=new Label("c. "+optC);
                Label optDL=new Label("d. "+optD);

                //constraint.gridx=0;
                //constraint.gridy=0;
                pQTemp.add(questL);
                pQTemp.add(optAL);
                pQTemp.add(optBL);
                pQTemp.add(optCL);
                pQTemp.add(optDL);

                constraint.gridx=0;
                constraint.gridy=i;
                constraint.weightx=0.25;
                constraint.weighty=0;
                efQues.paneCF.add(pQTemp,constraint);

                Label ansL=new Label(ans);
                pSTemp.add(ansL);
                constraint.gridx=0;
                constraint.gridy=i;
                constraint.weightx=0.25;
                constraint.weighty=0;
                efSoln.paneCF.add(pSTemp,constraint);
            }
            else if(typeQ==2){//TRue/False
                String quest=dbms.database.tf[randSeq[i]].quest;
                String ans=dbms.database.tf[randSeq[i]].ans;

                Label questL=new Label(quest);
                pQTemp.add(questL);

                constraint.gridx=0;
                constraint.gridy=i;
                constraint.weightx=0.25;
                constraint.weighty=0;
                efQues.paneCF.add(pQTemp,constraint);

                Label ansL=new Label(ans);
                pSTemp.add(ansL);
                constraint.gridx=0;
                constraint.gridy=i;
                constraint.weightx=0.25;
                constraint.weighty=0;
                efSoln.paneCF.add(pSTemp,constraint);
            }
            else if(typeQ==3){//Fill in the Balnks
                String bQuest=dbms.database.fill[randSeq[i]].beforeQuest;
                String aQuest=dbms.database.fill[randSeq[i]].afterQuest;
                String ans=dbms.database.fill[randSeq[i]].ans;

                Label questL=new Label(bQuest+"  "+aQuest);
                pQTemp.add(questL);

                constraint.gridx=0;
                constraint.gridy=i;
                constraint.weightx=0.25;
                constraint.weighty=0;
                efQues.paneCF.add(pQTemp,constraint);

                Label ansL=new Label(ans);
                pSTemp.add(ansL);
                constraint.gridx=0;
                constraint.gridy=i;
                constraint.weightx=0.25;
                constraint.weighty=0;
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
    }

    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Cancel")){
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

        }
        else if(cmd.equals("Export Ques to File")){
            System.out.println("have to export file to the System");
            //File Dialogue has to come.
        }
        else if(cmd.equals("Reshuffle")){
            //AHve to reshuffle the random number array to get hte
            //new question from bank
            System.out.println("Reshuffling");
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
