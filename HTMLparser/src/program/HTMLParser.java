package program;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class HTMLParser {
    //Метод загружает HTMl страницы, адрес которой передается в url и помещает его в файл
    //в папку с проектом
    public static void DownloadHtmlFrom(String url) throws java.io.IOException {
        Document html = Jsoup.connect(url)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();
        String strHTML = html.toString();
        FileWriter writer = new FileWriter("Kinopoisk.html", false);
        writer.write(strHTML);
    }

    //Метод принимает путь к файлу с HTML страницы и лист в который необходимо вычленить элементы
    //HTML кода: текст не относящийся к коду разметки, находящийся в классе по которому происходит сортировка
    public static void ThrowList(String path, ArrayList<String> throwableList) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String strHTML = null;
        while (br.read() != -1) {
            strHTML += br.readLine();
        }
        Document doc = Jsoup.parse(strHTML);

        Elements listOfItems = doc.getElementsByClass("selection-film-item-meta__name");
        for (Element element : listOfItems) {
            System.out.println(element.text()); // проверка правлиьности сортировки
            throwableList.add(element.text());
        }
    }

}
