package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ex_12 {

        ArrayList<String> map = new ArrayList<>();
        ArrayList<Field> fields = new ArrayList<>();
        boolean[][] visited ;

        ex_12() throws IOException {
        String path = "src/inputs/day12.txt";

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while((line = br.readLine()) != null) {

            map.add(line);
        }
        br.close();
        visited = new boolean[map.size()][map.get(0).length()];

        for(int i = 0; i < map.size(); i++) {
            for(int j = 0; j < map.get(0).length(); j++) {


                    calculatefield(new position(j,i));

            }

        }
        int pricesum = 0;
        for(Field f : fields) {
            System.out.println(f.getConjucatedSideNumber());
            pricesum += (f.getConjucatedSideNumber()*f.positions.size());



        }
        System.out.println(pricesum);



    }

    void calculatefield(position p)
    {
        if(visited[p.y][p.x])
            return;



        fields.add(new Field(map.get(p.y).charAt(p.x)));
        managePosition(p);


    }
    void managePosition(position p)
    {
        if((!visited[p.y][p.x])&&fields.get(fields.size()-1).name == map.get(p.y).charAt(p.x))
        {
            fields.get(fields.size()-1).addPosition(p);
            visited[p.y][p.x] = true;
            if(p.x > 0&&map.get(p.y).charAt(p.x-1)==map.get(p.y).charAt(p.x))
            {
                managePosition(new position(p.x - 1, p.y));
            }
            else
            {
                fields.get(fields.size()-1).sides.add(new side(p.x, p.y, direction.vertical) );
            }
            if(p.x < map.get(0).length()-1&&map.get(p.y).charAt(p.x+1)==map.get(p.y).charAt(p.x))
            {
                managePosition(new position(p.x+1,p.y));
            }
            else
            {
                fields.get(fields.size()-1).sides.add(new side(p.x+1, p.y, direction.vertical) );
            }
            if(p.y > 0&&map.get(p.y-1).charAt(p.x)==map.get(p.y).charAt(p.x))
            {
                managePosition(new position(p.x, p.y - 1));
            }
            else
            {
                fields.get(fields.size()-1).sides.add(new side(p.x, p.y, direction.horizontal) );
            }
            if(p.y < map.size()-1&&map.get(p.y+1).charAt(p.x)==map.get(p.y).charAt(p.x))
            {
                managePosition(new position(p.x,p.y+1));
            }
            else
            {
                fields.get(fields.size()-1).sides.add(new side(p.x, p.y+1, direction.horizontal) );
            }
        }

        else
        {



            return;
        }
    }


    class Field
    {
        char name;

        ArrayList<position> positions = new ArrayList<>();
        ArrayList<side> sides = new ArrayList<>();

        Field(char name)
        {
            this.name = name;


        }
        void addPosition(position p)
        {
            positions.add(p);
        }
        int getConjucatedSideNumber()
        {
            ArrayList<side> sides1 = new ArrayList<>(sides);
                int conjugated = 0;
            while(!sides1.isEmpty())
            {
                side s = sides1.get(0);
                conjugated++;
                sides1.remove(0);
                int index=0;
                while(index < sides1.size())
                {
                    if(sides1.get(index).isConjugated(s)&&getSideParentingPosition(s).isConjugated(getSideParentingPosition(sides1.get(index)))) {
                        sides1 = deleteConjugatedSides(sides1, sides1.get(index));
                        index=0;

                    }
                    else
                    {
                        index++;
                    }
                }


            }


            return conjugated;
        }
        ArrayList<side> deleteConjugatedSides(ArrayList<side> sides , side s)
        {
            ArrayList<side> newSides = new ArrayList<>(sides);
            int index = 0;
            newSides.remove(s);
            while(!newSides.isEmpty()&&index < newSides.size())
            {
                if(newSides.get(index).isConjugated(s)&&getSideParentingPosition(s).isConjugated(getSideParentingPosition(newSides.get(index))))
                {
                    newSides=deleteConjugatedSides(newSides,newSides.get(index));
                }
                else
                {
                    index++;
                }

            }

            return newSides;
        }
        position getSideParentingPosition(side s)
        {
            if(s.dir == direction.horizontal)
            {
               if(s.y ==0)
               {
                   return new position(s.x,0);
               }
               else
               {
                   if(map.get(s.y-1).charAt(s.x)==name)
                   {
                       return new position(s.x,s.y-1);
                   }
                   else
                   {
                       return new position(s.x,s.y);
                   }
               }
            }
                else
            {
                if(s.x ==0)
                {
                    return new position(0,s.y);
                }
                else
                {
                    if(map.get(s.y).charAt(s.x-1)==name)
                    {
                        return new position(s.x-1,s.y);
                    }
                    else
                    {
                        return new position(s.x,s.y);
                    }
                }

            }
        }

    }


    class position
    {
        int x;
        int y;
        position(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o)
        {
            if(o instanceof position)
            {
                position p = (position)o;
                return p.x == x && p.y == y;
            }
            return false;
        }
        public boolean isConjugated(position p)
        {
            return (p.x == x+1 && p.y == y)||(p.x == x-1 && p.y == y )||(p.x == x && p.y == y+1)||(p.x == x && p.y == y-1);
        }
    }
    class side
    {
        int x;
        int y;
        direction dir;
        side(int x, int y, direction dir)
        {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
        @Override
        public boolean equals(Object o)
        {
            if(o instanceof side)
            {
                side s = (side)o;
                return s.x == x && s.y == y && s.dir == dir;
            }
            return false;
        }
        public boolean isInline(side s)
        {
            return s.dir==dir&&(s.x == x && s.y != y )||(s.x != x && s.y == y );
        }
        public boolean isConjugated(side s)
        {

                   boolean a= s.dir==dir&&((dir==direction.horizontal &&((s.x == x+1 && s.y == y )||(s.x == x-1 && s.y == y )))||((dir==direction.vertical&&((s.x == x && s.y == y+1 )||(s.x == x && s.y == y-1 )))));

                   return a;
        }
    }
    enum direction
    {
        horizontal,
        vertical
    }

}
