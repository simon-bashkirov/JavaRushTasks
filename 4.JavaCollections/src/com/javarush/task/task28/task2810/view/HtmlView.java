package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";

    public static void main(String[] args) throws Exception {
        HtmlView htmlView = new HtmlView();
        htmlView.getUpdatedFileContent(new ArrayList<>());
//        Document document = htmlView.getDocument();
//        System.out.println(htmlView.filePath);
    }

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            String updatedFileContent = getUpdatedFileContent(vacancies);
            updateFile(updatedFileContent);
        } catch (Exception e) {
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

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        Document document = null;
        try {
            document = getDocument();
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }

        document.select("[class=vacancy]").remove();
//        Element element = document.select("[class=vacancy template]").first();
        Element element = document.getElementsByClass("template").first();
        Element copyTemplate = element.clone();
        Attributes attributes = copyTemplate.attributes();
        copyTemplate.removeAttr("style");
        copyTemplate.removeClass("template");

        for (Vacancy vacancy : vacancies) {
            Element copy = copyTemplate.clone();
            copy.select("a").first()
                    .attr("href", vacancy.getUrl())
                    .text(vacancy.getTitle());
            copy.select("[class=city]").first().text(vacancy.getCity());
            copy.select("[class=companyName]").first().text(vacancy.getCompanyName());
            copy.select("[class=salary]").first().text(vacancy.getSalary());
            element.before(copy);
        }

        return document.html();
    }

    private void updateFile(String fileContent) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(fileContent);
        }
    }

    protected Document getDocument() throws IOException {
        Document document = Jsoup.parse(new File(filePath), "UTF-8");
        return document;
    }

}
