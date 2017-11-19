import java.io.*;

public class test{
    public static void main(String args[]){
        File dir;
        dir=new File("/home/abhinav/Desktop/OOPMiniProject/questGenerator-Java/frames/filehandle/tempDir/kalpana");
        boolean test=dir.isDirectory();
        System.out.println(test);
        if(dir.exists()){
            String[] temp=dir.list();
            int len=temp.length;
            for(int i=0;i<len;i++){
                System.out.println(temp[i]);
            }
            System.out.println(dir.getPath());
            //System.out.println(dir.exists());
        }
        else {
            dir.mkdirs();
            System.out.println(dir.exists());
        }


        //DatabaseHandler db=new DatabaseHandler("user",dir);
        //db.readOrCreate();
    }
}
