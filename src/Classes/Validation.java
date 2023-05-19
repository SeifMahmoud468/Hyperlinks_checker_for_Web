package Classes;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Validation {

    public static int sitesNumber = 0, validSites = 0, invalidSites = 0;
    public static ExecutorService executor;

    public Validation(int i) {
        executor = Executors.newFixedThreadPool(i);
    }

    public void destroy() {
        sitesNumber = validSites = invalidSites = 0;
    }

    public void URLvalidation(String link, int currentDepth, int inputDepth) throws IOException, InterruptedException {
        threadValidation t1;
        if (siteValidation(link)) {
            System.out.println("Valid: " + link);
            validSites++;
            if (currentDepth == inputDepth + 1) {
                return;
            }
            Document doc = Jsoup.connect(link).get();
            Elements links = doc.select("a[href]");
            URL u = new URL(link);
            sitesNumber = sitesNumber + links.size();
            for (int i = 0; i < links.size(); i++) {
                String x = links.get(i).attr("href");
                String baseLINK = u.getProtocol() + "://" + u.getHost();
                if (!x.startsWith("http")) {
                    x = baseLINK + x;
                }
                t1 = new threadValidation(x, currentDepth + 1, inputDepth, links.get(i).text());
                executor.execute(t1);
            }
        } else {
            invalidSites++;
            System.err.println("Invalid: " + link);
        }
    }

    public boolean siteValidation(String link) {
        boolean valid;
        try {
            Document doc = Jsoup.connect(link).get();
            valid = true;
        } catch (IOException ex) {
            valid = false;
        } catch (Exception e) {
            valid = false;
        }
        return valid;
    }

    public long TimeCalculation(String link, int inputDepth) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        URLvalidation(link, 0, inputDepth);
        while (((ThreadPoolExecutor) Validation.executor).getActiveCount() > 0) {
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
