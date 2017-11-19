package filehandle;

import java.lang.*;
import java.io.*;

public class DatabaseHandler{
    public String username;
    public File dir;
    public File file;
    public User database;

    public DatabaseHandler(String username,File dir){
        this.username=username;
        this.dir=dir;
        database=new User();//Initializing data base.
        file=takeOrCreateFile();//Reading the previous state
        //saved if present and getting file adress for saving
    }

    public void writeUserDatabase(){
        try{
            FileOutputStream fos=new FileOutputStream(file.getPath());
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(database);
        }
        catch(IOException io){
            System.out.println("IO: "+io);
        }
        catch(Exception e){
            System.out.println("Exc: "+e);
        }
    }

    public File takeOrCreateFile(){
        String pathName=dir.getName();
        String[] files=dir.list();
        int len=files.length;
        int flag=0;
        for(int i=0;i<len;i++){
            if(username.equals(files[i])){
                flag=1;
                File oldFile=new File(pathName+"/"+files[i]);
                System.out.println(pathName+"/"+files[i]);
                readUserDatabase(oldFile);
                return oldFile;
            }
        }
        String path=dir.getPath();
        System.out.println(pathName+"/"+username);
        File newFile=new File(pathName+"/"+username);
        return newFile;
    }
    //Called internally
    private void readUserDatabase(File oldFile){
        try{
            FileInputStream fis=new FileInputStream(oldFile.getPath());
            ObjectInputStream ois=new ObjectInputStream(fis);
            database=(User)ois.readObject();
        }
        catch(IOException io){
            System.out.println("IO: "+io);
        }
        catch(Exception e){
            System.out.println("Exe: "+e);
        }
    }
}
