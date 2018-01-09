package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
        private ATableInterface a;

        public TableInterfaceWrapper(ATableInterface a) {
            this.a=a;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            a.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return a.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            a.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}