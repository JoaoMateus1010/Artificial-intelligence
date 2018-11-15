package Mount_CNF;
import main.Main;
public class Diagonals {
    Main mn = new Main();
    public String getStringDiagonalsCNFforMinisat(int SizeOfTable){        
        String StringForReturn = "";
        int vectDP[] = new int[SizeOfTable];
        int vectDS[] = new int[SizeOfTable];
        int matriz[][]   = new int[SizeOfTable][SizeOfTable];
        int cont = 1;
        for(int i=0;i<SizeOfTable;i++){
            for(int j=0;j<SizeOfTable;j++){
                matriz[i][j] = cont;
                cont++;
            }
        }
        //Code for Main Diagonal and Second Diagonal
        int indexVectDP = 0;
        int indexVectDS = 0;
        for(int i=0;i<SizeOfTable;i++){
            for(int j=0;j<SizeOfTable;j++){
                if(i==j){
                    vectDP[indexVectDP] = matriz[i][j];
                    indexVectDP++;
                }
                if(i+j == SizeOfTable-1){
                    vectDS[indexVectDS] = matriz[i][j];                    
                    indexVectDS++;
                }               
            }
        }        
        for(int i=0;i<SizeOfTable;i++){
            for(int j=0;j<SizeOfTable;j++){
                if(vectDP[i]!=vectDP[j]){                    
                    StringForReturn = StringForReturn.concat("-"+vectDP[i]+" -"+vectDP[j]+" 0\n");
                    mn.setAddNumberOfLinesInText(1);
                }
            }
        }
        for(int i=0;i<SizeOfTable;i++){
            for(int j=0;j<SizeOfTable;j++){
                if(vectDS[i]!=vectDS[j]){                    
                    StringForReturn = StringForReturn.concat("-"+vectDS[i]+" -"+vectDS[j]+" 0\n");
                    mn.setAddNumberOfLinesInText(1);
                }
            }
        }
//        for(int i=0;i<SizeOfTable;i++){
//            for(int j=0;j<SizeOfTable;j++){
//                System.out.println(matriz[i][j]);
//            }
//        }
        //Code for anothers mains diagonals        
        int interateJ = 0;
        int j = 1;
        int BaseIndexI = 0;
        int BaseIndexJ = 0;        
        for(interateJ=1;interateJ<SizeOfTable-1;interateJ++){
            int Vecto[] = new int[SizeOfTable-interateJ];                        
            int VectoInv[] = new int[SizeOfTable-interateJ];                        
            BaseIndexI = interateJ;
            BaseIndexJ = 0;
            for(int i=0;i<SizeOfTable-interateJ;i++){
                Vecto[i]=matriz[BaseIndexI][BaseIndexJ];
                VectoInv[i]=matriz[BaseIndexJ][BaseIndexI];
                //System.out.println(Base);                
                BaseIndexI++;
                BaseIndexJ++;
            }
            for(int k=0;k<SizeOfTable-interateJ;k++){
                for(int l=0;l<SizeOfTable-interateJ;l++){                    
                    if(VectoInv[l]!=VectoInv[k]){                        
                        StringForReturn = StringForReturn.concat("-"+VectoInv[l]+" -"+VectoInv[k]+" 0\n");                        
                        mn.setAddNumberOfLinesInText(1);
                    }                    
                }
            }
            for(int k=0;k<SizeOfTable-interateJ;k++){
                for(int l=0;l<SizeOfTable-interateJ;l++){
                    if(Vecto[k]!=Vecto[l]){
                        StringForReturn=StringForReturn.concat("-"+Vecto[k]+" -"+Vecto[l]+" 0\n");                        
                        mn.setAddNumberOfLinesInText(1);
                    }                                        
                }
            }
            j+=SizeOfTable;
        }        
        // Code for anothers seconds diagonals
        interateJ = 0;
        j = 1;
        BaseIndexI = 0;
        BaseIndexJ = 0;        
        for(interateJ=1;interateJ<SizeOfTable-1;interateJ++){
            int Vecto[] = new int[SizeOfTable-interateJ];                                    
            BaseIndexI = interateJ;
            BaseIndexJ = SizeOfTable-1;
            for(int i=0;i<SizeOfTable-interateJ;i++){
                Vecto[i]=matriz[BaseIndexI][BaseIndexJ];  
                //System.out.println(BaseIndexI+" "+BaseIndexJ);
                BaseIndexI++;
                BaseIndexJ--;
            }            
            for(int k=0;k<SizeOfTable-interateJ;k++){
                for(int l=0;l<SizeOfTable-interateJ;l++){
                    if(Vecto[k]!=Vecto[l]){
                        StringForReturn=StringForReturn.concat("-"+Vecto[k]+" -"+Vecto[l]+" 0\n");  
                        mn.setAddNumberOfLinesInText(1);
                    }                                        
                }
            }
            j+=SizeOfTable;
        }
        int SecondBaseI = 0;
        int SecondBaseJ = SizeOfTable-2;
        int NewValueI = 0;
        int NewValueJ = SizeOfTable-2;
        for(int SecondInteratesI = 0;SecondInteratesI<SizeOfTable-2;SecondInteratesI++){
            int VectSecond[] = new int[SizeOfTable-SecondInteratesI];
            for(int SecondInteratesJ = 0;SecondInteratesJ<SizeOfTable-SecondInteratesI-1;SecondInteratesJ++){
                VectSecond[SecondInteratesJ] = matriz[NewValueI][NewValueJ];                
                NewValueJ--;
                NewValueI++;
            }
            for(int i=0;i<VectSecond.length-1;i++){
                for(int i2=0;i2<VectSecond.length-1;i2++){
                    if(VectSecond[i]!=VectSecond[i2]){
                        StringForReturn=StringForReturn.concat("-"+VectSecond[i]+" -"+VectSecond[i2]+" 0\n");
                        mn.setAddNumberOfLinesInText(1);                        
                    }                    
                }
            }            
            SecondBaseJ-=1;
            NewValueI = SecondBaseI;
            NewValueJ = SecondBaseJ;
        }
        return StringForReturn;
    }
}