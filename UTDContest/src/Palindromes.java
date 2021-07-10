import java.util.Scanner;

public class Palindromes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        int k = Integer.parseInt(temp[2]);

        int numPalis = 0;

        for(int i = a; i<=b; i++){
            boolean addOne = true;
            for(int base = 2; base<=k; base++){
                if(!isPalindrome(Integer.toString(Integer.parseInt(String.valueOf(i), 10), base))){
                    addOne = false;
                    break;
                }
            }
            if(addOne)
                numPalis++;
        }

        System.out.print(numPalis);

    }

    static boolean isPalindrome(String s){
        for(int i = 0; i<s.length()/2; i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }

}
