package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ex_3 {

    ex_3() throws IOException {
        String path = "";

        BufferedReader br = new BufferedReader(new FileReader(path));

        String line;

        boolean enebled=true;
        int sum=0;

        while ((line = br.readLine()) != null) {


         for(int i=0;i<line.length()-7;i++)
         {
             if(line.startsWith("do()", i))
             {
                enebled=true;
             }
             else if(line.startsWith("don't()", i))
             {
                    enebled=false;
             }
             else if(enebled&&line.startsWith("mul(", i))
             {
             for(int k=0;k<1;k++){
                int j=i+4;
                String a="";
                int x=0;

                while(isnumber(line.charAt(j))&&j<i+7)
                {
                    a+=line.charAt(j);
                    j++;
                }
                if(a.length()==0)
                {
                    //terminate

                        break;
                }
                else
                {
                    x=Integer.parseInt(a);
                }
                if(line.charAt(j)!=',')
                {
                    break;
                    //terminate
                }
                else
                {
                    j++;
                    a="";
                    while(isnumber(line.charAt(j))&&j<(i+9+Math.floor(Math.log(x))))
                    {
                        a+=line.charAt(j);
                        j++;
                    }
                    if(a.length()==0)
                    {
                        break;
                        //terminate
                    }
                    else
                    {
                        int y=Integer.parseInt(a);
                        if(line.charAt(j)==')')
                        {
                            sum+=x*y;
                        }
                        else
                        {break;
                            //terminate
                        }
                    }


                }




             }}
         }




        }
        System.out.println(sum);

    }
    boolean isnumber(String s)
    {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    boolean isnumber(char s)
    {
       String a = String.valueOf(s);
            return a.matches("[0-9]+");

    }


}
