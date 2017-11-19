package filehandle;

import java.lang.*;
import java.io.*;

public class FillQuest implements Serializable{
    String beforeQuest;
    String afterQuest;
    String ans;
    public FillQuest(String beforeQuest,String afterQuest,String ans){
        this.beforeQuest=beforeQuest;
        this.afterQuest=afterQuest;
        this.ans=ans;
    }
    public void printThem(){
        System.out.println(beforeQuest);
        System.out.println(afterQuest);
        System.out.println(ans);
    }
}
