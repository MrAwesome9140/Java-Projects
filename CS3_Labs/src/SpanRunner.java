//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class SpanRunner {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("spantoeng.dat"));
		int words = Integer.parseInt(br.readLine()); // Get number of words to translate
		SpanishToEnglish spToEn = new SpanishToEnglish();
		for(int i = 0; i<words; i++)
			spToEn.putEntry(br.readLine()); // Add each subsequent word to our hashmap
		out.println(spToEn+"\n"); // Print out spanish words and their translations
		String s;
		while((s = br.readLine())!=null)
			out.println(spToEn.translate(s)); // Translate the sentence and print it out

	}

}

class SpanishToEnglish {

	private Map<String,String> pairs;

	public SpanishToEnglish() {
		pairs = new HashMap<>(); // Initialize HashMap
	}

	public void putEntry(String entry) {
		String[] list = entry.split(" "); // Split string into spanish word and english translation
		pairs.put(list[0], list[1]); // Add word as key and its translation as value
	}

	public String translate(String sent) {
		Scanner chop = new Scanner(sent); // Create scanner from input string
		String output ="";
		while(chop.hasNext()) // While not fully done reading sentence
			output+=pairs.get(chop.next())+" "; // Add english translation of next word to output
		return output;
	}

	public String toString() {
		return pairs.toString().replaceAll("\\,","\n");
	}
}