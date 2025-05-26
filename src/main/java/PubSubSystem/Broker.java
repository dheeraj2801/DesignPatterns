package PubSubSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Broker {
    private final Map<String, Topic> topics = new ConcurrentHashMap<>();

    public void createTopic(String name) {
        topics.putIfAbsent(name, new Topic(name));
    }

    public void subscribe(String topicName, Subscriber subscriber) {
        Topic topic = topics.get(topicName);
        if(topic == null) throw new IllegalArgumentException("Topic not found: " + topicName);
        topic.addSubscribers(subscriber);
    }

    public void unsubscribe(String topicName, Subscriber subscriber) {
        Topic topic = topics.get(topicName);
        if(topic == null) throw new IllegalArgumentException("Topic not found: " + topicName);
        topic.removeSubscribers(subscriber);
    }

    public void publish(String topicName, Message message) {
        Topic topic = topics.get(topicName);
        if(topic == null) throw new IllegalArgumentException("Topic not found: " + topicName);
        topic.broadcast(message);
    }
}
