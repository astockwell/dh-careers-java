package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.regex.*;

public class Application extends Controller {

    public static Result index() throws IOException {
        Document doc = Jsoup.connect("http://dignityhealth.org/careers/jobs/index.php?do=search&category=Information+Technology+%28IT%29&location=").get();
        String html = doc.html();

        Pattern pattern = Pattern.compile("(var tblDataRows.*)");
        String resultString = "initial";
        Matcher regexMatcher = pattern.matcher( html );
        while (regexMatcher.find()) {
            resultString = regexMatcher.group(1);
        }

        // return ok(resultString);
        return ok(index.render(resultString));
    }

}
