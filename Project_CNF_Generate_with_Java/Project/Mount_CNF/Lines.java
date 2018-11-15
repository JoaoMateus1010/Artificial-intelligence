package Mount_CNF;
import main.Main;
public class Lines {
    Main mn = new Main();
    public String getStringLinesCNFforMinisat(int SizeOfTable){
        String StringForReturn = "";
        int j=1;
        int InteratesI = 0;
        int NumberBaseLine = 1;
        for(int i = 1; i<=SizeOfTable*SizeOfTable;i++){
            if(InteratesI==SizeOfTable){                
                InteratesI=0;
                NumberBaseLine = i;
            }
            j=NumberBaseLine;
            for(int InteratorJ = 0;InteratorJ<SizeOfTable;InteratorJ++){
                if(i!=j){
                   StringForReturn = StringForReturn.concat("-"+i+" "+"-"+j+" 0"+"\n");
                   mn.setAddNumberOfLinesInText(1);
                }
                j++;
            }
            InteratesI++;
        }
        return StringForReturn;
    }
}