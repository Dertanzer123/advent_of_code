package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ex_2 {


    ex_2() throws IOException {
        String path = "";
        BufferedReader br = new BufferedReader(new FileReader(path));

        String line;

        int safe=0;
        while ((line = br.readLine()) != null) {
            if (isrealysafe(line)) {
             safe++;
            }
        }
        System.out.println(safe);

    }
    boolean isrealysafe(String line)
    {
        int[] a= new int[line.split(" ").length];
        for(int i=0;i<a.length;i++)
        {
            a[i]=Integer.parseInt(line.split(" ")[i]);
            System.out.print(a[i]+" ");
        }
        System.out.println();

        if(issafe2(a)){
            return true;
        }

        int[] b=new int[a.length-1];
        for (int i = 0; i < a.length; i++) {
        for(int j=0;j<i;j++)
        {
            b[j]=a[j];
        }
        for(int j=i;j<a.length-1;j++)
        {
            b[j]=a[j+1];
        }
        if(issafe2(b))
        {
            return true;
        }

        }
        return false;
    }
    boolean issafe2(int[]a)
    {


       boolean increase=false;
        if(a[0]>a[1])
        {
        increase=false;
        }
        else if(a[0]<a[1])
        {
            increase=true;
        }
        else
        {
            return false;
        }
        if(Math.abs( a[1]-a[0])>3)
        {
            return false;
        }

        for(int i=1;i<a.length-1;i++)
        {
            if(a[i]>a[i+1])
            {
            if(increase)
            {
                return false;
            }
            else
            {

            }
            }
            else if(a[i]<a[i+1])
            {
                if(increase) {

                }
                else{
                    return false;
                }
            }
            else
            {
                return false;
            }

            if(Math.abs( a[i]-a[i+1])>3)
            {
                return false;
            }

        }
        System.out.println(true);
        return true;



    }
    boolean issafe(String line)
    {
        boolean flag=false;
        boolean increase=false;
       String[] a= line.split(" ");

       for(int i=0;i<a.length-1;i++)
       {
           if(Integer.parseInt(a[i])>Integer.parseInt(a[i+1]))
           {if(!flag)
           {
               flag=true;
               increase=false;
           }
           else if(increase||Integer.parseInt(a[i])-3>Integer.parseInt(a[i+1]))
           {
               return false;
           }




           }
           else if(Integer.parseInt(a[i])<Integer.parseInt(a[i+1]))
           {
               if(!flag)
               {
                   flag=true;
                   increase=true;
               }
               else if(!increase||Integer.parseInt(a[i])+3<Integer.parseInt(a[i+1]))
               {
                   return false;
               }

           }
           else
           {
               return false;
           }
       }



        return true;
    }

}
