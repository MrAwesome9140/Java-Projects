import java.util.*;
import java.awt.*;

public class Physics{

   static double launchAngle = 0;
   static double launchSpeed = 0;
   static String units       = "";
   static double gravity     = -9.8;

   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter launch angle(In degrees): ");
      launchAngle = sc.nextDouble();
      System.out.print("Enter initial launch speed: ");
      launchSpeed = sc.nextDouble();
      System.out.println("Enter units of speed: ");
      units = sc.nextLine();
      String[] unitSplit = units.split("/",-1);
      System.out.println("\nSolutions:\n" + "----------------------\n" + "Initial Vertical Speed: " + initialVerticalSpeed() + " " + units +
                        "\nFinal Vertical Speed: " + (0-initialVerticalSpeed()) + " " + units + "\nMaximum Veritcal Height: " + maxVertHeight() + 
                        " " + unitSplit[0] + "\nHorizontal Distance Travelled: " + horizontalDist() + " " + unitSplit[0] + "\nTotal Time: " 
                        + totalTime() + " " + unitSplit[0]);
   }
   
   public static double initialVerticalSpeed(){ 
      return launchSpeed*Math.sin(Math.toRadians(launchAngle));
   }
   
   public static double horizontalSpeed(){
      return launchSpeed*Math.cos(Math.toRadians(launchAngle));
   }
   
   public static double totalTime(){
      double initialVSp = initialVerticalSpeed();
      double finalVSp   = 0-initialVSp;
      return (finalVSp-initialVSp)/(gravity);
   }
   
   public static double horizontalDist(){
      return horizontalSpeed()*totalTime();
   }
   
   public static double maxVertHeight(){
      double height = (initialVerticalSpeed()*(totalTime()/2.0)) + ((1.0/2.0)*gravity*Math.pow((totalTime()/2.0),2));
      return height;
      //x = (Initial Speed x Time) + (1/2 x gravity x time^2)
   }

}