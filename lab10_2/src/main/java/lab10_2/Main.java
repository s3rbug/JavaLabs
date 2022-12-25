package lab10_2;

import org.apache.log4j.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

//  ALL
//  TRACE
//  DEBUG
//  INFO
//  WARN
//  ERROR
//  FATAL
//  OFF

public class Main {
    public final static Logger logger = Logger.getLogger(Main.class);
    public static Locale locale = Locale.getDefault();
    public static ResourceBundle labels;

    public static String labelWithColon(String key){
        return labels.getString(key) + ": ";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Choose language:
                1 - English
                2 - Ukrainian""");
        String answer = scanner.nextLine();
        if (answer.equals("1")) {
            locale = new Locale("en");
        } else if (answer.equals("2")) {
            locale = new Locale("ua");
        }
        labels = ResourceBundle.getBundle("location/text", locale);
        System.out.print(labels.getString("logToConsole") + "? " + "(" + labels.getString("yes") + "/" + labels.getString("no") +  "): ");
        answer = scanner.nextLine();
        try {
            RollingFileAppender fileAppender = new RollingFileAppender(new SimpleLayout(), "log.txt", false);
            logger.addAppender(fileAppender);
            Appender consoleAppender = new ConsoleAppender(new SimpleLayout());
            if (Objects.equals(answer, labels.getString("yes"))) {
                logger.addAppender(consoleAppender);
            }
            logger.setLevel(Level.ALL);
            logger.info(labels.getString("loggerReady"));
        } catch (IOException e) {
            logger.error(labels.getString("IOError"), e);
        }
        System.out.print(labelWithColon("enterInputFile"));
        String filenameInput = scanner.nextLine();
        if (filenameInput.equals("")) {
            filenameInput = "input.txt";
        }
        logger.debug(labelWithColon("gotInputFile") + filenameInput);
        System.out.print(labelWithColon("enterOutputFile"));
        String filenameOutput = scanner.nextLine();
        if (filenameOutput.equals("")) {
            filenameOutput = "output.txt";
        }
        logger.debug(labelWithColon("gotOutputFile") + filenameOutput);
        char keyCharacter = '*';
        logger.debug(labelWithColon("initializedKeyCharacter") + keyCharacter);
        try {
            EncodingInputStream in = new EncodingInputStream(new FileInputStream(filenameInput), keyCharacter);
            EncodingOutputStream out = new EncodingOutputStream(new FileOutputStream(filenameOutput), keyCharacter);
            String testFilenameOutput = filenameOutput.split("\\.")[0] + "_test.txt";
            logger.info(labelWithColon("generatedTestFilename") + testFilenameOutput);
            FileOutputStream test_out = new FileOutputStream(testFilenameOutput);
            logger.debug(labelWithColon("initializedTestOut") + testFilenameOutput);
            int buffer;
            while ((buffer = in.read()) != -1) {
                out.write(buffer);
                test_out.write(buffer);
            }
            in.close();
            logger.debug(labels.getString("closeIn"));
            out.close();
            logger.debug(labels.getString("closeOut"));
            test_out.close();
            logger.debug(labels.getString("closeTestOut"));
        } catch (FileNotFoundException e) {
            logger.fatal(labels.getString("fileNotFound"), e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.fatal(labels.getString("IOError"), e);
            throw new RuntimeException(e);
        }
    }
}