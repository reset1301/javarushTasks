package com.javarush.task.task14.task1419;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

import javax.security.cert.CertificateException;
import javax.xml.ws.http.HTTPException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.BatchUpdateException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.FormatterClosedException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.jar.JarException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
        exceptions.add(new FormatterClosedException());
        exceptions.add(new HTTPException(1));
        exceptions.add(new BatchUpdateException());
        exceptions.add(new CertificateException());
        exceptions.add(new DateTimeException("asd"));
        exceptions.add(new EOFException());
        exceptions.add(new JarException());
    }
}
