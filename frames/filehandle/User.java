package filehandle;

import java.lang.*;
import java.io.*;

public class User{
    MCQQuest[] mcq;//type=1
    FillQuest[] fill;//type=2
    TfQuest[] tf;//type=3
    int[] size,filled;

    public User(){
        mcq=new MCQQuest[20];
        fill=new FillQuest[20];
        tf=new TfQuest[20];//default size of array;
        size=new int[] {20,20,20};
        filled=new int[] {0,0,0};
    }

    public void addMCQQuest(String quest,String optA,String optB,String optC,String optD,String ans){
        MCQQuest temp=new MCQQuest(quest,optA,optB,optC,optD,ans);
        try{
            mcq[filled[0]]=temp;
            filled[0]=filled[0]+1;
        }
        catch(ArrayIndexOutOfBoundsException oob){
            extendDataBase(1);
            mcq[filled[0]]=temp;
            filled[0]=filled[0]+1;
        }
    }

    public void addFillQuest(String beforeQuest,String afterQuest,String ans){
        FillQuest temp=new FillQuest(beforeQuest,afterQuest,ans);
        try{
            fill[filled[1]]=temp;
            filled[1]+=1;
        }
        catch(ArrayIndexOutOfBoundsException oob){
            extendDataBase(2);
            fill[filled[1]]=temp;
            filled[1]+=1;
        }
    }

    public void addTfQust(String quest,String ans){
        TfQuest temp=new TfQuest(quest,ans);
        try{
            tf[filled[2]]=temp;
            filled[2]+=1;
        }
        catch(ArrayIndexOutOfBoundsException oob){
            extendDataBase(3);
            tf[filled[2]]=temp;
            filled[2]+=1;
        }
    }

    public void extendDataBase(int typeFlag){
        if(typeFlag==1){
            MCQQuest mcqTemp[]=new MCQQuest[size[0]+10];//increasing the buffer by 10 each time
            for(int i=0;i<size[0];i++){
                mcqTemp[i]=mcq[i];
            }
            mcq=mcqTemp;
            size[0]=size[0]+10;
        }
        else if(typeFlag==2){
            FillQuest fillTemp[]=new FillQuest[size[1]+10];//increasing the buffer by 10 each time
            for(int i=0;i<size[1];i++){
                fillTemp[i]=fill[i];
            }
            fill=fillTemp;
            size[1]=size[1]+10;
        }
        else if(typeFlag==3){
            TfQuest tfTemp[]=new TfQuest[size[2]+10];
            for(int i=0;i<size[2];i++){
                tfTemp[i]=tf[i];
            }
            tf=tfTemp;
            size[2]=size[2]+10;
        }
    }
}
