package frames;

import java.lang.*;
import java.awt.*;

public class LoginFrame extends Frame{
    TextField userNameF,passwordF;
    Label msgF;

    public LoginFrame(LoginListener lIsner){
        //Main Layout is the Border Layout and nested inside is other ones.
        setLayout(new BorderLayout());

        //TOP PANEL
        Panel paneT=new Panel(new GridBagLayout());
        paneT.setBackground(Color.gray);
        GridBagConstraints constraint=new GridBagConstraints();

        //Adding Greeting Label
        Label greet=new Label("Welcome to the QUESTION MANAGEMENT SYSTEM(QMS)",Label.CENTER);
        Font greetFont=new Font("Serif",Font.BOLD,17);
        greet.setFont(greetFont);
        //constraint.fill=GridBagConstraints.HORIZONTAL;
        //constraint.fill=GridBagConstraints.BOTH;
        //constraint.gridheight=2;
        //constraint.gridwidth=1;
        constraint.weightx=0.8;
        constraint.weighty=0.8;
        constraint.gridx=0;
        constraint.gridy=0;
        paneT.add(greet,constraint);

        //Adding additional registration button
        Button register=new Button("New Registration");
        register.addActionListener(lIsner);
        Font regFont=new Font("Plain",Font.BOLD,15);
        register.setFont(regFont);
        //constraint.fill=GridBagConstraints.HORIZONTAL;
        //constraint.fill=GridBagConstraints.BOTH;
        //constraint.gridheight=2;
        //constraint.gridwidth=1;
        constraint.weightx=0.8;
        constraint.weighty=0.8;
        constraint.gridx=3;
        constraint.gridy=0;
        paneT.add(register,constraint);


        //CENTER PANEL

        Panel paneC=new Panel(new GridBagLayout());
        paneC.setBackground(Color.lightGray);

        //UserName Entring Area
        Label msgL=new Label("For registring Fill the details and then click New Registation",Label.CENTER);
        this.msgF=msgL;
        Font userFont=new Font("Plain",Font.BOLD,15);
        msgL.setFont(userFont);
        constraint.gridx=1;
        constraint.gridy=0;
        constraint.weighty=0.5;
        paneC.add(msgL,constraint);

        Label userNameL=new Label("UserName : ",Label.RIGHT);
        userNameL.setFont(userFont);
        constraint.gridx=0;
        constraint.gridy=1;
        constraint.weightx=0.5;
        constraint.weighty=0;
        paneC.add(userNameL,constraint);
        TextField userNameT=new TextField(20);
        userNameF=userNameT;
        constraint.gridx=1;
        constraint.gridy=1;
        paneC.add(userNameT,constraint);

        //Password Staging area.
        Label passwordL=new Label("Password : ",Label.RIGHT);
        //passwordL.setAlignment(Label.RIGHT);
        passwordL.setFont(userFont);
        constraint.gridx=0;
        constraint.gridy=2;
        paneC.add(passwordL,constraint);
        TextField passwordT=new TextField(20);
        passwordF=passwordT;
        passwordT.setEchoChar('*');
        constraint.gridx=1;
        constraint.gridy=2;
        paneC.add(passwordT,constraint);


        Button loginB=new Button("Login To Profile");
        loginB.addActionListener(lIsner);
        loginB.setFont(userFont);
        constraint.gridx=1;
        constraint.gridy=3;
        constraint.weighty=0.5;
        paneC.add(loginB,constraint);

        add(paneT,BorderLayout.NORTH);
        add(paneC,BorderLayout.CENTER);
        setTitle("LOGIN PAGE");
        //setBackground(Color.gray);
        setSize(1000,500);
        addWindowListener(lIsner);

    }
    public Insets getInsets(){
        return new Insets(100,100,100,100);
    }
    /*
    public static void main(String args[]){
        LoginListener temp=new LoginListener();
        LoginFrame lf=new LoginFrame(temp);
        lf.setVisible(true);
    }
    */
}
