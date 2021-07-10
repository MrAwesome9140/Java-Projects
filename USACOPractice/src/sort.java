import java.io.*;

public class sort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("sort.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("sort.out")));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        for(int i = 0; i<n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        boolean sorted = false;
        int k = 0;
//        while(!sorted){
//            sorted = true;
//            k++;
//            for(int i = 0; i<n-1; i++){
//                if(nums[i+1]<nums[i]){
//                    swap(nums, i+1, i);
//                    sorted = false;
//                }
//            }
//        }
        for(int i = 0; i<n; i++){
            int temp = nums[i];
            for(int j = i+1; j<n; j++){
                if(nums[j]<temp)
                    k++;
            }
        }
        bw.write(String.valueOf(k));
        bw.close();
    }

    static void swap(int[] nums, int ind1, int ind2){
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }

}
