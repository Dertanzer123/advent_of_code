package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ex_5 {
    ArrayList<Integer>[] list =new ArrayList[100];
    int[] realvalid =new int[100];

    ex_5() throws IOException {
      BufferedReader  br= new BufferedReader(new FileReader(""));

      String line;
      int sum=0;
      int sum2=0;

      for (int i=0;i<100;i++)
      {
          list[i]=new ArrayList<Integer>();
      }

      while ((line=br.readLine()).length()!=0)
      {
        int a=Integer.parseInt(line.substring(0,2));
        int b=Integer.parseInt(line.substring(3));

            list[a].add(b);



      }
    //infinite loop// constructvalid();
      int[] b;
      while ((line=br.readLine())!=null)
      {int i=0;
          b=new int[line.split(",").length];
        for ( String a : line.split(","))
        {
            b[i]=Integer.parseInt(a);
            i++;

        }
        if (isvalid(b))
        {

           sum+=b[(b.length/2)];
        }
        else
        {
            for ( int k:returnvalid(b))
            {
                System.out.print(k+" ");
            }
            System.out.println(returnvalid(b)[(b.length/2)]);
            sum2+=returnvalid(b)[(b.length/2)];
        }
        }
      System.out.println(sum);
      System.out.println(sum2);



      }
      void constructvalid()
      {
          int a =0;
          for (int i=0;i<100;i++)
              {
                    realvalid[i]=i;
              }



          while (true)
          {boolean flag=false;
          for (int i=0;i<realvalid.length-1;i++)
          {
              if(list[realvalid[realvalid.length-1]].isEmpty())
              {
                  int m=realvalid[realvalid.length-1];
                  for (int j=realvalid.length-1;j>0;j--)
                  {
                      realvalid[j]=realvalid[j-1];
                  }
                  realvalid[0]=m;
              }
              if(list[realvalid[realvalid.length-1]].contains(realvalid[i]))
              {
                  a=realvalid[realvalid.length-1];
                  realvalid[realvalid.length-1]=realvalid[i];
                  realvalid[i]=a;
                  flag=true;
                  break;
              }

          }
          if (!flag) break;

          }
      }
    boolean isvalid(int[] b)
    {
        for (int j=0;j<b.length;j++)
        {
            for (int k=j+1;k<b.length;k++)
            {
                if (list[b[k]].contains(b[j]))
                {
                    //return false
                return false;
                }

            }
        }
        return true;
    }
    int[] returnvalid(int[] b)
    {
        int[] out=new int[b.length];
        for (int i=0;i<b.length;i++)
        {
            out[i]=b[i];
        }
        int c=0;
        while (!isvalid(out)) {
            for (int i = b.length - 1; i > 0; i--) {

                if (list[out[i]].contains(out[i - 1])) {
                    c = out[i];
                    out[i] = out[i - 1];
                    out[i - 1] = c;
                }

            }
        }

        return out;
    }









}
