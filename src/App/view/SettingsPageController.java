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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;
import javax.swing.JOptionPane;
import jidefx.scene.control.field.DoubleField;
import jidefx.scene.control.field.IntegerField;
import jidefx.scene.control.field.MaskTextField;
import org.controlsfx.control.ToggleSwitch;

public class SettingsPageController {
    @FXML
    private RadioButton radioBtnMouse;
    @FXML
    private ToggleGroup scanGroup;
    @FXML
    private RadioButton radioBtnKey;
    @FXML
    private RadioButton radioBtnTime;
    @FXML
    private Button btnStart;
    @FXML
    private Slider sliderConSpeed;
    @FXML
    private RadioButton radioBtnStrict;
    @FXML
    private ToggleGroup conditionsGroup;
    @FXML
    private RadioButton radioBtnRan;
    @FXML
    private Slider sliderExpDiff;
    @FXML
    private TextField txtCor;
    @FXML
    private TextField txtInCor;
    @FXML
    private TextField txtRec;
    @FXML
    private TextField txtNotRec;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtSaveDir;
    @FXML
    private Button btnID;
    @FXML
    private Button btnDir;
    @FXML
    private MaskTextField txtLeftKey;
    @FXML
    private MaskTextField txtRightKey;
    @FXML
    private MaskTextField txtConfKey;
    @FXML
    private IntegerField txtRestT;
    @FXML
    private IntegerField txtConT;
    @FXML
    private IntegerField txtExpT;
    @FXML
    private IntegerField txtRep;
    @FXML
    private IntegerField txtNBack;
    @FXML
    private MaskTextField txtKeySig;
    @FXML
    private ToggleSwitch toggleRest;
    @FXML
    private ToggleSwitch toggleCon;
    @FXML
    private ToggleSwitch toggleExp;
    @FXML
    private ToggleSwitch toggleTimeout;
    @FXML
    private ToggleSwitch toggleSound;
    @FXML
    private ToggleSwitch toggleClick;
    @FXML
    private ToggleSwitch togglePopUp;
    @FXML
    private DoubleField txtSigDur;
    @FXML
    private TextField txtBottomName;
    @FXML
    private TextField txtTopName;
    @FXML
    private ToggleSwitch toggleMoveFeedback;
    private MainMISTApp mainApp;
    private String userDir;
    private String filename;
    private File initialFile;
    private final DirectoryChooser saveDir = new DirectoryChooser();
    private int controlSpeed;
    private Preferences userPrefs;

    public SettingsPageController() {
    }

    public void setMainApp(MainMISTApp var1) {
        this.mainApp = var1;
    }

