package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
  private HashMap<String, List<String>> phBook = new HashMap<>();

  public PhoneBook(){}

  public String get(String lastName){
    StringBuilder record = new StringBuilder( String.format("%s: not found", lastName) );

    List<String> phone = phBook.get(lastName);
    if (phone != null){
      record.replace(0, record.length(),
          String.format("%s phone: %s", lastName, phone.toString())
      );
    }

    return record.toString();
  }

  public void add(String lastName, String phone){
    // или лучше один раз до if сделать value = get() и проверить value на null/notnull?
    if (phBook.containsKey(lastName)){
      phBook.get(lastName).add(phone);
    }
    else {
      phBook.put(lastName, new ArrayList<>(Arrays.asList(phone)));
    }
  }
}
