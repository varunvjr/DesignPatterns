package ObserverPattern.Observer;
import ObserverPattern.Observable.StockObservable;
public class EmailNotificationImpl implements NotificationAlertObserver{
    String emailId;
    StockObservable observable;
    public EmailNotificationImpl(String emailId,StockObservable observable){
        this.emailId = emailId;
        this.observable = observable;
    }
    @Override
    public void update(){
        sendEmail(emailId,"product is in the stock");
    }
    public void sendEmail(String emailId,String msg){
        System.out.println(msg+" sent to "+emailId);
    }

}
