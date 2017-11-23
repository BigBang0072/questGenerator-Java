package frames.filehandle;

import java.lang.*;
import java.io.*;

public class User implements Serializable{
    public MCQQuest[] mcq;//type=1
    public FillQuest[] fill;//type=3
    public TfQuest[] tf;//type=2
    public int[] size,filled;//Directly contain the place to fill

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
            fill[filled[2]]=temp;
            filled[2]+=1;
        }
        catch(ArrayIndexOutOfBoundsException oob){
            extendDataBase(3);
            fill[filled[2]]=temp;
            filled[2]+=1;
        }
    }

    public void addTfQuest(String quest,String ans){
        TfQuest temp=new TfQuest(quest,ans);
        try{
            tf[filled[1]]=temp;
            filled[1]+=1;
        }
        catch(ArrayIndexOutOfBoundsException oob){
            extendDataBase(2);
            tf[filled[1]]=temp;
            filled[1]+=1;
        }
    }

    public void modifyMCQQuest(int quesNum,String quest,String optA,String optB,String optC,String optD,String ans){
        MCQQuest temp=new MCQQuest(quest,optA,optB,optC,optD,ans);
        System.out.println("Ques No to modify at: "+quesNum);
        mcq[quesNum]=temp;
    }
    public void modifyFillQuest(int quesNum,String beforeQuest,String afterQuest,String ans){
        FillQuest temp=new FillQuest(beforeQuest,afterQuest,ans);
        fill[quesNum]=temp;
    }
    public void modifyTfQuest(int quesNum,String quest,String ans){
        TfQuest temp=new TfQuest(quest,ans);
        tf[quesNum]=temp;
    }

    public void removeMCQQuest(int quesNum){
        int last=filled[0]-1;//current last
        for(int i=quesNum;i<last;i++){
            mcq[i]=mcq[i+1];
        }
        filled[0]=last;//now fill next time here
    }
    public void removeFillQuest(int quesNum){
        int last=filled[2]-1;
        for(int i=quesNum;i<last;i++){
            fill[i]=fill[i+1];
        }
        filled[2]=last;
    }
    public void removeTfQuest(int quesNum){
        int last=filled[1]-1;
        for(int i=quesNum;i<last;i++){
            tf[i]=tf[i+1];
        }
        filled[1]=last;
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
        else if(typeFlag==3){
            FillQuest fillTemp[]=new FillQuest[size[2]+10];//increasing the buffer by 10 each time
            for(int i=0;i<size[2];i++){
                fillTemp[i]=fill[i];
            }
            fill=fillTemp;
            size[2]=size[2]+10;
        }
        else if(typeFlag==2){
            TfQuest tfTemp[]=new TfQuest[size[1]+10];
            for(int i=0;i<size[1];i++){
                tfTemp[i]=tf[i];
            }
            tf=tfTemp;
            size[1]=size[1]+10;
        }
    }
}
