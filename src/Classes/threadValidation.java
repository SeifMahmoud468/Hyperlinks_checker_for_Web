package Classes;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class threadValidation extends Thread {

    String link, text;
    int currentDepth, inputDepth;
    public static Validation v;

    public threadValidation(int n) {
        v = new Validation(n);
    }

    public threadValidation(String link, int currentDepth, int inputDepth, String text) {
        this.link = link;
        this.currentDepth = currentDepth;
        this.inputDepth = inputDepth;
        this.text = text;
    }

    @Override
    public void run() {
        try {
            v.URLvalidation(link, currentDepth, inputDepth);
            //System.out.println("Text:" + text+"\n");
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(threadValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
