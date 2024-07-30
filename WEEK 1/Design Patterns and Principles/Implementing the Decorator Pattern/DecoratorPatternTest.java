public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Create a basic email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Wrap the email notifier with SMS and Slack decorators
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send a notification through Slack, which also sends via SMS and email
        slackNotifier.send("Hello, World!");
    }
}
