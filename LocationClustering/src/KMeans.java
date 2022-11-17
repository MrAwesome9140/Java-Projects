import java.awt.*;
import java.util.*;
import java.util.List;

public class KMeans {

    private Coords[] locs;

    public KMeans(Coords[] temp){
        locs = temp;
    }

    HashMap<Coords, ArrayList<Coords>> calculate(int numClus){
        ArrayList<Coords> points = new ArrayList<>(Arrays.asList(locs));
        if(numClus>locs.length)
            return null;

        Random ran = new Random();
        ArrayList<Coords> initMeans = new ArrayList<>();
        while(initMeans.size()<numClus){
            Coords temp = points.remove(ran.nextInt(points.size()));
            initMeans.add(temp);
        }

        HashMap<Coords,ArrayList<Coords>> clusters = new HashMap<>();
        for(Coords p:initMeans)
            clusters.put(p, new ArrayList<>());
        for(Coords p:points){
            double minDist = Integer.MAX_VALUE;
            Coords minPoint = null;
            for(Coords s:initMeans){
                if(p.distance(s)<minDist){
                    minDist = p.distance(s);
                    minPoint = s;
                }
            }
            clusters.get(minPoint).add(p);
        }

        HashMap<Coords, ArrayList<Coords>> old = new HashMap<>(clusters);
        HashMap<Coords, ArrayList<Coords>> updated = new HashMap<>(clusters);
        do{
            old = (HashMap<Coords, ArrayList<Coords>>) updated.clone();
            updated.clear();
            ArrayList<Coords> newMeans = new ArrayList<>();
            for(Coords p:old.keySet()){
                double totalX = 0, totalY = 0;
                for(Coords i:old.get(p)){
                    totalX += i.x;
                    totalY += i.y;
                }
                double avgX = totalX/old.get(p).size();
                double avgY = totalY/old.get(p).size();
                newMeans.add(new Coords(avgX, avgY));
            }
            for(Coords p:newMeans)
                updated.put(p, new ArrayList<Coords>());
            ArrayList<Coords> ps = new ArrayList<>(Arrays.asList(locs));
            for(Coords p:ps){
                double minDist = Integer.MAX_VALUE;
                Coords minPoint = null;
                for(Coords s:newMeans){
                    if(p.distance(s)<minDist){
                        minDist = p.distance(s);
                        minPoint = s;
                    }
                }
                updated.get(minPoint).add(p);
            }
        } while (!mapsSame(old, updated));
//        double total = totalCost(updated);
//        SDofCost(updated, total);
        return updated;
    }

    private void SDofCost(HashMap<Coords, ArrayList<Coords>> clusters, double totalCost){
        double total = 0;
        double numPoints = locs.length-clusters.keySet().size();
        double mean = totalCost/numPoints;
        for(Coords mediod:clusters.keySet()){
            for(Coords point:clusters.get(mediod)){
                total+=Math.pow(point.distance(mediod)-mean,2);
            }
        }
        System.out.println("Means SD is: " + Math.sqrt(total/numPoints) + "\n");
    }

    boolean mapsSame(HashMap<Coords, ArrayList<Coords>> temp1, HashMap<Coords, ArrayList<Coords>> temp2){
        return temp1.keySet().containsAll(temp2.keySet());
    }

    private double totalCost(HashMap<Coords, ArrayList<Coords>> clusters){
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
        System.out.println("Means Cost is: " + totalCost);
        System.out.println("Means max dist is: " + maxDist);
        System.out.println("Means min dist is: " + minDist);
        return totalCost;
    }

}

class Coords implements Comparable{

    double x;
    double y;

    public Coords(double x1, double y1){
        x = x1;
        y = y1;
    }

    double distance(Coords temp){
        return Math.sqrt(Math.pow(x-temp.x,2)+Math.pow(y-temp.y,2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coords)) return false;
        Coords coords = (Coords) o;
        return Double.compare(coords.x, x) == 0 &&
                Double.compare(coords.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Coords(x,y);
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Coords){
            return (int)((x-((Coords)o).x)+(y-((Coords)o).y));
        }
        return -1;
    }
}