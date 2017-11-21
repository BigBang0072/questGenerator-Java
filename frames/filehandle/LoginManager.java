package frames.filehandle;

import java.lang.*;
import java.io.*;
import java.util.*;

public class LoginManager implements Serializable{
    Hashtable<String,String> credentials;
    File credAddress;

    public LoginManager(){
        //Default location to store the passwords. No outside connection
        credAddress=new File("/home/abhinav/Desktop/OOPMiniProject/questGenerator-Java/LoginCredentials");
        if(credAddress.exists()){
            //Read the previous credentials state
            try{
                FileInputStream fis=new FileInputStream(credAddress.getPath()+"/"+"loginHash");
                ObjectInputStream ois=new ObjectInputStream(fis);
                credentials=(Hashtable<String,String>)ois.readObject();
                System.out.println("Read Credentail from File");
            }
            catch(IOException io){
                System.out.println("IO: "+io);
            }
            catch(Exception e){
                System.out.println("Execp: "+e);
            }
        }
        else{
            credAddress.mkdirs();
            credentials=new Hashtable<String,String>();
            System.out.println("Created new Hastable");
        }
    }
    //If availble free to create new or not.(meaning, free-yes.)
    public boolean checkNameAvailable(String userName){
        return !credentials.containsKey(userName);
    }

    public void addUser(String userName,String password){
        credentials.put(userName,password);
    }

    public boolean authenticateLogin(String userName,String password){
        String saved=credentials.get(userName);
        //System.out.println("pass: "+saved);
        if(saved.equals(password)){
            return true;
        }
        return false;
    }

    //Called at the end of the Program
    public void saveCredentails(){
        try{
            FileOutputStream fos=new FileOutputStream(credAddress.getPath()+"/"+"loginHash");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(credentials);
        }
        catch(IOException io){
            System.out.println("IO : "+io);
        }
        catch(Exception e){
            System.out.println("Execp: "+e);
        }
    }
}
