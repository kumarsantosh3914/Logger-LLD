package subscribers;

public class ConsoleSubscriber implements Subscriber {

    @Override
    public void update(String message) {
        System.out.println("Console Subscriber received: " + message);
    }
}
