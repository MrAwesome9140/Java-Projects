import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class boring {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] vals = new long[t][2];
        for(int i = 0; i<t; i++){
            String[] temp = br.readLine().split(" ");
            vals[i][0] = Long.parseLong(temp[0]); vals[i][1] = Long.parseLong(temp[1]);
        }
        for(int i = 0; i<t; i++){
            long f = vals[i][0];
            long r = vals[i][1];
            int numB = 0;
            for(long k = f; k<=r; k++){
                boolean odd = true;
                String s = String.valueOf(k);
                boolean boring = true;
                for(int j = 0; j<String.valueOf(k).length(); j++){
                    int i1 = Integer.parseInt(String.valueOf(s.charAt(j))) % 2;
                    if((i1 == 0 && odd) || (i1 != 0 && !odd)){
                        boring = false;
                        break;

                    }
                    odd = !odd;
                }
                if(boring) numB++;
            }
            System.out.println("Case #"+(i+1)+": "+numB);
        }

    }

}
