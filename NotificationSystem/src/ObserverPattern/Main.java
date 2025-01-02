package ObserverPattern;
import ObserverPattern.Observable.StockObservable;
import ObserverPattern.Observable.IPhoneObservableImpl;
import ObserverPattern.Observer.EmailNotificationImpl;
import ObserverPattern.Observer.MobileNotificationImpl;
import ObserverPattern.Observer.NotificationAlertObserver;
public class Main {
    public static void main(String[] args) {
        StockObservable iphoneStockObservable = new IPhoneObservableImpl();
        NotificationAlertObserver observer1 = new EmailNotificationImpl("varun.vjr@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer2 = new MobileNotificationImpl("varun_vjr",iphoneStockObservable);
        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.setStockCount(10);
    }
}