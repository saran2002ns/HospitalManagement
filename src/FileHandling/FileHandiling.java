package FileHandling;

import repository.Db;

public class FileHandiling {
    private static FileHandiling file;
    private FileHandiling(){

    }
     public static FileHandiling getInstance(){
        if(file==null){
            file= new FileHandiling();
            return file;
        }
        return file;
    }
    
}
