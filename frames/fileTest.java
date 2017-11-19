//package frames;
import filehandle.*;

import java.lang.*;

public class fileTest{
    public static void main(String args[]){
        User a=new User();
        for(int i=0;i<25;i++){
            a.addTfQuest("RAM",Integer.toString(i));
            //System.out.println("Capacity : "+a.size[0]+" "+a.size[1]+" "+a.size[2]);
            //System.out.println("Capacity : "+a.filled[0]+" "+a.filled[1]+" "+a.filled[2]);
            if(i==22){
                for(int j=0;j<20;j++){
                    System.out.println("Data: "+a.tf[j].ans);
                }
            }
            //System.out.println("");
        }
    }
}
