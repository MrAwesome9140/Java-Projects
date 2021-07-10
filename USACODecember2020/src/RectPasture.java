import java.awt.*;
import java.util.*;

public class RectPasture {

    static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i<n; i++){
            String[] temp = sc.nextLine().split(" ");
            points.add(new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }
        int ans = (int)Math.pow(2,n);
        ArrayList<Point> pointsX = (ArrayList<Point>) points.clone();
        ArrayList<Point> pointsY = (ArrayList<Point>) points.clone();
        pointsX.sort(Comparator.comparingInt(o -> o.x));
        pointsY.sort(Comparator.comparingInt(o -> o.y));

        for(int i = 0; i<n; i++){
            Point p = pointsX.get(i);
            int index = pointsY.indexOf(p);
            Set<Point> total = new HashSet<>(pointsY.subList(index+1, n));
            Set<Point> xs = new HashSet<>(pointsX.subList(i+1, n));
            total.retainAll(xs);
            total.removeAll(pointsX.subList(0, i));
            int left  = total.size();
            ans-=Math.pow(2, left)-left-1;
        }

        System.out.print(ans);
    }

}
