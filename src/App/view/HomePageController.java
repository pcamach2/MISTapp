//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package App.view;

import App.MainMISTApp;
import App.model.TestSettings;
import App.model.TestSettings.ScanSig;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.swing.JOptionPane;

public class HomePageController {
    @FXML
    private Button btnSettings;
    private MainMISTApp mainApp;

    public HomePageController() {
    }

    public void setMainApp(MainMISTApp var1) {
        this.mainApp = var1;
    }

    public void loadSettings() {
        try {
            String var1 = HomePageController.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            String var2 = var1.substring(1);
            Path var3 = Paths.get(var2);
            Path var4 = var3.getParent();
            File var5 = new File(var4.toString() + File.separator + "AppSettings.txt");
            ArrayList var7 = new ArrayList();

            try {
                BufferedReader var8 = new BufferedReader(new FileReader(var5));

                String var6;
                while((var6 = var8.readLine()) != null) {
                    var7.add(var6);
                }

                var8.close();
            } catch (IOException var18) {
                var18.printStackTrace();
            }

            String[] var20 = (String[])var7.toArray(new String[0]);
            String[] var9 = var20[0].split(",", 0);
            int[] var10 = new int[var9.length];

            for(int var11 = 0; var11 < var9.length; ++var11) {
                var10[var11] = Integer.parseInt(var9[var11]);
            }

            var9 = var20[1].split(",", 0);
            boolean[] var21 = new boolean[var9.length];

            for(int var12 = 0; var12 < var9.length; ++var12) {
                var21[var12] = Boolean.valueOf(var9[var12]);
            }

            var9 = var20[2].split(",", 0);
            char[] var22 = new char[var9.length];

            for(int var13 = 0; var13 < var9.length; ++var13) {
                var22[var13] = var9[var13].charAt(0);
            }

            var9 = var20[3].split(",", 0);
            String[] var23 = new String[var9.length];

            System.arraycopy(var9, 0, var23, 0, var9.length);

            var9 = var20[4].split(",", 0);
            boolean[] var24 = new boolean[var9.length];

            for(int var15 = 0; var15 < var9.length; ++var15) {
                var24[var15] = Boolean.valueOf(var9[var15]);
            }

            double var25 = Double.parseDouble(var20[5]);
            TestSettings.ScanSig var17;
            if (var24[0]) {
                var17 = ScanSig.MOUSE;
            } else if (var24[1]) {
                var17 = ScanSig.KEYBOARD;
            } else {
                var17 = ScanSig.TIMED;
            }

            this.mainApp.makeTests(var10, var21, var22, var23, var17, var25);
        } catch (URISyntaxException var19) {
            JOptionPane.showMessageDialog(null, "Errors Loading Test Settings", "Attention", 1);
            var19.printStackTrace();
        }

    }

    @FXML
    public void OnBtnAction(ActionEvent var1) {
        this.mainApp.showPreTestPage();
    }
}
