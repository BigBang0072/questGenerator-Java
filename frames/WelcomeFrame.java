package frames;
import java.lang.*;
import java.awt.*;

public class WelcomeFrame extends Frame{

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

        Label infoBlank=new Label("");
        constraint.weightx=0;
        constraint.weighty=0.1;
        constraint.gridx=1;
        constraint.gridy=20;//Constaing to register only 20 subjects
        paneC.add(infoBlank,constraint);

        //SOUTH PANEL
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




        add(paneT,BorderLayout.NORTH);
        add(paneC,BorderLayout.CENTER);
        add(paneS,BorderLayout.SOUTH);
        setTitle("WelcomePage");
        setSize(1000,600);
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
