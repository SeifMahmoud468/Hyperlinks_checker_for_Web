
package LinkValidation;

import java.net.MalformedURLException;
import java.net.URL;
import org.jsoup.nodes.Element;


public class WebPageExtractions {
    
    //extracting the clickable text from the anchor tags in the html file
    public static String getClickableText(Element e)
    {
        String html = e.html();
        String parameters[]=html.split("<");
        return parameters[0];
    }
    
    //joining the parent link to a link who lacks the protocol and the host 
    public static String joinParentLink(String parentLink, String smallerLink) throws MalformedURLException
    {
         URL m = new URL(parentLink);
         String parentLINK = m.getProtocol() + "://" + m.getHost();
            if (!smallerLink.startsWith("http")) {
                smallerLink = parentLINK + smallerLink;
            }
           return smallerLink;
    }
}
