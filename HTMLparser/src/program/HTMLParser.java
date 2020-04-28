package program;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class HTMLParser {

    public static void DownloadHtmlFrom(String url) throws java.io.IOException {
        Document html = Jsoup.connect(url)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();
        String strHTML = html.toString();
        FileWriter writer = new FileWriter("Kinopoisk.html", false);
        writer.write(strHTML);
    }

    public static void ThrowList(String path, ArrayList<String> throwableList) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String strHTML = null;
        while (br.read() != -1) {
            strHTML += br.readLine();
            //System.out.println(br.readLine());
        }
        Document doc = Jsoup.parse(strHTML);
        //System.out.println(doc);
        Elements listOfItems = doc.getElementsByClass("selection-film-item-meta__name");
        Pattern pattern = Pattern.compile("[А-Я[а-я]]+");
        for (Element element : listOfItems) {
            System.out.println(element);
            throwableList.add(element.toString());
        }
    }

}
