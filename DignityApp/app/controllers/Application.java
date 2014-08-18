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
        // return ok(index.render("Your new application is ready."));
        // return ok("Hello World");

        Document doc = Jsoup.connect("http://en.wikipedia.org").get();
        String html = doc.html();

        // via http://stackoverflow.com/questions/4829627/search-strings-in-a-multi-line-string-with-regex-and-java
        Pattern p = Pattern.compile("var tblDataRows= (.*)", Pattern.MULTILINE|Pattern.DOTALL);
        String result = "nothing";
        Matcher regexMatcher = p.matcher(html);
        while (regexMatcher.find() ) {
            result += regexMatcher.group(1);
        }

        return ok(result);
    }

}
