//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package App.view;

import App.MainMISTApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class EndPageController {
    @FXML
    private AnchorPane endPane;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnExit;
    @FXML
    private Label lblEndInstruc;
    private MainMISTApp mainApp;

    public EndPageController() {
    }

    public void setMainApp(MainMISTApp var1) {
        this.mainApp = var1;
    }

    public void callFocus() {
        this.endPane.requestFocus();
    }

    @FXML
    public void BtnSettingsPress(ActionEvent var1) {
        System.exit(1);
    }
}
