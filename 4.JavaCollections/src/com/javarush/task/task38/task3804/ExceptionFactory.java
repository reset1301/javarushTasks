package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable newException(Enum e) {
        if (e != null) {
            String message = e.toString().replace("_", " ");
            message = message.charAt(0) + message.substring(1).toLowerCase();

            if (e instanceof ExceptionApplicationMessage)
                return new Exception(message);
            if (e instanceof ExceptionDBMessage)
                return new RuntimeException(message);
            if (e instanceof ExceptionUserMessage)
                return new Error(message);
        }
        return new IllegalArgumentException();
//        if (e == null) return new IllegalArgumentException(e.toString().replace("_", " ").charAt(0)+
//                e.toString().replace("_", " ").substring(1).toLowerCase());
//        String s = e.toString().replace("_", " ");
//        s = s.charAt(0) + s.substring(1).toLowerCase();
//        if (e instanceof ExceptionApplicationMessage) return new Exception(s);
//        if (e instanceof ExceptionDBMessage) return new RuntimeException(s);
//        if (e instanceof ExceptionUserMessage) return new Error(s);
//        return new IllegalArgumentException(s);
    }
}
