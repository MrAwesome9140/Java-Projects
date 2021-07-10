import java.util.Scanner;

public class prob12 {

    static String[] choices;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        choices = new String[n];
        for(int i = 0; i<n; i++){
            choices[i]=sc.nextLine();
        }
        int p = Integer.parseInt(sc.nextLine());
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<p; i++){
            String temp = anagram(sc.nextLine());
            if(temp.equals(""))
                sb.append("No: No matching case\n");
            else
                sb.append("Yes: "+temp+"\n");
        }

        System.out.println(sb);


    }

    static String anagram(String cur){
        String ans = "a";
        for(String s:choices){
            StringBuffer temp = new StringBuffer(s);
            boolean ana = true;
            for(int i = 0; i<cur.length(); i++){
                if(cur.charAt(i)!=' '){
                    int index = -1;
                    if((index=temp.toString().indexOf(String.valueOf(cur.charAt(i))))!=-1){
                        temp.deleteCharAt(index);
                    }
                    else{
                        ana = false;
                        break;
                    }
                }
            }
            if(ana && s.compareTo(ans)<0)
                ans = s;
        }
        if(ans.equals("a"))
            return "";
        else
            return ans;
    }

}
