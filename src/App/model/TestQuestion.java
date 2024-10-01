//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package App.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestQuestion {
    private int answer;
    private String question;
    private int baseTime;
    private Integer diffLevel;

    public TestQuestion(int var1, int var2) {
        switch (var1) {
            case 1:
                int var3 = ThreadLocalRandom.current().nextInt(2);
                switch (var3) {
                    case 0:
                        this.questionLevel1(var2);
                        return;
                    case 1:
                        this.questionLevel2(var2);
                        return;
                    default:
                        return;
                }
            case 2:
                int var4 = ThreadLocalRandom.current().nextInt(3);
                switch (var4) {
                    case 0:
                        this.questionLevel1(var2);
                        return;
                    case 1:
                        this.questionLevel2(var2);
                        return;
                    case 2:
                        this.questionLevel3(var2);
                        return;
                    default:
                        return;
                }
            case 3:
                int var5 = ThreadLocalRandom.current().nextInt(4);
                switch (var5) {
                    case 0:
                        this.questionLevel1(var2);
                        return;
                    case 1:
                        this.questionLevel2(var2);
                        return;
                    case 2:
                        this.questionLevel3(var2);
                        return;
                    case 3:
                        this.questionLevel4(var2);
                        return;
                    default:
                        return;
                }
            case 4:
                int var6 = ThreadLocalRandom.current().nextInt(5);
                switch (var6) {
                    case 0:
                        this.questionLevel1(var2);
                        return;
                    case 1:
                        this.questionLevel2(var2);
                        return;
                    case 2:
                        this.questionLevel3(var2);
                        return;
                    case 3:
                        this.questionLevel4(var2);
                        return;
                    case 4:
                        this.questionLevel5(var2);
                        return;
                    default:
                        return;
                }
            case 5:
                int var7 = ThreadLocalRandom.current().nextInt(6);
                switch (var7) {
                    case 0:
                        this.questionLevel2(var2);
                        return;
                    case 1:
                        this.questionLevel3(var2);
                        return;
                    case 2:
                        this.questionLevel4(var2);
                        return;
                    case 3:
                        this.questionLevel5(var2);
                        return;
                    case 4:
                        this.questionLevel6(var2);
                        return;
                    case 5:
                        this.questionLevel1(var2);
                        return;
                    default:
                        return;
                }
            case 6:
                int var8 = ThreadLocalRandom.current().nextInt(7);
                switch (var8) {
                    case 0:
                        this.questionLevel3(var2);
                        break;
                    case 1:
                        this.questionLevel4(var2);
                        break;
                    case 2:
                        this.questionLevel5(var2);
                        break;
                    case 3:
                        this.questionLevel6(var2);
                        break;
                    case 4:
                        this.questionLevel7(var2);
                        break;
                    case 5:
                        this.questionLevel1(var2);
                        break;
                    case 6:
                        this.questionLevel2(var2);
                }
        }

    }

    private void questionLevel1(int var1) {
        this.diffLevel = 1;
        int var2 = ThreadLocalRandom.current().nextInt(2);
        this.baseTime = 1800;
        List var3;
        if (var2 == 0) {
            var3 = this.addQuestion();
            this.answer = (Integer)var3.get(0) + (Integer)var3.get(1);
            this.question = ((Integer)var3.get(0)).toString() + " + " + ((Integer)var3.get(1)).toString() + " = ?";
        } else {
            var3 = this.subQuestion(var1);
            this.answer = (Integer)var3.get(0) - (Integer)var3.get(1);
            this.question = ((Integer)var3.get(0)).toString() + " - " + ((Integer)var3.get(1)).toString() + " = ?";
        }

    }

    private void questionLevel2(int var1) {
        this.diffLevel = 2;
        int var2 = ThreadLocalRandom.current().nextInt(2);
        this.baseTime = 2100;
        List var3;
        if (var2 == 0) {
            var3 = this.addSubQuestion(var1);
            this.answer = (Integer)var3.get(0) + (Integer)var3.get(1) - (Integer)var3.get(2);
            this.question = ((Integer)var3.get(0)).toString() + " + " + ((Integer)var3.get(1)).toString() + " - " + var3.get(2) + " = ?";
        } else if (var2 == 1) {
            var3 = this.subSubQuestion(var1);
            this.answer = (Integer)var3.get(0) - (Integer)var3.get(1) - (Integer)var3.get(2);
            this.question = ((Integer)var3.get(0)).toString() + " - " + ((Integer)var3.get(1)).toString() + " - " + ((Integer)var3.get(2)).toString() + " = ?";
        } else {
            var3 = this.subAddQuestion(var1);
            this.answer = (Integer)var3.get(0) - (Integer)var3.get(1) + (Integer)var3.get(2);
            this.question = ((Integer)var3.get(0)).toString() + " - " + ((Integer)var3.get(1)).toString() + " + " + ((Integer)var3.get(2)).toString() + " = ?";
        }

    }

    private void questionLevel3(int var1) {
        this.diffLevel = 3;
        int var2 = ThreadLocalRandom.current().nextInt(4);
        this.baseTime = 2400;
        List var3;
        if (var2 == 0) {
            var3 = this.mulAddQuestion();
            this.answer = (Integer)var3.get(0) * (Integer)var3.get(1) + (Integer)var3.get(2);
            this.question = ((Integer)var3.get(0)).toString() + " x " + ((Integer)var3.get(1)).toString() + " + " + ((Integer)var3.get(2)).toString() + " = ?";
        } else if (var2 == 1) {
            var3 = this.addMulQuestion();
            this.answer = (Integer)var3.get(0) + (Integer)var3.get(1) * (Integer)var3.get(2);
            this.question = ((Integer)var3.get(0)).toString() + " + " + ((Integer)var3.get(1)).toString() + " x " + ((Integer)var3.get(2)).toString() + " = ?";
        } else if (var2 == 2) {
            var3 = this.mulSubQuestion(var1);
            this.answer = (Integer)var3.get(0) * (Integer)var3.get(1) - (Integer)var3.get(2);
            this.question = ((Integer)var3.get(0)).toString() + " x " + ((Integer)var3.get(1)).toString() + " - " + ((Integer)var3.get(2)).toString() + " = ?";
        } else if (var2 == 3) {
            var3 = this.subMulQuestion(var1);
            this.answer = (Integer)var3.get(0) - (Integer)var3.get(1) * (Integer)var3.get(2);
            this.question = ((Integer)var3.get(0)).toString() + " - " + ((Integer)var3.get(1)).toString() + " x " + ((Integer)var3.get(2)).toString() + " = ?";
        } else {
            var3 = this.mulQuestion();
            this.answer = (Integer)var3.get(0) * (Integer)var3.get(1);
            this.question = ((Integer)var3.get(0)).toString() + " x " + ((Integer)var3.get(1)).toString() + " = ?";
        }

    }

    private void questionLevel4(int var1) {
        this.diffLevel = 4;
        int var2 = ThreadLocalRandom.current().nextInt(6);
        this.baseTime = 2600;
        List var3;
        if (var2 == 0) {
            var3 = this.fracAddSub(var1);
            this.answer = (Integer)var3.get(0) / (Integer)var3.get(1) + (Integer)var3.get(2) - (Integer)var3.get(3);
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " + " + ((Integer)var3.get(2)).toString() + " - " + ((Integer)var3.get(3)).toString() + " = ?";
        } else if (var2 == 1) {
            var3 = this.fracSubAdd(var1);
            this.answer = (Integer)var3.get(0) / (Integer)var3.get(1) - (Integer)var3.get(2) + (Integer)var3.get(3);
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " - " + ((Integer)var3.get(2)).toString() + " + " + ((Integer)var3.get(3)).toString() + " = ?";
        } else if (var2 == 2) {
            var3 = this.fracSubSub(var1);
            this.answer = (Integer)var3.get(0) / (Integer)var3.get(1) - (Integer)var3.get(2) - (Integer)var3.get(3);
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " - " + ((Integer)var3.get(2)).toString() + " - " + ((Integer)var3.get(3)).toString() + " = ?";
        } else if (var2 == 3) {
            var3 = this.fracSub(var1);
            this.answer = (Integer)var3.get(0) / (Integer)var3.get(1) - (Integer)var3.get(2);
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " - " + ((Integer)var3.get(2)).toString() + " = ?";
        } else if (var2 == 4) {
            var3 = this.divQuestion(var1);
            this.answer = (Integer)var3.get(0) / (Integer)var3.get(1);
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " = ?";
        } else if (var2 == 5) {
            var3 = this.addFrac(var1);
            this.answer = (Integer)var3.get(0) + (Integer)var3.get(1) / (Integer)var3.get(2);
            this.question = ((Integer)var3.get(0)).toString() + " + " + var3.get(1) + "/" + var3.get(2) + " = ?";
        } else {
            var3 = this.subFrac(var1);
            this.answer = (Integer)var3.get(0) - (Integer)var3.get(1) / (Integer)var3.get(2);
            this.question = ((Integer)var3.get(0)).toString() + " - " + var3.get(1) + "/" + var3.get(2) + " = ?";
        }

    }

    private void questionLevel5(int var1) {
        this.diffLevel = 5;
        int var2 = ThreadLocalRandom.current().nextInt(2);
        this.baseTime = 3300;
        List var3;
        if (var2 == 0) {
            var3 = this.fracMulFracAdd(var1);
            this.answer = (Integer)var3.get(0) * (Integer)var3.get(2) / ((Integer)var3.get(1) * (Integer)var3.get(3)) + (Integer)var3.get(4);
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " x " + ((Integer)var3.get(2)).toString() + "/" + ((Integer)var3.get(3)).toString() + " + " + ((Integer)var3.get(4)).toString() + " = ?";
        } else if (var2 == 1) {
            var3 = this.fracMulFracSub(var1);
            this.answer = (Integer)var3.get(0) * (Integer)var3.get(2) / ((Integer)var3.get(1) * (Integer)var3.get(3)) - (Integer)var3.get(4);
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " x " + ((Integer)var3.get(2)).toString() + "/" + ((Integer)var3.get(3)).toString() + " - " + ((Integer)var3.get(4)).toString() + " = ?";
        } else {
            var3 = this.fracMul(var1);
            this.answer = (Integer)var3.get(0) * (Integer)var3.get(2) / ((Integer)var3.get(1) * (Integer)var3.get(3));
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " x " + ((Integer)var3.get(2)).toString() + "/" + ((Integer)var3.get(3)).toString() + " = ?";
        }

    }

    private void questionLevel6(int var1) {
        this.diffLevel = 6;
        int var2 = ThreadLocalRandom.current().nextInt(3);
        this.baseTime = 4300;
        List var3;
        if (var2 == 0) {
            var3 = this.fracAddSubFrac(var1);
            this.answer = (Integer)var3.get(0) / (Integer)var3.get(1) + (Integer)var3.get(2) - (Integer)var3.get(3) / (Integer)var3.get(4);
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " + " + ((Integer)var3.get(2)).toString() + " - " + ((Integer)var3.get(3)).toString() + "/" + ((Integer)var3.get(4)).toString() + " = ?";
        } else if (var2 == 1) {
            var3 = this.fracSubAddFrac(var1);
            this.answer = (Integer)var3.get(0) / (Integer)var3.get(1) - (Integer)var3.get(2) + (Integer)var3.get(3) / (Integer)var3.get(4);
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " - " + ((Integer)var3.get(2)).toString() + " + " + ((Integer)var3.get(3)).toString() + "/" + ((Integer)var3.get(4)).toString() + " = ?";
        } else if (var2 == 2) {
            var3 = this.mulFracMulFrac(var1);
            this.answer = (Integer)var3.get(0) * (Integer)var3.get(1) * (Integer)var3.get(3) / ((Integer)var3.get(2) * (Integer)var3.get(4));
            this.question = ((Integer)var3.get(0)).toString() + " x " + ((Integer)var3.get(1)).toString() + "/" + ((Integer)var3.get(2)).toString() + " x " + ((Integer)var3.get(3)).toString() + "/" + ((Integer)var3.get(4)).toString() + " = ?";
        } else {
            var3 = this.fracMulFracMul(var1);
            this.answer = (Integer)var3.get(0) * (Integer)var3.get(2) * (Integer)var3.get(4) / ((Integer)var3.get(1) * (Integer)var3.get(3) * (Integer)var3.get(5));
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " x " + ((Integer)var3.get(2)).toString() + "/" + ((Integer)var3.get(3)).toString() + " x " + ((Integer)var3.get(4)).toString() + "/" + ((Integer)var3.get(5)).toString() + " = ?";
        }

    }

    private void questionLevel7(int var1) {
        this.diffLevel = 7;
        int var2 = ThreadLocalRandom.current().nextInt(5);
        this.baseTime = 5800;
        List var3;
        if (var2 == 0) {
            var3 = this.fracMulFracSubFracMul(var1);
            this.answer = (Integer)var3.get(0) * (Integer)var3.get(2) / ((Integer)var3.get(1) * (Integer)var3.get(3)) - (Integer)var3.get(4) * (Integer)var3.get(6) / ((Integer)var3.get(5) * (Integer)var3.get(7));
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " x " + ((Integer)var3.get(2)).toString() + "/" + ((Integer)var3.get(3)).toString() + " - " + ((Integer)var3.get(4)).toString() + "/" + ((Integer)var3.get(5)).toString() + " x " + ((Integer)var3.get(6)).toString() + "/" + ((Integer)var3.get(7)).toString() + " = ?";
        } else if (var2 == 1) {
            var3 = this.fracMulFracAddFracMul(var1);
            this.answer = (Integer)var3.get(0) * (Integer)var3.get(2) / ((Integer)var3.get(1) * (Integer)var3.get(3)) + (Integer)var3.get(4) * (Integer)var3.get(6) / ((Integer)var3.get(5) * (Integer)var3.get(7));
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " x " + ((Integer)var3.get(2)).toString() + "/" + ((Integer)var3.get(3)).toString() + " + " + ((Integer)var3.get(4)).toString() + "/" + ((Integer)var3.get(5)).toString() + " x " + ((Integer)var3.get(6)).toString() + "/" + ((Integer)var3.get(7)).toString() + " = ?";
        } else if (var2 == 2) {
            var3 = this.fracSubFracMulFrac(var1);
            this.answer = (Integer)var3.get(0) / (Integer)var3.get(1) - (Integer)var3.get(2) * (Integer)var3.get(4) / ((Integer)var3.get(3) * (Integer)var3.get(5));
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " - " + ((Integer)var3.get(2)).toString() + "/" + ((Integer)var3.get(3)).toString() + " x " + ((Integer)var3.get(4)).toString() + "/" + ((Integer)var3.get(5)).toString() + " = ?";
        } else if (var2 == 3) {
            var3 = this.fracAddFracMulFrac(var1);
            this.answer = (Integer)var3.get(0) / (Integer)var3.get(1) + (Integer)var3.get(2) * (Integer)var3.get(4) / ((Integer)var3.get(3) * (Integer)var3.get(5));
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " + " + ((Integer)var3.get(2)).toString() + "/" + ((Integer)var3.get(3)).toString() + " x " + ((Integer)var3.get(4)).toString() + "/" + ((Integer)var3.get(5)).toString() + " = ?";
        } else if (var2 == 4) {
            var3 = this.fracMulFracMulFracAdd(var1);
            this.answer = (Integer)var3.get(0) * (Integer)var3.get(2) * (Integer)var3.get(4) / ((Integer)var3.get(1) * (Integer)var3.get(3) * (Integer)var3.get(5)) + (Integer)var3.get(6);
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " x " + ((Integer)var3.get(2)).toString() + "/" + ((Integer)var3.get(3)).toString() + " x " + ((Integer)var3.get(4)).toString() + "/" + ((Integer)var3.get(5)).toString() + " + " + ((Integer)var3.get(6)).toString() + " = ?";
        } else {
            var3 = this.fracMulFracMulFracSub(var1);
            this.answer = (Integer)var3.get(0) * (Integer)var3.get(2) * (Integer)var3.get(4) / ((Integer)var3.get(1) * (Integer)var3.get(3) * (Integer)var3.get(5)) - (Integer)var3.get(6);
            this.question = ((Integer)var3.get(0)).toString() + "/" + ((Integer)var3.get(1)).toString() + " x " + ((Integer)var3.get(2)).toString() + "/" + ((Integer)var3.get(3)).toString() + " x " + ((Integer)var3.get(4)).toString() + "/" + ((Integer)var3.get(5)).toString() + " - " + ((Integer)var3.get(6)).toString() + " = ?";
        }

    }

    public String getQuestion() {
        return this.question;
    }

    public int getAnswer() {
        return this.answer;
    }

    public int getBaseTime() {
        return this.baseTime;
    }

    private List<Integer> addQuestion() {
        boolean var1 = false;
        ArrayList var2 = new ArrayList();

        while(!var1) {
            int var3 = ThreadLocalRandom.current().nextInt(10);
            int var4 = ThreadLocalRandom.current().nextInt(10);
            if (var3 + var4 < 10) {
                var2.add(var3);
                var2.add(var4);
                var1 = true;
            }
        }

        Collections.shuffle(var2);
        return var2;
    }

    private List<Integer> subQuestion(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1);
            int var5 = ThreadLocalRandom.current().nextInt(var1);
            if (var4 - var5 < 10 && var4 - var5 >= 0) {
                var3.add(var4);
                var3.add(var5);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> subSubQuestion(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1);
            int var5 = ThreadLocalRandom.current().nextInt(var1);
            int var6 = ThreadLocalRandom.current().nextInt(var1);
            if (var4 - var5 - var6 < 10 && var4 - var5 - var6 >= 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> addSubQuestion(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1);
            int var5 = ThreadLocalRandom.current().nextInt(var1);
            int var6 = ThreadLocalRandom.current().nextInt(var1);
            if (var4 + var5 - var6 < 10 && var4 + var5 - var6 >= 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> subAddQuestion(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1);
            int var5 = ThreadLocalRandom.current().nextInt(var1);
            int var6 = ThreadLocalRandom.current().nextInt(var1);
            if (var4 - var5 + var6 < 10 && var4 - var5 + var6 >= 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> mulQuestion() {
        boolean var1 = false;
        ArrayList var2 = new ArrayList();

        while(!var1) {
            int var3 = ThreadLocalRandom.current().nextInt(9) + 1;
            int var4 = ThreadLocalRandom.current().nextInt(9) + 1;
            if (var3 * var4 < 10) {
                var2.add(var3);
                var2.add(var4);
                var1 = true;
            }
        }

        Collections.shuffle(var2);
        return var2;
    }

    private List<Integer> mulAddQuestion() {
        boolean var1 = false;
        ArrayList var2 = new ArrayList();

        while(!var1) {
            int var3 = ThreadLocalRandom.current().nextInt(9) + 1;
            int var4 = ThreadLocalRandom.current().nextInt(9) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(10);
            if (var3 * var4 + var5 < 10) {
                var2.add(var3);
                var2.add(var4);
                var2.add(var5);
                var1 = true;
            }
        }

        return var2;
    }

    private List<Integer> addMulQuestion() {
        boolean var1 = false;
        ArrayList var2 = new ArrayList();

        while(!var1) {
            int var3 = ThreadLocalRandom.current().nextInt(10);
            int var4 = ThreadLocalRandom.current().nextInt(9) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(9) + 1;
            if (var3 + var4 * var5 < 10) {
                var2.add(var3);
                var2.add(var4);
                var2.add(var5);
                var1 = true;
            }
        }

        return var2;
    }

    private List<Integer> mulSubQuestion(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1);
            if (var4 * var5 - var6 < 10 && var4 * var5 - var6 >= 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> subMulQuestion(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1);
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 - var5 * var6 < 10 && var4 - var5 * var6 >= 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> divQuestion(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 / var5 < 10 && var4 % var5 == 0) {
                var3.add(var4);
                var3.add(var5);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracAddSub(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1);
            int var7 = ThreadLocalRandom.current().nextInt(var1);
            if (var4 / var5 + var6 - var7 < 10 && var4 / var5 + var6 - var7 >= 0 && var4 % var5 == 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracSubAdd(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1);
            int var7 = ThreadLocalRandom.current().nextInt(var1);
            if (var4 / var5 - var6 + var7 < 10 && var4 / var5 - var6 + var7 >= 0 && var4 % var5 == 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracSub(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1);
            if (var4 / var5 - var6 < 10 && var4 / var5 - var6 >= 0 && var4 % var5 == 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracSubSub(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1);
            int var7 = ThreadLocalRandom.current().nextInt(var1);
            if (var4 / var5 - var6 - var7 < 10 && var4 / var5 - var6 - var7 >= 0 && var4 % var5 == 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> addFrac(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1);
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 + var5 / var6 < 10 && var5 % var6 == 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> subFrac(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1);
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 - var5 / var6 < 10 && var4 - var5 / var6 >= 0 && var5 % var6 == 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracMul(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 * var6 % (var5 * var7) == 0 && var4 * var6 / (var5 * var7) < 10) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracMulFracAdd(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var8 = ThreadLocalRandom.current().nextInt(10);
            if (var4 * var6 % (var5 * var7) == 0 && var4 * var6 / (var5 * var7) + var8 < 10) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var3.add(var8);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracMulFracSub(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var8 = ThreadLocalRandom.current().nextInt(var1);
            if (var4 * var6 % (var5 * var7) == 0 && var4 * var6 / (var5 * var7) - var8 < 10 && var4 * var6 / (var5 * var7) - var8 >= 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var3.add(var8);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracAddSubFrac(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1);
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var8 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 % var5 == 0 && var7 % var8 == 0 && var4 / var5 + var6 - var7 / var8 < 10 && var4 / var5 + var6 - var7 / var8 >= 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var3.add(var8);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracSubAddFrac(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1);
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var8 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 % var5 == 0 && var7 % var8 == 0 && var4 / var5 - var6 + var7 / var8 < 10 && var4 / var5 - var6 + var7 / var8 >= 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var3.add(var8);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> mulFracMulFrac(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var8 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 * var5 * var7 % (var6 * var8) == 0 && var4 * var5 * var7 / (var6 * var8) < 10) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var3.add(var8);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracMulFracMul(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1);
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1);
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var8 = ThreadLocalRandom.current().nextInt(var1);
            int var9 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 * var6 * var8 % (var5 * var7 * var9) == 0 && var4 * var6 * var8 / (var5 * var7 * var9) < 10) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var3.add(var8);
                var3.add(var9);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracMulFracSubFracMul(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var8 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var9 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var10 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var11 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 * var6 % (var5 * var7) == 0 && var8 * var10 % (var9 * var11) == 0 && var4 * var6 / (var5 * var7) - var8 * var10 / (var9 * var11) < 10 && var4 * var6 / (var5 * var7) - var8 * var10 / (var9 * var11) >= 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var3.add(var8);
                var3.add(var9);
                var3.add(var10);
                var3.add(var11);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracMulFracAddFracMul(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var8 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var9 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var10 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var11 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 * var6 % (var5 * var7) == 0 && var8 * var10 % (var9 * var11) == 0 && var4 * var6 / (var5 * var7) + var8 * var10 / (var9 * var11) < 10) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var3.add(var8);
                var3.add(var9);
                var3.add(var10);
                var3.add(var11);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracSubFracMulFrac(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1);
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var8 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var9 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 % var5 == 0 && var6 * var8 % (var7 * var9) == 0 && var4 / var5 - var6 * var8 / (var7 * var9) < 10 && var4 / var5 - var6 * var8 / (var7 * var9) >= 0) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var3.add(var8);
                var3.add(var9);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracAddFracMulFrac(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1);
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var8 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var9 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            if (var4 % var5 == 0 && var6 * var8 % (var7 * var9) == 0 && var4 / var5 + var6 * var8 / (var7 * var9) < 10) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var3.add(var8);
                var3.add(var9);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracMulFracMulFracAdd(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var8 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var9 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var10 = ThreadLocalRandom.current().nextInt(10);
            if (var4 * var6 * var8 % (var5 * var7 * var9) == 0 && var4 * var6 * var8 / (var5 * var7 * var9) + var10 < 10) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var3.add(var8);
                var3.add(var9);
                var3.add(var10);
                var2 = true;
            }
        }

        return var3;
    }

    private List<Integer> fracMulFracMulFracSub(int var1) {
        boolean var2 = false;
        ArrayList var3 = new ArrayList();

        while(!var2) {
            int var4 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var5 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var6 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var7 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var8 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var9 = ThreadLocalRandom.current().nextInt(var1 - 1) + 1;
            int var10 = ThreadLocalRandom.current().nextInt(var1);
            if (var4 * var6 * var8 % (var5 * var7 * var9) == 0 && var4 * var6 * var8 / (var5 * var7 * var9) - var10 < 10) {
                var3.add(var4);
                var3.add(var5);
                var3.add(var6);
                var3.add(var7);
                var3.add(var8);
                var3.add(var9);
                var3.add(var10);
                var2 = true;
            }
        }

        return var3;
    }

    public Integer getDiffLevel() {
        return this.diffLevel;
    }
}
