import java.util.ArrayList;

public class NameRecord implements Comparable<NameRecord> {

    private String name;
    private int baseDec;
    private ArrayList<Integer> ranksByDec;

    /**
     * Construct a new NameRecord using the name, base decade,
     * and array of ranks passed by the user
     *
     * @param name     != null, The name for this NameRecord
     * @param baseDec, the base decade
     * @param ranks    != null, An array of this NameRecord's
     *                 ranks through the decades in chronological
     *                 order
     */
    public NameRecord(String name, int baseDec, int[] ranks) {
        if (name == null || ranks == null) {
            throw new IllegalArgumentException("String name and int array" +
                    "ranks cannot be null");
        }

        this.name = name;
        this.baseDec = baseDec;
        ranksByDec = new ArrayList<>();
        for (int rank : ranks) {
            ranksByDec.add(rank);
        }
    }

    /**
     * Return the name of this NameRecord
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Return the base decade of this NameRecord
     *
     * @return baseDec
     */
    public int getBaseDec() {
        return baseDec;
    }

    /**
     * Return the rank of this NameRecord during the decade
     * specified by the user in the param, int decade
     *
     * @param decade, a number between 0, inclusive, and ranksByDec.size(),
     *                exclusive, that specifies which decade's rank to
     *                return
     * @return ranksByDec.get(decade)
     */
    public int getRank(int decade) {
        if (decade < 0 || decade >= ranksByDec.size()) {
            throw new IllegalArgumentException(
                    "int decade must be between 0, inclusive, " +
                            "and the number of decade, exclusive.");
        }

        return ranksByDec.get(decade);
    }

    /**
     * @return the decade during which this NameRecord has the
     * best (lowest number) rank
     */
    public int getBestDecade() {
        int bestRank = 1001;
        int bestInd = ranksByDec.size() - 1;

        // Iterate from the most recent decade to the oldest record decade to
        // ensure the decade returned will be the most recent in case of a tie
        for (int i = ranksByDec.size() - 1; i >= 0; i--) {
            int rank = ranksByDec.get(i) == 0 ? 1001 : ranksByDec.get(i);
            if (rank < bestRank) {
                bestRank = rank;
                bestInd = i;
            }
        }
        return baseDec + (bestInd * 10);
    }

    /**
     * @return the number of decades during which this NameRecord
     * was ranked as one of the top 1000 most popular baby names
     */
    public int numDecsTop1000() {
        int total = 0;
        for (int i = 0; i < ranksByDec.size(); i++) {
            if (ranksByDec.get(i) > 0 && ranksByDec.get(i) <= 1000) {
                total++;
            }
        }
        return total;
    }

    /**
     * @return true if this NameRecord has been ranked in the top
     * 1000 baby names for the entirety of its record, and false
     * otherwise
     */
    public boolean allTop1000() {
        return numDecsTop1000() == ranksByDec.size();
    }

    /**
     * @return true if this NameRecord has been ranked in the top
     * 1000 baby names for exactly one decade, and false
     * otherwise
     */
    public boolean oneTop1000() {
        return numDecsTop1000() == 1;
    }

    /**
     * @return true if this NameRecord's rank has improved every
     * single decade since the base decade, and false otherwise
     */
    public boolean morePopular() {
        boolean gettingPop = true;

        // Assign all ranks outside the top 1000 as 1001
        int bestRank = ranksByDec.get(0) == 0 ? 1001 : ranksByDec.get(0);
        for (int i = 1; i < ranksByDec.size() && gettingPop; i++) {
            int rank = ranksByDec.get(i) == 0 ? 1001 : ranksByDec.get(i);
            if (rank < bestRank) {
                bestRank = rank;
            } else {
                gettingPop = false;
            }
        }
        return gettingPop;
    }

    /**
     * @return true if this NameRecord's rank has gotten worse every
     * single decade since the base decade, and false otherwise
     */
    public boolean lessPopular() {
        boolean losingPop = true;

        // Assign all ranks outside the top 1000 as 1001
        int worstRank = ranksByDec.get(0) == 0 ? 1001 : ranksByDec.get(0);
        for (int i = 1; i < ranksByDec.size() && losingPop; i++) {
            int rank = ranksByDec.get(i) == 0 ? 1001 : ranksByDec.get(i);
            if (rank > worstRank) {
                worstRank = rank;
            } else {
                losingPop = false;
            }
        }
        return losingPop;
    }

    /**
     * @return a String listing out the base decade of this NameRecord
     * as well as all the decades of data available with the corresponding
     * rank during the decade
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        for (int i = 0; i < ranksByDec.size(); i++) {
            sb.append(baseDec + (i * 10)).append(": ").append(ranksByDec.get(i))
                    .append("\n");
        }
        return sb.toString();
    }

    /**
     * NameRecords implements Comparable so it must override the compareTo
     * method, which is useful for sorting an array of NameRecords
     *
     * @param o != null
     * @return the result of name.compareTo(o.name)
     */
    public int compareTo(NameRecord o) {
        if (o == null) {
            throw new IllegalArgumentException("NameRecord o cannot be null");
        }

        return name.compareTo(o.name);
    }
}
