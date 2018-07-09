package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        try {
            if (denominations.containsKey(denomination))
                denominations.put(denomination, denominations.get(denomination) + count);
            else
                denominations.put(denomination, count);
        } catch (NullPointerException ignored) {
        }
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> m : denominations.entrySet()) totalAmount += m.getKey() * m.getValue();

        return totalAmount;
    }

    public boolean hasMoney() {
        return getTotalAmount() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> tmpDenominations = new HashMap<>(denominations);
        Map<Integer, Integer> result = new HashMap<>();
        ArrayList<Integer> nominals = new ArrayList<>(tmpDenominations.keySet());
        Collections.sort(nominals);
        Collections.reverse(nominals);
        while (expectedAmount > 0) {
            for (Integer nominal : nominals) {
                if (expectedAmount >= nominal) {
                    int n = expectedAmount / nominal;
                    if (tmpDenominations.get(nominal) < n) {
                        n = tmpDenominations.get(nominal);
                        expectedAmount -= n * nominal;
                    } else
                        expectedAmount %= nominal;
                    result.put(nominal, n);
                }
            }
            if (expectedAmount > 0) throw new NotEnoughMoneyException();
            else {
                for (Map.Entry<Integer, Integer> m : result.entrySet()) {
                    tmpDenominations.put(m.getKey(), tmpDenominations.get(m.getKey()) - m.getValue());
                }
                denominations = tmpDenominations;
            }
        }

        return result;
    }
}