    public void loadPreferences() {
        this.userPrefs = Preferences.userNodeForPackage(this.getClass());
        this.txtRep.setValue(this.userPrefs.getInt("REPETITIONS", 1));
        this.sliderExpDiff.setValue(this.userPrefs.getInt("DIFFICULTY", 1));
        this.txtNBack.setValue(this.userPrefs.getInt("N_BACK", 0));
        this.txtRestT.setValue(this.userPrefs.getInt("REST_TIME", 10));
        this.txtConT.setValue(this.userPrefs.getInt("CONTROL_TIME", 10));
        this.txtExpT.setValue(this.userPrefs.getInt("EXP_TIME", 10));
        this.sliderConSpeed.setValue(this.userPrefs.getInt("CONTROL_SPEED", 1));
        this.radioBtnStrict.setSelected(this.userPrefs.getBoolean("IS_STRICT", true));
        this.radioBtnRan.setSelected(!this.radioBtnStrict.isSelected());
        this.toggleRest.setSelected(this.userPrefs.getBoolean("IS_REST", false));
        this.toggleCon.setSelected(this.userPrefs.getBoolean("IS_CONTROL", false));
        this.toggleExp.setSelected(this.userPrefs.getBoolean("IS_EXP", false));
        this.toggleSound.setSelected(this.userPrefs.getBoolean("IS_SOUND", false));
        this.toggleClick.setSelected(this.userPrefs.getBoolean("IS_CLICK", false));
        this.toggleTimeout.setSelected(this.userPrefs.getBoolean("IS_TIMEOUT", false));
        this.togglePopUp.setSelected(this.userPrefs.getBoolean("IS_POP_UP", false));
        this.toggleMoveFeedback.setSelected(this.userPrefs.getBoolean("IS_STATIC_FEEDBACK", false));
        this.radioBtnMouse.setSelected(this.userPrefs.getBoolean("IS_MOUSE", true));
        this.radioBtnKey.setSelected(this.userPrefs.getBoolean("IS_KEYBOARD", false));
        this.radioBtnTime.setSelected(this.userPrefs.getBoolean("IS_TIMED", false));
        this.txtCor.setText(this.userPrefs.get("FEEDBACK_CORRECT", "CORRECT"));
        this.txtInCor.setText(this.userPrefs.get("FEEDBACK_WRONG", "INCORRECT"));
        this.txtRec.setText(this.userPrefs.get("FEEDBACK_RECORD", "RECORDED"));
        this.txtNotRec.setText(this.userPrefs.get("FEEDBACK_NOT_RECORD", "NOT RECORDED"));
        this.txtID.setText(this.userPrefs.get("FILENAME", "01"));
        this.userDir = this.userPrefs.get("USER_DIRECTORY", System.getProperty("user.home") + File.separator);
        this.txtTopName.setText(this.userPrefs.get("NAME_TOP", "YOU"));
        this.txtBottomName.setText(this.userPrefs.get("NAME_BOTTOM", "AVERAGE"));
        this.txtKeySig.setText(this.userPrefs.get("KEY_SCAN_SIGNAL", "a"));
        this.txtLeftKey.setText(this.userPrefs.get("KEY_LEFT", "1"));
        this.txtRightKey.setText(this.userPrefs.get("KEY_RIGHT", "3"));
        this.txtConfKey.setText(this.userPrefs.get("KEY_CONF", "2"));
        this.txtSigDur.setValue(this.userPrefs.getDouble("SIGNAL_LENGTH", 2.5));
    }

    public void setUpPage() {
        SimpleDateFormat var1 = new SimpleDateFormat("dd-MM-yyyy");
        Date var2 = new Date();
        this.filename = this.txtID.getText() + "_" + var1.format(var2);
        this.initialFile = new File(this.userDir);
        if (this.initialFile.exists() && this.initialFile.isDirectory()) {
            this.saveDir.setInitialDirectory(this.initialFile);
            this.txtSaveDir.setText(this.userDir + this.filename + ".txt");
        } else {
            this.userDir = System.getProperty("user.home") + File.separator;
            this.initialFile = new File(this.userDir);
            this.saveDir.setInitialDirectory(this.initialFile);
            this.txtSaveDir.setText(this.userDir + this.filename + ".txt");
        }

    }

