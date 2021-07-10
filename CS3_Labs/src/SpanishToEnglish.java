////© A+ Computer Science  -  www.apluscompsci.com
////Name -
////Date -
////Class -
////Lab  -
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.Scanner;
//import static java.lang.System.*;
//
//public class SpanishToEnglish {
//
//	private Map<String,String> pairs;
//
//	public SpanishToEnglish() {
//		pairs = new HashMap<>(); // Initialize HashMap
//	}
//
//	public void putEntry(String entry) {
//		String[] list = entry.split(" "); // Split string into spanish word and english translation
//		pairs.put(list[0], list[1]); // Add word as key and its translation as value
//	}
//
//	public String translate(String sent) {
//		Scanner chop = new Scanner(sent); // Create scanner from input string
//		String output ="";
//		while(chop.hasNext()) // While not fully done reading sentence
//			output+=pairs.get(chop.next())+" "; // Add english translation of next word to output
//		return output;
//	}
//
//	public String toString() {
//		return pairs.toString().replaceAll("\\,","\n");
//	}
//}