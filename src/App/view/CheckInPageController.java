//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package App.view;

import App.MainMISTApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class CheckInPageController {
    @FXML
    private AnchorPane checkinPane;
    @FXML
    private Label lblStartInstruc;
    private MainMISTApp mainApp;

    public CheckInPageController() {
    }

    public void setMainApp(MainMISTApp var1) {
        this.mainApp = var1;
    }

    public void callFocus() {
        this.checkinPane.requestFocus();
    }

    @FXML
    public void OnEnterPressed(KeyEvent var1) {
        if (var1.getCode() == KeyCode.ENTER) {
            this.mainApp.testnum = 2;
            this.mainApp.showPreTestPage();
        }

    }
}
