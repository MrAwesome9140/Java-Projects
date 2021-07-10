//import java.util.Set;
//import java.util.StringTokenizer;
//import java.util.TreeSet;
//
//public class OddEvenSets {
//    private Set<Integer> odds;
//    private Set<Integer> evens;
//
//    public OddEvenSets() {
//        odds = new TreeSet<>(); // Instantiate odds set
//        evens = new TreeSet<>(); // Instantiate evens set
//    }
//
//    public OddEvenSets(String line) {
//        odds = new TreeSet<>(); // Instantiate odds set
//        evens = new TreeSet<>(); // Instantiate evens set
//        StringTokenizer st = new StringTokenizer(line); // Create StringTokenizer for line
//        while(st.hasMoreTokens()) {
//            int x = Integer.parseInt(st.nextToken()); // Parse next int
//            if(x%2==1)
//                odds.add(x); // If odd, add to odds set
//            else
//                evens.add(x); // If even, add to evens set
//        }
//    }
//
//    public String toString() {
//        return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
//    }
//}