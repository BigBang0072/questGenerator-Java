package frames;
import java.lang.*;
import java.awt.*;

public class ExportFrame extends Frame{
    //Instance Variable
    Button viewF;

    public ExportFrame(String name,int totalQuest,ExportListener eIsner){
        setLayout(new BorderLayout());

        //Top Panel: coustamary Welcome.
        Panel paneT=new Panel(new GridBagLayout());
        paneT.setBackground(Color.gray);
        GridBagConstraints constraint=new GridBagConstraints();

        Label greetL=new Label(name+"! See the Generated Question Paper");
        Font greetFont=new Font("Serif",Font.BOLD,18);
        greetL.setFont(greetFont);
        constraint.gridx=0;
        constraint.gridy=0;
        paneT.add(greetL,constraint);

        Button goBackB=new Button("Cancel");
        goBackB.addActionListener(eIsner);
        Font buttonFont=new Font("Plain",Font.BOLD,15);
        constraint.gridx=1;
        constraint.gridy=0;
        constraint.weightx=0.5;
        paneT.add(goBackB,constraint);


        Font genFont=new Font("Plain",Font.BOLD,15);
        //Center Panel (main challenge)
        ScrollPane scrollP=new ScrollPane();
        Panel paneC=new Panel(new GridBagLayout());
        paneC.setBackground(Color.lightGray);

        GridBagConstraints interPanelCon=new GridBagConstraints();
        for(int i=0;i<totalQuest;i++){
            Panel pTemp=new Panel(new GridBagLayout());
            pTemp.setBackground(Color.cyan);

            Label lTemp=new Label("This is my Question on a new Panel "+(i+1));
            lTemp.setFont(genFont);
            constraint.gridx=0;
            constraint.gridy=0;
            constraint.weightx=0.5;
            constraint.weighty=0.5;
            pTemp.add(lTemp,constraint);

            interPanelCon.gridx=0;
            interPanelCon.gridy=i;
            interPanelCon.weighty=0.5;
            interPanelCon.weightx=0;
            paneC.add(pTemp,interPanelCon);
        }
        scrollP.add(paneC);


        //constraint.anchor=GridBagConstraints.CENTER;

        //South Panel
        Panel paneS=new Panel(new GridBagLayout());
        paneS.setBackground(Color.gray);

        Button reshuffleB=new Button("Reshuffle");
        reshuffleB.addActionListener(eIsner);
        reshuffleB.setFont(genFont);
        constraint.gridx=1;
        constraint.gridy=0;
        constraint.weightx=0.5;
        constraint.weighty=0;
        paneS.add(reshuffleB,constraint);

        Button modifyB=new Button("Export Ques to File");
        modifyB.addActionListener(eIsner);
        modifyB.setFont(genFont);
        constraint.gridx=2;
        constraint.gridy=0;
        paneS.add(modifyB,constraint);

        Button solnB=new Button("Export Soln to File");
        solnB.addActionListener(eIsner);
        solnB.setFont(genFont);
        constraint.gridx=3;
        constraint.gridy=0;
        paneS.add(solnB,constraint);

        Button seeSolnB=new Button("View Solution");
        this.viewF=seeSolnB;
        seeSolnB.addActionListener(eIsner);
        seeSolnB.setFont(genFont);
        constraint.gridx=0;
        constraint.gridy=0;
        paneS.add(seeSolnB,constraint);


        add(paneT,BorderLayout.NORTH);
        add(paneS,BorderLayout.SOUTH);
        add(scrollP,BorderLayout.CENTER);
        setSize(1000,1000);
        setTitle("Generate Questions-Paper");
        addWindowListener(eIsner);
    }
    public Insets getInsets(){
        return new Insets(100,100,100,100);
    }
    /*
    public static void main(String args[]){
        String name="Abhinav";
        int questCount=20;
        ExportFrame mf=new ExportFrame(name,questCount);
        mf.setVisible(true);
    }*/
}
