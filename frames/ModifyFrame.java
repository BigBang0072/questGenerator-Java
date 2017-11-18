package frames;

import java.lang.*;
import java.awt.*;

public class ModifyFrame extends Frame{
    public ModifyFrame(String name,int totalQuest){
        setLayout(new BorderLayout());

        //Top Panel: coustamary Welcome.
        Panel paneT=new Panel(new GridBagLayout());
        paneT.setBackground(Color.gray);
        GridBagConstraints constraint=new GridBagConstraints();

        Label greetL=new Label(name+"! Please tick the question to Modify (one at a time)");
        Font greetFont=new Font("Serif",Font.BOLD,18);
        greetL.setFont(greetFont);
        constraint.gridx=0;
        constraint.gridy=0;
        paneT.add(greetL,constraint);

        Font genFont=new Font("Plain",Font.BOLD,15);
        //Center Panel (main challenge)
        Panel paneC=new Panel(new GridBagLayout());
        paneC.setBackground(Color.lightGray);

        List questList=new List(totalQuest);
        questList.setFont(genFont);
        for(int i=0;i<totalQuest;i++){
            if(i<9){
                questList.add("0"+(i+1)+"        First line");
            }
            else{
                questList.add((i+1)+"        First line");
            }
        }
        constraint.gridx=0;
        constraint.gridy=0;
        constraint.weightx=0.5;
        constraint.weighty=0.5;
        //constraint.anchor=GridBagConstraints.WEST;
        paneC.add(questList,constraint);
        constraint.anchor=GridBagConstraints.CENTER;

        //South Panel
        Panel paneS=new Panel(new GridBagLayout());
        paneS.setBackground(Color.gray);

        Button modifyB=new Button("Modify");
        modifyB.setFont(genFont);
        constraint.gridx=0;
        constraint.gridy=0;
        constraint.anchor=GridBagConstraints.EAST;
        paneS.add(modifyB,constraint);
        constraint.anchor=GridBagConstraints.CENTER;

        /*//Scroll Bar in EAST Panel
        Panel paneE=new Panel(new GridBagLayout());
        paneE.setBackground(Color.cyan);
        Scrollbar scb=new Scrollbar(Scrollbar.VERTICAL,0,10,0,100);
        scb.setBackground(Color.gray);
        //scb.setVisibleAmount(10000);
        constraint.fill=GridBagConstraints.BOTH;
        paneE.add(scb,constraint);*/


        add(paneT,BorderLayout.NORTH);
        add(paneS,BorderLayout.SOUTH);
        add(paneC,BorderLayout.CENTER);
        //add(paneE,BorderLayout.EAST);
        setSize(1000,500);
        setTitle("Modify Existing Questions");
    }
    public Insets getInsets(){
        return new Insets(100,100,100,100);
    }
    /*
    public static void main(String args[]){
        String name="Abhinav";
        int questCount=20;
        ModifyFrame mf=new ModifyFrame(name,questCount);
        mf.setVisible(true);
    }*/
}
