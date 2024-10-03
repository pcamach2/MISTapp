//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package App.view;

import App.MainMISTApp;
import App.model.TestQuestion;
import App.model.TestMath.condition;
import App.model.TestSettings.ScanSig;
import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class TestPageController {
    @FXML
    private ProgressBar barTimer;
    @FXML
    private TextField txtQuestion;
    @FXML
    private TextArea txtFeedback;
    @FXML
    private TextField txtGo;
    @FXML
    private AnchorPane testPane;
    @FXML
    private Group groupInput;
    @FXML
    private ToggleGroup numGroup;
    @FXML
    private Group g0;
    @FXML
    private Rectangle rec0;
    @FXML
    private Label num0;
    @FXML
    private Group g1;
    @FXML
    private Rectangle rec1;
    @FXML
    private Label num1;
    @FXML
    private Group g2;
    @FXML
    private Rectangle rec2;
    @FXML
    private Label num2;
    @FXML
    private Group g3;
    @FXML
    private Rectangle rec3;
    @FXML
    private Label num3;
    @FXML
    private Group g4;
    @FXML
    private Rectangle rec4;
    @FXML
    private Label num4;
    @FXML
    private Group g5;
    @FXML
    private Rectangle rec5;
    @FXML
    private Label num5;
    @FXML
    private Group g6;
    @FXML
    private Rectangle rec6;
    @FXML
    private Label num6;
    @FXML
    private Group g7;
    @FXML
    private Rectangle rec7;
    @FXML
    private Label num7;
    @FXML
    private Group g8;
    @FXML
    private Rectangle rec8;
    @FXML
    private Label num8;
    @FXML
    private Group g9;
    @FXML
    private Rectangle rec9;
    @FXML
    private Label num9;
    @FXML
    private Polygon arrowYou;
    @FXML
    private Polygon arrowThem;
    @FXML
    private Label lblYou;
    @FXML
    private Label lblThem;
    private MainMISTApp mainApp;
    private int scannerCount;
    private Integer inputHover;
    private Integer chosenAnswer;
    private int orderIndex;
    private int popUpOrderIndex;
    private Integer currentAnswer;
    private ArrayList<Integer> oldAnswers;
    private Timeline questionTimer;
    private Timeline timerControl;
    private double questionSpeedVar = 1500.0;
    private Timeline conditionTimer;
    private int numCorrect = 0;
    private int numWrong = 0;
    private int numTime;
    private int numQuestions;
    private int trialCount = 0;
    private Integer successiveAnswers = 0;
    private boolean isFirstQuestion;
    private boolean duringFirstQuestion;
    private boolean hasTimedOut = false;
    private final int redOff = 232;
    private final int greenOff = 235;
    private final int blueOff = 238;
    private final int redOn = 142;
    private final int greenOn = 144;
    private final int blueOn = 147;
    private boolean gettingFeedback;
    private boolean gettingTotalFeedback = false;
    private boolean clickingAnswer = false;
    private boolean isScanSig = false;
    private double xPosArrowYou = 493.0;
    private double xPosArrowThem = 493.0;
    private AudioClip rightS;
    private AudioClip wrongS;
    private MediaPlayer timeS;
    private final String format = "%-20d\t%-20s\t%-20s\t%-20d%n";
    private String dataFile;
    private long qStartTime;

    public TestPageController() {
    }

    public void setMainApp(MainMISTApp var1) {
        this.mainApp = var1;
    }

    public void setFilePath() {
        this.dataFile = this.mainApp.getTestSettings().getSaveDir() + this.mainApp.getTestSettings().getID() + ".txt";
    }

    public void setOrderIndex(int var1) {
        this.orderIndex = var1;
    }

    public void setQuestionSpeed(double var1) {
        KeyValue var3 = new KeyValue(this.barTimer.progressProperty(), 1);
        KeyFrame var4 = new KeyFrame(Duration.ZERO, new KeyValue(this.barTimer.progressProperty(), 0));
        KeyFrame var5 = new KeyFrame(Duration.millis(var1), var3);
        this.questionTimer = new Timeline();
        this.questionTimer.getKeyFrames().addAll(var4, var5);
        this.questionTimer.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent var1) {
                if (TestPageController.this.duringFirstQuestion) {
                    TestPageController.this.duringFirstQuestion = false;
                }

                if (TestPageController.this.mainApp.getTestSettings().getNBack() > 0) {
                    TestPageController.this.hasTimedOut = true;
                    TestPageController.this.nBackFeedback();
                } else {
                    TestPageController.this.hasTimedOut = true;
                    TestPageController.this.feedback();
                }

            }
        });
    }

    public void setNewTime() {
        if (this.successiveAnswers > 2 && this.questionSpeedVar > 0.0) {
            this.questionSpeedVar -= 500.0;
        } else if (this.successiveAnswers < -3 && this.questionSpeedVar < 5000.0) {
            this.questionSpeedVar += 250.0;
        }

    }

    public void setPage() {
        this.oldAnswers = new ArrayList();
        this.numQuestions = 0;
        if (!this.gettingTotalFeedback) {
            if (!this.isScanSig) {
                if (this.timerControl != null) {
                    this.timerControl.stop();
                }

                if (this.timeS != null) {
                    this.timeS.stop();
                }

                if (this.questionTimer != null) {
                    this.questionTimer.stop();
                }

                this.resetButtons();
                this.txtFeedback.clear();
                this.txtQuestion.clear();
                this.txtGo.clear();
                if (this.mainApp.getTestSettings().getIsSound()) {
                    this.rightS = new AudioClip((new File("resources/sound/correct_answer_sound.wav")).toURI().toString());
                    this.wrongS = new AudioClip((new File("resources/sound/wrong_answer_sound.wav")).toURI().toString());
                    Media var1 = new Media((new File("resources/sound/time_lapsing_sound_long.wav")).toURI().toString());
                    this.timeS = new MediaPlayer(var1);
                } else {
                    this.rightS = null;
                    this.wrongS = null;
                    this.timeS = null;
                }

                FileWriter var7;
                KeyFrame var8;
                if (this.mainApp.getTestMath().returnOrder(this.orderIndex).equals(condition.REST)) {
                    this.txtGo.setVisible(false);
                    ++this.trialCount;

                    try {
                        var7 = new FileWriter(this.dataFile, true);
                        var7.write(String.format(this.format, System.currentTimeMillis(), "New Condition", "REST", null));
                        var7.close();
                    } catch (IOException var6) {
                        var6.printStackTrace();
                    }

                    if (this.mainApp.getTestSettings().getScanSig().equals(ScanSig.TIMED)) {
                        var8 = new KeyFrame(Duration.millis(this.mainApp.getTestSettings().getRestT() * 1000));
                        this.conditionTimer = new Timeline();
                        this.conditionTimer.getKeyFrames().add(var8);
                        this.conditionTimer.setOnFinished(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent var1) {
                                TestPageController.this.popUpOrderIndex = TestPageController.this.orderIndex;
                                if (TestPageController.this.orderIndex < TestPageController.this.mainApp.getTestMath().returnOrderSize() - 1) {
                                    TestPageController.this.orderIndex++;
                                } else {
                                    TestPageController.this.orderIndex = 0;
                                }

                                TestPageController.this.restPopUp();
                            }
                        });
                        this.conditionTimer.playFromStart();
                    }

                    this.mainApp.getRootLayout().setStyle("-fx-border-color: CHARTREUSE; -fx-border-style: SOLID; -fx-border-width: 10; -fx-border-radius: null;");
                    this.barTimer.setVisible(false);
                    this.lblYou.setVisible(false);
                    this.lblThem.setVisible(false);
                    this.arrowYou.setVisible(false);
                    this.arrowThem.setVisible(false);
                    this.testPane.requestFocus();
                    this.inputHover = 100;
                } else if (this.mainApp.getTestMath().returnOrder(this.orderIndex).equals(condition.CONTROL)) {
                    try {
                        var7 = new FileWriter(this.dataFile, true);
                        var7.write(String.format(this.format, System.currentTimeMillis(), "New Condition", "CONTROL", null));
                        var7.close();
                    } catch (IOException var5) {
                        var5.printStackTrace();
                    }

                    this.txtGo.setVisible(this.mainApp.getTestSettings().getNBack() > 0);

                    this.isFirstQuestion = true;
                    ++this.trialCount;
                    if (this.mainApp.getTestSettings().getScanSig().equals(ScanSig.TIMED)) {
                        var8 = new KeyFrame(Duration.millis(this.mainApp.getTestSettings().getConT() * 1000));
                        this.conditionTimer = new Timeline();
                        this.conditionTimer.getKeyFrames().add(var8);
                        this.conditionTimer.setOnFinished(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent var1) {
                                TestPageController.this.popUpOrderIndex = TestPageController.this.orderIndex;
                                if (TestPageController.this.orderIndex < TestPageController.this.mainApp.getTestMath().returnOrderSize() - 1) {
                                    TestPageController.this.orderIndex++;
                                } else {
                                    TestPageController.this.orderIndex = 0;
                                }

                                if (TestPageController.this.timerControl != null) {
                                    TestPageController.this.timerControl.stop();
                                }

                                TestPageController.this.popUp();
                            }
                        });
                        this.conditionTimer.playFromStart();
                    }

                    this.mainApp.getRootLayout().setStyle("-fx-border-color: YELLOW; -fx-border-style: SOLID; -fx-border-width: 10; -fx-border-radius: null;");
                    this.barTimer.setVisible(false);
                    this.lblYou.setVisible(false);
                    this.lblThem.setVisible(false);
                    this.arrowYou.setVisible(false);
                    this.arrowThem.setVisible(false);
                    this.inputHover = 0;
                    this.rec0.setFill(Color.rgb(142, 144, 147));
                    this.numCorrect = 0;
                    this.numWrong = 0;
                    this.testPane.requestFocus();
                    this.setNewQuestion(this.mainApp.getTestMath().getDiff());
                    this.duringFirstQuestion = true;
                } else {
                    try {
                        var7 = new FileWriter(this.dataFile, true);
                        var7.write(String.format(this.format, System.currentTimeMillis(), "New Condition", "EXPERIMENTAL", null));
                        var7.close();
                    } catch (IOException var4) {
                        var4.printStackTrace();
                    }

                    this.txtGo.setVisible(this.mainApp.getTestSettings().getNBack() > 0);

                    this.lblYou.setTranslateX(0.0);
                    this.arrowYou.setTranslateX(0.0);
                    this.lblYou.translateXProperty();
                    this.arrowYou.translateXProperty();
                    if (this.mainApp.getTestSettings().getIsStaticFeedback()) {
                        this.xPosArrowThem = 628.0;
                        this.lblThem.setTranslateX(0.0);
                        this.arrowThem.setTranslateX(0.0);
                        this.lblThem.translateXProperty();
                        this.arrowThem.translateXProperty();
                        this.lblThem.setTranslateX(this.lblThem.getTranslateX() + 135.0);
                        this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() + 135.0);
                        this.lblThem.translateXProperty();
                        this.arrowThem.translateXProperty();
                    } else {
                        this.lblThem.setTranslateX(0.0);
                        this.arrowThem.setTranslateX(0.0);
                        this.lblThem.translateXProperty();
                        this.arrowThem.translateXProperty();
                        this.xPosArrowThem = 493.0;
                    }

                    int var9 = this.mainApp.getTestSettings().getNameTop().length();
                    int var2 = this.mainApp.getTestSettings().getNameBottom().length();
                    if (var2 > 12) {
                        this.lblYou.setFont(Font.font("System", FontWeight.BOLD, 8.0));
                    } else if (var2 > 9 && var2 <= 12) {
                        this.lblYou.setFont(Font.font("System", FontWeight.BOLD, 10.0));
                    } else if (var2 > 7 && var2 <= 9) {
                        this.lblYou.setFont(Font.font("System", FontWeight.BOLD, 12.0));
                    } else {
                        this.lblYou.setFont(Font.font("System", FontWeight.BOLD, 15.0));
                    }

                    if (var9 > 12) {
                        this.lblThem.setFont(Font.font("System", FontWeight.BOLD, 8.0));
                    } else if (var9 > 9 && var9 <= 12) {
                        this.lblThem.setFont(Font.font("System", FontWeight.BOLD, 10.0));
                    } else if (var9 > 7 && var9 <= 9) {
                        this.lblThem.setFont(Font.font("System", FontWeight.BOLD, 12.0));
                    } else {
                        this.lblThem.setFont(Font.font("System", FontWeight.BOLD, 15.0));
                    }

                    this.lblYou.setText(this.mainApp.getTestSettings().getNameBottom());
                    this.lblThem.setText(this.mainApp.getTestSettings().getNameTop());
                    this.xPosArrowYou = 493.0;
                    this.isFirstQuestion = true;
                    ++this.trialCount;
                    if (this.mainApp.getTestSettings().getScanSig().equals(ScanSig.TIMED)) {
                        KeyFrame var3 = new KeyFrame(Duration.millis(this.mainApp.getTestSettings().getExpT() * 1000));
                        this.conditionTimer = new Timeline();
                        this.conditionTimer.getKeyFrames().add(var3);
                        this.conditionTimer.setOnFinished(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent var1) {
                                TestPageController.this.popUpOrderIndex = TestPageController.this.orderIndex;
                                if (TestPageController.this.orderIndex < TestPageController.this.mainApp.getTestMath().returnOrderSize() - 1) {
                                    TestPageController.this.orderIndex++;
                                } else {
                                    TestPageController.this.orderIndex = 0;
                                }

                                TestPageController.this.questionTimer.stop();
                                if (TestPageController.this.timeS != null) {
                                    TestPageController.this.timeS.stop();
                                }

                                TestPageController.this.popUp();
                            }
                        });
                        this.conditionTimer.playFromStart();
                    }

                    this.mainApp.getRootLayout().setStyle("-fx-border-color: RED; -fx-border-style: SOLID; -fx-border-width: 10; -fx-border-radius: null;");
                    this.barTimer.setVisible(true);
                    this.lblYou.setVisible(true);
                    this.lblThem.setVisible(true);
                    this.arrowYou.setVisible(true);
                    this.arrowThem.setVisible(true);
                    this.inputHover = 0;
                    this.rec0.setFill(Color.rgb(142, 144, 147));
                    this.numCorrect = 0;
                    this.numWrong = 0;
                    this.questionSpeedVar = 1500.0;
                    this.testPane.requestFocus();
                    this.setNewQuestion(this.mainApp.getTestMath().getDiff());
                    this.duringFirstQuestion = true;
                }

            }
        }
    }

    @FXML
    public void onKeyTyped(KeyEvent var1) {
        if (!this.gettingFeedback) {
            if (var1.getCharacter().toLowerCase().charAt(0) == this.mainApp.getTestSettings().getLeftKey() && !this.mainApp.getTestMath().returnOrder(this.orderIndex).equals(condition.REST)) {
                this.moveLeft();
            }

            if (var1.getCharacter().toLowerCase().charAt(0) == this.mainApp.getTestSettings().getRightKey() && !this.mainApp.getTestMath().returnOrder(this.orderIndex).equals(condition.REST)) {
                this.moveRight();
            }

            if (var1.getCharacter().toLowerCase().charAt(0) == this.mainApp.getTestSettings().getConfKey() && !this.mainApp.getTestMath().returnOrder(this.orderIndex).equals(condition.REST)) {
                this.confirm();
            }
        }

        if (this.mainApp.getTestSettings().getScanSig().equals(ScanSig.KEYBOARD) && var1.getCharacter().toLowerCase().charAt(0) == this.mainApp.getTestSettings().getScanKey()) {
            this.scanKeyPress();
        }

        byte var2 = 113;
        if (var1.getCharacter().toLowerCase().charAt(0) == var2) {
            this.mainApp.showSettingsPage();
        }

    }

    @FXML
    public void onMouseClicked(MouseEvent var1) {
        if (this.mainApp.getTestSettings().getScanSig().equals(ScanSig.MOUSE) && !this.clickingAnswer) {
            this.scanKeyPress();
        }

    }

    private void moveLeft() {
        Integer var2;
        Integer var3;
        switch (this.inputHover) {
            case 0:
                this.rec0.setFill(Color.rgb(232, 235, 238));
                this.rec9.setFill(Color.rgb(142, 144, 147));
                this.inputHover = 9;
                break;
            case 1:
                this.rec1.setFill(Color.rgb(232, 235, 238));
                this.rec0.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover - 1;
                break;
            case 2:
                this.rec2.setFill(Color.rgb(232, 235, 238));
                this.rec1.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover - 1;
                break;
            case 3:
                this.rec3.setFill(Color.rgb(232, 235, 238));
                this.rec2.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover - 1;
                break;
            case 4:
                this.rec4.setFill(Color.rgb(232, 235, 238));
                this.rec3.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover - 1;
                break;
            case 5:
                this.rec5.setFill(Color.rgb(232, 235, 238));
                this.rec4.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover - 1;
                break;
            case 6:
                this.rec6.setFill(Color.rgb(232, 235, 238));
                this.rec5.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover - 1;
                break;
            case 7:
                this.rec7.setFill(Color.rgb(232, 235, 238));
                this.rec6.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover - 1;
                break;
            case 8:
                this.rec8.setFill(Color.rgb(232, 235, 238));
                this.rec7.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover - 1;
                break;
            case 9:
                this.rec9.setFill(Color.rgb(232, 235, 238));
                this.rec8.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover - 1;
        }

    }

    private void moveRight() {
        Integer var2;
        Integer var3;
        switch (this.inputHover) {
            case 0:
                this.rec0.setFill(Color.rgb(232, 235, 238));
                this.rec1.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover + 1;
                break;
            case 1:
                this.rec1.setFill(Color.rgb(232, 235, 238));
                this.rec2.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover + 1;
                break;
            case 2:
                this.rec2.setFill(Color.rgb(232, 235, 238));
                this.rec3.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover + 1;
                break;
            case 3:
                this.rec3.setFill(Color.rgb(232, 235, 238));
                this.rec4.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover + 1;
                break;
            case 4:
                this.rec4.setFill(Color.rgb(232, 235, 238));
                this.rec5.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover + 1;
                break;
            case 5:
                this.rec5.setFill(Color.rgb(232, 235, 238));
                this.rec6.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover + 1;
                break;
            case 6:
                this.rec6.setFill(Color.rgb(232, 235, 238));
                this.rec7.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover + 1;
                break;
            case 7:
                this.rec7.setFill(Color.rgb(232, 235, 238));
                this.rec8.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover + 1;
                break;
            case 8:
                this.rec8.setFill(Color.rgb(232, 235, 238));
                this.rec9.setFill(Color.rgb(142, 144, 147));
                var2 = this.inputHover;
                var3 = this.inputHover = this.inputHover + 1;
                break;
            case 9:
                this.rec9.setFill(Color.rgb(232, 235, 238));
                this.rec0.setFill(Color.rgb(142, 144, 147));
                this.inputHover = 0;
        }

    }

    private void confirm() {
        if (this.duringFirstQuestion) {
            this.duringFirstQuestion = false;
        }

        if (this.mainApp.getTestSettings().getNBack() <= 0 || this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
            if (this.mainApp.getTestSettings().getNBack() > 0 && this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                this.chosenAnswer = this.inputHover;
                this.nBackFeedback();
            } else {
                this.chosenAnswer = this.inputHover;
                this.feedback();
            }

        }
    }

    private void scanKeyPress() {
        this.isScanSig = true;
        ++this.scannerCount;

        try {
            FileWriter var1 = new FileWriter(this.dataFile, true);
            var1.write(String.format(this.format, System.currentTimeMillis(), "Scanner Signal", this.mainApp.getTestSettings().getScanSig() + ", Count = " + this.scannerCount, null));
            var1.close();
        } catch (IOException var3) {
            var3.printStackTrace();
        }

        Timeline var2;
        KeyFrame var4;
        switch (this.mainApp.getTestMath().returnOrder(this.orderIndex)) {
            case REST:
                if (this.scannerCount == this.mainApp.getTestSettings().getRestT()) {
                    this.scannerCount = 0;
                    this.popUpOrderIndex = this.orderIndex;
                    if (this.orderIndex < this.mainApp.getTestMath().returnOrderSize() - 1) {
                        ++this.orderIndex;
                    } else {
                        this.orderIndex = 0;
                    }

                    var4 = new KeyFrame(Duration.millis(this.mainApp.getTestSettings().getSigDuration() * 1000.0));
                    var2 = new Timeline();
                    var2.getKeyFrames().add(var4);
                    var2.setOnFinished(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent var1) {
                            TestPageController.this.restPopUp();
                        }
                    });
                    var2.playFromStart();
                    break;
                }
            case CONTROL:
                if (this.scannerCount == this.mainApp.getTestSettings().getConT()) {
                    this.scannerCount = 0;
                    this.popUpOrderIndex = this.orderIndex;
                    if (this.orderIndex < this.mainApp.getTestMath().returnOrderSize() - 1) {
                        ++this.orderIndex;
                    } else {
                        this.orderIndex = 0;
                    }

                    var4 = new KeyFrame(Duration.millis(this.mainApp.getTestSettings().getSigDuration() * 1000.0));
                    var2 = new Timeline();
                    var2.getKeyFrames().add(var4);
                    var2.setOnFinished(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent var1) {
                            if (TestPageController.this.timerControl != null) {
                                TestPageController.this.timerControl.stop();
                            }

                            TestPageController.this.popUp();
                        }
                    });
                    var2.playFromStart();
                    break;
                }
            case EXPERIMENTAL:
                if (this.scannerCount == this.mainApp.getTestSettings().getExpT()) {
                    this.scannerCount = 0;
                    this.popUpOrderIndex = this.orderIndex;
                    if (this.orderIndex < this.mainApp.getTestMath().returnOrderSize() - 1) {
                        ++this.orderIndex;
                    } else {
                        this.orderIndex = 0;
                    }

                    var4 = new KeyFrame(Duration.millis(this.mainApp.getTestSettings().getSigDuration() * 1000.0));
                    var2 = new Timeline();
                    var2.getKeyFrames().add(var4);
                    var2.setOnFinished(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent var1) {
                            if (TestPageController.this.questionTimer != null) {
                                TestPageController.this.questionTimer.stop();
                            }

                            if (TestPageController.this.timeS != null) {
                                TestPageController.this.timeS.stop();
                            }

                            TestPageController.this.popUp();
                        }
                    });
                    var2.playFromStart();
                }
        }

        this.isScanSig = false;
    }

    private void setNewQuestion(int var1) {
        if (!this.gettingTotalFeedback) {
            if (!this.isScanSig) {
                if (!this.mainApp.getTestMath().returnOrder(this.orderIndex).equals(condition.REST)) {
                    this.testPane.requestFocus();
                    this.chosenAnswer = 1000;
                    ++this.numQuestions;
                    TestQuestion var2 = new TestQuestion(var1, this.mainApp.getTestMath().getULimit());
                    this.currentAnswer = var2.getAnswer();
                    this.txtQuestion.clear();
                    this.qStartTime = System.currentTimeMillis();
                    if (var2.getBaseTime() == 5800) {
                        this.txtQuestion.setFont(Font.font("System", FontWeight.BOLD, 40.0));
                        this.txtQuestion.setText(var2.getQuestion());
                    } else if (var2.getBaseTime() != 4300 && var2.getBaseTime() != 3300) {
                        this.txtQuestion.setFont(Font.font("System", FontWeight.BOLD, 55.0));
                        this.txtQuestion.setText(var2.getQuestion());
                    } else {
                        this.txtQuestion.setFont(Font.font("System", FontWeight.BOLD, 48.0));
                        this.txtQuestion.setText(var2.getQuestion());
                    }

                    FileWriter var3;
                    if (this.mainApp.getTestMath().returnOrder(this.orderIndex).equals(condition.CONTROL)) {
                        KeyFrame var9;
                        if (this.mainApp.getTestSettings().getNBack() > 0) {
                            try {
                                var3 = new FileWriter(this.dataFile, true);
                                var3.write(String.format(this.format, this.qStartTime, "New Question", "Lvl " + var2.getDiffLevel() + " - N-Back = " + this.mainApp.getTestSettings().getNBack(), null));
                                var3.close();
                            } catch (IOException var8) {
                                var8.printStackTrace();
                            }

                            this.oldAnswers.add(this.currentAnswer);
                            if (this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                                this.txtGo.setText("Answer Now");
                                if (this.mainApp.getTestSettings().getIsTimeout()) {
                                    var9 = new KeyFrame(Duration.millis(this.mainApp.getTestSettings().getConTimeout() * 1000));
                                    this.timerControl = new Timeline();
                                    this.timerControl.getKeyFrames().add(var9);
                                    this.timerControl.setOnFinished(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent var1) {
                                            if (TestPageController.this.duringFirstQuestion = true) {
                                                TestPageController.this.duringFirstQuestion = false;
                                            }

                                            TestPageController.this.hasTimedOut = true;
                                            TestPageController.this.nBackFeedback();
                                        }
                                    });
                                    this.timerControl.playFromStart();
                                }
                            } else {
                                this.txtGo.setText("Do Not Answer Yet!");
                                if (this.mainApp.getTestSettings().getIsTimeout()) {
                                    var9 = new KeyFrame(Duration.millis(this.mainApp.getTestSettings().getConTimeout() * 1000));
                                    this.timerControl = new Timeline();
                                    this.timerControl.getKeyFrames().add(var9);
                                    this.timerControl.setOnFinished(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent var1) {
                                            if (TestPageController.this.duringFirstQuestion) {
                                                TestPageController.this.duringFirstQuestion = false;
                                            }

                                            TestPageController.this.hasTimedOut = true;
                                            TestPageController.this.nBackFeedback();
                                        }
                                    });
                                    this.timerControl.playFromStart();
                                } else {
                                    var9 = new KeyFrame(Duration.millis(8000.0));
                                    Timeline var4 = new Timeline();
                                    var4.getKeyFrames().add(var9);
                                    var4.setOnFinished(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent var1) {
                                            if (TestPageController.this.duringFirstQuestion) {
                                                TestPageController.this.duringFirstQuestion = false;
                                            }

                                            TestPageController.this.nBackFeedback();
                                        }
                                    });
                                    var4.playFromStart();
                                }
                            }
                        } else {
                            try {
                                var3 = new FileWriter(this.dataFile, true);
                                var3.write(String.format(this.format, this.qStartTime, "New Question", "Lvl " + var2.getDiffLevel(), null));
                                var3.close();
                            } catch (IOException var7) {
                                var7.printStackTrace();
                            }

                            if (this.mainApp.getTestSettings().getIsTimeout()) {
                                var9 = new KeyFrame(Duration.millis(this.mainApp.getTestSettings().getConTimeout() * 1000));
                                this.timerControl = new Timeline();
                                this.timerControl.getKeyFrames().add(var9);
                                this.timerControl.setOnFinished(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent var1) {
                                        if (TestPageController.this.duringFirstQuestion) {
                                            TestPageController.this.duringFirstQuestion = false;
                                        }

                                        TestPageController.this.hasTimedOut = true;
                                        TestPageController.this.feedback();
                                    }
                                });
                                this.timerControl.playFromStart();
                            }
                        }
                    } else if (this.mainApp.getTestSettings().getNBack() > 0) {
                        try {
                            var3 = new FileWriter(this.dataFile, true);
                            var3.write(String.format(this.format, this.qStartTime, "New Question", "Lvl " + var2.getDiffLevel() + " - N-Back = " + this.mainApp.getTestSettings().getNBack(), null));
                            var3.close();
                        } catch (IOException var6) {
                            var6.printStackTrace();
                        }

                        this.oldAnswers.add(this.currentAnswer);
                        if (this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                            this.txtGo.setText("Answer Now");
                        } else {
                            this.txtGo.setText("Do Not Answer Yet!");
                        }

                        if (!this.isFirstQuestion) {
                            this.questionTimer.stop();
                            this.setQuestionSpeed((double)var2.getBaseTime() + this.questionSpeedVar);
                            this.barTimer.setProgress(0.0);
                            this.questionTimer.playFromStart();
                            if (this.timeS != null) {
                                this.timeS.play();
                            }
                        } else {
                            this.setQuestionSpeed((double)var2.getBaseTime() + this.questionSpeedVar);
                            this.barTimer.setProgress(0.0);
                            this.questionTimer.playFromStart();
                            this.isFirstQuestion = false;
                            if (this.timeS != null) {
                                this.timeS.play();
                            }
                        }
                    } else {
                        try {
                            var3 = new FileWriter(this.dataFile, true);
                            var3.write(String.format(this.format, this.qStartTime, "New Question", "Lvl " + var2.getDiffLevel(), null));
                            var3.close();
                        } catch (IOException var5) {
                            var5.printStackTrace();
                        }

                        if (!this.isFirstQuestion) {
                            this.questionTimer.stop();
                            this.setQuestionSpeed((double)var2.getBaseTime() + this.questionSpeedVar);
                            this.barTimer.setProgress(0.0);
                            this.questionTimer.playFromStart();
                            if (this.timeS != null) {
                                this.timeS.play();
                            }
                        } else {
                            this.setQuestionSpeed((double)var2.getBaseTime() + this.questionSpeedVar);
                            this.barTimer.setProgress(0.0);
                            this.questionTimer.playFromStart();
                            this.isFirstQuestion = false;
                            if (this.timeS != null) {
                                this.timeS.play();
                            }
                        }
                    }

                    this.gettingFeedback = false;
                }
            }
        }
    }

    private void feedback() {
        this.gettingFeedback = true;
        if (this.timeS != null) {
            this.timeS.stop();
        }

        if (this.timerControl != null) {
            this.timerControl.stop();
        }

        if (this.questionTimer != null) {
            this.questionTimer.stop();
        }

        FileWriter var1;
        Integer var2;
        Integer var3;
        if (this.chosenAnswer.equals(this.currentAnswer)) {
            try {
                var1 = new FileWriter(this.dataFile, true);
                var1.write(String.format(this.format, System.currentTimeMillis(), "Response", "CORRECT", System.currentTimeMillis() - this.qStartTime));
                var1.close();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

            if (this.successiveAnswers >= 0) {
                var2 = this.successiveAnswers;
                var3 = this.successiveAnswers = this.successiveAnswers + 1;
            } else {
                this.successiveAnswers = 1;
            }

            ++this.numCorrect;
            if (this.rightS != null) {
                this.rightS.play();
            }

            this.txtFeedback.setText(this.mainApp.getTestSettings().getCorrect());
            if (this.xPosArrowYou < 763.0) {
                this.arrowYou.setTranslateX(this.arrowYou.getTranslateX() + 25.0);
                this.lblYou.setTranslateX(this.lblYou.getTranslateX() + 25.0);
                this.arrowYou.translateXProperty();
                this.lblYou.translateXProperty();
                this.xPosArrowYou += 25.0;
            }

            if (!this.mainApp.getTestSettings().getIsStaticFeedback()) {
                this.opponentFeedback();
            }
        } else {
            try {
                var1 = new FileWriter(this.dataFile, true);
                if (!this.hasTimedOut) {
                    var1.write(String.format(this.format, System.currentTimeMillis(), "Response", "WRONG", System.currentTimeMillis() - this.qStartTime));
                    var1.close();
                } else {
                    var1.write(String.format(this.format, System.currentTimeMillis(), "Response", "TIMEOUT", System.currentTimeMillis() - this.qStartTime));
                    var1.close();
                }
            } catch (IOException var4) {
                var4.printStackTrace();
            }

            if (this.successiveAnswers <= 0) {
                var2 = this.successiveAnswers;
                var3 = this.successiveAnswers = this.successiveAnswers - 1;
            } else {
                this.successiveAnswers = -1;
            }

            if (this.wrongS != null) {
                this.wrongS.play();
            }

            if (!this.hasTimedOut && this.mainApp.getTestMath().returnOrder(this.orderIndex).equals(condition.CONTROL)) {
                this.txtFeedback.setText(this.mainApp.getTestSettings().getNCorrect());
                ++this.numWrong;
            } else if (this.hasTimedOut && this.mainApp.getTestMath().returnOrder(this.orderIndex).equals(condition.CONTROL)) {
                this.txtFeedback.setText("TIMEOUT");
                ++this.numTime;
                this.hasTimedOut = false;
            } else {
                this.txtFeedback.setText(this.mainApp.getTestSettings().getNCorrect());
                ++this.numWrong;
                this.hasTimedOut = false;
            }

            if (this.xPosArrowYou > 103.0) {
                this.arrowYou.setTranslateX(this.arrowYou.getTranslateX() - 25.0);
                this.lblYou.setTranslateX(this.lblYou.getTranslateX() - 25.0);
                this.arrowYou.translateXProperty();
                this.lblYou.translateXProperty();
                this.xPosArrowYou -= 25.0;
            }

            if (!this.mainApp.getTestSettings().getIsStaticFeedback()) {
                this.opponentFeedback();
            }
        }

        if (this.mainApp.getTestMath().returnOrder(this.orderIndex).equals(condition.CONTROL)) {
            this.txtFeedback.appendText("\n" + this.mainApp.getTestSettings().getNRecord());
        } else {
            this.txtFeedback.appendText("\n" + this.mainApp.getTestSettings().getRecord());
            if (this.questionTimer != null) {
                this.questionTimer.pause();
            }

            this.setNewTime();
            this.setNewDifficulty();
        }

        PauseTransition var6 = new PauseTransition(Duration.millis(3000.0));
        var6.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent var1) {
                TestPageController.this.txtFeedback.clear();
                if (TestPageController.this.duringFirstQuestion) {
                    TestPageController.this.duringFirstQuestion = false;
                } else {
                    TestPageController.this.setNewQuestion(TestPageController.this.mainApp.getTestMath().getDiff());
                }

            }
        });
        var6.play();
    }

    private void nBackFeedback() {
        this.gettingFeedback = true;
        if (this.timeS != null) {
            this.timeS.stop();
        }

        if (this.questionTimer != null) {
            this.questionTimer.stop();
        }

        if (this.timerControl != null) {
            this.timerControl.stop();
        }

        if (this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
            FileWriter var1;
            Integer var2;
            Integer var3;
            if (this.chosenAnswer.equals(this.oldAnswers.get(this.numQuestions - this.mainApp.getTestSettings().getNBack() - 1))) {
                try {
                    var1 = new FileWriter(this.dataFile, true);
                    var1.write(String.format(this.format, System.currentTimeMillis(), "Response", "CORRECT", System.currentTimeMillis() - this.qStartTime));
                    var1.close();
                } catch (IOException var5) {
                    var5.printStackTrace();
                }

                if (this.successiveAnswers >= 0) {
                    var2 = this.successiveAnswers;
                    var3 = this.successiveAnswers = this.successiveAnswers + 1;
                } else {
                    this.successiveAnswers = 1;
                }

                ++this.numCorrect;
                if (this.rightS != null) {
                    this.rightS.play();
                }

                this.txtFeedback.setText(this.mainApp.getTestSettings().getCorrect());
                if (this.xPosArrowYou < 763.0) {
                    this.arrowYou.setTranslateX(this.arrowYou.getTranslateX() + 25.0);
                    this.lblYou.setTranslateX(this.lblYou.getTranslateX() + 25.0);
                    this.arrowYou.translateXProperty();
                    this.lblYou.translateXProperty();
                    this.xPosArrowYou += 25.0;
                }

                if (!this.mainApp.getTestSettings().getIsStaticFeedback()) {
                    this.opponentFeedback();
                }
            } else {
                try {
                    var1 = new FileWriter(this.dataFile, true);
                    if (!this.hasTimedOut) {
                        var1.write(String.format(this.format, System.currentTimeMillis(), "Response", "WRONG", System.currentTimeMillis() - this.qStartTime));
                        var1.close();
                    } else {
                        var1.write(String.format(this.format, System.currentTimeMillis(), "Response", "TIMEOUT", System.currentTimeMillis() - this.qStartTime));
                        var1.close();
                    }
                } catch (IOException var4) {
                    var4.printStackTrace();
                }

                if (this.successiveAnswers <= 0) {
                    var2 = this.successiveAnswers;
                    var3 = this.successiveAnswers = this.successiveAnswers - 1;
                } else {
                    this.successiveAnswers = -1;
                }

                if (!this.hasTimedOut) {
                    this.txtFeedback.setText(this.mainApp.getTestSettings().getNCorrect());
                    ++this.numWrong;
                } else if (this.hasTimedOut && this.mainApp.getTestMath().returnOrder(this.orderIndex).equals(condition.CONTROL)) {
                    this.txtFeedback.setText("TIMEOUT");
                    ++this.numTime;
                    this.hasTimedOut = false;
                } else {
                    this.txtFeedback.setText(this.mainApp.getTestSettings().getNCorrect());
                    ++this.numWrong;
                    this.hasTimedOut = false;
                }

                if (this.wrongS != null) {
                    this.wrongS.play();
                }

                if (this.xPosArrowYou > 103.0) {
                    this.arrowYou.setTranslateX(this.arrowYou.getTranslateX() - 25.0);
                    this.lblYou.setTranslateX(this.lblYou.getTranslateX() - 25.0);
                    this.arrowYou.translateXProperty();
                    this.lblYou.translateXProperty();
                    this.xPosArrowYou -= 25.0;
                }

                if (!this.mainApp.getTestSettings().getIsStaticFeedback()) {
                    this.opponentFeedback();
                }
            }

            if (this.mainApp.getTestMath().returnOrder(this.orderIndex).equals(condition.CONTROL)) {
                this.txtFeedback.appendText("\n" + this.mainApp.getTestSettings().getNRecord());
            } else {
                this.txtFeedback.appendText("\n" + this.mainApp.getTestSettings().getRecord());
                this.questionTimer.pause();
                this.setNewTime();
                this.setNewDifficulty();
            }
        } else {
            this.txtFeedback.setText("\n" + this.mainApp.getTestSettings().getNRecord());
        }

        PauseTransition var6 = new PauseTransition(Duration.millis(3000.0));
        var6.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent var1) {
                TestPageController.this.txtFeedback.clear();
                if (TestPageController.this.duringFirstQuestion) {
                    TestPageController.this.duringFirstQuestion = false;
                } else {
                    TestPageController.this.setNewQuestion(TestPageController.this.mainApp.getTestMath().getDiff());
                }

            }
        });
        var6.play();
    }

    private void setNewDifficulty() {
        if (this.successiveAnswers > 2) {
            this.mainApp.getTestMath().increaseULimit();
        } else if (this.successiveAnswers < -3) {
            this.mainApp.getTestMath().decreaseULimit();
        }

    }

    private void opponentFeedback() {
        int var1;
        if (this.xPosArrowThem == 493.0) {
            var1 = ThreadLocalRandom.current().nextInt(2);
            switch (var1) {
                case 0:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() + 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() + 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem += 25.0;
                    break;
                case 1:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() + 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() + 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem += 25.0;
                case 2:
            }
        } else if (this.xPosArrowThem < 613.0) {
            var1 = ThreadLocalRandom.current().nextInt(6);
            switch (var1) {
                case 0:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() + 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() + 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem += 25.0;
                    break;
                case 1:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() + 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() + 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem += 25.0;
                    break;
                case 2:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() + 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() + 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem += 25.0;
                    break;
                case 3:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() - 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() - 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem -= 25.0;
                case 4:
                default:
                    break;
                case 5:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() + 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() + 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem += 25.0;
                    break;
                case 6:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() - 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() - 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem -= 25.0;
            }
        } else if (this.xPosArrowThem >= 613.0 && this.xPosArrowThem < 718.0) {
            var1 = ThreadLocalRandom.current().nextInt(2);
            switch (var1) {
                case 0:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() + 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() + 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem += 25.0;
                    break;
                case 1:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() - 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() - 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem -= 25.0;
                case 2:
            }
        } else if (this.xPosArrowThem >= 718.0 && this.xPosArrowThem < 763.0) {
            var1 = ThreadLocalRandom.current().nextInt(3);
            switch (var1) {
                case 1:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() - 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() - 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem -= 25.0;
                    break;
                case 2:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() - 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() - 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem -= 25.0;
                case 3:
                default:
                    break;
                case 4:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() + 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() + 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem += 25.0;
            }
        } else {
            var1 = ThreadLocalRandom.current().nextInt(1);
            switch (var1) {
                case 0:
                    this.arrowThem.setTranslateX(this.arrowThem.getTranslateX() - 25.0);
                    this.lblThem.setTranslateX(this.lblThem.getTranslateX() - 25.0);
                    this.arrowThem.translateXProperty();
                    this.lblThem.translateXProperty();
                    this.xPosArrowThem -= 25.0;
                case 1:
            }
        }

    }

    private void resetButtons() {
        this.rec0.setFill(Color.rgb(232, 235, 238));
        this.rec1.setFill(Color.rgb(232, 235, 238));
        this.rec2.setFill(Color.rgb(232, 235, 238));
        this.rec3.setFill(Color.rgb(232, 235, 238));
        this.rec4.setFill(Color.rgb(232, 235, 238));
        this.rec5.setFill(Color.rgb(232, 235, 238));
        this.rec6.setFill(Color.rgb(232, 235, 238));
        this.rec7.setFill(Color.rgb(232, 235, 238));
        this.rec8.setFill(Color.rgb(232, 235, 238));
        this.rec9.setFill(Color.rgb(232, 235, 238));
    }

    private void popUp() {
        if (this.timeS != null) {
            this.timeS.stop();
        }

        if (this.timerControl != null) {
            this.timerControl.stop();
        }

        this.gettingTotalFeedback = true;
        if (this.trialCount >= this.mainApp.getTestMath().getNumberOfTrials()) {
            if (this.mainApp.testnum == 1) {
                // JOptionPane.showMessageDialog(null, "Test has been paused by the experimenter", "Attention", 1);
                System.exit(1);
            } else {
                this.mainApp.showEndPage();
            }
        } else {
            this.gettingTotalFeedback = false;
            this.isScanSig = false;
            this.setPage();
        }

    }

    private void restPopUp() {
        this.gettingTotalFeedback = true;
        if (this.mainApp.getTestSettings().getIsPopUp()) {
            final Alert var1 = new Alert(AlertType.INFORMATION);
            var1.setTitle("Feedback");
            var1.setHeaderText(null);
            var1.setContentText("No Questions Presented");
            ButtonType var2;
            final ButtonType var3;
            if (this.trialCount >= this.mainApp.getTestMath().getNumberOfTrials()) {
                var2 = new ButtonType("CONTINUE", ButtonData.CANCEL_CLOSE);
                var3 = new ButtonType("SETTINGS");
                var1.getButtonTypes().setAll(var2, var3);
                Platform.runLater(new Runnable() {
                    public void run() {
                        Optional var1x = var1.showAndWait();
                        if (var1x.get() == var3) {
                            TestPageController.this.mainApp.showSettingsPage();
                        } else {
                            TestPageController.this.mainApp.showEndPage();
                        }

                    }
                });
            } else {
                var2 = new ButtonType("CONTINUE", ButtonData.CANCEL_CLOSE);
                var3 = new ButtonType("SETTINGS");
                var1.getButtonTypes().setAll(var2, var3);
                Platform.runLater(new Runnable() {
                    public void run() {
                        Optional var1x = var1.showAndWait();
                        if (var1x.get() == var3) {
                            TestPageController.this.mainApp.showSettingsPage();
                        } else {
                            TestPageController.this.gettingTotalFeedback = false;
                            TestPageController.this.setPage();
                        }

                    }
                });
            }
        } else if (this.trialCount >= this.mainApp.getTestMath().getNumberOfTrials()) {
            this.mainApp.showEndPage();
        } else {
            this.gettingTotalFeedback = false;
            this.isScanSig = false;
            this.setPage();
        }

    }

    @FXML
    public void onClickOne(MouseEvent var1) {
        if (!this.gettingFeedback) {
            if (this.duringFirstQuestion) {
                this.duringFirstQuestion = false;
            }

            if (this.mainApp.getTestSettings().getNBack() <= 0 || this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                if (this.mainApp.getTestSettings().getIsClick()) {
                    this.resetButtons();
                    this.chosenAnswer = 1;
                    this.feedback();
                } else if (this.mainApp.getTestSettings().getIsClick() && this.mainApp.getTestSettings().getNBack() > 0 && this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                    this.resetButtons();
                    this.chosenAnswer = 1;
                    this.nBackFeedback();
                }

            }
        }
    }

    @FXML
    public void onClickTwo(MouseEvent var1) {
        if (!this.gettingFeedback) {
            if (this.duringFirstQuestion) {
                this.duringFirstQuestion = false;
            }

            if (this.mainApp.getTestSettings().getNBack() <= 0 || this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                if (this.mainApp.getTestSettings().getIsClick()) {
                    this.resetButtons();
                    this.chosenAnswer = 2;
                    this.feedback();
                } else if (this.mainApp.getTestSettings().getIsClick() && this.mainApp.getTestSettings().getNBack() > 0 && this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                    this.resetButtons();
                    this.chosenAnswer = 2;
                    this.nBackFeedback();
                }

            }
        }
    }

    @FXML
    public void onClickThree(MouseEvent var1) {
        if (!this.gettingFeedback) {
            if (this.duringFirstQuestion) {
                this.duringFirstQuestion = false;
            }

            if (this.mainApp.getTestSettings().getNBack() <= 0 || this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                if (this.mainApp.getTestSettings().getIsClick()) {
                    this.resetButtons();
                    this.chosenAnswer = 3;
                    this.feedback();
                } else if (this.mainApp.getTestSettings().getIsClick() && this.mainApp.getTestSettings().getNBack() > 0 && this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                    this.resetButtons();
                    this.chosenAnswer = 3;
                    this.nBackFeedback();
                }

            }
        }
    }

    @FXML
    public void onClickFour(MouseEvent var1) {
        if (!this.gettingFeedback) {
            if (this.duringFirstQuestion) {
                this.duringFirstQuestion = false;
            }

            if (this.mainApp.getTestSettings().getNBack() <= 0 || this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                if (this.mainApp.getTestSettings().getIsClick()) {
                    this.resetButtons();
                    this.chosenAnswer = 4;
                    this.feedback();
                } else if (this.mainApp.getTestSettings().getIsClick() && this.mainApp.getTestSettings().getNBack() > 0 && this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                    this.resetButtons();
                    this.chosenAnswer = 4;
                    this.nBackFeedback();
                }

            }
        }
    }

    @FXML
    public void onClickFive(MouseEvent var1) {
        if (!this.gettingFeedback) {
            if (this.duringFirstQuestion) {
                this.duringFirstQuestion = false;
            }

            if (this.mainApp.getTestSettings().getNBack() <= 0 || this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                if (this.mainApp.getTestSettings().getIsClick()) {
                    this.resetButtons();
                    this.chosenAnswer = 5;
                    this.feedback();
                } else if (this.mainApp.getTestSettings().getIsClick() && this.mainApp.getTestSettings().getNBack() > 0 && this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                    this.resetButtons();
                    this.chosenAnswer = 5;
                    this.nBackFeedback();
                }

            }
        }
    }

    @FXML
    public void onClickSix(MouseEvent var1) {
        if (!this.gettingFeedback) {
            if (this.duringFirstQuestion) {
                this.duringFirstQuestion = false;
            }

            if (this.mainApp.getTestSettings().getNBack() <= 0 || this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                if (this.mainApp.getTestSettings().getIsClick()) {
                    this.resetButtons();
                    this.chosenAnswer = 6;
                    this.feedback();
                } else if (this.mainApp.getTestSettings().getIsClick() && this.mainApp.getTestSettings().getNBack() > 0 && this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                    this.resetButtons();
                    this.chosenAnswer = 6;
                    this.nBackFeedback();
                }

            }
        }
    }

    @FXML
    public void onClickSeven(MouseEvent var1) {
        if (!this.gettingFeedback) {
            if (this.duringFirstQuestion) {
                this.duringFirstQuestion = false;
            }

            if (this.mainApp.getTestSettings().getNBack() <= 0 || this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                if (this.mainApp.getTestSettings().getIsClick()) {
                    this.resetButtons();
                    this.chosenAnswer = 7;
                    this.feedback();
                } else if (this.mainApp.getTestSettings().getIsClick() && this.mainApp.getTestSettings().getNBack() > 0 && this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                    this.resetButtons();
                    this.chosenAnswer = 7;
                    this.nBackFeedback();
                }

            }
        }
    }

    @FXML
    public void onClickEight(MouseEvent var1) {
        if (!this.gettingFeedback) {
            if (this.duringFirstQuestion) {
                this.duringFirstQuestion = false;
            }

            if (this.mainApp.getTestSettings().getNBack() <= 0 || this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                if (this.mainApp.getTestSettings().getIsClick()) {
                    this.resetButtons();
                    this.chosenAnswer = 8;
                    this.feedback();
                } else if (this.mainApp.getTestSettings().getIsClick() && this.mainApp.getTestSettings().getNBack() > 0 && this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                    this.resetButtons();
                    this.chosenAnswer = 8;
                    this.nBackFeedback();
                }

            }
        }
    }

    @FXML
    public void onClickNine(MouseEvent var1) {
        if (!this.gettingFeedback) {
            if (this.duringFirstQuestion) {
                this.duringFirstQuestion = false;
            }

            if (this.mainApp.getTestSettings().getNBack() <= 0 || this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                if (this.mainApp.getTestSettings().getIsClick()) {
                    this.resetButtons();
                    this.chosenAnswer = 9;
                    this.feedback();
                } else if (this.mainApp.getTestSettings().getIsClick() && this.mainApp.getTestSettings().getNBack() > 0 && this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                    this.resetButtons();
                    this.chosenAnswer = 9;
                    this.nBackFeedback();
                }

            }
        }
    }

    @FXML
    public void onClickZero(MouseEvent var1) {
        if (!this.gettingFeedback) {
            if (this.duringFirstQuestion) {
                this.duringFirstQuestion = false;
            }

            if (this.mainApp.getTestSettings().getNBack() <= 0 || this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                if (this.mainApp.getTestSettings().getIsClick()) {
                    this.resetButtons();
                    this.chosenAnswer = 0;
                    this.feedback();
                } else if (this.mainApp.getTestSettings().getIsClick() && this.mainApp.getTestSettings().getNBack() > 0 && this.numQuestions > this.mainApp.getTestSettings().getNBack()) {
                    this.resetButtons();
                    this.chosenAnswer = 0;
                    this.nBackFeedback();
                }

            }
        }
    }

    @FXML
    public void onMouseEnter(MouseEvent var1) {
        if (this.mainApp.getTestSettings().getIsClick()) {
            this.clickingAnswer = true;
        }

    }

    @FXML
    public void onMouseExit(MouseEvent var1) {
        if (this.mainApp.getTestSettings().getIsClick()) {
            this.clickingAnswer = false;
        }

    }
}
