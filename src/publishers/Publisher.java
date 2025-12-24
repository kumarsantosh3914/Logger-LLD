package publishers;

import subscribers.Subscriber;

public interface Publisher {

    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(String message);
}
