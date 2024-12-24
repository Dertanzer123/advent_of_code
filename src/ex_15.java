package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

public class ex_15 {
    int positionx=0;
    int positiony=0;
        ArrayList<char[]> map = new ArrayList<char[]>();
    ex_15() throws Exception {
        String path = "src/inputs/day15.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));

        String line;

        int linecount=0;
        while(!Objects.equals(line = br.readLine(), ""))
        {
            line=line.replaceAll("\\.","..");
            line=line.replaceAll("O","[]");
            line=line.replaceAll("#","##");
            if(line.contains("@"))
            {
                line=line.replaceAll("@","@.");
               positionx=line.indexOf("@");
               positiony=linecount;
            }
            map.add(line.toCharArray());
            linecount++;
            System.out.println(line);
        }
        System.out.println(positionx+" "+positiony);
        System.out.println(map.get(positiony)[positionx]);

        while((line = br.readLine()) != null)
        {
            for(char c:line.toCharArray())
            {
            move2(c);
            System.out.println(c);
           // print();
            }
        }
        long sum=0;
        for(int i=0;i<map.size();i++)
        {
            for(int j=0;j<map.get(i).length;j++)
            {

                if(map.get(i)[j]=='[')
                {
                    sum+=i* 100L +j;
                }
            }

        }
        System.out.println(sum);
        print();



    }
    void print()
    {
        for(int i=0;i<map.size();i++)
        {
            for(int j=0;j<map.get(i).length;j++)
            {
                System.out.print(map.get(i)[j]);
            }
            System.out.println();
        }
    }
    void move2(char c)
    {
        map.get(positiony)[positionx]='.';
        switch (c)
        {
            case '>':
                if(map.get(positiony)[positionx+1]=='.')
                {
                    positionx++;
                }
                else if(map.get(positiony)[positionx+1]=='[')
                {

                    if(isPushable(positionx+1,positiony,'>'))
                    {
                        push2(positionx+1,positiony,'>');
                        positionx++;
                    }

                }
                else
                {

                }
                break;
            case '<':
                if(map.get(positiony)[positionx-1]=='.')
                {
                    positionx--;
                }
                else if(map.get(positiony)[positionx-1]==']')
                {

                    if(isPushable(positionx-1,positiony,'<'))
                    {
                        push2(positionx-1,positiony,'<');
                        positionx--;
                    }

                }
                else
                {



                }
                break;
            case '^':
                if(map.get(positiony-1)[positionx]=='.')
                {
                    positiony--;
                }
                else if(map.get(positiony-1)[positionx]=='['||map.get(positiony-1)[positionx]==']')
                {

                    if(isPushable(positionx,positiony-1,'^'))
                    {
                        push2(positionx,positiony-1,'^');
                        positiony--;
                    }

                }
                else
                {}
                break;
            case 'v':
                if(map.get(positiony+1)[positionx]=='.')
                {
                    positiony++;
                }
                else if(map.get(positiony+1)[positionx]=='['||map.get(positiony+1)[positionx]==']')
                {

                    if(isPushable(positionx,positiony+1,'v'))
                    {
                        push2(positionx,positiony+1,'v');
                        positiony++;
                    }

                }
                else
                {}
                break;
        }
        map.get(positiony)[positionx]='@';
    }
    void move(char c)
    {
        map.get(positiony)[positionx]='.';
        switch (c)
        {
            case '>':
                if(map.get(positiony)[positionx+1]=='.')
                {
                    positionx++;
                }
                else if(map.get(positiony)[positionx+1]=='O')
                {
                    if(push(positionx+1,positiony,'>'))
                    {
                    positionx++;
                    }
                }
                else
                {

                }
                break;
            case '<':
                if(map.get(positiony)[positionx-1]=='.')
                {
                    positionx--;
                }
                else if(map.get(positiony)[positionx-1]=='O')
                {
                    if(push(positionx-1,positiony,'<'))
                    {
                    positionx--;
                    }
                }
                else
                {



                }
                break;
            case '^':
                if(map.get(positiony-1)[positionx]=='.')
                {
                    positiony--;
                }
                else if(map.get(positiony-1)[positionx]=='O')
                {
                    if(push(positionx,positiony-1,'^'))
                    {
                    positiony--;
                    }
                }
                else
                {}
                break;
            case 'v':
                if(map.get(positiony+1)[positionx]=='.')
                {
                    positiony++;
                }
                else if(map.get(positiony+1)[positionx]=='O')
                {
                    if(push(positionx,positiony+1,'v'))
                    {
                    positiony++;
                    }
                }
                else
                {}
                break;
        }
        map.get(positiony)[positionx]='@';
    }
    boolean push2(int x,int y,char c)
    {
        if(map.get(y)[x]=='.')
        {
            return true;
        }
        else if(map.get(y)[x]==']')
        {
            switch (c)
            {
                case '>':
                    if(push2(x+1,y,'>'))
                    {
                        map.get(y)[x+1]=map.get(y)[x];
                        map.get(y)[x]='.';
                        return true;
                    }


                case '<':

                    if(push2(x-1,y,'<'))
                    {
                        map.get(y)[x-1]=map.get(y)[x];
                        map.get(y)[x]='.';
                        return true;
                    }

                case 'v':
                    if(push2(x,y+1,'v')&&push2(x-1,y+1,'v'))
                    {
                        map.get(y+1)[x]=map.get(y)[x];
                        map.get(y+1)[x-1]=map.get(y)[x-1];
                        map.get(y)[x]='.';
                        map.get(y)[x-1]='.';
                        return true;
                    }


                case '^':
                    if(push2(x,y-1,'^')&&push2(x-1,y-1,'^'))
                    {
                        map.get(y-1)[x]=map.get(y)[x];
                        map.get(y-1)[x-1]=map.get(y)[x-1];
                        map.get(y)[x]='.';
                        map.get(y)[x-1]='.';
                        return true;
                    }

            }
        }
        else if(map.get(y)[x]=='[')
        {
            switch (c) {
                case '>':
                    if (push2(x + 1, y, '>')) {
                        map.get(y)[x + 1] = map.get(y)[x];
                        map.get(y)[x] = '.';
                        return true;
                    }


                case '<':
                    if (push2(x - 1, y, '<')) {
                        map.get(y)[x - 1] = map.get(y)[x];
                        map.get(y)[x] = '.';
                        return true;
                    }

                case 'v':
                    if (push2(x, y + 1, 'v') && push2(x + 1, y + 1, 'v')) {
                        map.get(y + 1)[x] = map.get(y)[x];
                        map.get(y + 1)[x + 1] = map.get(y)[x + 1];
                        map.get(y)[x] = '.';
                        map.get(y)[x + 1] = '.';
                        return true;
                    }


                case '^':
                    if (push2(x, y - 1, '^') && push2(x + 1, y - 1, '^')) {
                        map.get(y - 1)[x] = map.get(y)[x];
                        map.get(y - 1)[x + 1] = map.get(y)[x + 1];
                        map.get(y)[x] = '.';
                        map.get(y)[x + 1] = '.';
                        return true;
                    }
            }
        }

        return false;
    }