    @FXML
    public void OnBtnAction(ActionEvent var1) {
        Alert var22;
        if (!this.toggleRest.isSelected() && !this.toggleCon.isSelected() && !this.toggleExp.isSelected()) {
            var22 = new Alert(AlertType.WARNING);
            var22.setTitle("!");
            var22.setHeaderText(null);
            var22.setContentText("Please select at least one condtion type");
            var22.showAndWait();
        } else if (this.radioBtnKey.isSelected() && (this.txtKeySig.getText().charAt(0) == this.txtLeftKey.getCharacters().charAt(0) || this.txtKeySig.getText().charAt(0) == this.txtRightKey.getCharacters().charAt(0) || this.txtKeySig.getText().charAt(0) == this.txtConfKey.getCharacters().charAt(0))) {
            var22 = new Alert(AlertType.WARNING);
            var22.setTitle("!");
            var22.setHeaderText(null);
            var22.setContentText("The scan signal key is the same as one of the control keys");
            var22.showAndWait();
        } else {
            switch ((int)this.sliderConSpeed.getValue()) {
                case 1:
                    this.controlSpeed = 20;
                    break;
                case 2:
                    this.controlSpeed = 18;
                    break;
                case 3:
                    this.controlSpeed = 16;
                    break;
                case 4:
                    this.controlSpeed = 14;
                    break;
                case 5:
                    this.controlSpeed = 12;
                    break;
                case 6:
                    this.controlSpeed = 10;
                    break;
                case 7:
                    this.controlSpeed = 8;
                    break;
                case 8:
                    this.controlSpeed = 6;
            }

            int[] var2 = new int[]{this.txtRep.getValue(), (int)this.sliderExpDiff.getValue(), this.txtNBack.getValue(), this.txtRestT.getValue(), this.txtConT.getValue(), this.txtExpT.getValue(), this.controlSpeed};
            double var3;
            if (this.txtSigDur.getValue() == null) {
                var3 = 2.5;
            } else {
                var3 = this.txtSigDur.getValue();
            }

            boolean[] var5 = new boolean[]{this.radioBtnStrict.isSelected(), this.toggleRest.isSelected(), this.toggleCon.isSelected(), this.toggleExp.isSelected(), this.toggleSound.isSelected(), this.toggleClick.isSelected(), !this.toggleTimeout.isSelected(), !this.togglePopUp.isSelected(), this.toggleMoveFeedback.isSelected()};
            char[] var6 = new char[]{this.txtKeySig.getText().charAt(0), this.txtLeftKey.getCharacters().charAt(0), this.txtRightKey.getCharacters().charAt(0), this.txtConfKey.getCharacters().charAt(0)};
            String[] var7 = new String[]{this.txtKeySig.getText(), this.txtLeftKey.getText(), this.txtRightKey.getText(), this.txtConfKey.getText()};
            boolean[] var8 = new boolean[]{false, false, false};
            TestSettings.ScanSig var9;
            if (this.radioBtnMouse.isSelected()) {
                var9 = ScanSig.MOUSE;
                var8[0] = true;
            } else if (this.radioBtnKey.isSelected()) {
                var9 = ScanSig.KEYBOARD;
                var8[1] = true;
            } else {
                var9 = ScanSig.TIMED;
                var8[2] = true;
            }

            File var10 = new File(this.userDir + this.filename + ".txt");

            for(Integer var11 = 1; var10.exists(); var11 = var11 + 1) {
                SimpleDateFormat var12 = new SimpleDateFormat("dd-MM-yyyy");
                Date var13 = new Date();
                this.filename = this.txtID.getText() + "-" + var11 + "_" + var12.format(var13);
                var10 = new File(this.userDir + this.filename + ".txt");
            }

            String[] var23 = new String[]{this.txtCor.getCharacters().toString(), this.txtInCor.getCharacters().toString(), this.txtRec.getCharacters().toString(), this.txtNotRec.getCharacters().toString(), this.filename, this.userDir, this.txtBottomName.getCharacters().toString(), this.txtTopName.getCharacters().toString()};

            try {
                var10.createNewFile();
            } catch (IOException var20) {
                var20.printStackTrace();
                System.out.println(this.userDir + this.filename);
            }

            String var24 = "%-20s\t%-20s\t%-20s\t%-20s%n";

            try {
                FileWriter var14 = new FileWriter(var10);
                var14.write(String.format(var24, "TIME", "EVENT", "INFO", "RT (ms)"));
                var14.close();
            } catch (IOException var19) {
                var19.printStackTrace();
            }

            this.savePreferences(var2, var5, var7, var23, var8, var3, (int)this.sliderConSpeed.getValue(), this.txtID.getText());
            String var25 = Paths.get(".").toAbsolutePath().normalize().toString();
            File var15 = new File(var25 + File.separator + "AppSettings.txt");

            try {
                var15.createNewFile();
            } catch (IOException var18) {
                var18.printStackTrace();
                System.out.println(var25 + "AppSettings.txt");
            }

            try {
                BufferedWriter var16 = null;
                var16 = new BufferedWriter(new FileWriter(var15));

                int var17;
                for(var17 = 0; var17 < var2.length; ++var17) {
                    if (var17 < var2.length - 1) {
                        var16.write(var2[var17] + ",");
                    } else {
                        var16.write(Integer.toString(var2[var17]));
                    }
                }

                var16.newLine();

                for(var17 = 0; var17 < var5.length; ++var17) {
                    if (var17 < var5.length - 1) {
                        var16.write(var5[var17] + ",");
                    } else {
                        var16.write(Boolean.toString(var5[var17]));
                    }
                }

                var16.newLine();

                for(var17 = 0; var17 < var6.length; ++var17) {
                    if (var17 < var6.length - 1) {
                        var16.write(var6[var17] + ",");
                    } else {
                        var16.write(Character.toString(var6[var17]));
                    }
                }

                var16.newLine();

                for(var17 = 0; var17 < var23.length; ++var17) {
                    if (var17 < var23.length - 1) {
                        var16.write(var23[var17] + ",");
                    } else {
                        var16.write(var23[var17]);
                    }
                }

                var16.newLine();

                for(var17 = 0; var17 < var8.length; ++var17) {
                    if (var17 < var8.length - 1) {
                        var16.write(var8[var17] + ",");
                    } else {
                        var16.write(Boolean.toString(var8[var17]));
                    }
                }

                var16.newLine();
                var16.write(Double.toString(var3));
                var16.flush();
                var16.close();
            } catch (IOException var21) {
                var21.printStackTrace();
            }

            this.mainApp.makeTests(var2, var5, var6, var23, var9, var3);
            this.mainApp.showPreTestPage();
        }

    }

