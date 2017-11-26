package frames;
import java.lang.*;
import java.awt.*;

public class WelcomeFrame extends Frame{
    //Instance Variable
    TextField restPathF,otherF;


    public WelcomeFrame(String name,WelcomeListener wIsner){
        setLayout(new BorderLayout());

        //Top Panel
        Panel paneT=new Panel(new GridBagLayout());
        paneT.setBackground(Color.gray);
        GridBagConstraints constraint=new GridBagConstraints();

        Label greetL=new Label("Welcome, "+name,Label.CENTER);//Label
        Font greetFont=new Font("Serif",Font.BOLD,18);
        greetL.setFont(greetFont);
        constraint.weightx=0.5;
        constraint.weighty=0.5;
        constraint.gridx=0;
        constraint.gridy=0;
        paneT.add(greetL,constraint);
        Button logoutB=new Button("Logout");//Button to Logout
        logoutB.addActionListener(wIsner);
        Font logoutFont=new Font("Plain",Font.BOLD,15);
        logoutB.setFont(logoutFont);
        constraint.gridx=2;
        constraint.gridy=0;
        paneT.add(logoutB,constraint);

        //Center Panel
        Panel paneC=new Panel(new GridBagLayout());
        paneC.setBackground(Color.lightGray);

        Label infoL=new Label("Please click on the Subject to enter specific Domain");
        Font infoFont=new Font("Plain",Font.BOLD,17);//Description
        infoL.setFont(infoFont);
        constraint.weightx=0;
        constraint.weighty=0.1;
        constraint.gridx=1;
        constraint.gridy=0;
        paneC.add(infoL,constraint);

        Button compB=new Button("Computer Science");
        compB.addActionListener(wIsner);
        Font subFont=new Font("Plain",Font.BOLD,15);
        compB.setFont(subFont);
        constraint.weightx=0;
        constraint.weighty=0;
        constraint.gridx=1;
        constraint.gridy=1;
        paneC.add(compB,constraint);

        Button phyB=new Button("Physics");
        phyB.addActionListener(wIsner);
        phyB.setFont(subFont);
        constraint.weightx=0;
        constraint.weighty=0;
        constraint.gridx=1;
        constraint.gridy=2;
        paneC.add(phyB,constraint);

        TextField otherTF=new TextField(15);
        this.otherF=otherTF;
        constraint.gridx=0;
        constraint.gridy=3;
        paneC.add(otherTF,constraint);

        Button otherB=new Button("Other Subject?(Type and click HERE)");
        otherB.addActionListener(wIsner);
        otherB.setFont(subFont);
        constraint.gridx=1;
        constraint.gridy=3;
        paneC.add(otherB,constraint);

        Label infoBlank=new Label("Directory to save QB(Default set):");
        infoBlank.setFont(new Font("Serif",Font.BOLD,17));
        constraint.weightx=0;
        constraint.weighty=0.1;
        constraint.gridx=0;
        constraint.gridy=21;//Constaing to register only 20 subjects
        paneC.add(infoBlank,constraint);

        Label path=new Label("/home/abhinav/Desktop/OOPMiniProject/questGenerator-Java/");
        path.setFont(subFont);
        constraint.weightx=0;
        constraint.weighty=0.1;
        constraint.gridx=1;
        constraint.gridy=21;
        paneC.add(path,constraint);

        TextField restPath=new TextField("Database",35);
        this.restPathF=restPath;
        constraint.gridx=2;
        constraint.gridy=21;
        paneC.add(restPath,constraint);

        Label caution=new Label("CAUTION: This path will be used to read & write your database");
        caution.setFont(subFont);
        constraint.weightx=0;
        constraint.weighty=0.1;
        constraint.gridx=1;
        constraint.gridy=22;
        paneC.add(caution,constraint);


        //SOUTH PANEL
        /*
        Panel paneS=new Panel(new GridBagLayout());
        paneS.setBackground(Color.white);

        Button addSub=new Button("Add Subject");
        addSub.addActionListener(wIsner);
        addSub.setFont(subFont);
        constraint.weightx=0.1;
        constraint.weighty=0;
        constraint.gridx=0;
        constraint.gridy=0;
        paneS.add(addSub,constraint);

        Button deleteSub=new Button("Remove Subject");
        deleteSub.addActionListener(wIsner);
        deleteSub.setFont(subFont);
        constraint.weightx=0.1;
        constraint.weighty=0;
        constraint.gridx=1;
        constraint.gridy=0;
        paneS.add(deleteSub,constraint);
        */



        add(paneT,BorderLayout.NORTH);
        add(paneC,BorderLayout.CENTER);
        //add(paneS,BorderLayout.SOUTH);
        setTitle("WelcomePage");
        setSize(1600,700);
        addWindowListener(wIsner);
    }
    public Insets getInsets(){
        return new Insets(100,100,100,100);
    }
    /*
    public static void main(String args[]){
        String name="Abhinav";
        WelcomeFrame wf=new WelcomeFrame(name);
        wf.setVisible(true);
    }*/
}