    boolean isPushable(int x,int y,char c)
    {
        if(map.get(y)[x]=='.')
        {
            return true;
        }
        else if(map.get(y)[x]==']')
        {
            switch (c) {

                case '>':
                    return isPushable(x+1,y,'>');


                    case '<':
                    return isPushable(x-1,y,'<');


                    case 'v':
                    return isPushable(x,y+1,'v')&&isPushable(x-1,y+1,'v');


                    case '^':
                    return isPushable(x,y-1,'^')&&isPushable(x-1,y-1,'^');


            }
        }
        else if(map.get(y)[x]=='[')
        {
            switch (c)
            {
                case '>':
                    return isPushable(x+1,y,'>');


                case '<':
                return isPushable(x-1,y,'<');


                case 'v':
                return isPushable(x,y+1,'v')&&isPushable(x+1,y+1,'v');


                case '^':
                return isPushable(x,y-1,'^')&&isPushable(x+1,y-1,'^');

            }
        }
        return false;


    }

    boolean push(int x,int y,char c)
    {
        switch (c)
        {
            case '>':
                if(map.get(y)[x+1]=='.')
                {

                    map.get(y)[x+1] = 'O';
                    map.get(y)[x] = '.';
                    return true;
                }
                else if(map.get(y)[x+1]=='O')
                {
                    if(push(x+1,y,'>'))
                    {
                        map.get(y)[x+1] = 'O';
                        map.get(y)[x] = '.';
                        return true;
                    }
                }
                else
                {
                return false;
                }
                break;
            case '<':
                if(map.get(y)[x-1]=='.')
                {

                    map.get(y)[x-1] = 'O';
                    map.get(y)[x] = '.';
                    return true;
                }
                else if(map.get(y)[x-1]=='O')
                {
                    if(push(x-1,y,'<'))
                    {
                        map.get(y)[x-1] = 'O';
                        map.get(y)[x] = '.';
                        return true;
                    }
                }
                else
                {

                    return false;
                }
                break;
            case '^':
                if(map.get(y-1)[x]=='.')
                {

                    map.get(y-1)[x] = 'O';
                    map.get(y)[x] = '.';
                    return true;
                }
                else if(map.get(y-1)[x]=='O')
                {
                    if(push(x,y-1,'^'))
                    {
                        map.get(y-1)[x] = 'O';
                        map.get(y)[x] = '.';
                        return true;
                    }
                }
                else
                {

                    return false;
                }
                break;
            case 'v':
                if (map.get(y+1)[x]=='.')
                {

                    map.get(y+1)[x] = 'O';
                    map.get(y)[x] = '.';
                    return true;
                }
                else if (map.get(y+1)[x]=='O')
                {
                    if(push(x,y+1,'v'))
                    {
                        map.get(y+1)[x] = 'O';
                        map.get(y)[x] = '.';
                        return true;
                    }
                }
                else
                {
                  //  System.out.println("false");
                    return false;
                }
                break;
        }
        return false;
    }

}