    @FXML
    public void OnTestBtn(ActionEvent var1) {
        JOptionPane.showMessageDialog(null, "Starting Test", "Test", 1);
        File var2 = new File("C:\\Users\\Tony\\Documents\\UIUC\\MIST\\New_Repo\\MIST\\AppSettings.txt");
        ArrayList var4 = new ArrayList();

        try {
            BufferedReader var5 = new BufferedReader(new FileReader(var2));

            String var3;
            while((var3 = var5.readLine()) != null) {
                var4.add(var3);
            }

            var5.close();
        } catch (IOException var16) {
            var16.printStackTrace();
        }

        String[] var17 = (String[])var4.toArray(new String[0]);
        JOptionPane.showMessageDialog(null, "Read File", "Test", 1);
        String[] var6 = var17[0].split(",", 0);
        int[] var7 = new int[var6.length];

        for(int var8 = 0; var8 < var6.length; ++var8) {
            var7[var8] = Integer.parseInt(var6[var8]);
        }

        var6 = var17[1].split(",", 0);
        boolean[] var18 = new boolean[var6.length];

        for(int var9 = 0; var9 < var6.length; ++var9) {
            var18[var9] = Boolean.valueOf(var6[var9]);
        }

        var6 = var17[2].split(",", 0);
        char[] var19 = new char[var6.length];

        for(int var10 = 0; var10 < var6.length; ++var10) {
            var19[var10] = var6[var10].charAt(0);
        }

        var6 = var17[3].split(",", 0);
        String[] var20 = new String[var6.length];

        System.arraycopy(var6, 0, var20, 0, var6.length);

        var6 = var17[4].split(",", 0);
        boolean[] var21 = new boolean[var6.length];

        for(int var12 = 0; var12 < var6.length; ++var12) {
            var21[var12] = Boolean.valueOf(var6[var12]);
        }

        double var22 = Double.parseDouble(var17[5]);
        TestSettings.ScanSig var14;
        if (var21[0]) {
            var14 = ScanSig.MOUSE;
        } else if (var21[1]) {
            var14 = ScanSig.KEYBOARD;
        } else {
            var14 = ScanSig.TIMED;
        }

        String var15 = "intVar: " + Arrays.toString(var7) + "\nbooVar: " + Arrays.toString(var18) + "\ncharVar: " + Arrays.toString(var19) + "\nstringVar: " + Arrays.toString(var20) + "\nsigBoo: " + Arrays.toString(var21) + "\nsigDur: " + var22;
        JOptionPane.showMessageDialog(null, var15, "Test", 1);
    }

