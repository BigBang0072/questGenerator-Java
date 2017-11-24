package frames.filehandle;


import java.lang.*;
import java.io.*;

public class ExportHandle{
    DatabaseHandler dbms;
    int[] randSeq;
    int typeQ;
    File writeDirectory;

    public ExportHandle(DatabaseHandler dbms,int[] randSeq,int typeQ,File writeDirectory){
        this.dbms=dbms;
        this.randSeq=randSeq;
        this.writeDirectory=writeDirectory;
        this.typeQ=typeQ;
    }

    public void writeQuestionToFile(){
        String address=writeDirectory.getPath()+"/"+"quest"+typeQ+".txt";
        try{
            PrintWriter writer =new PrintWriter(address);
            for(int i=0;i<randSeq.length;i++){
                if(typeQ==1){
                    String quest=dbms.database.mcq[randSeq[i]].quest;
                    String optA=dbms.database.mcq[randSeq[i]].optA;
                    String optB=dbms.database.mcq[randSeq[i]].optB;
                    String optC=dbms.database.mcq[randSeq[i]].optC;
                    String optD=dbms.database.mcq[randSeq[i]].optD;
                    //String ans=dbms.database.mcq[randSeq[i]].ans;
                    writer.println("Question "+i+" :"+quest);
                    writer.println("    option (a)"+optA);
                    writer.println("    option (b)"+optB);
                    writer.println("    option (c)"+optC);
                    writer.println("    option (d)"+optD);
                    writer.println(" ");
                }
                else if(typeQ==2){
                    String quest=dbms.database.tf[randSeq[i]].quest;
                    //String ans=dbms.database.tf[randSeq[i]].ans;
                    writer.println("Question "+i+" :"+quest);
                    writer.println(" ");
                }
                else if(typeQ==3){
                    String bQuest=dbms.database.fill[randSeq[i]].beforeQuest;
                    String aQuest=dbms.database.fill[randSeq[i]].afterQuest;
                    //String ans=dbms.database.fill[randSeq[i]].ans;
                    writer.println("Question "+i+" :"+bQuest+"         "+aQuest);
                    writer.println(" ");

                }
            }
            writer.close();
            System.out.println("Printing the Question Successfull at "+address);
        }
        catch(IOException io){
            System.out.println("IO in Export: "+io);
        }
    }

    public void writeSolutionToFile(){
        String address=writeDirectory.getPath()+"/"+"soln"+typeQ+".txt";
        try{
            PrintWriter writer = new PrintWriter(address);
            for(int i=0;i<randSeq.length;i++){
                if(typeQ==1){
                    String ans=dbms.database.mcq[randSeq[i]].ans;
                    writer.println("Solution "+i+" :"+ans);
                    writer.println(" ");
                }
                else if(typeQ==2){
                    String ans=dbms.database.tf[randSeq[i]].ans;
                    writer.println("Solution "+i+" :"+ans);
                    writer.println(" ");
                }
                else if(typeQ==3){
                    String ans=dbms.database.fill[randSeq[i]].ans;
                    writer.println("Solution "+i+" :"+ans);
                    writer.println(" ");

                }
            }
            writer.close();
            System.out.println("Printing the Solution Successfull at "+address);
        }
        catch(IOException io){
            System.out.println("IO in Export: "+io);
        }
    }
}
