package frames;
import java.lang.*;
import java.awt.*;

public class SubjectFrame extends Frame{
    public SubjectFrame(String name,String subject,SubjectListener sIsner){
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
        goBack.addActionListener(sIsner);
        Font goBackFont=new Font("Plain",Font.BOLD,15);
        goBack.setFont(goBackFont);
        constraint.gridx=2;
        constraint.weightx=0;
        paneT.add(goBack,constraint);

        Button logoutB=new Button("Logout");//Button to Logout
        logoutB.addActionListener(sIsner);
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

        //Panel for the INSERT subPanel
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

        CheckboxGroup cbgInsert=new CheckboxGroup();
        Checkbox mcqI,fillInI,tFI;
        Font optFontI=new Font("Plain",Font.BOLD,15);
        mcqI=new Checkbox("MCQ",cbgInsert,true);
        mcqI.addItemListener(sIsner);
        tFI=new Checkbox("True/False",cbgInsert,false);
        tFI.addItemListener(sIsner);
        fillInI=new Checkbox("Fill in Blanks",cbgInsert,false);
        fillInI.addItemListener(sIsner);
        mcqI.setFont(optFontI);
        tFI.setFont(optFontI);
        fillInI.setFont(optFontI);
        constraint.anchor=GridBagConstraints.WEST;
        constraint.gridx=0;
        constraint.gridy=1;
        paneInsert.add(mcqI,constraint);
        constraint.gridx=0;
        constraint.gridy=2;
        paneInsert.add(tFI,constraint);
        constraint.gridx=0;
        constraint.gridy=3;
        paneInsert.add(fillInI,constraint);

        Button InsertB=new Button("Insert!!");
        InsertB.addActionListener(sIsner);
        InsertB.setFont(optFontI);
        constraint.anchor=GridBagConstraints.EAST;
        constraint.gridx=0;
        constraint.gridy=4;
        paneInsert.add(InsertB,constraint);

        interCons.gridx=0;
        interCons.gridy=0;
        paneC.add(paneInsert,interCons);

        //Panel for Generate subPanel
        Panel paneGenerate=new Panel(new GridBagLayout());
        paneGenerate.setBackground(Color.yellow);

        Label generateL=new Label("Please select 'type' of Question to Generate Question Bank");
        generateL.setFont(insertLF);
        constraint.weighty=0.1;
        constraint.weightx=0;
        constraint.gridx=0;
        constraint.gridy=0;
        paneGenerate.add(generateL,constraint);

        CheckboxGroup cbgGenerate=new CheckboxGroup();
        Checkbox mcq,fillIn,tF;
        Font optFont=new Font("Plain",Font.BOLD,15);
        mcq=new Checkbox("MCQ",cbgGenerate,true);
        mcq.addItemListener(sIsner);
        tF=new Checkbox("True/False",cbgGenerate,false);
        tF.addItemListener(sIsner);
        fillIn=new Checkbox("Fill in Blanks",cbgGenerate,false);
        fillIn.addItemListener(sIsner);
        mcq.setFont(optFont);
        tF.setFont(optFont);
        fillIn.setFont(optFont);
        constraint.anchor=GridBagConstraints.WEST;
        constraint.gridx=0;
        constraint.gridy=1;
        paneGenerate.add(mcq,constraint);
        constraint.gridx=0;
        constraint.gridy=2;
        paneGenerate.add(tF,constraint);
        constraint.gridx=0;
        constraint.gridy=3;
        paneGenerate.add(fillIn,constraint);

        Button generateB=new Button("Generate!!");
        generateB.addActionListener(sIsner);
        generateB.setFont(optFont);
        constraint.anchor=GridBagConstraints.EAST;
        constraint.gridx=0;
        constraint.gridy=4;
        paneGenerate.add(generateB,constraint);

        interCons.gridx=1;
        interCons.gridy=0;
        paneC.add(paneGenerate,interCons);

        //Panel for Modify subPanel
        Panel paneModify=new Panel(new GridBagLayout());
        paneModify.setBackground(Color.orange);

        Label modifyL=new Label("Please Click to modify existing Question Bank");
        modifyL.setFont(insertLF);
        constraint.weighty=0.1;
        constraint.weightx=0;
        constraint.gridx=0;
        constraint.gridy=0;
        paneModify.add(modifyL,constraint);

        CheckboxGroup cbgModify=new CheckboxGroup();
        Checkbox mcqM,fillInM,tFM;
        Font optFontM=new Font("Plain",Font.BOLD,15);
        mcqM=new Checkbox("MCQ",cbgModify,true);
        mcqM.addItemListener(sIsner);
        tFM=new Checkbox("True/False",cbgModify,false);
        tFM.addItemListener(sIsner);
        fillInM=new Checkbox("Fill in Blanks",cbgModify,false);
        fillInM.addItemListener(sIsner);
        mcqM.setFont(optFontM);
        tFM.setFont(optFontM);
        fillInM.setFont(optFontM);
        constraint.anchor=GridBagConstraints.WEST;
        constraint.gridx=0;
        constraint.gridy=1;
        paneModify.add(mcqM,constraint);
        constraint.gridx=0;
        constraint.gridy=2;
        paneModify.add(tFM,constraint);
        constraint.gridx=0;
        constraint.gridy=3;
        paneModify.add(fillInM,constraint);

        Button ModifyB=new Button("Modify!!");
        ModifyB.addActionListener(sIsner);
        ModifyB.setFont(optFontM);
        constraint.anchor=GridBagConstraints.EAST;
        constraint.gridx=0;
        constraint.gridy=4;
        paneModify.add(ModifyB,constraint);

        interCons.gridx=0;
        interCons.gridy=1;
        paneC.add(paneModify,interCons);

        //Panel for Delete Subpanel
        Panel paneDelete=new Panel(new GridBagLayout());
        paneDelete.setBackground(Color.red);

        Label deleteL=new Label("Please Click to delete question in existing Question Bank");
        deleteL.setFont(insertLF);
        constraint.weighty=0.1;
        constraint.weightx=0;
        constraint.gridx=0;
        constraint.gridy=0;
        paneDelete.add(deleteL,constraint);

        CheckboxGroup cbgDelete=new CheckboxGroup();
        Checkbox mcqD,fillInD,tFD;
        Font optFontD=new Font("Plain",Font.BOLD,15);
        mcqD=new Checkbox("MCQ",cbgDelete,true);
        mcqD.addItemListener(sIsner);
        tFD=new Checkbox("True/False",cbgDelete,false);
        tFD.addItemListener(sIsner);
        fillInD=new Checkbox("Fill in Blanks",cbgDelete,false);
        fillInD.addItemListener(sIsner);
        mcqD.setFont(optFontD);
        tFD.setFont(optFontD);
        fillInD.setFont(optFontD);
        constraint.anchor=GridBagConstraints.WEST;
        constraint.gridx=0;
        constraint.gridy=1;
        paneDelete.add(mcqD,constraint);
        constraint.gridx=0;
        constraint.gridy=2;
        paneDelete.add(tFD,constraint);
        constraint.gridx=0;
        constraint.gridy=3;
        paneDelete.add(fillInD,constraint);

        Button DeleteB=new Button("Delete!!");
        DeleteB.addActionListener(sIsner);
        DeleteB.setFont(optFontD);
        constraint.anchor=GridBagConstraints.EAST;
        constraint.gridx=0;
        constraint.gridy=4;
        paneDelete.add(DeleteB,constraint);

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
    /*
    public static void main(String args[]){
        String subject="Physics";
        String name="Abhinav";
        SubjectFrame sf=new SubjectFrame(name,subject);
        sf.setVisible(true);
    }*/
}
