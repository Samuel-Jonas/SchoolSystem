package start;

import screen.HomeScreen;

public class Program {

    public static HomeScreen window;
    public static void main(String[] args) {
        window = new HomeScreen();
        window.renderizaJanela();
    }
}