    @FXML
    public void OnBtnID(ActionEvent var1) {
        SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
        Date var3 = new Date();
        TextInputDialog var4 = new TextInputDialog();
        var4.setTitle(null);
        var4.setHeaderText(null);
        var4.setContentText("Please enter your participant ID:");
        Optional var5 = var4.showAndWait();
        var5.ifPresent((var1x) -> {
            this.txtID.setText(var1x.toString());
        });
        var5.ifPresent((var3x) -> {
            this.filename = var3x + "_" + var2.format(var3);
        });
        this.txtSaveDir.setText(this.userDir + this.filename + ".txt");
    }

    @FXML
    public void OnDirectoryBtn(ActionEvent var1) {
        File var2 = this.saveDir.showDialog(this.mainApp.getPrimaryStage());
        if (var2 != null) {
            this.userDir = var2 + File.separator;
            this.txtSaveDir.setText(this.userDir + this.filename + ".txt");
        }

    }

    private void savePreferences(int[] var1, boolean[] var2, String[] var3, String[] var4, boolean[] var5, double var6, int var8, String var9) {
        this.userPrefs.putInt("REPETITIONS", var1[0]);
        this.userPrefs.putInt("DIFFICULTY", var1[1]);
        this.userPrefs.putInt("N_BACK", var1[2]);
        this.userPrefs.putInt("REST_TIME", var1[3]);
        this.userPrefs.putInt("CONTROL_TIME", var1[4]);
        this.userPrefs.putInt("EXP_TIME", var1[5]);
        this.userPrefs.putInt("CONTROL_SPEED", var8);
        this.userPrefs.putBoolean("IS_STRICT", var2[0]);
        this.userPrefs.putBoolean("IS_REST", var2[1]);
        this.userPrefs.putBoolean("IS_CONTROL", var2[2]);
        this.userPrefs.putBoolean("IS_EXP", var2[3]);
        this.userPrefs.putBoolean("IS_SOUND", var2[4]);
        this.userPrefs.putBoolean("IS_CLICK", var2[5]);
        this.userPrefs.putBoolean("IS_TIMEOUT", !var2[6]);
        this.userPrefs.putBoolean("IS_POP_UP", !var2[7]);
        this.userPrefs.putBoolean("IS_STATIC_FEEDBACK", var2[8]);
        this.userPrefs.putBoolean("IS_MOUSE", var5[0]);
        this.userPrefs.putBoolean("IS_KEYBOARD", var5[1]);
        this.userPrefs.putBoolean("IS_TIMED", var5[2]);
        this.userPrefs.put("FEEDBACK_CORRECT", var4[0]);
        this.userPrefs.put("FEEDBACK_WRONG", var4[1]);
        this.userPrefs.put("FEEDBACK_RECORD", var4[2]);
        this.userPrefs.put("FEEDBACK_NOT_RECORD", var4[3]);
        this.userPrefs.put("FILENAME", var9);
        this.userPrefs.put("USER_DIRECTORY", var4[5]);
        this.userPrefs.put("NAME_BOTTOM", var4[6]);
        this.userPrefs.put("NAME_TOP", var4[7]);
        this.userPrefs.put("KEY_SCAN_SIGNAL", var3[0]);
        this.userPrefs.put("KEY_LEFT", var3[1]);
        this.userPrefs.put("KEY_RIGHT", var3[2]);
        this.userPrefs.put("KEY_CONF", var3[3]);
        this.userPrefs.putDouble("SIGNAL_LENGTH", var6);
    }
}
