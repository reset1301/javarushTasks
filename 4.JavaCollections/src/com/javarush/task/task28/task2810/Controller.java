package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Controller {
//    private Provider[] providers;
    private Model model;

    public Controller(Model model) {
        if (model==null)
            throw new IllegalArgumentException();
        this.model = model;
    }
    public void onCitySelect(String cityName) {
        model.selectCity(cityName);
    }
    //    public Controller(Provider... providers) {
//        if (providers == null || providers.length == 0)
//            throw new IllegalArgumentException();
//        this.providers = providers;
//    }

//    @Override
//    public String toString() {
//        return "Controller{" +
//                "providers=" + Arrays.toString(providers) +
//                '}';
//    }

//    public void scan() throws IOException {
//        List<Vacancy> vacancies = new ArrayList<>();
//        for (Provider p : providers) {
//            vacancies.addAll(p.getJavaVacancies(null) == null ? Collections.EMPTY_LIST : p.getJavaVacancies(null));
//        }
//        System.out.println(vacancies.size());
//    }
}
