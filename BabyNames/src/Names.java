/*  Student information for assignment:
 *
 *  On my honor, Aaroh Sharma, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: as225925
 *  email address: aaroh.sh@gmail.com
 *  Number of slip days I am using: 0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A collection of NameRecords.
 * Stores NameRecord objects and provides methods to select
 * NameRecords based on various criteria.
 */
public class Names {

    private ArrayList<NameRecord> names;
    private int numRanks;

    /**
     * Construct a new Names object based on the data source the Scanner
     * sc is connected to. Assume the first two lines in the
     * data source are the base year and number of decades to use.
     * Any lines without the correct number of decades are discarded
     * and are not part of the resulting Names object.
     * Any names with ranks of all 0 are discarded and not
     * part of the resulting Names object.
     *
     * @param sc Is connected to a data file with baby names
     *           and positioned at the start of the data source.
     */
    public Names(Scanner sc) {
        names = new ArrayList<>();
        int baseDec = Integer.parseInt(sc.nextLine());
        numRanks = Integer.parseInt(sc.nextLine());
        int[] ranks;

        // Iterate through each line of the file to and add all names to the
        // names ArrayList that have the correct number of decades and are
        // ranked in the top 1000 in at least one decade
        while (sc.hasNextLine()) {
            String[] parts = sc.nextLine().split(" ");

            // Filter out names that don't have the right number of decades
            // with a ranking in the database
            if (parts.length == (numRanks + 1)) {
                ranks = new int[numRanks];
                int index = 1, numTimesRanked = 0;
                while (index < parts.length) {
                    int rank = Integer.parseInt(parts[index]);
                    if (rank != 0) {
                        numTimesRanked++;
                    }
                    ranks[index - 1] = rank;
                    index++;
                }

                // Only add the name to the ArrayList names if it has been
                // ranked in the top 1000 in at least one decade
                if (numTimesRanked > 0) {
                    names.add(new NameRecord(parts[0], baseDec, ranks));
                }
            }
        }
        Collections.sort(names);
    }

    /**
     * Returns an ArrayList of NameRecord objects that contain a
     * given substring, ignoring case.  The names must be in sorted order based
     * on the names of the NameRecords.
     *
     * @param partialName != null, partialName.length() > 0
     * @return an ArrayList of NameRecords whose names contains
     * partialName. If there are no NameRecords that meet this
     * criteria returns an empty list.
     */
    public ArrayList<NameRecord> getMatches(String partialName) {
        if (partialName == null || partialName.length() == 0) {
            throw new IllegalArgumentException(
                    "String partialName cannot be null and " +
                            "must have a length greater than 0");
        }

        // Convert partialName and all names in the ArrayList names to
        // lowercase to be able to compare them without worrying about
        // capitalization
        partialName = partialName.toLowerCase();
        ArrayList<NameRecord> matches = new ArrayList<>();
        for (NameRecord rec : names) {
            if (rec.getName().toLowerCase().contains(partialName)) {
                matches.add(rec);
            }
        }
        Collections.sort(matches);

        return matches;
    }

    /**
     * Returns an ArrayList of Strings of names that have been ranked in the
     * top 1000 or better for every decade. The Strings  must be in sorted
     * order based on the name of the NameRecords.
     *
     * @return A list of the names that have been ranked in the top
     * 1000 or better in every decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list.
     */
    public ArrayList<String> rankedEveryDecade() {
        ArrayList<String> ranked = new ArrayList<>();
        for (NameRecord rec : names) {
            if (rec.allTop1000()) {
                ranked.add(rec.getName());
            }
        }
        Collections.sort(ranked);

        return ranked;
    }

    /**
     * Returns an ArrayList of Strings of names that have been ranked in the
     * top 1000 or better in exactly one decade. The Strings must be in sorted
     * order based on the name of the NameRecords.
     *
     * @return A list of the names that have been ranked in the top
     * 1000 or better in exactly one decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list.
     */
    public ArrayList<String> rankedOnlyOneDecade() {
        ArrayList<String> rankedOnce = new ArrayList<>();
        for (NameRecord rec : names) {
            if (rec.oneTop1000()) {
                rankedOnce.add(rec.getName());
            }
        }
        Collections.sort(rankedOnce);

        return rankedOnce;
    }

    /**
     * Returns an ArrayList of Strings of names that have been getting more
     * popular every decade. The Strings  must be in sorted
     * order based on the name of the NameRecords.
     *
     * @return A list of the names that have been getting more popular in
     * every decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list.
     */
    public ArrayList<String> alwaysMorePopular() {
        ArrayList<String> morePop = new ArrayList<>();
        for (NameRecord rec : names) {
            if (rec.morePopular()) {
                morePop.add(rec.getName());
            }
        }
        Collections.sort(morePop);

        return morePop;
    }

    /**
     * Returns an ArrayList of Strings of names that have been getting less
     * popular every decade. The Strings  must be in sorted order based
     * on the name of the NameRecords.
     *
     * @return A list of the names that have been getting less popular in
     * every decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list.
     */
    public ArrayList<String> alwaysLessPopular() {
        ArrayList<String> lessPop = new ArrayList<>();
        for (NameRecord rec : names) {
            if (rec.lessPopular()) {
                lessPop.add(rec.getName());
            }
        }
        Collections.sort(lessPop);

        return lessPop;
    }

    /**
     * Returns an ArrayList of String of names that have have been ranked
     * within the top 1000 for every decade and have a difference of 200 or
     * less between their lowest and highest ranks sorted alphabetically by
     * name
     *
     * @return An arraylist of names that have have been ranked within the
     * top 1000 for every decade and have a difference of 200 or less between
     * their lowest and highest ranks sorted alphabetically by name. Return an
     * empty ArrayList if no names match this criteria.
     */
    public ArrayList<String> ranksWithin200() {
        ArrayList<String> valid = new ArrayList<>();
        for (NameRecord rec : names) {
            if (rec.allTop1000()) {

                // Record the best and worst rank for each name by iterating
                // through its rank in each decade
                int bestRank = 1001;
                int worstRank = 1;
                for (int i = 0; i < numRanks; i++) {
                    bestRank = Math.min(bestRank, rec.getRank(i));
                    worstRank = Math.max(worstRank, rec.getRank(i));
                }

                // Add the name to the ArrayList of valid names if it has a
                // difference of 200 or less between its best and worst rank
                if (worstRank - bestRank <= 200) {
                    valid.add(rec.getName());
                }
            }
        }
        Collections.sort(valid);

        return valid;
    }

    /**
     * Return the NameRecord in this Names object that matches the given String ignoring case.
     * <br>
     * <tt>pre: name != null</tt>
     *
     * @param name The name to search for.
     * @return The name record with the given name or null if no NameRecord in this Names
     * object contains the given name.
     */
    public NameRecord getName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(
                    "The parameter name cannot be null");
        }

        // Compare lowercase version of String name to the names in the
        // ArrayList to avoid capitalization conflicts
        name = name.toLowerCase();
        for (NameRecord rec : names) {
            if (rec.getName().toLowerCase().equals(name)) {
                return rec;
            }
        }
        return null;
    }
}