package ObserverPattern.Observable;
import java.util.ArrayList;
import java.util.List;
import ObserverPattern.Observer.NotificationAlertObserver;
public class IPhoneObservableImpl implements StockObservable {
    public List<NotificationAlertObserver>observerList = new ArrayList<>();
    public int stockCount = 0;
    @Override
    public void add(NotificationAlertObserver observer){
        observerList.add(observer);
    }
    @Override
    public void remove(NotificationAlertObserver observer){
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer:observerList){
            observer.update();
        }
    }
    public void setStockCount(int newStockAdded){
        if(stockCount == 0){    //main business logic
            notifySubscribers();
        }
        stockCount = stockCount+newStockAdded;
    }
    public int getStockCount(){
        return stockCount;
    }

}
