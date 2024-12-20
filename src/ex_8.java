package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ex_8 {


    ex_8() throws Exception {
     String path = "src/inputs/day8.txt";
     BufferedReader br = new BufferedReader(new FileReader(path));

        String line;
        int sum=0;
        Boolean[][] antinodes;
        ArrayList<String> list=new ArrayList<String>();
        while ((line = br.readLine()) != null) {
            list.add(line);

        }
        antinodes=new Boolean[list.size()][list.get(0).length()];
        ArrayList<antenalist> antennas=new ArrayList<antenalist>();


        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.get(i).length();j++)
            {
                if(list.get(i).charAt(j)!='.')
                {boolean flag=false;
                    for(int k=0;k<antennas.size();k++)
                    {

                        if(list.get(i).charAt(j)==(antennas.get(k).getName()))
                        {
                            antennas.get(k).add(new position(i,j));
                            flag=true;
                            break;
                        }

                    }
                    if(!flag)
                    {
                        antennas.add(new antenalist(list.get(i).charAt(j)));
                        antennas.get(antennas.size()-1).add(new position(i,j));
                    }


                }

            }
        }
        for(int i=0;i<antennas.size();i++)
        {
            for (int j = 0; j < antennas.get(i).size(); j++) {
                for (int k = j + 1; k < antennas.get(i).size(); k++) {
                    int dx = antennas.get(i).get(j).x - antennas.get(i).get(k).x;
                    int dy = antennas.get(i).get(j).y - antennas.get(i).get(k).y;
                    int factor = 0;
                    while (0<=antennas.get(i).get(j).x + dx*factor&&antennas.get(i).get(j).x + dx*factor < antinodes[0].length && 0<=antennas.get(i).get(j).y + dy*factor&&antennas.get(i).get(j).y + dy*factor < antinodes.length)
                    {       antinodes[antennas.get(i).get(j).x + dx*factor][antennas.get(i).get(j).y + dy*factor] = true;
                    factor++;
                    }

                    factor = 0;
                    while (0<=antennas.get(i).get(k).x - dx*factor&&antennas.get(i).get(k).x - dx*factor < antinodes[0].length && 0<=antennas.get(i).get(k).y - dy*factor&&antennas.get(i).get(k).y - dy*factor < antinodes.length) {
                        antinodes[antennas.get(i).get(k).x - dx*factor][antennas.get(i).get(k).y - dy*factor] = true;
                        factor++;
                    }
                }
            }
        }


        for(int i=0;i<antinodes.length;i++)
         {
             for(int j=0;j<antinodes[i].length;j++)
             {
                 if(antinodes[i][j]!=null&&antinodes[i][j])
                 {
                     System.out.print("#");
                     sum++;
                 }
                 else
                 {
                     System.out.print(".");
                 }
             }
             System.out.println();
         }
        System.out.println(sum);

    }
    class antenalist extends ArrayList<position>
    {
        private Character Name;
        antenalist(Character Name)
        {this.Name=Name;

        }
        public Character getName()
        {
            return Name;
        }

    }
    class position
        {
            int x;
            int y;
            position(int x, int y)
            {
                this.x=x;
                this.y=y;
            }
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                position position = (position) obj;
                return x == position.x && y == position.y;
            }

        }



}
