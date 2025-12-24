package loggers;

import enums.LogLevel;
import interfaces.Logger;
import publishers.Publisher;
import subscribers.Subscriber;

import java.util.ArrayList;
import java.util.List;

public abstract  class AbstractLogger implements Logger, Publisher {

    protected LogLevel level;
    protected AbstractLogger nextLogger;
    private final List<Subscriber> subscribers;

    public AbstractLogger(LogLevel level) {
        this.level = level;
        this.subscribers = new ArrayList<>();
    }

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void log(LogLevel level, String message) {
        if(level.getValue() <= this.level.getValue()) {
            write(message);
        }

        if(nextLogger != null) {
            nextLogger.log(level, message);
        }
    }

    protected abstract void write(String message);

    @Override
    public void subscribe(Subscriber subscriber) {
        if(!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String message) {
        for(Subscriber subscriber: subscribers) {
            subscriber.update(message);
        }
    }

    public void subscribeToChain(Subscriber subscriber) {
        AbstractLogger current = this;
        while(current != null) {
            current.subscribe(subscriber);
            current = current.nextLogger;
        }
    }

    public void unsubscribeFromChain(Subscriber subscriber) {
        AbstractLogger current = this;
        while(current != null) {
            current.unsubscribe(subscriber);
            current = current.nextLogger;
        }
    }
}



