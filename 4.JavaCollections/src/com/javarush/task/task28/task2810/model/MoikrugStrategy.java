package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    //    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    private static final String URL_FORMAT_TEST = "http://javarush.ru/testdata/big28data2.html";

    @Override
    public List<Vacancy> getVacancies(String searchString) throws IOException {
        List<Vacancy> vacancyList = new ArrayList<>();
        Document document;
        Elements vacancyElements = null;
        int i = 0;
        while (true) {
            try {
                document = getDocument(searchString, i);
                vacancyElements = document.select("div[id^=\"job_\"]");
            } catch (IOException ignore) {
            }
            if (vacancyElements.isEmpty()) {
                break;
            }
            for (Element vacancy : vacancyElements) {
                vacancyList.add(parseElementToVacancy(vacancy));
            }
            i++;
        }
        return vacancyList;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                .timeout(5000)
                .referrer("http://google.ru")
                .get();
//        return Jsoup
//                .connect(String.format(URL_FORMAT, searchString, page))
//                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36")
//                .referrer("https://moikrug.ru")
//                .get();
    }

    private Vacancy parseElementToVacancy(Element element) {
        Vacancy result = new Vacancy();
        String title = element.select("[class=\"title\"]").attr("title");
        result.setTitle(title);
        String salary = element.select("[class=\"salary\"]").text();
        if (salary != null) {
            result.setSalary(salary);
        } else result.setSalary("");

        String city = element.select("[class=\"location\"]").text();
        if (city != null) {
            result.setCity(city);
        }

        String companyName = element.select("[class=\"company_name\"]").text();
        if (companyName != null) {
            result.setCompanyName(companyName);
        }

        String siteName = "https://moikrug.ru";
        result.setSiteName(siteName);

        String url = siteName + element.select("[class=\"title\"]").select("a").attr("href");
        result.setUrl(url);

        return result;
    }
}
