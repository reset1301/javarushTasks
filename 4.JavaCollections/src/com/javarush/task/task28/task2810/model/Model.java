package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {
        if (view == null || providers == null || providers.length == 0)
            throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city) {
        List<Vacancy> list = new ArrayList<>();
        for (Provider p : providers) {
            try {
                list.addAll(p.getJavaVacancies(city) == null ? Collections.EMPTY_LIST : p.getJavaVacancies(city));
            } catch (IOException ignored) {
            }
        }
        view.update(list);
    }
}
