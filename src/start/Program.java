package start;

import app.Application;
import database.ConnectionFactory;
import factories.GUIFactory;
import factories.MacFactory;
import factories.WindowsFactory;
import screen.HomeScreen;

public class Program {

    public static HomeScreen window;
    public static void main(String[] args) {
        ConnectionFactory.initDatabase();

        Application app = configureApplication();
        app.start();
    }

    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) {
            factory = new MacFactory();
        } else {
            factory = new WindowsFactory();
        }

        app = new Application(factory);

        return app;
    }
}
