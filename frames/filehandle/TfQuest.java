package filehandle;

import java.lang.*;
import java.io.*;

public class TfQuest implements Serializable{
    String quest;
    String ans;

    public TfQuest(String quest,String ans){
        this.quest=quest;
        this.ans=ans;
    }
    public void printThem(){
        System.out.println(quest);
        System.out.println(ans);
    }
}
