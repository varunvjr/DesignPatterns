package ObserverPattern.Observer;
import ObserverPattern.Observable.StockObservable;
public class MobileNotificationImpl implements NotificationAlertObserver{
    String username;
    StockObservable observable;
    public MobileNotificationImpl(String username,StockObservable observable){
        this.username = username;
        this.observable = observable;
    }

    @Override
    public void update(){
        sendMobileNotification(username,"stock is available in the market");
    }
    public void sendMobileNotification(String username,String msg){
        System.out.println(msg+" sent to "+username);
    }
}
