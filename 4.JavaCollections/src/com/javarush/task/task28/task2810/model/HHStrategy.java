package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%s";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36";
    private static final int timeout = 5 * 1000;
    private static final String referrer = "no-referrer-when-downgrade";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();

        int pageNumber = 0;
        while (true) {
            Document document = null;
            try {
                document = getDocument(searchString, pageNumber++);
            } catch (IOException ignored) {}

            Elements elements = document.select("[data-qa='vacancy-serp__vacancy']");

            if (elements.isEmpty()) {
                break;
            }

            for (Element element : elements) {
                Vacancy vacancy = new Vacancy();
                Element titleElement = element.select("[data-qa='vacancy-serp__vacancy-title']").first();
                vacancy.setTitle(titleElement.text());
                vacancy.setCity(element.select("[data-qa='vacancy-serp__vacancy-address']").first().text());
                vacancy.setCompanyName(element.select("[data-qa='vacancy-serp__vacancy-employer']").first().text());
                vacancy.setSiteName("hh.ua");
                vacancy.setUrl(titleElement.attr("href"));
                vacancy.setSalary(
                        Optional.ofNullable(element.select("[data-qa='vacancy-serp__vacancy-compensation']").first())
                                .map(Element::text)
                                .orElse("")
                );
                vacancies.add(vacancy);
            }

        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);

        Document document = null;

        try {
            document = Jsoup.connect(url)
                    .userAgent(userAgent)
                    .referrer(referrer)
                    .timeout(timeout).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        File file = new File("D:\\dev\\JavaRushTasks\\hhua.html");
//        Document document = Jsoup.parse(file, "UTF-8");

        return document;
    }
}
