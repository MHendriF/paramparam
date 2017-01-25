import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class ReadWrite {
    
    public int read(){
        int score = 0;
        try{
           File file = new File("D:/newscore.txt");
           
           if(!file.exists()){
                file.createNewFile();
           }
           
           FileReader fr = new FileReader(file);
           BufferedReader text = new BufferedReader(fr);
           
                String[] data = new String [1];
                data[0] = text.readLine();
                score = Integer.parseInt(data[0]);
                System.out.println("Score: "+score);
                fr.close();
           
        }
        catch(Exception e){
            
        }
        return score;
    }
    
    public void write(int score){
        try{
            File file = new File("D:/newscore.txt");
            
            if(!file.exists()){
                file.createNewFile();
            }
            
            PrintWriter writer = new PrintWriter(file);
            score += 10;
            String temp = String.valueOf(score);
            writer.write(temp);
            writer.flush();
            writer.close();  
        }
        catch(Exception e){
            
        }
       
    }
    
    public void setnol(){
        try{
            File file = new File("D:/newscore.txt");
            
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter writer = new PrintWriter(file);
            String temp = String.valueOf(0);
            writer.write(temp);
            writer.flush();
            writer.close();  
        }
        catch(Exception e){  
        }
       
    }
    
}
