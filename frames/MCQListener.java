package frames;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class MCQListener extends WindowAdapter implements ActionListener,ItemListener{
    SubjectFrame sf;
    MCQFrame mf;
    String user;
    String ans;
    public MCQListener(SubjectFrame sf,String user){
        this.sf=sf;
        this.user=user;
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
            if(quest.equals("") || optA.equals("") || optB.equals("") || optD.equals("")){
                System.out.println("Please enter all the fields");
            }
            else{
                System.out.println("Adding the question to Question Bank");
                System.out.println(quest);
                System.out.println(optA);
                System.out.println(optB);
                System.out.println(optC);
                System.out.println(optD);
                mf.setVisible(false);
                sf.setVisible(true);
            }
        }
        else if(cmd.equals("Cancel")){
            System.out.println("Cancelled!!");
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
