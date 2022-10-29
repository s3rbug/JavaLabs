package HtmlParser;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class HtmlParser implements Serializable {
    String link;
    URL url;
    BufferedReader bufferedReader;
    URLConnection connection;
    String html;

    public HtmlParser(String link) throws IOException {
        this.link = link;
        url = new URL(link);
        connection = url.openConnection();
        bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        html = calculateHtml();
    }

    private String calculateHtml() throws IOException {
        StringBuilder html = new StringBuilder();
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null) {
            html.append(inputLine).append("\n");
        }
        return html.toString();
    }

    public String getHtml(){
        return html;
    }

    public void saveHtmlToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(html);
        writer.close();
    }

    public void close() throws IOException {
        bufferedReader.close();
    }
}
