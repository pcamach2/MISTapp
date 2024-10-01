//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package App.model;

import java.util.ArrayList;
import java.util.Collections;

public class TestMath {
    private final ArrayList<condition> order;
    private boolean hasOrderBeenSet = false;
    private final TestSettings testSettings;
    private int numberOfTrials;
    private final int difficulty;
    private int uLimit;
    private double expSpeed;

    public TestMath(TestSettings var1) {
        this.testSettings = var1;
        this.order = new ArrayList();
        this.difficulty = this.testSettings.getDiff();
        this.uLimit = 30;
        this.expSpeed = 3000.0;
    }

    private void setOrder() {
        if (!this.hasOrderBeenSet) {
            if (this.testSettings.getIsRest()) {
                this.order.add(TestMath.condition.REST);
            }

            if (this.testSettings.getIsCon()) {
                this.order.add(TestMath.condition.CONTROL);
            }

            if (this.testSettings.getIsExp()) {
                this.order.add(TestMath.condition.EXPERIMENTAL);
            }

            if (!this.testSettings.getIsStrict()) {
                Collections.shuffle(this.order);
            }

            this.hasOrderBeenSet = true;
            this.numberOfTrials = this.testSettings.getReps() * this.order.size();
        }
    }

    public void callSetOrder() {
        this.setOrder();
    }

    public condition returnOrder(int var1) {
        return this.order.get(var1);
    }

    public int returnOrderSize() {
        return this.order.size();
    }

    public int getNumberOfTrials() {
        return this.numberOfTrials;
    }

    public int getDiff() {
        return this.difficulty;
    }

    public void increaseULimit() {
        if (this.uLimit < 110) {
            this.uLimit += 5;
        }
    }

    public void decreaseULimit() {
        if (this.uLimit > 15) {
            this.uLimit -= 5;
        }
    }

    public int getULimit() {
        return this.uLimit;
    }

    public double getExpSpeed() {
        return this.expSpeed;
    }

    public void setExpSpeed(double var1) {
        this.expSpeed = var1;
    }

    public enum condition {
        REST,
        CONTROL,
        EXPERIMENTAL;

        condition() {
        }
    }
}
