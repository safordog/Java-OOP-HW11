/*
 * Проверить доступность сайтов указанных в отдельном файле.
 */
package homework11c;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author safordog
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File file = new File("websites.txt");
        Available temp = new Available(file);
        temp.checkAvailable();
    }
    
}
