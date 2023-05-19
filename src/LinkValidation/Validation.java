
package LinkValidation;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Validation {
    
    //validity counters and totalNumofLinks are static due to the recreation of multiples instances within the same validation due to threads
    private static int valid = 0;
    private static int invalid = 0;
    private static int totalNumofLinks = 1;
    private int numOfThreads; //need to be stored for every instance to execute the Executor Service
    
    public static ExecutorService es; //what will execute the thread
    public ValidationThreads t1; // the thread itself (both are used outside the class directly, so they're public)

    public Validation(int numOfThreads) {
       this.numOfThreads = numOfThreads;
       es = Executors.newFixedThreadPool(numOfThreads);
       t1 = new ValidationThreads("", 0, 0, "",0); //as long as it's not time to execute, it will be initialized with garbage values
    }
    
    public static int getValid() {
        return valid;
    }

    public static void setValid(int valid) {
        Validation.valid = valid;
    }

    public static int getInvalid() {
        return invalid;
    }

    public static void setInvalid(int invalid) {
        Validation.invalid = invalid;
    }
    
    public static int getTotalNumofLinks()
    {
        return totalNumofLinks;
    }
    public static void setTotalNumofLinks(int totalNumofLinks)
    {
        Validation.totalNumofLinks = totalNumofLinks;
    }

    public int getNumOfThreads() {
        return numOfThreads;
    }

    public void setNumOfThreads(int numOfThreads) {
        this.numOfThreads = numOfThreads;
    }
    
    public boolean singleURLIsValid(String link) //checks the validity of a single URL
    {
        boolean flag;
        try {
            Document page = Jsoup.connect(link).get();
            flag = true;
        }catch (IOException ex) { //thrown exception due to timeout to connect to server
            flag = false;
        }catch(Exception e) { //for any exceptions generally to prevent program crashing
            flag = false;
        }
        return flag;
    }

    public int test = 0;
    public void URLsValidation(String link, int currentDepth, int stopAtDepth, String clickableText) throws IOException, InterruptedException {
        
        
        if (singleURLIsValid(link)) 
        {
            
            valid++;
            //prints the link then the clickable text then the validity
            System.out.println("Link: " + link);
            System.out.println("Text: " + clickableText);
            System.out.println("Valid Link\n\n");
            System.out.println(test); 
            test++;
            
            //base case for recursion
            if (currentDepth == stopAtDepth)
                return;
            
            //getting next depth links
            Document page = Jsoup.connect(link).get(); //opening the web document
            Elements anchor = page.select("a[href]"); //getting anchor tags into an instance of type Elements
            totalNumofLinks +=anchor.size();
            String clickTextTemp;
            
            for (int i = 0; i < anchor.size(); i++) 
            {
                String incompleteLink = anchor.get(i).attr("href");
                incompleteLink = WebPageExtractions.joinParentLink(link,incompleteLink);
                Element temp = anchor.get(i);
                clickTextTemp = WebPageExtractions.getClickableText(temp);
                
                try{t1 = new ValidationThreads(incompleteLink, currentDepth + 1, stopAtDepth, clickTextTemp,numOfThreads);
                es.execute(t1);}
                catch(Exception e)
                {}
            }
            
        } else {
            
            invalid++;
            System.err.println("Link: " + link);
            System.err.println("Invalid Link\n\n");
            System.out.println(test); 
            test++;
        }
    }
    
}
