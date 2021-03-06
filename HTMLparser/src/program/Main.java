package program;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws java.io.IOException {

        File file = new File("E:\\Programming\\GitHub\\Java_Projects\\HTMLparser\\Kinopoisk.html");
        if (!(file.exists())) {
            HTMLParser.DownloadHtmlFrom("https://www.kinopoisk.ru/lists/top250/");
        }

        ArrayList<String> listOfFilms = new ArrayList<String>(10);

        HTMLParser.ThrowList(file.getPath(), listOfFilms);
    }

}
