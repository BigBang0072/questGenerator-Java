package filehandle;

import java.lang.*;
import java.io.*;

public class TfQuest implements Serializable{
    public String quest;
    public String ans;

    public TfQuest(String quest,String ans){
        this.quest=quest;
        this.ans=ans;
    }
    public void printThem(){
        System.out.println(quest);
        System.out.println(ans);
    }
}
