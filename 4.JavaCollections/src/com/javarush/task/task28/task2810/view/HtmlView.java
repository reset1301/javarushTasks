package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    //    private final String filePath =
//            "./" + (this.getClass().getPackage() +
//                    "/").split(" ")[1].replace("\\.", "/");
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
//        System.out.println("Total vacancies: " + vacancies.size());
//        System.out.println(vacancies.size());
        String updatedFileContent = getUpdatedFileContent(vacancies);
        updateFile(updatedFileContent);
//        StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n" +
//                "<html lang=\"ru\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"utf-8\">\n" +
//                "    <title>Вакансии</title>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "<table>\n" +
//                "    <tr>\n" +
//                "        <th>Title</th>\n" +
//                "        <th>City</th>\n" +
//                "        <th>Company Name</th>\n" +
//                "        <th>Salary</th>\n" +
//                "    </tr>\n");
//        for (Vacancy v : vacancies) {
//            sb.append("<tr class=\"vacancy\">\n" +
//                    "        <td class=\"title\"><a href=\"" + v.getSiteName() + "\">" + v.getTitle() + "</a></td>\n" +
//                    "        <td class=\"city\">" + v.getCity() + "</td>\n" +
//                    "        <td class=\"companyName\">" + v.getCompanyName() + "</td>\n" +
//                    "        <td class=\"salary\">" + v.getSalary() + "</td>\n" +
//                    "    </tr>");
//        }
//        sb.append("</table>\n" +
//                "</body>\n" +
//                "</html>");
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath + "vacancies.html"));
//            bw.write(sb.toString());
//            bw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        Document document = null;
        try {
            document = getDocument();

            Element template = document.getElementsByClass("template").first();
            Element copyTemplate = template.clone();
            copyTemplate.removeAttr("style");
            copyTemplate.removeClass("template");
            Elements deleteElems = document.select("tr[class~=^vacancy$]");
            for (Element e : deleteElems) {
                e.remove();
            }
            for (Vacancy v : vacancies) {
                Element copyTmpl = copyTemplate.clone();
                Element city = copyTmpl.select("td[class=\"city\"]").first();
                city.html(v.getCity());
                Element companyName = copyTmpl.select("td[class=\"companyName\"]").first();
                companyName.html(v.getCompanyName());
                Element salary = copyTmpl.select("td[class=\"salary\"]").first();
                salary.html(v.getSalary());
                Element link = copyTmpl.select("a[href]").first();
                link.html(v.getTitle());
                link.attr("href", v.getUrl());
                String outerHtml = copyTmpl.outerHtml();
                template.before(outerHtml);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return document.html();
    }

    private void updateFile(String contentString) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(contentString);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8", filePath);
    }

}
