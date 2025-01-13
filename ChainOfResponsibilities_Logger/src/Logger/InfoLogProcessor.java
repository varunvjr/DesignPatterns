package Logger;

public class InfoLogProcessor extends LogProcessor{
    public InfoLogProcessor(LogProcessor nextLogger){
        super(nextLogger);
    }
    public void log(int level,String message){
        if(level == INFO){
            System.out.println("Info Message has been processed");
        }else{
            super.log(level,message);
        }
    }
}
