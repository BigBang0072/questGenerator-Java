package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import frames.filehandle.*;

public class DeleteListener extends WindowAdapter implements ActionListener,ItemListener{
    //Instance Varaible
    SubjectFrame sf;
    DeleteFrame df;
    int quesNo=-1;
    DatabaseHandler dbms;
    int typeQ;

    public DeleteListener(SubjectFrame sf,int typeQ,DatabaseHandler dbms){
        this.sf=sf;
        this.typeQ=typeQ;
        this.dbms=dbms;
    }

    public void fillTheQuestionList(){
        int totalQNow=dbms.database.filled[typeQ-1];
        System.out.println("Total question in Existance of Type :"+typeQ+" is: "+totalQNow);
        for(int i=1;i<=totalQNow;i++){
            if(i<10){
                if(typeQ==1){
                    df.questListF.add("0"+i+" "+dbms.database.mcq[i-1].quest);
                }
                else if(typeQ==2){
                    df.questListF.add("0"+i+" "+dbms.database.tf[i-1].quest);
                }
                else{
                    df.questListF.add("0"+i+" "+dbms.database.fill[i-1].beforeQuest+" "+dbms.database.fill[i-1].afterQuest);
                }
            }
            else{
                if(typeQ==1){
                    df.questListF.add(i+" "+dbms.database.mcq[i-1].quest);
                }
                else if(typeQ==2){
                    df.questListF.add(i+" "+dbms.database.tf[i-1].quest);
                }
                else{
                    df.questListF.add(i+" "+dbms.database.fill[i-1].beforeQuest+" "+dbms.database.fill[i-1].afterQuest);
                }
            }
        }
    }

    public void actionPerformed(ActionEvent buttonPressed){
        String cmd=buttonPressed.getActionCommand();
        if(cmd.equals("Cancel")){
            System.out.println("Taking you to subject Window");
            df.setVisible(false);
            sf.setVisible(true);
        }
        else if(cmd.equals("Delete")){
            if(quesNo==-1){
                df.msgF.setText("Please Select one before deleting");
                df.setVisible(false);
                df.setVisible(true);//Refreshing
            }
            else{
                System.out.println("Deleting the Question");
                //Have to handle the database here to delete the question.
                if(typeQ==1){
                    System.out.println("Removing question of type :"+typeQ);
                    dbms.database.removeMCQQuest(quesNo);
                    //hatho-hath link bhi to karna hai na
                    dbms.writeUserDatabase();
                    df.setVisible(false);
                    sf.setVisible(true);
                }
                else if(typeQ==2){
                    System.out.println("Removing question of type :"+typeQ);
                    dbms.database.removeTfQuest(quesNo);
                    dbms.writeUserDatabase();
                    df.setVisible(false);
                    sf.setVisible(true);
                }
                else if(typeQ==3){
                    System.out.println("Removing question of type :"+typeQ);
                    dbms.database.removeFillQuest(quesNo);
                    dbms.writeUserDatabase();
                    df.setVisible(false);
                    sf.setVisible(true);
                }
            }
        }
    }

    public void itemStateChanged(ItemEvent changed){
        try{
            List listTemp=(List)changed.getItemSelectable();
            quesNo=listTemp.getSelectedIndex();
            System.out.println("The item selected to delete is : "+quesNo);
        }
        catch(Exception e){
            System.out.println("The list conversion is happening wrong see.!!!");
        }
    }

    public void windowClosing(WindowEvent we){
        System.out.println("Sending to the Subject Frame");
        df.setVisible(false);
        sf.setVisible(true);
    }
    public void addFrames(DeleteFrame df){
        this.df=df;
    }
}
