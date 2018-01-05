package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
UnsupportedFileName Git
*/

public class TxtInputStream extends FileInputStream {
    TxtInputStream txtInputStream;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        Pattern p = Pattern.compile("txt$");
        Matcher m = p.matcher(fileName);
//        System.out.println(m.find());
        if (m.find()){
            
        }
        else {
            super.close();
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
//        TxtInputStream t = new TxtInputStream("c:/111/output.txt");
    }
}

