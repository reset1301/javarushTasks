package com.javarush.task.task25.task2503;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        Column[] b=values();
        int count=0;
        for (int i:realOrder
             ) {
            if (i>=0)
                count++;
        }
        Column[] a = new Column[count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < realOrder.length; j++) {
                if (i==realOrder[j])
                    a[i] = b[j];
            }
        }
        Collections.addAll(result, a);
        return result;
    }

    @Override
    public String getColumnName() {
//        return toString();
//        return Column.valueOf(columnName).toString();
        return this.columnName;

//        return null;
    }

    @Override
    public boolean isShown() {
//        Column[] a = Column.values();
        if (realOrder[ordinal()] == -1)
            return false;
        return true;
    }

    @Override
    public void hide() {
        int x = realOrder[ordinal()];
        realOrder[ordinal()] = -1;
        for (int i = 0; i < realOrder.length; i++) {
            if (realOrder[i]>x)
                realOrder[i]--;
        }
    }
}
