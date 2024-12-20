package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class ex_7 {


    ex_7() throws IOException {
        BufferedReader br= new BufferedReader(new FileReader("src/inputs/day7.txt"));

        String line ;
        long a;
        long sum=0;
        ArrayList<Long> list=new ArrayList<Long>();
        while((line=br.readLine())!=null)
        {

         a =Long.parseLong( line.substring(0 ,line.indexOf(":")));
         for(String s:line.substring(line.indexOf(":")+2).split(" "))
         {
             list.add(Long.parseLong(s));


        }

         node n=new node(list.get(list.size()-1));
         node m=n;
         for(int i=list.size()-2;i>=0;i--)
         {
             m.setnext(new node(list.get(i)));
             m=m.next;
         }
         ArrayList<Long> solutions=solve(n);
         for(int i=0;i<solutions.size();i++)
         {
             if(solutions.get(i)==a)
             {
                 sum+=a;
                 break;
             }
         }


        list.clear();
    }
        System.out.println(sum);
    }
    ArrayList<Long> solve(node n)
    {
        ArrayList<Long> list=new ArrayList<Long>();
        if(n.next==null)
        {
            list.add(n.data);
            return list;
        }
        else
        {
            ArrayList<Long> pastsolutions= solve(n.next);
            for(int i=0;i<pastsolutions.size();i++)
            {
                list.add(n.data*pastsolutions.get(i));
                list.add(n.data+pastsolutions.get(i));
                list.add(Long.parseLong( pastsolutions.get(i)+""+n.data));

            }
            return list;
        }

    }
    class node
    {
        node next;
        long data;

        node(long data)
        {
            this.data=data;
            next=null;
        }
        void setnext(node n)
        {
            next=n;
        }
    }

}

