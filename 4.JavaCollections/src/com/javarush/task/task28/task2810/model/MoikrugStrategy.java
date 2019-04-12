package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%s&q=java+%s";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36";
    private static final int timeout = 5 * 1000;
    private static final String referrer = "no-referrer-when-downgrade";
    public static final String SITE_NAME = "https://moikrug.ru";

    public static void main(String[] args) {
        MoikrugStrategy strategy = new MoikrugStrategy();
        strategy.getVacancies("");

    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();

        int pageNumber = 0;

        while (true) {
            Document document = null;
            try {
                document = getDocument(searchString, pageNumber++);
            } catch (IOException ignored) {}

            Elements elements = document.select("[class=job]");

            if (elements.isEmpty()) {
                break;
            }

            for (Element element : elements) {
                Vacancy vacancy = new Vacancy();
                Element titleElement = element.select("[class=title]").first();
                vacancy.setTitle(titleElement.attr("title"));
                vacancy.setCity(
                        Optional.ofNullable(element.select("[class=location]").first())
                                .map(Element::text)
                                .orElse("")
                );
                vacancy.setCompanyName(element.select("[class=company_name]").first().getElementsByAttribute("href").first().text());
                vacancy.setSiteName(SITE_NAME);
                vacancy.setUrl(SITE_NAME + titleElement.getElementsByAttribute("href").first().attr("href"));
                vacancy.setSalary(
                        Optional.ofNullable(element.select("[class=count]").first())
                                .map(Element::text)
                                .orElse("")
                );
                vacancies.add(vacancy);
            }

        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, page, searchString);

        /*Document document = null;

        try {
            document = Jsoup.connect(url)
                    .userAgent(userAgent)
                    .referrer(referrer)
                    .timeout(timeout).get();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        File file = new File("D:\\dev\\JavaRushTasks\\moikrugru.html");
        Document document = Jsoup.parse(file, "UTF-8");

        return document;
    }
}
