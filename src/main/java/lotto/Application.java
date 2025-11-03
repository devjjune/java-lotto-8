package lotto;

public class Application {
    public static void main(String[] args) {
        Service service = new Service();
        Controller controller = new Controller(service);
        Controller.run();
    }
}
