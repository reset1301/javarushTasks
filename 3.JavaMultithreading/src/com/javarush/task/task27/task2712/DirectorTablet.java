package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        TreeMap<Date, Long> advertisementRevenueAgregatedByDay = StatisticManager.getInstance().getAdvertProfitStatistic();
        if (advertisementRevenueAgregatedByDay.isEmpty()) return;
        NavigableSet<Date> datesRow = advertisementRevenueAgregatedByDay.descendingKeySet();
        Long totalAmmout = Long.valueOf(0);
        for (Date date : datesRow) {
            Long dayAmount = advertisementRevenueAgregatedByDay.get(date);
            totalAmmout += dayAmount;
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f",
                    new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(date),
                    0.01d * dayAmount)
            );
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", 0.01d * totalAmmout));
    }

    public void printCookWorkloading() {
        TreeMap<Date, HashMap<String, Integer>> cookWorkloadingAgregatedByDay = StatisticManager.getInstance().getCooksEmployment();
        if (cookWorkloadingAgregatedByDay.isEmpty()) return;
        NavigableSet<Date> datesRow = cookWorkloadingAgregatedByDay.descendingKeySet();
        for (Date date : datesRow) {
            ConsoleHelper.writeMessage(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(date));
            List<Map.Entry<String, Integer>> cooksNameWorkDuration = new ArrayList(cookWorkloadingAgregatedByDay.get(date).entrySet());
            Collections.sort(cooksNameWorkDuration, new Comparator<Map.Entry<String, Integer>>() {

                @Override
                public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                    return b.getValue() - a.getValue();
                }
            });

            for (Map.Entry<String, Integer> cookNameWorkDuration : cooksNameWorkDuration) {
                ConsoleHelper.writeMessage(String.format("%s - %d min",
                        cookNameWorkDuration.getKey(),
                        (int) Math.ceil(cookNameWorkDuration.getValue() / 60.0))
                );
            }

        }
    }

    public void printActiveVideoSet() {
        List<Advertisement> advertisements = StatisticAdvertisementManager.getActiveAdvertisements();
        Map<String, Advertisement> advertisementMap = new HashMap<>();
        for (Advertisement ad:advertisements
                ) {
            advertisementMap.put(ad.getName().toLowerCase(), ad);
        }
        Map<String, Advertisement> treeMap = new TreeMap<>(advertisementMap);
        for (Map.Entry<String,Advertisement> ad: treeMap.entrySet()) {
            ConsoleHelper.writeMessage(ad.getValue().getName()+" - "+ad.getValue().getHits());
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> advertisements = StatisticAdvertisementManager.getUnactivAdvertisements();
        Map<String, Advertisement> advertisementMap = new HashMap<>();
        for (Advertisement ad:advertisements
                ) {
            advertisementMap.put(ad.getName().toLowerCase(), ad);
        }
        Map<String, Advertisement> treeMap = new TreeMap<>(advertisementMap);
        for (Map.Entry<String,Advertisement> ad: treeMap.entrySet()) {
            ConsoleHelper.writeMessage(ad.getValue().getName());
        }
    }
}
