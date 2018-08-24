/*
 * Напишите программу, которая выведет в файл все ссылки,
 * которые содержатся в html документе, который будет прислан в
 * результате запроса на произвольный URL.
 */
package homework11b;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author safordog
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
        URL url = new URL("https://prog.kiev.ua");
        Link link = new Link(url);
        link.saveLink(link.getLinkFromHTML()); 
    }    
    
}
