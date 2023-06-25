package start;

import javax.swing.SwingUtilities;

import database.ConnectionFactory;
import screen.HomeScreen;
import view.HomeFrame;

public class Program {

    public static HomeScreen window;
    public static void main(String[] args) {
        //window = new HomeScreen();
        //window.renderizaJanela();

        ConnectionFactory.initDatabase();

        SwingUtilities.invokeLater(HomeFrame::new);
    }
}
