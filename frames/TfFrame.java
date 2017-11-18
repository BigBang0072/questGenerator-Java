package frames;
import java.lang.*;
import java.awt.*;

public class TfFrame extends Frame{
    public TfFrame(String name){
        setLayout(new BorderLayout());

        //Top Panel
        Panel paneT=new Panel(new GridBagLayout());
        paneT.setBackground(Color.gray);
        GridBagConstraints constraint =new GridBagConstraints();

        Label greetL=new Label(name+"! Please enter the True/Flase Question in space below");
        Font greetFont=new Font("Serif",Font.BOLD,18);
        greetL.setFont(greetFont);
        constraint.gridx=0;
        constraint.gridy=0;
        paneT.add(greetL,constraint);

        //CENTER PANEL
        Panel paneC=new Panel(new GridBagLayout());
        paneC.setBackground(Color.lightGray);

        Label questL=new Label("Question : ");
        Font questFont=new Font("Plain",Font.BOLD,15);
        questL.setFont(questFont);
        constraint.gridx=0;
        constraint.gridy=0;
        constraint.weightx=0.5;
        constraint.weighty=0.5;
        constraint.anchor=GridBagConstraints.WEST;
        paneC.add(questL,constraint);
        constraint.anchor=GridBagConstraints.CENTER;

        TextArea questTA=new TextArea(4,70);
        constraint.gridx=1;
        constraint.gridy=0;
        constraint.weightx=0.5;
        constraint.weighty=0.5;
        paneC.add(questTA,constraint);

        Label answerL=new Label("Correct Answer : ");
        answerL.setFont(questFont);
        constraint.gridx=0;
        constraint.gridy=1;
        constraint.weightx=0.5;
        constraint.weighty=0;
        constraint.anchor=GridBagConstraints.WEST;
        paneC.add(answerL,constraint);
        constraint.anchor=GridBagConstraints.CENTER;

        List tF=new List(2);
        tF.setFont(questFont);
        tF.add("True");
        tF.add("False");
        constraint.gridx=1;
        constraint.gridy=1;
        paneC.add(tF,constraint);

        Button insertB=new Button("Add to Question-Bank");
        insertB.setFont(questFont);
        constraint.gridx=1;
        constraint.gridy=2;
        constraint.weightx=0.5;
        constraint.weighty=0.5;
        paneC.add(insertB,constraint);


        add(paneC,BorderLayout.CENTER);
        add(paneT,BorderLayout.NORTH);
        setSize(1000,500);
        setTitle("Insert:True/False-Question");

    }
    public Insets getInsets(){
        return new Insets(100,100,100,100);
    }
    /*
    public static void main(String args[]){
        String name="Kalpana";
        TfFrame tf=new TfFrame(name);
        tf.setVisible(true);
    }*/
}
