package WordOccuranceInFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors; 
     
public class WordCount {    
	public static void main(String[] args) throws IOException {         
	    HashMap<String, Integer> wordcount =
	            new HashMap<String, Integer>();
	    try { 
	        BufferedReader in = new BufferedReader(
	                                  new FileReader("input.txt"));
	        String str;

	        while ((str = in.readLine()) != null) { 
	            str = str.toLowerCase(); // convert to lower case 
	            String[] words = str.split("\\s+"); //split the line on whitespace, would return an array of words

	            for( String word : words ) {
	              if( word.length() == 0 ) {
	                continue; 
	              }

	              Integer occurences = wordcount.get(word);

	              if( occurences == null) {
	                occurences = 1;
	              } else {
	                occurences++;
	              }
	              
	              
	              wordcount.put(word, occurences);
	            

	                } 

	        } 
	    }
	    catch(Exception e){
	        System.out.println(e);
	    }
	    
	    wordcount.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
        .limit(10).forEach(System.out::println);
	}
}

