import EncodingStream.EncodingInputStream;
import EncodingStream.EncodingOutputStream;
import HtmlParser.HtmlParser;
import WordsCounter.FileLines;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("[TASK 1]");
            System.out.print("Enter input file path: ");
            String filenameInput = scanner.nextLine();
            if (filenameInput.equals("")) {
                filenameInput = "input.txt";
            }
            System.out.print("Enter output file path: ");
            String filenameOutput = scanner.nextLine();
            if (filenameOutput.equals("")) {
                filenameOutput = "output.txt";
            }
            FileLines fileLines = new FileLines(filenameInput);
            System.out.println("Longest line in file '" + filenameInput + "' with " +
                    fileLines.getMaxCountOfWords() + " words: " + fileLines.getMaxLine());
            fileLines.close();
            System.out.println("[TASK 3]");
            System.out.print("Enter key character: ");
            char keyCharacter = '*';
            EncodingInputStream in = new EncodingInputStream(new FileInputStream(filenameInput), keyCharacter);
            EncodingOutputStream out = new EncodingOutputStream(new FileOutputStream(filenameOutput), keyCharacter);
            String testFilenameOutput = filenameOutput.split("\\.")[0] + "_test.txt";
            FileOutputStream test_out = new FileOutputStream(testFilenameOutput);
            int buffer;
            while ((buffer = in.read()) != -1) {
                out.write(buffer);
                test_out.write(buffer);
            }
            in.close();
            out.close();
            test_out.close();
            System.out.println("Saved files " + filenameOutput + " and " + testFilenameOutput);
            System.out.println("[TASK 4]");
            System.out.print("Enter URL: ");
            String link = scanner.nextLine();
            if (link.equals("")) {
                link = "https://stackoverflow.com";
            }
            HtmlParser htmlParser = new HtmlParser(link);
            String html = htmlParser.getHtml();
            htmlParser.saveHtmlToFile("index.html");
            htmlParser.close();
            ArrayList<String> rawTags = new ArrayList<>(Arrays.asList(html.split("<")));
            ArrayList<String> tags = new ArrayList<>();
            HashMap<String, Integer> countElements = new HashMap<>();
            for (String rawTag : rawTags) {
                if (rawTag.length() > 0 && Character.isLetter(rawTag.charAt(0))) {
                    String tag = rawTag.split(" ")[0];
                    if (tag.contains(">")) {
                        tag = tag.substring(0, tag.indexOf(">"));
                    }
                    tag = tag.replace("/", "");
                    if (!tag.matches("[a-zA-Z0-9]+")) {
                        continue;
                    }
                    tags.add(tag);
                    if (countElements.containsKey(tag)) {
                        countElements.put(tag, countElements.get(tag) + 1);
                    } else {
                        countElements.put(tag, 1);
                    }
                }
            }
            Collections.sort(tags);
            System.out.println("HTML tags on page " + link + " sorted in alphabetical order:");
            tags.forEach(tag -> System.out.print(tag + " "));
            System.out.println();

            ArrayList<Entry<String, Integer>> list = new ArrayList<>(countElements.entrySet());
            list.sort(Entry.<String, Integer>comparingByValue().reversed());
            System.out.println("HTML tags on page " + link + " sorted based on their count:");
            for (Entry<String, Integer> entry : list) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}