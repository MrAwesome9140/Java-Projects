import java.util.*;

import static java.util.stream.Collectors.*;

public class KMediods {

    private Coords[] locs;

    public KMediods(Coords[] temp){
        locs = temp;
    }

    HashMap<Coords, ArrayList<Coords>> calculate(int numClus) throws CloneNotSupportedException {
        ArrayList<Coords> points = new ArrayList<>(Arrays.asList(locs));
        if(numClus>locs.length)
            return null;

        Random ran = new Random();
        ArrayList<Coords> initMediods = new ArrayList<>();
        while(initMediods.size()<numClus){
            Coords temp = points.remove(ran.nextInt(points.size()));
            initMediods.add(temp);
        }

        HashMap<Coords,ArrayList<Coords>> clusters = assignPoints(initMediods);

        boolean didSomething;
        do{
            didSomething = false;
            ArrayList<Coords> mediods = new ArrayList<>(clusters.keySet());
            ArrayList<Coords> newMediods=  new ArrayList<>();
            for(Coords p:mediods){
                double minCost = Integer.MAX_VALUE;
                Coords newMed = p;
                ArrayList<Coords> cluster = new ArrayList<>(clusters.get(p));
                cluster.add(p);
                for(Coords s:cluster){
                    double totCost = 0;
                    for(Coords i:cluster)
                        if(i!=s)
                            totCost+=i.distance(s);
                    if(totCost<minCost){
                        ArrayList<Coords> pos = new ArrayList<>(clusters.get(newMed));
                        pos.remove(s);
                        pos.add(newMed);
                        clusters.remove(newMed);
                        clusters.put(s, pos);
                        minCost = totCost;
                        newMed = s;
                    }
                }
                newMediods.add(newMed);
                if(!newMed.equals(p))
                    didSomething = true;
            }
            if(didSomething)
                clusters = assignPoints(newMediods);
        } while (didSomething);
//        double total=totalCost(clusters);
//        SDofCost(clusters, total);
        return clusters;
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
        System.out.println("Mediods SD is: " + Math.sqrt(total/numPoints) + "\n");
    }

    HashMap<Coords, ArrayList<Coords>> assignPoints(ArrayList<Coords> mediods){
        HashMap<Coords,ArrayList<Coords>> clusters = new HashMap<>();
        ArrayList<Coords> points = new ArrayList<>(Arrays.asList(locs));
        points.removeAll(mediods);
        for(Coords p:mediods)
            clusters.put(p, new ArrayList<>());
        for(Coords p:points){
            double minDist = Integer.MAX_VALUE;
            Coords minPoint = null;
            for(Coords s:mediods){
                if(p.distance(s)<minDist){
                    minDist = p.distance(s);
                    minPoint = s;
                }
            }
            clusters.get(minPoint).add(p);
        }
        return clusters;
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
        System.out.println("Mediods Cost is: " + totalCost);
        System.out.println("Mediods max dist is: " + maxDist);
        System.out.println("Mediods min dist is: " + minDist);
        return totalCost;
    }

}
