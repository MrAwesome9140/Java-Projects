import javax.swing.*;
import java.awt.*;
import java.util.*;

public class test {

    public static void main(String[] args) throws CloneNotSupportedException {

        int locs = 2000;

        double meansTotalCost = 0, meansAvgMin = 0, meansAvgMax = 0, meansTotalSD = 0;
        double mediansTotalCost = 0, mediansAvgMin = 0, mediansAvgMax = 0, mediansTotalSD = 0;
        double mediodsTotalCost = 0, mediodsAvgMin = 0, mediodsAvgMax = 0, mediodsTotalSD = 0;
        for(int k = 0; k<2000; k++) {
            Random rand = new Random();
            Coords[] temp = new Coords[locs];
            for (int i = 0; i < locs; i++) {
                temp[i] = new Coords(rand.nextInt(950), rand.nextInt(950));
            }

            int clusters = 8;
            KMeans means = new KMeans(temp);
            KMedians medians = new KMedians(temp);
            KMediods mediods = new KMediods(temp);
            HashMap<Coords, ArrayList<Coords>> sol = means.calculate(clusters);
            HashMap<Coords, ArrayList<Coords>> sol2 = medians.calculate(clusters);
            HashMap<Coords, ArrayList<Coords>> sol3 = mediods.calculate(clusters);

            double meansTot = totalCost(sol);
            meansTotalCost += meansTot;
            meansTotalSD += SDofCost(sol, meansTot, locs);

            double mediansTot = totalCost(sol2);
            mediansTotalCost += mediansTot;
            mediansTotalSD += SDofCost(sol2, mediansTot, locs);

            double mediodsTot = totalCost(sol3);
            mediodsTotalCost += mediodsTot;
            mediodsTotalSD += SDofCost(sol3, mediodsTot, locs);
        }

        System.out.println("Means Avg Cost: " + meansTotalCost/2000.0);
        System.out.println("Means Avg SD: " + meansTotalSD/2000.0 + "\n");
        System.out.println("Medians Avg Cost: " + mediansTotalCost/2000.0);
        System.out.println("Medians Avg SD: " + mediansTotalSD/2000.0 + "\n");
        System.out.println("Mediods Avg Cost: " + mediodsTotalCost/2000.0);
        System.out.println("Mediods Avg SD: " + mediodsTotalSD/2000.0 + "\n");

//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                    ex.printStackTrace();
//                }
//
//                JFrame frame = new JFrame("Means");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.add(new Drawing(sol));
//                frame.pack();
//                frame.setLocationRelativeTo(null);
//                frame.setVisible(true);
//
//                JFrame frame2 = new JFrame("Medians");
//                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame2.add(new Drawing(sol2));
//                frame2.pack();
//                frame2.setLocationRelativeTo(null);
//                frame2.setVisible(true);
//
//                JFrame frame3 = new JFrame("Mediods");
//                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame3.add(new Drawing(sol3));
//                frame3.pack();
//                frame3.setLocationRelativeTo(null);
//                frame3.setVisible(true);
//            }
//        });
    }

    private static double SDofCost(HashMap<Coords, ArrayList<Coords>> clusters, double totalCost, int numP){
        double total = 0;
        double numPoints = numP-clusters.keySet().size();
        double mean = totalCost/numPoints;
        for(Coords mediod:clusters.keySet()){
            for(Coords point:clusters.get(mediod)){
                total+=Math.pow(point.distance(mediod)-mean,2);
            }
        }
//        System.out.println("Means SD is: " + Math.sqrt(total/numPoints) + "\n");
        return Math.sqrt(total/numPoints);
    }

    private static double totalCost(HashMap<Coords, ArrayList<Coords>> clusters){
        double totalCost = 0;
        double maxDist = 0;
        double minDist = Integer.MAX_VALUE;
        for(Coords mediod:clusters.keySet()){
            for(Coords point:clusters.get(mediod)){
                maxDist = Math.max(maxDist, point.distance(mediod));
                minDist = Math.min(minDist, point.distance(mediod));
                totalCost+=point.distance(mediod);
            }
        }
//        System.out.println("Medians Cost is: " + totalCost);
//        System.out.println("Medians max dist is: " + maxDist);
//        System.out.println("Medians min dist is: " + minDist);
        return totalCost;
    }

}
