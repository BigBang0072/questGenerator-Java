package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class FillListener extends WindowAdapter implements ActionListener{
    SubjectFrame sf;
    FillFrame ff;

    public FillListener(SubjectFrame sf){
        this.sf=sf;
    }

    public void actionPerformed(ActionEvent buttonPressed){
        String cmd=buttonPressed.getActionCommand();
        if(cmd.equals("Add to Question Bank")){
            String fHalf=ff.fHalfF.getText();
            String lHalf=ff.lHalfF.getText();
            String ansC=ff.ansCF.getText();
            if(fHalf.equals("") || lHalf.equals("") || ansC.equals("")){
                ff.msgF.setText("Please fill all the fields!!");
                ff.setVisible(false);
                ff.setVisible(true);//Refreshing the window.
            }
            else{
                System.out.println("Adding to Question Bank");
                //Have to link with dataBase.
                ff.setVisible(false);
                sf.setVisible(true);
            }
        }
        else if(cmd.equals("Cancel")){
            System.out.println("Going back to Subject Frame");
            ff.setVisible(false);
            sf.setVisible(true);
        }
    }

    public void windowClosing(WindowEvent we){
        System.out.println("Returning you to the subject Window");
        ff.setVisible(false);
        sf.setVisible(true);
    }

    public void addFrames(FillFrame ff){
        this.ff=ff;
    }
}