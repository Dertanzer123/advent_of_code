package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ex_10 {
    int[][] map;
   ArrayList<ArrayList<position>> scores = new ArrayList<ArrayList<position>>();
    ex_10() throws Exception {
        String path = "src/inputs/day10.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        ArrayList<String> list = new ArrayList<String>();
        while ((line=br.readLine()) != null)
        {
            list.add(line);

        }
         map = new int[list.size()][list.get(0).length()];

        for(int i=0;i<list.size();i++)
        {
            int j=0;
            for(char c:list.get(i).toCharArray())
            {
                map[i][j]=Integer.parseInt(""+c);
                j++;
            }
        }
        for(int i=0;i<map.length;i++)
        {
            for(int j=0;j<map[0].length;j++)
            {
            if(map[i][j]==0)
            {
                position origin=new position(i,j);

                ArrayList<position> newlist = new ArrayList<position>();
                newlist.add(origin);
                scores.add(newlist);
                deapsearch(i,j,origin);

            }

            }

        }
        int sum=0;
        for(ArrayList<position> iteratorlist:scores)
        {
            sum+=iteratorlist.size()-1;
        }
        System.out.println(sum);





    }
    void deapsearch(int x,int y,position origin)
    {
        if(map[x][y]==9)
        {
//            if(scores.get(findindex(origin)).contains(new position(x,y)))
//            {
//                return;
//            }
            scores.get(findindex(origin)).add(new position(x,y));

            return;
        }
        else
        {
            if(x>0&&map[x][y]+1==map[x-1][y])
            {
                deapsearch(x-1,y,origin);
            }
            if(x<map.length-1&&map[x][y]+1==map[x+1][y])
            {
                deapsearch(x+1,y,origin);
            }
            if(y>0&&map[x][y]+1==map[x][y-1])
            {
                deapsearch(x,y-1,origin);
            }
            if(y<map[0].length-1&&map[x][y]+1==map[x][y+1])
            {
                deapsearch(x,y+1,origin);
            }
        }



    }
    int findindex(position origin)
    {
        for(int i=0;i<scores.size();i++)
        {
            if(scores.get(i).contains(origin))
            {
                return i;
            }//origins are positions of 0s so they cant be found on the list other than first index they are kind of a key to list other indexes are the positions of the 9s

        }
       return -1;
    }
    class position
    {

       public int x;
       public int y;
       public position(int x,int y)
       {
           this.x=x;
           this.y=y;
       }
       @Override
       public boolean equals(Object o)
        {
            if(o instanceof position)
            {
                position p=(position)o;
                return p.x==x&&p.y==y;
            }
            return false;
        }
    }
}
