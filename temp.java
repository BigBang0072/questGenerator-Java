import java.io.*;
import java.lang.*;

class Box implements Serializable{
    int a=1;
    String s="Kalpana";
}

public class temp{
    public static void main(String args[]){
        Box b=new Box();
        Box b2;
        try{
            FileOutputStream fos=new FileOutputStream("box");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(b);
        }
        catch(IOException io){
            System.out.println(io);
        }
        try{
            FileInputStream fis=new FileInputStream("box");
            ObjectInputStream ois=new ObjectInputStream(fis);
            b2=(Box)ois.readObject();
            System.out.println(b2.a+b2.s);
        }
        catch(Exception io){
            System.out.println(io);
        }
    }
}
