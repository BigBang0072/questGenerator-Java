package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteListener extends WindowAdapter implements ActionListener,ItemListener{
    //Instance Varaible
    SubjectFrame sf;
    DeleteFrame df;
    int quesNo=-1;

    public DeleteListener(SubjectFrame sf){
        this.sf=sf;
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
