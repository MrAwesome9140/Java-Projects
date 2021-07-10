import java.text.DecimalFormat;
import java.util.Scanner;

public class prob18 {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int peoReq = Integer.parseInt(sc.nextLine());
        int timeRun = Integer.parseInt(sc.nextLine());
        int startup = Integer.parseInt(sc.nextLine());
        double output = Double.parseDouble(sc.nextLine());
        int people = Integer.parseInt(sc.nextLine());
        output = Math.round((output/3600.0)*100.0)/100.0;
        if(people<peoReq || timeRun*60-startup<1)
            output = 0.0;
        System.out.println(name+" can generate "+df.format(output)+" watts/second");
        double gigas = Math.round((output/1000000000.0)*100.0)/100.0;
        if(gigas>=1.21 && people>=peoReq && timeRun*60-startup>=1)
            System.out.print("MARTY CAN MAKE IT!");
        else
            System.out.print("WHOA, HEAVY!");

    }

}
