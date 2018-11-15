package functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Functions_File {
    public boolean createFile(String nameFile){
        try {
            File file = new File(nameFile);
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }     
    }
    public boolean WriteFile(String StringnameFile,String StringForWriteFile){        
        File nameFile = new File(StringnameFile);        
        FileWriter file_writer;
        try {
            if(nameFile.canWrite()){
                file_writer = new FileWriter(nameFile, false); // LEMBRAR de colocar em true
                file_writer.write(StringForWriteFile);
                file_writer.close();
            }else{
                System.out.println("Something is wrong with this file, can't write.");
                System.exit(0);
            }
        } catch (IOException e) {
        }
        return true;
    }
    public String ReaderFile(String StringnameFile){     
        String strForReturn = "";
        try {            
            File nameFile = new File(StringnameFile);                            
            if(nameFile.canRead()){                                
                FileReader file_reader = new FileReader(nameFile);
                BufferedReader lerArq = new BufferedReader(file_reader);
                String linha = lerArq.readLine();                    
                file_reader.close();                
            }else{
                System.out.println("Something is wrong with this file, can't write.");
                System.exit(0);
            }
        } catch (IOException e) {
        }        
        return strForReturn;
    }

    public String changeXtoY(String StringnameFile,String X,String Y){     
        String strForReturn = "";
        try {            
            File nameFile = new File(StringnameFile);                            
            if(nameFile.canRead()){ 
                FileReader file_reader = new FileReader(nameFile);
                BufferedReader lerArq = new BufferedReader(file_reader);
                String linha = lerArq.readLine();                
                String str_changed = linha.replaceAll(X,Y);
                WriteFile(StringnameFile, "\n"+str_changed);
                file_reader.close();                
            }else{
                System.out.println("Something is wrong with this file, can't write.");
                System.exit(0);
            }
        } catch (IOException e) {
        }        
        return strForReturn;
    }
}
