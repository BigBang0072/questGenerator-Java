package frames;
import java.lang.*;
import java.awt.*;

public class FillFrame extends Frame{
    public FillFrame(String name){
        setLayout(new BorderLayout());

        //Top Panel
        Panel paneT=new Panel(new GridBagLayout());
        paneT.setBackground(Color.gray);
        GridBagConstraints constraint=new GridBagConstraints();

        Label greetL=new Label(name+"! Please type the FillInBlanks Question in the space Below");
        Font greetFont=new Font("Serif",Font.BOLD,18);
        greetL.setFont(greetFont);
        constraint.gridx=0;
        constraint.gridy=0;
        paneT.add(greetL,constraint);

        //CENTER PANEL
        Panel paneC=new Panel(new GridBagLayout());
        paneC.setBackground(Color.lightGray);

        Label firstL=new Label("Qustion before 'space' ");
        Font firstF=new Font("Plain",Font.BOLD,17);
        firstL.setFont(firstF);
        constraint.gridx=0;
        constraint.gridy=0;
        constraint.weightx=0.1;
        constraint.weighty=0;
        paneC.add(firstL,constraint);
        Label secondL=new Label("Question after 'space' ");
        secondL.setFont(firstF);
        constraint.gridx=2;
        constraint.gridy=0;
        paneC.add(secondL,constraint);

        TextArea firstTA=new TextArea(3,50);
        TextArea secondTA=new TextArea(3,50);
        constraint.gridx=0;
        constraint.gridy=1;
        paneC.add(firstTA,constraint);
        constraint.gridx=2;
        constraint.gridy=1;
        paneC.add(secondTA,constraint);

        //constraint.anchor=GridBagConstraints.WEST;//default
        Label ansL=new Label("Correct Answer : ");
        ansL.setFont(firstF);
        constraint.gridx=0;
        constraint.gridy=3;
        constraint.weightx=0.1;
        constraint.weighty=0.1;
        paneC.add(ansL,constraint);

        TextField ansF=new TextField(25);
        constraint.gridx=2;
        constraint.gridy=3;
        //constraint.anchor=GridBagConstraints.WEST;//default
        paneC.add(ansF,constraint);


        Button insertB=new Button("Add to Question Bank");
        insertB.setFont(new Font("Plain",Font.BOLD,16));
        constraint.gridx=2;
        constraint.gridy=4;
        paneC.add(insertB,constraint);


        add(paneT,BorderLayout.NORTH);
        add(paneC,BorderLayout.CENTER);

        setSize(1000,500);
        setTitle("Insert:Fill In the Blanks-Question");
    }
    public Insets getInsets(){
        return new Insets(100,100,100,100);
    }
    /*
    public static void main(String args[]){
        String name="Abhinav";
        FillFrame f=new FillFrame(name);
        f.setVisible(true);
    }*/
}
