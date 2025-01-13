package Logger;

public class ErrorLogProcessor extends LogProcessor{
    public ErrorLogProcessor(LogProcessor nextLogger){
        super(nextLogger);
    }
    public void log(int level,String message){
        if(level == ERROR){
            System.out.println("Error message has occurred");
        }else{
            super.log(level,message);
        }
    }
}
