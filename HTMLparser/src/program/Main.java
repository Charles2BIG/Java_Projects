package program;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws java.io.IOException {

//        HTMLParser.DownloadHtmlFrom("https://www.kinopoisk.ru/lists/top250/");

        ArrayList<String> listOfFilms = new ArrayList<String>(10);

        HTMLParser.ThrowList("E:\\Programming\\GitHub\\Java_Projects\\HTMLparser\\Kinopoisk.html", listOfFilms);
    }

}
