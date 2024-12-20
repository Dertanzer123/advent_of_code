package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ex_6 {

    ArrayList<char[]> map=new ArrayList<char[]>();

    int x=0;
    int y=0;
    int originx=0;
    int originy=0;
    Direction dir=Direction.north;
    HashMap<location,ArrayList<Direction>> states=new HashMap<location,ArrayList<Direction>>();


    ex_6() throws IOException {
        BufferedReader br= new BufferedReader(new FileReader(""));

        String line;
        int sum=0;

        while ((line=br.readLine())!=null)
        {
            map.add(line.toCharArray());
            if (line.contains("^"))
            {
                x =line.indexOf("^");

                break;
            }
            else
            {
                y++;
            }
        }
        originx=x;
        originy=y;
        while ((line=br.readLine())!=null)
        {

            map.add(line.toCharArray());
        }
        map.get(y)[x]='X';

        while(update(ismoove()))
        {

        }

        for (int i=0;i<map.size();i++)
        {
            for (int j=0;j<map.get(i).length;j++)
            {

                if(map.get(i)[j]=='X')
                {
                    sum++;


                }
            }


        }
        System.out.println(sum);
        int sumloops=0;
        for (int i=0;i<map.size();i++)
         {
          for (int j=0;j<map.get(i).length;j++)
          {
              if(i==originy && j==originx){}
              else if(map.get(i)[j]=='X')
              {
                  map.get(i)[j]='#';
                  x=originx;
                  y=originy;
                  dir =Direction.north;
                  if (checkloop())
                  {
                      sumloops++;
                  }

                  map.get(i)[j]='X';


              }

          }
         }
        System.out.println(sumloops);



    }
    boolean checkloop()
    {   states.clear();
        while (update(ismoove())){
        if(isloop())
        {
            return true;
        }
        }
        return false;
    }
    boolean isloop()
    {
    if (states.containsKey(new location(x,y)))
    {
        if (states.get(new location(x,y)).contains(dir))
        {
            return true;
        }
        else
        {
         states.get(new location(x,y)).add(dir);
            return false;
        }
    }
    else {
        states.put(new location(x, y), new ArrayList<Direction>(4));
        states.get(new location(x, y));
        if (dir==Direction.north)
        states.get(new location(x, y)).add(Direction.north);
        else if (dir==Direction.south)
        states.get(new location(x, y)).add(Direction.south);
        else if (dir==Direction.east)
        states.get(new location(x, y)).add(Direction.east);
        else if (dir==Direction.west)
        states.get(new location(x, y)).add(Direction.west);
        return false;
    }
    }
    boolean update(State s)
    {
        if (s==State.move)
        {
            if (dir==Direction.north)
            {
                y--;
            }
            else if (dir==Direction.south)
            {
                y++;
            }
            else if (dir==Direction.east)
            {
                x++;
            }
            else if (dir==Direction.west)
            {
                x--;
            }
            map.get(y)[x]='X';
            return true;
        }
        else if (s==State.rotate)
        {
           if (dir==Direction.north)
           {
               dir=Direction.east;
           }
           else if (dir==Direction.south)
           {
               dir=Direction.west;
           }
           else if (dir==Direction.east)
           {
               dir=Direction.south;
           }
           else if (dir==Direction.west)
           {
               dir=Direction.north;
           }
            return true;
        }

        else if (s==State.terminate)
        {

            return false;
        }
        return false;
    }

    State ismoove()
    {
        if (dir==Direction.north)
        {
           if (y>0)
           {
               if (map.get(y-1)[x]=='#')
               {
                   return State.rotate;
               }
               else
               {
                   return State.move;
               }
           }
           else {
               return State.terminate;
           }

        }
        else if (dir==Direction.south)
        {
            if (y<map.size()-1)
            {
                if (map.get(y+1)[x]=='#')
                {
                    return State.rotate;
                }
                else
                {
                    return State.move;
                }

            }
            else {
                return State.terminate;
            }
        }
        else if (dir==Direction.east)
        {
            if (x<map.get(y).length-1)
            {
                if (map.get(y)[x+1]=='#')
                {
                    return State.rotate;
                }
                else
                {
                    return State.move;
                }

            }
                else{
                    return State.terminate;
                }
        }
        else if (dir==Direction.west)
        {
            if (x>0)
            {
                if (map.get(y)[x-1]=='#')
                {
                    return State.rotate;
                }
                else
                {
                    return State.move;
                }

            }
                else
                {
                    return State.terminate;
                }
        }
        return State.terminate;
    }






class location
{
    int x;
    int y;
    location(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        location location = (location) obj;
        return x == location.x && y == location.y;
    }
    @Override
    public int hashCode() {
        return map.size()*x+y;
    }


}


}
enum State {
    terminate, move, rotate
}
enum Direction {

    north, south, east, west
}
