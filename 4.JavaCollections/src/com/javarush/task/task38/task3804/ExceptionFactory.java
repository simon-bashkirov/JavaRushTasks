package com.javarush.task.task38.task3804;

public class ExceptionFactory {

    public static Throwable getException(Enum exceptionMessage) {
        if (exceptionMessage == null) {
            return new IllegalArgumentException();
        }

        String upperCaseMessage = exceptionMessage.toString().replace("_", " ");
        String capitalCaseMessage = upperCaseMessage.substring(0, 1).toUpperCase() + upperCaseMessage.substring(1).toLowerCase();
        if (exceptionMessage.getClass() == ApplicationExceptionMessage.class) {
            return new Exception(capitalCaseMessage);
        } else if (exceptionMessage.getClass() == DatabaseExceptionMessage.class) {
            return new RuntimeException(capitalCaseMessage);
        } else if (exceptionMessage.getClass() == UserExceptionMessage.class) {
            return new Error(capitalCaseMessage);
        }
        return new IllegalArgumentException();
    }
}
