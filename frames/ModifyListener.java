package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class ModifyListener extends WindowAdapter implements ActionListener,ItemListener{
    //Instance Varaible
    SubjectFrame sf;
    ModifyFrame mf;
    int quesNo=-1;
    public ModifyListener(SubjectFrame sf){
        this.sf=sf;
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
