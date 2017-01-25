import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
    int i=10;
    Timer timer = new Timer();
    
    public Countdown(){
        TimerTask task = new TimerTask(){
            public void run(){
                try{
                    System.out.println("running");
                    update_time();
                    count();
                    System.out.println(i+"");
                    if(i==0){
                        timer.cancel();
                    }
                }
                catch(Exception e){
                    System.out.print(e);
                }  
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
    
    public void count(){
        i--;
    }
    
    public int update_time(){
        return i;
    }
}
