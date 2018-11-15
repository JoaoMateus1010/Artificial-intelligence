package main;
import functions.*;
import Mount_CNF.*;
public class Main {
    public static int NumberOfLinesInText = 0;
    public static void main(String[] args) {
        Contador_via_Thread ct = new Contador_via_Thread();        
        int n=Integer.parseInt(args[0]);        
        String STR_Line_Initial = "p cnf X Y\n";//X is number of p and Y is number of lines
        String STR_Lines = "";
        String STR_Columns = "";
        String STR_Diagonals = "";
        String STR_Final_for_Write = "";        
        String Name_File = "FILE_CNF_MINISAT.txt";                  
        Functions_File func_file = new Functions_File();    
        func_file.createFile(Name_File);                        
        Lines lines = new Lines();
        Columns columns = new Columns();
        Diagonals diagonals = new Diagonals();
        try {
            ct.start();
            STR_Lines = lines.getStringLinesCNFforMinisat(n);                   
            STR_Columns = columns.getStringColumnsCNFforMinisat(n);  
            STR_Diagonals = diagonals.getStringDiagonalsCNFforMinisat(n);            
            ct.endCompilation = false;            
            STR_Line_Initial = STR_Line_Initial.replaceAll("Y", String.valueOf(NumberOfLinesInText));
            STR_Line_Initial = STR_Line_Initial.replaceAll("X", String.valueOf(n*n));
            //Final
            STR_Final_for_Write = STR_Line_Initial.concat(STR_Lines.concat(STR_Columns.concat(STR_Diagonals)));
            func_file.WriteFile(Name_File, STR_Final_for_Write);            
            System.out.println("NUMBER OF VARIABLES: "+n*n);
            System.out.println("NUMBER OF CLAUSES: "+NumberOfLinesInText);
        } catch (Exception e) {
                System.out.println("ERROR: "+e);
                System.exit(0);
        }        
    }
    public void setAddNumberOfLinesInText(int value){
        NumberOfLinesInText+=value;
    }    
}