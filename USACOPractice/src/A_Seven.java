import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class A_Seven {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("a_seven.dat")));

        String s;
        while((s = br.readLine())!=null){
            char[] temp = s.toCharArray();
            int[] og = new int[temp.length];
            int[] nums;
            for(int i = 0 ;i<temp.length; i++){
                og[i] = Integer.parseInt(String.valueOf(temp[i]));
            }
            nums = og.clone();
            Arrays.sort(nums);
            int median;
            if(nums.length%2==0)
                median = nums.length/2-1;
            else
                median = (nums.length-1)/2;
            int a = 0;
            while(a<nums.length && nums[a]!=nums[median]){
                a++;
            }
            int closest = nums[median];
            int temps = a;
            int switcheroo = s.indexOf(String.valueOf(nums[temps]));
            if(closest==0 || closest==1 || closest==2){
                og[switcheroo] = nums[largestDigit(nums)];
            }
            else if(closest==3 || closest==4 || closest==5){
                og[switcheroo] = nums[smallestDigit(nums)];
            }
            else if(closest<9){
                og[switcheroo] = onesSum(nums);
            }
            else{
                og[switcheroo] = 0;
            }

            String total = "";
            for(int i:og)
                total+=String.valueOf(i);

            System.out.println(Integer.parseInt(total));
        }
    }

    static int largestDigit(int[] nums){
        int maxInd = 0;
        int maxNum = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>maxNum){
                maxInd = i;
                maxNum = nums[i];
            }
        }
        return maxInd;
    }

    static int smallestDigit(int[] nums){
        int maxInd = 0;
        int maxNum = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]<maxNum){
                maxInd = i;
                maxNum = nums[i];
            }
        }
        return maxInd;
    }

    static int onesSum(int[] nums){
        int sum = 0;
        for(int i:nums)
            sum+=i;
        String wow = String.valueOf(sum);
        return Integer.parseInt(String.valueOf(wow.charAt(wow.length()-1)));
    }

}
