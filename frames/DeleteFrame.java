package frames;
import java.lang.*;
import java.awt.*;

public class DeleteFrame extends Frame{
    //Instance Variable
    Label msgF;

    public DeleteFrame(String name,int totalQuest,DeleteListener dIsner){
        //Top Panel: coustamary Welcome.
        Panel paneT=new Panel(new GridBagLayout());
        paneT.setBackground(Color.gray);
        GridBagConstraints constraint=new GridBagConstraints();

        Label greetL=new Label(name+"! Please tick the question to Delete (one at a time)");
        Font greetFont=new Font("Serif",Font.BOLD,18);
        greetL.setFont(greetFont);
        constraint.gridx=0;
        constraint.gridy=0;
        paneT.add(greetL,constraint);

        Button goBackB=new Button("Cancel");
        goBackB.addActionListener(dIsner);
        Font buttonFont=new Font("Plain",Font.BOLD,15);
        constraint.gridx=1;
        constraint.gridy=0;
        constraint.weightx=0.5;
        paneT.add(goBackB,constraint);

        Font genFont=new Font("Plain",Font.BOLD,15);
        //Center Panel (main challenge)
        Panel paneC=new Panel(new GridBagLayout());
        paneC.setBackground(Color.lightGray);

        List questList=new List(totalQuest);
        questList.addItemListener(dIsner);
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

        Button modifyB=new Button("Delete");
        modifyB.addActionListener(dIsner);
        modifyB.setFont(genFont);
        modifyB.setBackground(Color.red);
        constraint.gridx=1;
        constraint.gridy=0;
        constraint.weightx=0.2;
        constraint.anchor=GridBagConstraints.EAST;
        paneS.add(modifyB,constraint);
        constraint.anchor=GridBagConstraints.CENTER;

        Label msgL=new Label("");
        this.msgF=msgL;
        msgL.setFont(new Font("Plain",Font.BOLD,17));
        constraint.gridx=0;
        constraint.gridy=0;
        paneS.add(msgL,constraint);


        add(paneT,BorderLayout.NORTH);
        add(paneS,BorderLayout.SOUTH);
        add(paneC,BorderLayout.CENTER);
        //add(paneE,BorderLayout.EAST);
        setSize(1000,500);
        setTitle("Delete Existing Questions");
        addWindowListener(dIsner);
    }
    public Insets getInsets(){
        return new Insets(100,100,100,100);
    }
    /*
    public static void main(String args[]){
        String name="Abhinav";
        int questCount=20;
        DeleteFrame df=new DeleteFrame(name,questCount);
        df.setVisible(true);
    }*/
}
