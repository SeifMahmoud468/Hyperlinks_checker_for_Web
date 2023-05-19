/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkValidation;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ValidationThreads extends Thread{
    
    private String link;
    private int depth;
    private int maxDepth;
    private String clickableText;
    private int numOfThreads;

    public ValidationThreads(String link, int depth, int maxDepth, String clickableText, int numOfThreads) {
        this.link = link;
        this.depth = depth;
        this.maxDepth = maxDepth;
        this.clickableText = clickableText;
        this.numOfThreads = numOfThreads;
    }
    
    @Override
    public void run() {
        Validation v = new Validation(numOfThreads);
        try {
            v.URLsValidation(link, depth, maxDepth,clickableText);
        } catch (IOException ex) {
            Logger.getLogger(ValidationThreads.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ValidationThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception e)
        {}
        
    }
  
}
