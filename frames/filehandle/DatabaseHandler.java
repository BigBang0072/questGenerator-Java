package frames.filehandle;

import java.lang.*;
import java.io.*;

public class DatabaseHandler{
    public String subject;
    public File dir;
    public File file;
    public User database;

    public DatabaseHandler(String subject,File dir){
        this.subject=subject;
        this.dir=dir;//Dir should be given with added username.
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
        String pathName=dir.getPath();
        System.out.println(pathName);
        String[] files=dir.list();
        int len=files.length;
        int flag=0;
        for(int i=0;i<len;i++){
            if(subject.equals(files[i])){
                flag=1;
                File oldFile=new File(pathName+"/"+files[i]);
                System.out.println(pathName+"/"+files[i]);
                readUserDatabase(oldFile);
                return oldFile;
            }
        }
        String path=dir.getPath();
        System.out.println(pathName+"/"+subject);
        File newFile=new File(pathName+"/"+subject);
        //newFile.mkdirs();//if file is not there initially.Silly me
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
