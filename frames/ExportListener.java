package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class ExportListener extends WindowAdapter implements ActionListener{
    //Instance Varaible
    SubjectFrame sf;
    ExportFrame efQues;
    ExportFrame efSoln;

    public ExportListener(SubjectFrame sf){
        this.sf=sf;
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
