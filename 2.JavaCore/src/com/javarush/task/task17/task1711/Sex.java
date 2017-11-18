package com.javarush.task.task17.task1711;

public enum Sex {
    MALE("м"),
    FEMALE("ж");

    private String sexString;

    private Sex(String sexString) {
        this.sexString = sexString;
    }

    public String getSexString() {
        return sexString;
    }

    /*public Sex getEnum(String sexString) {
        Sex sex = null;
        switch (sexString) {
            case "м": sex=Sex.MALE;
            case "ж": sex=Sex.FEMALE;
        }
        return sex;
    }*/
}