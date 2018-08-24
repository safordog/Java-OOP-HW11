/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework11b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author safordog
 */
public class Link {
    
    private URL url;

    public Link() {
    }

    public Link(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
    
    public String getLinkFromHTML() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(this.url.openStream()));
        String result = "";
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("href=\"http")) {
                int index = line.indexOf("href=");
                int endIndex = line.indexOf("\"", index + 6);
                result += line.substring(index + 6, endIndex) + "\r\n";
            }
        }
        br.close();
        return result;
    }
    
    public ArrayList saveLink(String str) throws IOException {
        Path out = Paths.get("links.txt");
        ArrayList<String> array = new ArrayList<>(Arrays.asList (str));
        Files.write(out, array);
        return array;
    }
    
}
