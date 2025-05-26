package PubSubSystem;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {
    private final String name;
    private final Set<Subscriber> subscribers = new CopyOnWriteArraySet<>();

    public Topic(String name) {
        this.name = name;
    }

    public void addSubscribers(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscribers(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void broadcast(Message message) {
        for(Subscriber subscriber: subscribers) {
            Dispatcher.dispatch(subscriber, message);
        }
    }
}
