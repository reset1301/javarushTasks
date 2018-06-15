package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager statisticAdvertisementManager = new StatisticAdvertisementManager();
    private static AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();
    private static List<Advertisement> activeAdvertisements = new ArrayList<>();
    private static List<Advertisement> unactivAdvertisements = new ArrayList<>();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        return statisticAdvertisementManager;
    }

    public static void activeAdvertisements() {
        for (Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement.getHits() > 0)
                activeAdvertisements.add(advertisement);
            else unactivAdvertisements.add(advertisement);
        }
    }

    public static List<Advertisement> getActiveAdvertisements() {
        StatisticAdvertisementManager.activeAdvertisements();
        return activeAdvertisements;
    }

    public static List<Advertisement> getUnactivAdvertisements() {
        StatisticAdvertisementManager.activeAdvertisements();
        return unactivAdvertisements;
    }
}
