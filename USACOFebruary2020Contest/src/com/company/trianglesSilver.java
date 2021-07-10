import java.io.*;
import java.util.*;

public class trianglesSilver {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("triangles.in")));
        int num = Integer.parseInt(br.readLine());
        int[][] points = new int[num][2];
        int[][] pointCopy = new int[num][2];

        for (int i = 0; i < num; i++) {
            String[] r = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(r[0]);
            points[i][1] = Integer.parseInt(r[1]);
            pointCopy[i][0] = Integer.parseInt(r[0]);
            pointCopy[i][1] = Integer.parseInt(r[1]);
        }
        br.close();

        List<Integer> yVals = new ArrayList<>();
        for (int[] temp : points) {
            yVals.add(temp[1]);
        }

        Arrays.sort(points, Comparator.comparingDouble(a -> a[0]));
        Arrays.sort(pointCopy, Comparator.comparingDouble(a -> a[1]));

        double maxArea = Double.MIN_VALUE;

        List<Double> areas = new ArrayList<>();

        int i = 0;
        while (i < points.length) {
            int[] coord1 = points[i];
            int counter = 1;
            while (i+counter<points.length && points[i + counter][0] == coord1[0]) {
                int index1 = findYVal(points, points[i+counter][1], 0, points.length-1, points[i+counter][0]);
                int index2 = findYVal(points, coord1[1], 0, points.length-1, coord1[0]);
                if(index1>=0) {
                    areas.add(area(coord1, points[i + counter], points[index1]));
                }
                else if(index2>=0){
                    areas.add(area(coord1, points[i + counter], points[index2]));
                }
                counter++;
            }
            i++;
        }

        double areaSum = 0.0;
        for (double d : areas) {
            areaSum += d;
        }

        areaSum = ((int) (areaSum * 2)) % (Math.pow(10, 9) + 7);

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("triangles.out")));
        bw.write(String.valueOf((int) areaSum));
        bw.close();

    }

    public static int findYVal(int[][] temp, int wanted, int start, int end, int not){
        int mid = (start+end)/2;
        if(end>=start) {
            if (temp[mid][1] == wanted && temp[mid][0]!=not)
                return mid;
            else if(temp[mid][1] > wanted) {
                return findYVal(temp, wanted, start, mid - 1, not);
            }
            else if(temp[mid][1] < wanted) {
                return findYVal(temp, wanted, mid + 1, end, not);
            }
            else if(temp[mid][1] == wanted){
                return Math.max(findYVal(temp, wanted, mid + 1, end, not), findYVal(temp, wanted, start, mid - 1, not));
            }
        }
        return -1;
    }

    public static double area(int[] coord1, int[] coord2, int[] coord3) {
        boolean parallelX = false;
        boolean parallelY = false;
        if (coord1[0] == coord2[0] || coord1[0] == coord3[0] || coord2[0] == coord3[0])
            parallelX = true;
        if (coord1[1] == coord2[1] || coord1[1] == coord3[1] || coord2[1] == coord3[1])
            parallelY = true;
        if (parallelX && parallelY) {
            double length1 = Math.sqrt(Math.pow(Math.abs(coord1[0] - coord2[0]), 2) + Math.pow(Math.abs(coord1[1] - coord2[1]), 2));
            double length2 = Math.sqrt(Math.pow(Math.abs(coord1[0] - coord3[0]), 2) + Math.pow(Math.abs(coord1[1] - coord3[1]), 2));
            double length3 = Math.sqrt(Math.pow(Math.abs(coord2[0] - coord3[0]), 2) + Math.pow(Math.abs(coord2[1] - coord3[1]), 2));
            double s = (length1 + length2 + length3) / 2.0;
            double min1 = Math.min(length1, Math.max(length2, length3));
            double min2 = 0.0;
            if (min1 == length1) {
                min2 = Math.min(length2, length3);
            }
            if (min1 == length2) {
                min2 = Math.min(length1, length3);
            }
            if (min1 == length3) {
                min2 = Math.min(length2, length1);
            }
            return 0.5*min1*min2;
        }
        return 0.0;
    }
}
