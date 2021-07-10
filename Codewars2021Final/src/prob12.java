import java.text.DecimalFormat;
import java.util.Scanner;

public class prob12 {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        double speed = Double.parseDouble(temp[1]);
        String dist = temp[2];
        String time = temp[4];
        if(time.equals("MINUTE"))
            speed/=60.0;
        else if(time.equals("HOUR"))
            speed/=3600.0;

        if(dist.equals("MILES"))
            speed*=1609.34;
        else if(dist.equals("KILOMETERS"))
            speed*=1000.0;
        else if(dist.equals("FEET"))
            speed*=0.3048;
        else if(dist.equals("YARDS"))
            speed*=0.9144;
        else if(dist.equals("CENTIMETERS"))
            speed/=100.0;
        else if(dist.equals("INCHES"))
            speed*=0.0254;

        double height = Math.round(Math.pow(speed,2)/(2*9.805)*100.0)/100.0;

        System.out.print(temp[0]+" will launch the messenger "+df.format(height)+" meters high, ");
        if(height<25.0)
            System.out.print("SPLAT!");
        else if(height>50.0)
            System.out.print("OUCH!");
        else
            System.out.print("SUCCESS!");


    }

}
