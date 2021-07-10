// Lab03vst.java
// Student starting version of the Lab03 assignment.
// Resave this program as Lab03v80 for the 80 point version.
// Resave this program as Lab03v100 for the 100 point version.


public class Lab03vst {
    final static int millis = 10000123;


    public static void main(String[] args) {
        System.out.println("Lab03, 100 Point Version\n");
        int[] times = calculateTime();
        System.out.println("Starting milli-seconds " + millis);
        System.out.println("Hours:                 " + times[0]);
        System.out.println("Minutes:               " + times[1]);
        System.out.println("Seconds:               " + times[2]);
        System.out.println("Milliseconds:          " + times[3]);
    }

    public static int[] calculateTime(){
        int leftover = 0;
        int hours = millis/3600000;
        leftover = millis%3600000;
        int mins = leftover/60000;
        leftover = leftover%60000;
        int seconds = leftover/1000;
        int mills = leftover%1000;
        int[] time = {hours,mins,seconds,mills};
        return time;
    }
}

