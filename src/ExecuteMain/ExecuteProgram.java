package ExecuteMain;

import PackageGUI.TelaMenu;

public class ExecuteProgram {

    public static TelaMenu window;
    public static void main(String[] args) {
        window = new TelaMenu();
        window.renderizaJanela();
    }
}
