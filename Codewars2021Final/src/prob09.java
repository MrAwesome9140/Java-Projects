import java.text.DecimalFormat;
import java.util.Scanner;

public class prob09 {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int mins = Integer.parseInt(sc.nextLine());
        double minsNeed = Math.round(mins*1.2*100.0)/100.0;
        double spRad = Double.parseDouble(sc.nextLine());
        String[] temp = sc.nextLine().split(" ");
        double cyHe = Double.parseDouble(temp[1]);
        double cyRad = Double.parseDouble(temp[0]);
        temp = sc.nextLine().split(" ");
        double pyL = Double.parseDouble(temp[0]);
        double pyW = Double.parseDouble(temp[1]);
        double pyH = Double.parseDouble(temp[2]);
        double volSphere = Math.round((4.0/3.0)*Math.PI*Math.pow(spRad,3)*100.0)/100.0-2.2-4.1;
        double volCy = Math.round(Math.PI*Math.pow(cyRad,2)*cyHe*100.0)/100.0-12.1;
        double volPy = Math.round(2*(1.0/3.0)*pyH*pyL*pyW*100.0)/100.0;
        double spaceLeft = Math.round((volCy+volPy+volSphere)*100.0)/100.0;
        System.out.println("Cockpit "+df.format(volSphere));
        System.out.println("Body "+df.format(volCy));
        System.out.println("Pods "+df.format(volPy));
        System.out.println("Minions Need "+df.format(minsNeed));
        if(minsNeed<=spaceLeft)
            System.out.print("PLAN ACCEPTED");
        else
            System.out.print("PLAN REJECTED");
    }

}
