/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework11c;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author safordog
 */
public class Available {
    
    private File file;

    public Available() {
    }

    public Available(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    public void checkAvailable() throws IOException {
        ArrayList<String> address = Files.lines(Paths.get(this.file.getName()))
                .collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < address.size(); i++) {
            try {
                URL url = new URL(address.get(i));
                URLConnection connect = url.openConnection();
                Map<String, List<String>> arr = connect.getHeaderFields();
                if (!arr.isEmpty()) {
                    System.out.print("Site available " + address.get(i) + ": ");
                    System.out.println(arr);
                } else if (arr.isEmpty()) {
                    System.out.println("!!! Site " + address.get(i) + " is not available");
                    }
            } catch (IOException e) {
                System.out.println("Site is not available: " + address.get(i));
                }
        }
    }
    
}
