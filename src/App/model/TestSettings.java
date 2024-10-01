//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package App.model;

public class TestSettings {
    private final int reps;
    private final int difficulty;
    private final int nBack;
    private final int restT;
    private final int conT;
    private final int expT;
    private final int conTimeout;
    private final double sigDuration;
    private final ScanSig scanSig;
    private final boolean isStrict;
    private final boolean isRest;
    private final boolean isCon;
    private final boolean isExp;
    private final boolean isSound;
    private final boolean isClick;
    private final boolean isTimeout;
    private final boolean isPopUp;
    private final boolean isStaticFeedback;
    private final char scanKey;
    private final char leftKey;
    private final char rightKey;
    private final char confKey;
    private final String correct;
    private final String nCorrect;
    private final String record;
    private final String nRecord;
    private final String ID;
    private final String saveDir;
    private final String nameTop;
    private final String nameBottom;

    public TestSettings(int[] var1, boolean[] var2, char[] var3, String[] var4, ScanSig var5, double var6) {
        if (var1[0] == 0) {
            this.reps = 1;
        } else {
            this.reps = var1[0];
        }

        this.difficulty = var1[1];
        this.nBack = var1[2];
        this.restT = var1[3];
        this.conT = var1[4];
        this.expT = var1[5];
        this.conTimeout = var1[6];
        this.isStrict = var2[0];
        this.isRest = var2[1];
        this.isCon = var2[2];
        this.isExp = var2[3];
        this.isSound = var2[4];
        this.isClick = var2[5];
        this.isTimeout = var2[6];
        this.isPopUp = var2[7];
        this.isStaticFeedback = var2[8];
        this.scanKey = var3[0];
        this.leftKey = var3[1];
        this.rightKey = var3[2];
        this.confKey = var3[3];
        this.correct = var4[0];
        this.nCorrect = var4[1];
        this.record = var4[2];
        this.nRecord = var4[3];
        this.ID = var4[4];
        this.saveDir = var4[5];
        this.nameBottom = var4[6];
        this.nameTop = var4[7];
        this.scanSig = var5;
        this.sigDuration = var6;
    }

    public int getNBack() {
        return this.nBack;
    }

    public int getReps() {
        return this.reps;
    }

    public int getDiff() {
        return this.difficulty;
    }

    public int getRestT() {
        return this.restT;
    }

    public int getConT() {
        return this.conT;
    }

    public int getExpT() {
        return this.expT;
    }

    public int getConTimeout() {
        return this.conTimeout;
    }

    public double getSigDuration() {
        return this.sigDuration;
    }

    public boolean getIsStrict() {
        return this.isStrict;
    }

    public boolean getIsRest() {
        return this.isRest;
    }

    public boolean getIsCon() {
        return this.isCon;
    }

    public boolean getIsExp() {
        return this.isExp;
    }

    public boolean getIsSound() {
        return this.isSound;
    }

    public boolean getIsClick() {
        return this.isClick;
    }

    public boolean getIsTimeout() {
        return this.isTimeout;
    }

    public boolean getIsPopUp() {
        return this.isPopUp;
    }

    public boolean getIsStaticFeedback() {
        return this.isStaticFeedback;
    }

    public char getScanKey() {
        return this.scanKey;
    }

    public char getLeftKey() {
        return this.leftKey;
    }

    public char getRightKey() {
        return this.rightKey;
    }

    public char getConfKey() {
        return this.confKey;
    }

    public String getCorrect() {
        return this.correct;
    }

    public String getNCorrect() {
        return this.nCorrect;
    }

    public String getRecord() {
        return this.record;
    }

    public String getNRecord() {
        return this.nRecord;
    }

    public String getID() {
        return this.ID;
    }

    public String getSaveDir() {
        return this.saveDir;
    }

    public String getNameBottom() {
        return this.nameBottom;
    }

    public String getNameTop() {
        return this.nameTop;
    }

    public ScanSig getScanSig() {
        return this.scanSig;
    }

    public enum ScanSig {
        MOUSE,
        KEYBOARD,
        TIMED;

        ScanSig() {
        }
    }
}
