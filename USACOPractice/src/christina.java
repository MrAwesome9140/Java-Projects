import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class christina {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("christina.dat")));
        int n = Integer.parseInt(br.readLine());

        String[] names = new String[n+1];
        for(int i = 0; i<n; i++){
            names[i+1] = br.readLine();
        }

        ArrayList<String> translate = new ArrayList<>();
        String s;
        while((s=br.readLine())!=null){
            translate.add(s);
        }

        for(String t: translate){
            String temp = "";
            for(int i = 0; i<t.length(); i+=3){
                String sub = t.substring(i, i+3);
                temp += modifiedString(sub, names);
            }
            System.out.println(temp);
        }

    }

    static String modifiedString(String temp, String[] names){
        char fin = temp.charAt(temp.length()-1);
        int index = Integer.parseInt(temp.substring(0,2));
        StringBuffer s = new StringBuffer(names[index]);
        switch (fin){
            case 'U':{
                return names[index].toUpperCase();
            }
            case 'L':{
                return names[index].toLowerCase();
            }
            case 'R':{
                return names[index];
            }
            case 'u':{
                return s.reverse().toString().toUpperCase();
            }
            case 'r':{
                return s.reverse().toString();
            }
            default:{
                return s.reverse().toString().toLowerCase();
            }
        }
    }

}
