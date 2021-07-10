import java.util.*;
import java.io.*;

public class SocDist {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("socdist.in")));
        String[] temp1 = br.readLine().split(" ");
        int N = Integer.parseInt(temp1[0]);
        int M = Integer.parseInt(temp1[1]);

        Interval[] intervals = new Interval[M];

        for(int i = 0; i<M; i++){
            String[] strings = br.readLine().split(" ");
            intervals[i] = new Interval(Long.parseLong(strings[0]), Long.parseLong(strings[1]));
        }
        br.close();

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return (int)(o1.start-o2.start)==0?(int)(o1.end-o2.end):(int)(o1.start-o2.start);
            }
        });

        long range = intervals[intervals.length-1].end-intervals[0].start+1;
        long preferredDist = (long) Math.ceil((double)range/N);
        ArrayList<Long> usedSpots = new ArrayList<>();
        long currSpot = -1;
        long prevSpot = 0;
        for(int i = 0; i<N; i++){
            if(currSpot<0){
                currSpot = intervals[0].start;
                usedSpots.add(currSpot);
                prevSpot = currSpot;
            }
            else{
                long preferredSpot = prevSpot+preferredDist;
                int index = findIndex(intervals, preferredSpot);
                if(index>=0){
                    currSpot = preferredSpot;
                    usedSpots.add(currSpot);
                    prevSpot = currSpot;
                }
                else{
                    int ind = closestInterval(intervals, preferredSpot);
                    if(ind<intervals.length) {
                        currSpot = intervals[ind].start;
                        usedSpots.add(currSpot);
                        prevSpot = currSpot;
                    }
                    else{
                        currSpot = intervals[intervals.length-1].end;
                        usedSpots.add(currSpot);
                        prevSpot = currSpot;
                    }
                }
            }
        }

//        long minD = Long.MAX_VALUE;
//        for(int i = 1; i<N; i++){
//            minD = Math.min(minD, Math.abs(usedSpots.get(i)-usedSpots.get(i-1)));
//        }
//
//        long sum = 0;
//        for(int i = 0; i<intervals.length; i++){
//            sum+=intervals[i].end-intervals[i].start+1;
//        }
//        long dist = (long) Math.ceil((double)sum/N);
//        long currSpot = -1;
//        long lastSpot = 0;
//        while(usedSpots.size()<N){
//            int index = findIndex(intervals, lastSpot+dist);
//            if(currSpot<0){
//                currSpot = intervals[0].start;
//                usedSpots.add(currSpot);
//                lastSpot = currSpot;
//            }
//            else if(index==-1){
//                int lastIndex = findIndex(intervals, lastSpot);
//                long leftover = dist-(intervals[lastIndex].end-lastSpot);
//                int currIndex = lastIndex+1;
//                while(currIndex<intervals.length && leftover>0){
//                    if(intervals[currIndex].end-intervals[currIndex].start>=leftover){
//                        currSpot = intervals[currIndex].start+leftover;
//                        usedSpots.add(currSpot);
//                        lastSpot = currSpot;
//                        leftover = 0;
//                    }
//                    else{
//                        leftover-=intervals[currIndex].end-intervals[currIndex].start;
//                        currIndex++;
//                    }
//                }
//                if(leftover>0){
//                    currSpot = intervals[intervals.length-1].end;
//                    usedSpots.add(currSpot);
//                    lastSpot = currSpot;
//                }
//            }
//            else if(index>=0){
//                currSpot = lastSpot+dist;
//                usedSpots.add(currSpot);
//                lastSpot = currSpot;
//            }
//        }
        long minD = Long.MAX_VALUE;
        for(int i = 1; i<usedSpots.size(); i++){
            minD = Math.min(minD, usedSpots.get(i)-usedSpots.get(i-1));
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("socdist.out")));
        bw.write(String.valueOf(minD));
        bw.flush();
        bw.close();

    }

    public static int closestInterval(Interval[] inters, long spot){
        int currInd = 0;
        while(currInd<inters.length && inters[currInd].end<spot)
            currInd++;
        return currInd;
    }

    public static int findIndex(Interval[] inters, long spot){
        for(int i = 0; i<inters.length; i++){
            if(inters[i].start<=spot && inters[i].end>=spot)
                return i;
        }
        return -1;
    }

}

class Interval{

    long start;
    long end;

    public Interval(long start, long end){
        this.start = start;
        this.end = end;
    }



}
