import java.io.*;

public class test{
    public static void main(String args[]){
        File dir;
        dir=new File("./");
        boolean test=dir.isDirectory();
        System.out.println(test);
        String[] temp=dir.list();
        int len=temp.length;
        for(int i=0;i<len;i++){
            System.out.println(temp[i]);
        }
        System.out.println(dir.getPath());

        DatabaseHandler db=new DatabaseHandler("user",dir);
        db.readOrCreate();
    }
}
