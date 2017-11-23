package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import frames.filehandle.*;

public class TfListener extends WindowAdapter implements ActionListener,ItemListener{
    SubjectFrame sf;
    TfFrame tf;
    String correct="";
    DatabaseHandler dbms;

    public TfListener(SubjectFrame sf,DatabaseHandler dbms){
        this.sf=sf;
        this.dbms=dbms;
    }

    public void actionPerformed(ActionEvent buttonPress){
        String cmd=buttonPress.getActionCommand();
        if(cmd.equals("Add to Question-Bank")){
            //System.out.println("Adding to Question Bank");
            String quest=tf.questF.getText();
            if(quest.equals("") || correct.equals("")){
                tf.msgF.setText("Please fill all the Fields");
                tf.setVisible(false);
                tf.setVisible(true);//Refreshing
            }
            else{
                //Linking to the database
                System.out.println("Adding to Question Bank"+" "+quest);
                dbms.database.addTfQuest(quest,correct);//Just in one line
                dbms.writeUserDatabase();
                tf.setVisible(false);
                sf.setVisible(true);
            }
        }
        else if(cmd.equals("Cancel")){
            System.out.println("Getting you to Subject Window");
            tf.setVisible(false);
            sf.setVisible(true);
        }
    }

    public void itemStateChanged(ItemEvent optionSelect){
        try{
            List listTemp=(List)optionSelect.getItemSelectable();
            correct=listTemp.getSelectedItem();
            System.out.println("The option selected is: "+correct);
        }
        catch(Exception e){
            System.out.println("Error Converting to List obejct(SEE)");
        }
    }

    public void windowClosing(WindowEvent we){
        System.out.println("Getting you back to Subject frame");
        tf.setVisible(false);
        sf.setVisible(true);
    }

    public void addFrames(TfFrame tf){
        this.tf=tf;
    }
}
