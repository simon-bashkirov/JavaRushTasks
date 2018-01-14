package com.javarush.task.task20.task2025;

public class Digit {
    private int digit;
    private Long digitPowerM;

    public Digit() {
    }

    public Digit(int digit, Long digitPowerM) {
        this.digit = digit;
        this.digitPowerM = digitPowerM;
    }

    public int getDigit() {
        return digit;
    }

    private void setDigit(int digit) {
        this.digit = digit;
    }

    public Long getDigitPowerM() {
        return digitPowerM;
    }

    private void setDigitPowerM(Long digitPowerM) {
        this.digitPowerM = digitPowerM;
    }

    public void increment(int powerM) {
        digit++;
        digitPowerM = (long)Math.pow(digit,powerM);
    }

    public void setToZero() {
        digit = 0;
        digitPowerM = 0L;
    }
}
