import java.lang.*;
import java.awt.*;

public class SubjectFrame extends Frame{
    SubjectFrame(String name,String subject){
        setLayout(new BorderLayout());

        //Top Panel
        Panel paneT=new Panel(new GridBagLayout());
        paneT.setBackground(Color.gray);
        GridBagConstraints constraint=new GridBagConstraints();

        Label greetL=new Label("Welcome, "+name,Label.CENTER);//Label
        Font greetFont=new Font("Serif",Font.BOLD,18);
        greetL.setFont(greetFont);
        constraint.weightx=0.5;
        constraint.weighty=0;
        constraint.gridx=0;
        constraint.gridy=0;
        paneT.add(greetL,constraint);

        Button goBack=new Button("Go Back");
        Font goBackFont=new Font("Plain",Font.BOLD,15);
        goBack.setFont(goBackFont);
        constraint.gridx=2;
        constraint.weightx=0;
        paneT.add(goBack,constraint);

        Button logoutB=new Button("Logout");//Button to Logout
        logoutB.setFont(goBackFont);
        constraint.gridx=3;
        constraint.gridy=0;
        paneT.add(logoutB,constraint);



        //WEST PANE
        int length=subject.length();
        Panel paneW=new Panel(new GridLayout(length,1));
        paneW.setBackground(Color.cyan);
        Font subFont=new Font("Serif",Font.BOLD,50);
        for(int i=0;i<length;i++){
            Label text=new Label(""+subject.charAt(i));
            text.setFont(subFont);
            paneW.add(text);
        }

        //Centre Panel
        Panel paneC=new Panel(new GridBagLayout());
        GridBagConstraints interCons=new GridBagConstraints();
        interCons.weightx=0.1;
        interCons.weighty=0.1;

        Panel paneInsert=new Panel(new GridBagLayout());
        paneInsert.setBackground(Color.green);
        Label insertL=new Label("Please select 'type' of Question and Insert");
        Font insertLF=new Font("Plain",Font.BOLD,18);
        insertL.setFont(insertLF);
        constraint.weighty=0.1;
        constraint.weightx=0;
        constraint.gridx=0;
        constraint.gridy=0;
        paneInsert.add(insertL,constraint);
        interCons.gridx=0;
        interCons.gridy=0;
        paneC.add(paneInsert,interCons);

        Panel paneGenerate=new Panel(new GridBagLayout());
        paneGenerate.setBackground(Color.yellow);
        Label generateL=new Label("Please select 'type' of Question to Generate Question Bank");
        generateL.setFont(insertLF);
        constraint.weighty=0.1;
        constraint.weightx=0;
        constraint.gridx=0;
        constraint.gridy=0;
        paneGenerate.add(generateL,constraint);
        interCons.gridx=1;
        interCons.gridy=0;
        paneC.add(paneGenerate,interCons);

        Panel paneModify=new Panel(new GridBagLayout());
        paneModify.setBackground(Color.orange);
        Label modifyL=new Label("Please Click to modify existing Question Bank");
        modifyL.setFont(insertLF);
        constraint.weighty=0.1;
        constraint.weightx=0;
        constraint.gridx=0;
        constraint.gridy=0;
        paneModify.add(modifyL,constraint);
        interCons.gridx=0;
        interCons.gridy=1;
        paneC.add(paneModify,interCons);

        Panel paneDelete=new Panel(new GridBagLayout());
        paneDelete.setBackground(Color.red);
        Label deleteL=new Label("Please Click to delete question in existing Question Bank");
        deleteL.setFont(insertLF);
        constraint.weighty=0.1;
        constraint.weightx=0;
        constraint.gridx=0;
        constraint.gridy=0;
        paneDelete.add(deleteL,constraint);
        interCons.gridx=1;
        interCons.gridy=1;
        paneC.add(paneDelete,interCons);



        add(paneT,BorderLayout.NORTH);
        add(paneW,BorderLayout.WEST);
        add(paneC,BorderLayout.CENTER);
        setTitle("Welcome To "+subject);
        setSize(1500,800);

    }

    public Insets getInsets(){
        return new Insets(60,100,100,100);
    }
    public static void main(String args[]){
        String subject="Physics";
        String name="Abhinav";
        SubjectFrame sf=new SubjectFrame(name,subject);
        sf.setVisible(true);
    }
}
