package WordsCounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLines {
    private final Stream<String> stream;
    private final WordsCounter wordsCounter = new WordsCounter();

    public FileLines(String filename) throws IOException {
        this.stream = Files.lines(Paths.get(filename));
        calculateWordsCount();
    }

    public void calculateWordsCount() {
        stream.forEach((line) -> {
            int wordsCount = WordsCounter.getLineWordsCount(line);
            if (wordsCount > wordsCounter.getMaxCountOfWords()) {
                wordsCounter.setMaxCountOfWords(wordsCount);
                wordsCounter.setMaxLine(line);
            }
        });
    }

    public void close() {
        this.stream.close();
    }

    public int getMaxCountOfWords() {
        return wordsCounter.getMaxCountOfWords();
    }

    public String getMaxLine() {
        return wordsCounter.getMaxLine();
    }
}
