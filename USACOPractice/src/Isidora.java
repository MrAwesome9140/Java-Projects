import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Isidora {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("isidora.dat")));
        String s;
        while((s=br.readLine())!=null){
            String command = s.substring(0,2);
            String[] nums = s.substring(3).split(" ");
            int amount = Integer.parseInt(nums[0]);
            int num = Integer.parseInt(nums[1]);
            System.out.println(operation(num, command, amount));
        }

    }

    static String operation(int bin, String com, int am){
        if(com.equals("RS")){
            return Integer.toBinaryString(bin >> am);
        }
        else if(com.equals("LS")){
            return Integer.toBinaryString(bin << am);
        }
        else if(com.equals("RC")){
            com = Integer.toBinaryString(bin);
            return com.substring(com.length()-am)+com.substring(0, com.length()-am);
        }
        else{
            com = Integer.toBinaryString(bin);
            return com.substring(am)+com.substring(0,am);
        }
    }

}
