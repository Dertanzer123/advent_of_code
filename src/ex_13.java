package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ex_13 {


    ex_13() throws IOException, IOException {

        String path = "src/inputs/day13.txt";

         BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        String[] data = new String[3];

        long total=0;
        float maxdistance=0.00001f;
        while((line = br.readLine()) != null) {
            for (int i = 0; i < 3; i++) {
                data[i] = line;
                line = br.readLine();
            }

                    int n1=Integer.parseInt(data[0].split(",")[0].substring(12));
            int n2=Integer.parseInt(data[1].split(",")[0].substring(12));
            long c1=Integer.parseInt(data[2].split(",")[0].substring(9))+ 10000000000000L;
            int n3=Integer.parseInt(data[0].split(",")[1].substring(3));
            int n4=Integer.parseInt(data[1].split(",")[1].substring(3));
            long c2=Integer.parseInt(data[2].split(",")[1].substring(3))+10000000000000L ;

//            int B= (int)Math.ceil((buttonattribute[0][0]*buttonattribute[2][1]-buttonattribute[1][0]*buttonattribute[2][0])/(buttonattribute[0][0]*buttonattribute[1][1]-buttonattribute[0][1]*buttonattribute[1][0]));
           double B = (double) (c2 * n1 - c1 * n3) /(n4*n1-n2*n3);

           if(Math.abs(B-Math.round(B))<=maxdistance)
            {
            double A=(c1-B*n2)/n1;

            if(Math.abs(A-Math.round(A))<=maxdistance)
            {

                total+=3*Math.round(A)+Math.round(B);

            }


            }

        }



        System.out.println(total);

        br.close();
    }
}
