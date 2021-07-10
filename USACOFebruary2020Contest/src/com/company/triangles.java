import java.io.*;

public class triangles {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("triangles.in")));
        int num = Integer.parseInt(br.readLine());
        int[][] points = new int[num][2];

        for(int i = 0; i<num; i++){
            String[] r = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(r[0]);
            points[i][1] = Integer.parseInt(r[1]);
        }
        br.close();

        double maxArea = Double.MIN_VALUE;

        for(int rows = 0; rows<points.length-2; rows++){
            int[] coord1 = points[rows];
            for(int second = rows+1; second<points.length-1; second++){
                int[] coord2 = points[second];
                for(int third = second+1; third<points.length; third++){
                    int[] coord3 = points[third];
                    boolean parallelX = false;
                    boolean parallelY = false;
                    if(coord1[0]==coord2[0]||coord1[0]==coord3[0]||coord2[0]==coord3[0])
                        parallelX = true;
                    if(coord1[1]==coord2[1]||coord1[1]==coord3[1]||coord2[1]==coord3[1])
                        parallelY = true;
                    if(parallelX && parallelY) {
                        double length1 = Math.sqrt(Math.pow(Math.abs(coord1[0] - coord2[0]), 2) + Math.pow(Math.abs(coord1[1] - coord2[1]), 2));
                        double length2 = Math.sqrt(Math.pow(Math.abs(coord1[0] - coord3[0]), 2) + Math.pow(Math.abs(coord1[1] - coord3[1]), 2));
                        double length3 = Math.sqrt(Math.pow(Math.abs(coord2[0] - coord3[0]), 2) + Math.pow(Math.abs(coord2[1] - coord3[1]), 2));
                        double s = (length1 + length2 + length3) / 2.0;
                        double min1 = Math.min(length1, Math.max(length2, length3));
                        double min2 = 0.0;
                        if(min1==length1){
                            min2 = Math.min(length2,length3);
                        }
                        if(min1==length2){
                            min2 = Math.min(length1,length3);
                        }
                        if(min1==length3){
                            min2 = Math.min(length2,length1);
                        }
                        double area = 0.5*min1*min2;
                        if (area > maxArea)
                            maxArea = area;
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("triangles.out")));
        bw.write(String.valueOf((int)(maxArea*2)));
        bw.close();

    }
}
