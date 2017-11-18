package frames;
import java.lang.*;
import java.awt.*;

public class MCQFrame extends Frame{
    public MCQFrame(String name){
        setLayout(new BorderLayout());

        //Top Panel
        Panel paneT=new Panel(new GridBagLayout());
        paneT.setBackground(Color.gray);
        GridBagConstraints constraint=new GridBagConstraints();

        Label greetL=new Label(name+"! Please type the MCQ Question and Options in the space Below");
        Font greetFont=new Font("Serif",Font.BOLD,18);
        greetL.setFont(greetFont);
        constraint.gridx=0;
        constraint.gridy=0;
        paneT.add(greetL,constraint);

        //Center Panel
        Panel paneC=new Panel(new GridBagLayout());
        paneC.setBackground(Color.lightGray);

        Label questL=new Label("Question : ");
        Font questFont=new Font("Plain",Font.BOLD,18);
        questL.setFont(questFont);
        constraint.anchor=GridBagConstraints.WEST;
        constraint.gridx=0;
        constraint.gridy=0;
        constraint.weightx=0.1;
        constraint.weighty=0.1;
        paneC.add(questL,constraint);

        TextArea questTA=new TextArea(6,60);
        constraint.anchor=GridBagConstraints.WEST;
        constraint.gridx=2;
        constraint.gridy=0;
        paneC.add(questTA,constraint);
        constraint.anchor=GridBagConstraints.WEST;

        Label optL=new Label("Options : ");
        optL.setFont(questFont);
        constraint.gridx=0;
        constraint.gridy=1;
        constraint.weightx=0.5;
        constraint.weighty=0;
        paneC.add(optL,constraint);

        TextField opt1=new TextField(25);
        Label opt1L=new Label("(a). ");
        opt1L.setFont(questFont);
        constraint.gridx=1;
        constraint.gridy=1;
        constraint.weightx=0;
        constraint.weighty=0;
        constraint.anchor=GridBagConstraints.EAST;
        paneC.add(opt1L,constraint);
        constraint.gridx=2;
        constraint.gridy=1;
        constraint.weightx=0.1;
        constraint.weighty=0;
        constraint.anchor=GridBagConstraints.WEST;
        paneC.add(opt1,constraint);

        TextField opt2=new TextField(25);
        Label opt2L=new Label("(b). ");
        opt2L.setFont(questFont);
        constraint.gridx=3;
        constraint.gridy=1;
        constraint.weightx=0;
        constraint.weighty=0;
        constraint.anchor=GridBagConstraints.EAST;
        paneC.add(opt2L,constraint);
        constraint.gridx=4;
        constraint.gridy=1;
        constraint.weightx=0.9;
        constraint.weighty=0;
        constraint.anchor=GridBagConstraints.WEST;
        paneC.add(opt2,constraint);

        TextField opt3=new TextField(25);
        Label opt3L=new Label("(c). ");
        opt3L.setFont(questFont);
        constraint.gridx=1;
        constraint.gridy=2;
        constraint.weightx=0;
        constraint.weighty=0;
        constraint.anchor=GridBagConstraints.EAST;
        paneC.add(opt3L,constraint);
        constraint.gridx=2;
        constraint.gridy=2;
        constraint.weightx=0.5;
        constraint.weighty=0;
        constraint.anchor=GridBagConstraints.WEST;
        paneC.add(opt3,constraint);

        TextField opt4=new TextField(25);
        Label opt4L=new Label("(d). ");
        opt4L.setFont(questFont);
        constraint.gridx=3;
        constraint.gridy=2;
        constraint.weightx=0;
        constraint.weighty=0;
        constraint.anchor=GridBagConstraints.EAST;
        paneC.add(opt4L,constraint);
        constraint.gridx=4;
        constraint.gridy=2;
        constraint.weightx=0;
        constraint.weighty=0;
        constraint.anchor=GridBagConstraints.WEST;
        paneC.add(opt4,constraint);

        constraint.anchor=GridBagConstraints.WEST;//default
        Label ansL=new Label("Correct Option : ");
        ansL.setFont(questFont);
        constraint.gridx=0;
        constraint.gridy=4;
        constraint.weightx=0.1;
        constraint.weighty=0.1;
        paneC.add(ansL,constraint);

        List optList=new List(4);
        optList.setFont(questFont);
        optList.add("a.");
        optList.add("b.");
        optList.add("c.");
        optList.add("d.");
        constraint.gridx=2;
        constraint.gridy=4;
        constraint.anchor=GridBagConstraints.WEST;//default
        paneC.add(optList,constraint);


        Button insertB=new Button("Add to Question Bank");
        insertB.setFont(new Font("Plain",Font.BOLD,16));
        constraint.gridx=4;
        constraint.gridy=4;
        paneC.add(insertB,constraint);


        add(paneT,BorderLayout.NORTH);
        add(paneC,BorderLayout.CENTER);
        setTitle("Insert:MCQ-Question");
        setSize(1250,800);
    }
    public Insets getInsets(){
        return new Insets(100,100,100,100);
    }
    /*
    public static void main(String args[]){
        String name="Kalpana";
        MCQFrame mf=new MCQFrame(name);
        mf.setVisible(true);
    }*/
}
