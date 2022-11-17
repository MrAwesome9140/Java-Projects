import java.util.*;

import static java.util.stream.Collectors.*;

public class KMedians {

    private Coords[] locs;

    public KMedians(Coords[] temp){
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
                ArrayList<Double> xs = new ArrayList<>(), ys = new ArrayList<>();
                for(Coords s:old.get(p)){
                    xs.add(s.x);
                    ys.add(s.y);
                }
                Collections.sort(xs);
                Collections.sort(ys);
                if(old.get(p).size()%2!=0){
                    newMeans.add(new Coords(xs.get(xs.size()/2), ys.get(ys.size()/2)));
                }
                else{
                    double newX = (xs.get(xs.size()/2)+xs.get(xs.size()/2-1))/2.0;
                    double newY = (ys.get(ys.size()/2)+ys.get(ys.size()/2-1))/2.0;
                    newMeans.add(new Coords(newX, newY));
                }
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
        System.out.println("Medians Cost is: " + totalCost);
        System.out.println("Medians max dist is: " + maxDist);
        System.out.println("Medians min dist is: " + minDist);
        return totalCost;
    }
}
