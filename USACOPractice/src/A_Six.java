import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class A_Six {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("a_six.dat")));
        String s;
        ArrayList<DataSet> data = new ArrayList<>();
        while((s = br.readLine())!=null){
            String[] temp = s.split("\\s++");
            String[] startDate = temp[0].split("/");
            String[] endDate = temp[1].split("/");
            DataSet d = new DataSet(Integer.parseInt(startDate[0]), Integer.parseInt(startDate[1]), Integer.parseInt(endDate[0]), Integer.parseInt(endDate[1]), Double.parseDouble(temp[2]));
            data.add(d);

            Collections.sort(data, new Comparator<DataSet>() {
                @Override
                public int compare(DataSet o1, DataSet o2) {
                    return o1.startMonth-o2.startMonth!=0?o1.startMonth-o2.startMonth:o1.startDay-o2.startDay;
                }
            });

            ArrayList<DataSet> wows = (ArrayList<DataSet>) data.clone();

            Collections.sort(wows, new Comparator<DataSet>() {
                @Override
                public int compare(DataSet o1, DataSet o2) {
                    return o1.endMonth-o2.endMonth!=0?o1.endMonth-o2.endMonth:o1.endDay-o2.endDay;
                }
            });

            for(int i = 0; i<data.size(); i++){
                DataSet temper = data.get(i);
                System.out.println(String.format("%02d", temper.startMonth)+"/"+String.format("%02d", temper.startDay)+"/16 "+temper.price);
            }

            DataSet temper = wows.get(wows.size()-1);
            System.out.println(String.format("%02d", temper.endMonth)+"/"+String.format("%02d", temper.endDay)+"/16 END");

            System.out.println();
        }

    }

}

class DataSet{

    int startMonth;
    int startDay;
    int endMonth;
    int endDay;
    double price;

    public DataSet(int startMonth, int startDay, int endMonth, int endDay, double price){
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.endMonth = endMonth;
        this.endDay = endDay;
        this.price = price;
    }
}