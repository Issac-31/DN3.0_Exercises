public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Delegate to the wrapped notifier
        sendSlackMessage(message); // Add Slack functionality
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack message with: " + message);
    }
}
