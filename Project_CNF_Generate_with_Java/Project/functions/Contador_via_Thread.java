package functions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Contador_via_Thread extends Thread{
    public boolean endCompilation = true;
    public int TimeForCompilation = 0;
    @Override
    public void run(){
        while(endCompilation){                        
            TimeForCompilation++;            
            try {
                Thread.sleep(1000);
                System.out.println("Sec: "+TimeForCompilation);
            } catch (InterruptedException ex) {
                Logger.getLogger(Contador_via_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
