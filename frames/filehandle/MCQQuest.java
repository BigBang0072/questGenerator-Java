package frames.filehandle;

import java.lang.*;
import java.io.*;

public class MCQQuest implements Serializable{
    public String quest;
    public String optA,optB,optC,optD;
    public String ans;//
    public MCQQuest(String quest,String optA,String optB,String optC,String optD,String ans){
        this.quest=quest;
        this.optA=optA;
        this.optB=optB;
        this.optC=optC;
        this.optD=optD;
        this.ans=ans;
    }
    public void printThem(){
        System.out.println(this.quest);
        System.out.println(this.optA);
        System.out.println(this.optB);
        System.out.println(this.optC);
        System.out.println(this.optD);
        System.out.println(this.ans);
    }
}
