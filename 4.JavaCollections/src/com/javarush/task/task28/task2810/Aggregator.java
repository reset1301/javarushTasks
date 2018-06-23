package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.MoikrugStrategy;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.view.HtmlView;

import java.io.IOException;

public class Aggregator {
    public static void main(String[] args) throws IOException {
        Provider provider = new Provider(new HHStrategy());
//        Controller controller = new Controller(provider);
//        controller.scan();

//        HtmlView view = new HtmlView();
//        Model model = new Model(view, provider);
//        Controller controller = new Controller(model);
//        view.setController(controller);
//        view.userCitySelectEmulationMethod();

        HtmlView htmlView = new HtmlView();
        Provider hh = new Provider(new HHStrategy());
        Provider mk = new Provider(new MoikrugStrategy());
        Model model = new Model(htmlView, hh, mk);
        Controller controller = new Controller(model);
        htmlView.setController(controller);
        htmlView.userCitySelectEmulationMethod();
    }
}
