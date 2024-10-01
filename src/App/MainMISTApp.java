//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package App;

import App.model.TestMath;
import App.model.TestSettings;
import App.view.CheckInPageController;
import App.view.EndPageController;
import App.view.HomePageController;
import App.view.PreTestPageController;
import App.view.SettingsPageController;
import App.view.TestPageController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainMISTApp extends Application {
    private Stage primaryStage;
    private Region rootLayout;
    private Scene scene;
    final double origW = 800.0;
    final double origH = 650.0;
    private double newW;
    private double newH;
    public Integer testnum;
    private TestSettings testSettings;
    private TestMath testMath;

    public MainMISTApp() {
    }

    public void start(Stage var1) {
        this.primaryStage = var1;
        this.primaryStage.setTitle("M I S T");
        this.testnum = 1;
        this.showHomePage();
    }

    public void showHomePage() {
        try {
            FXMLLoader var1 = new FXMLLoader();
            var1.setLocation(MainMISTApp.class.getResource("view/homePage.fxml"));
            this.rootLayout = var1.load();
            Group var2 = new Group(this.rootLayout);
            StackPane var3 = new StackPane();
            var3.getChildren().add(var2);
            this.scene = new Scene(var3, 800.0, 650.0);
            var2.scaleXProperty().bind(this.scene.widthProperty().divide(800.0));
            var2.scaleYProperty().bind(this.scene.heightProperty().divide(650.0));
            this.primaryStage.setScene(this.scene);
            this.primaryStage.show();
            HomePageController var4 = var1.getController();
            var4.setMainApp(this);
            var4.loadSettings();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void showSettingsPage() {
        try {
            this.newW = this.scene.getWidth();
            this.newH = this.scene.getHeight();
            FXMLLoader var1 = new FXMLLoader();
            var1.setLocation(MainMISTApp.class.getResource("view/settingsPage.fxml"));
            this.rootLayout = var1.load();
            Group var2 = new Group(this.rootLayout);
            StackPane var3 = new StackPane();
            var3.getChildren().add(var2);
            this.scene = new Scene(var3, this.newW, this.newH);
            var2.scaleXProperty().bind(this.scene.widthProperty().divide(800.0));
            var2.scaleYProperty().bind(this.scene.heightProperty().divide(650.0));
            SettingsPageController var4 = var1.getController();
            var4.setMainApp(this);
            var4.loadPreferences();
            var4.setUpPage();
            this.primaryStage.setScene(this.scene);
            this.primaryStage.show();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void showPreTestPage() {
        try {
            this.newW = this.scene.getWidth();
            this.newH = this.scene.getHeight();
            FXMLLoader var1 = new FXMLLoader();
            var1.setLocation(MainMISTApp.class.getResource("view/preTestPage.fxml"));
            this.rootLayout = var1.load();
            Group var2 = new Group(this.rootLayout);
            StackPane var3 = new StackPane();
            var3.getChildren().add(var2);
            var3.setFocusTraversable(true);
            this.scene = new Scene(var3, this.newW, this.newH);
            var2.scaleXProperty().bind(this.scene.widthProperty().divide(800.0));
            var2.scaleYProperty().bind(this.scene.heightProperty().divide(650.0));
            PreTestPageController var4 = var1.getController();
            var4.setMainApp(this);
            this.primaryStage.setScene(this.scene);
            this.primaryStage.show();
            var4.callFocus();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void showCheckInPage() {
        try {
            this.newW = this.scene.getWidth();
            this.newH = this.scene.getHeight();
            FXMLLoader var1 = new FXMLLoader();
            var1.setLocation(MainMISTApp.class.getResource("view/checkinPage.fxml"));
            this.rootLayout = var1.load();
            Group var2 = new Group(this.rootLayout);
            StackPane var3 = new StackPane();
            var3.getChildren().add(var2);
            var3.setFocusTraversable(true);
            this.scene = new Scene(var3, this.newW, this.newH);
            var2.scaleXProperty().bind(this.scene.widthProperty().divide(800.0));
            var2.scaleYProperty().bind(this.scene.heightProperty().divide(650.0));
            CheckInPageController var4 = var1.getController();
            var4.setMainApp(this);
            this.primaryStage.setScene(this.scene);
            this.primaryStage.show();
            var4.callFocus();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void showTestPage() {
        try {
            this.newW = this.scene.getWidth();
            this.newH = this.scene.getHeight();
            FXMLLoader var1 = new FXMLLoader();
            var1.setLocation(MainMISTApp.class.getResource("view/testPage.fxml"));
            this.rootLayout = var1.load();
            Group var2 = new Group(this.rootLayout);
            StackPane var3 = new StackPane();
            var3.getChildren().add(var2);
            this.scene = new Scene(var3, this.newW, this.newH);
            var2.scaleXProperty().bind(this.scene.widthProperty().divide(800.0));
            var2.scaleYProperty().bind(this.scene.heightProperty().divide(650.0));
            TestPageController var4 = var1.getController();
            var4.setMainApp(this);
            var4.setOrderIndex(0);
            var4.setFilePath();
            this.primaryStage.setScene(this.scene);
            this.primaryStage.show();
            var2.requestFocus();
            var4.setPage();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void showEndPage() {
        try {
            this.newW = this.scene.getWidth();
            this.newH = this.scene.getHeight();
            FXMLLoader var1 = new FXMLLoader();
            var1.setLocation(MainMISTApp.class.getResource("view/endPage.fxml"));
            this.rootLayout = var1.load();
            Group var2 = new Group(this.rootLayout);
            StackPane var3 = new StackPane();
            var3.getChildren().add(var2);
            this.scene = new Scene(var3, this.newW, this.newH);
            var2.scaleXProperty().bind(this.scene.widthProperty().divide(800.0));
            var2.scaleYProperty().bind(this.scene.heightProperty().divide(650.0));
            EndPageController var4 = var1.getController();
            var4.setMainApp(this);
            this.primaryStage.setScene(this.scene);
            this.primaryStage.show();
            var2.requestFocus();
            var4.callFocus();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void makeTests(int[] var1, boolean[] var2, char[] var3, String[] var4, TestSettings.ScanSig var5, double var6) {
        this.testSettings = new TestSettings(var1, var2, var3, var4, var5, var6);
        this.testMath = new TestMath(this.testSettings);
        this.testMath.callSetOrder();
    }

    public void setFile(String var1, String var2) {
    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }

    public Region getRootLayout() {
        return this.rootLayout;
    }

    public TestSettings getTestSettings() {
        return this.testSettings;
    }

    public TestMath getTestMath() {
        return this.testMath;
    }

    public static void main(String[] var0) {
        launch(var0);
    }
}
