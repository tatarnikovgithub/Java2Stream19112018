package lesson3;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class UniqueWords<String> {
  private List<String> words;
  private HashMap<String, Integer> uniqueWords = new HashMap<>();

  public UniqueWords(){}
  public UniqueWords(List<String> words) {
    this.words = words;
  }

  public void setWords(List<String> words) {
    this.words = words;
  }

  public HashMap<String, Integer> getUniqueWords() {
    this.makeUniqueWords();
    
    return uniqueWords;
  }

  private void makeUniqueWords() {
    for (String word : words){
      uniqueWords.put(word, Collections.frequency(words, word));
    }
  }
}
