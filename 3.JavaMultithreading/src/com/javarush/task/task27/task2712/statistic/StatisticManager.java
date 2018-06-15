package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager statisticManager = new StatisticManager();
    private StatisticStorage storage = new StatisticStorage();
//    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return statisticManager;
    }

    public void register(EventDataRow data) {
        storage.put(data);
    }

//    public void register(Cook cook) {
//        cooks.add(cook);
//    }

    private static final int[] TIME_FIELDS =
            {
                    Calendar.HOUR_OF_DAY,
                    Calendar.HOUR,
                    Calendar.AM_PM,
                    Calendar.MINUTE,
                    Calendar.SECOND,
                    Calendar.MILLISECOND
            };


    public TreeMap<Date, Long> getAdvertProfitStatistic() {
        TreeMap<Date, Long> result = new TreeMap<>();
        for (EventDataRow eventDataRow : storage.getEvents(EventType.SELECTED_VIDEOS)) {
            VideoSelectedEventDataRow vEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            GregorianCalendar gDate = new GregorianCalendar();
            gDate.setTime(vEventDataRow.getDate());
            for (int i : TIME_FIELDS)
                gDate.clear(i);

            Date date = gDate.getTime();
            Long dayRevenue = result.get(date);
            if (dayRevenue == null) dayRevenue = Long.valueOf(0);
            result.put(date, dayRevenue + vEventDataRow.getAmount());
        }

        return result;
    }

    public TreeMap<Date, HashMap<String, Integer>> getCooksEmployment() {
        TreeMap<Date, HashMap<String, Integer>> result = new TreeMap<>();

        for (EventDataRow eventDataRow : storage.getEvents(EventType.COOKED_ORDER)) {
            CookedOrderEventDataRow cookDataRow = (CookedOrderEventDataRow) eventDataRow;
            GregorianCalendar gDate = new GregorianCalendar();
            gDate.setTime(cookDataRow.getDate());

            for (int i : TIME_FIELDS)
                gDate.clear(i);
            Date date = gDate.getTime();
            HashMap<String, Integer> cooksNameWorkDuration = result.get(date);
            if (cooksNameWorkDuration == null) {
                cooksNameWorkDuration = new HashMap<>();
                result.put(date, cooksNameWorkDuration);
            }
            String cookName = cookDataRow.getCookName();
            Integer cookWorkDuration = cooksNameWorkDuration.get(cookName);

            if (cookWorkDuration == null) cookWorkDuration = Integer.valueOf(0);
            cooksNameWorkDuration.put(cookName, cookWorkDuration + cookDataRow.getTime());
        }
        return result;
    }

//    public Set<Cook> getCooks() {
//        return cooks;
//    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        private StatisticStorage() {
//            storage = new HashMap<>();
            EventType[] types = EventType.values();
            for (EventType t : types) {
                storage.put(t, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
            List<EventDataRow> dataRows = new ArrayList<>();
            dataRows = storage.get(data.getType());
            dataRows.add(data);
            storage.put(data.getType(), dataRows);
        }

        private List<EventDataRow> getEvents(EventType eventType) {
            return storage.get(eventType);
        }
    }
}
