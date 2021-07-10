import java.io.*;
import java.net.*;
import java.lang.System.*;
import java.nio.charset.Charset;
import java.util.Iterator;

import org.json.*;


public class DatabaseTest {

    public static void main(String[] args) throws JSONException, IOException{
        URL url2 = new URL("https://services.arcgis.com/KTcxiTD9dsQw4r7Z/arcgis/rest/services/TxDOT_Speed_Limits/FeatureServer/0/query?where=1%3D1&outFields=*&outSR=4326&f=json");
        JSONObject jsonTest = getTxDotValues(url2);
        JSONArray features = jsonTest.getJSONArray("features");
        for(int i = 0; i<features.length(); i++){
            JSONObject attributes = features.getJSONObject(0).getJSONObject("attributes");
            String y = attributes.getString("RTE_NM");
            System.out.println(y);
            if(y.equals("SH0099-KG")){
                System.out.println(attributes.toString());
            }
        }
    }

    public static JSONObject getTxDotValues(URL url1) throws IOException, JSONException {
        InputStream stream1 = url1.openStream();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(stream1, Charset.forName("UTF-8")));
            String readed = readAll(br);
            JSONObject jsonObject1 = new JSONObject(readed);
            return jsonObject1;
        }finally {
            stream1.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }


}
