package Logger;

public class DebugLogProcessor extends LogProcessor{
    public DebugLogProcessor(LogProcessor nextLogger){
        super(nextLogger);
    }
    public void log(int level,String message){
        if(level == DEBUG){
            System.out.println("Debug Message has been processed");
        }else{
            super.log(level,message);
        }
    }

}
