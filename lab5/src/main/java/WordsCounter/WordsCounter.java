package WordsCounter;

public class WordsCounter {
    private int maxCountOfWords = 0;
    private String maxLine = "";
    public static int getLineWordsCount(String line){
        return line.split("[\\s.,:-]+").length;
    }
    public void setMaxLine(String maxLine){
        this.maxLine = maxLine;
    }
    public void setMaxCountOfWords(int maxCountOfWords){
        this.maxCountOfWords = maxCountOfWords;
    }
    public int getMaxCountOfWords(){
        return maxCountOfWords;
    }
    public String getMaxLine(){
        return maxLine;
    }
}
