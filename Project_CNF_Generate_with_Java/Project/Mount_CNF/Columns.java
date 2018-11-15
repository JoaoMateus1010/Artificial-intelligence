package Mount_CNF;

import main.Main;

public class Columns {
    Main mn = new Main();    
    public String getStringColumnsCNFforMinisat(int SizeOfTable){
        String StringForReturn = "";
        int vectLeft[] = new int[SizeOfTable*SizeOfTable*SizeOfTable];
        int vectRight[] = new int[SizeOfTable*SizeOfTable*SizeOfTable];
        int FlagCont1 = 0;
        int FlagCont2 = 0;
        int BaseLeft = 1;
        int NewValueLeft = 1;
        for(int i=0;i<SizeOfTable*SizeOfTable*SizeOfTable;i++){
            if(FlagCont1==SizeOfTable){
                NewValueLeft += SizeOfTable;
                FlagCont1=0;
            }
            if(FlagCont2==SizeOfTable*SizeOfTable){
                BaseLeft++;
                NewValueLeft = BaseLeft;
                FlagCont2=0;
            }            
            vectLeft[i]=NewValueLeft;
            FlagCont1++;
            FlagCont2++;            
        }
        FlagCont1 = 0;
        FlagCont2 = 0;
        BaseLeft = 1;
        NewValueLeft = 1;
        for(int i=0;i<SizeOfTable*SizeOfTable*SizeOfTable;i++){
            if(FlagCont1==SizeOfTable){  
                NewValueLeft = BaseLeft;
                FlagCont1=0;                
            }
            if(FlagCont2==SizeOfTable*SizeOfTable){
                BaseLeft++;
                FlagCont2=0;
                NewValueLeft = BaseLeft;
            }
            //System.out.println(NewValueLeft);
            vectRight[i]=NewValueLeft;
            FlagCont1++;
            FlagCont2++;   
            NewValueLeft += SizeOfTable;
        }
        for(int i=0;i<SizeOfTable*SizeOfTable*SizeOfTable;i++){
            if(vectLeft[i]!=vectRight[i]){     
                StringForReturn = StringForReturn.concat("-"+vectLeft[i]+" -"+vectRight[i]+" 0"+"\n");
                mn.setAddNumberOfLinesInText(1);                
            }
        }
        return StringForReturn;
    }
}