import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        ArrayList<CharPos> order = new ArrayList<>();
        int curRow = 0;
        boolean decreasing = false;
        for (int i = 0; i < s.length(); i++) {
            if (curRow == numRows) {
                curRow -= 1;
                decreasing = true;
            } else if (curRow == 1) {
                curRow = 2;
                decreasing = false;
            } else if (decreasing) {
                curRow--;
            } else {
                curRow++;
            }

            order.add(new CharPos(s.charAt(i), curRow, i));
        }
        Collections.sort(order);
        StringBuilder sb = new StringBuilder();
        for (CharPos c : order)
            sb.append(c.character);
        return sb.toString();
    }

    private static class CharPos implements Comparable<CharPos> {

        char character;
        int row;
        int time;

        public CharPos(char character, int pos, int time) {
            this.character = character;
            row = pos;
            this.time = time;
        }

        public int compareTo(CharPos other) {
            if (row != other.row) {
                return row - other.row;
            }
            return time - other.time;
        }

    }
}