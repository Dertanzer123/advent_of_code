package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ex_20 {

        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        int currentX = 0;
        int currentY = 0;

        int width = 0;
        int height = 0;
        ArrayList<int[]> map = new ArrayList<>();
    ex_20() throws IOException {

        String path = "src/inputs/day20.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line;
        int y = 0;
        while ((line = reader.readLine()) != null) {
                int[] stipt = new int[line.length()];
                int i = 0;
                if (line.contains("E"))
                {
                    endX = line.indexOf("E");
                    endY = y;
                }
                if (line.contains("S"))
                {
                    startX = line.indexOf("S");
                    startY = y;
                }
            for (char c : line.toCharArray()) {
                if (c == '#') {
                    stipt[i] = -1;
                }
                else
                {
                    stipt[i] = -2;
                }

                i++;
            }
            map.add(stipt);
            y++;

        }
        width = map.get(0).length;
        height = map.size();
        reader.close();

        map.get(endY)[endX] = 0;

        currentX = endX;
        currentY = endY;

        while (currentX != startX || currentY != startY) {
           if( currentX>0&&map.get(currentY)[currentX-1]==-2)
           {
                map.get(currentY)[currentX-1] = map.get(currentY)[currentX]+1;
                currentX--;

           }
           else if(currentX<width-1&&map.get(currentY)[currentX+1]==-2)
           {
                map.get(currentY)[currentX+1] = map.get(currentY)[currentX]+1;
                currentX++;
           }
           else if(currentY>0&&map.get(currentY-1)[currentX]==-2)
           {
                map.get(currentY-1)[currentX] = map.get(currentY)[currentX]+1;
                currentY--;

           }
           else if(currentY<height-1&&map.get(currentY+1)[currentX]==-2)
           {
                map.get(currentY+1)[currentX] = map.get(currentY)[currentX]+1;
                currentY++;
           }

        }

        int filternumero=100;

        System.out.println(goodCheatNumber20p(filternumero));


//        System.out.println(map.get(startY)[startX]);
//        for(int[] i:map)
//        {
//            for(int j:i)
//            {
//               if(j==-1)
//               {
//                   System.out.print("##");
//               }
//               else if(j==-2)
//               {
//                   System.out.print("..");
//               }
//               else
//               {
//                   if(j<10)
//                   {
//                       System.out.print("_");
//                   }
//                   System.out.print(j);
//
//               }
//            }
//            System.out.println();
//        }







    }
    long goodCheatNumber20p(int filternumero)
    {
        long desantCheatNumero=0;
        while (currentX != endX || currentY != endY)
        {
            for(int i=2;i<=20;i++)
            {
                int dx=i;
                int dy=0;
                for(int k=0;k<i;k++)
                {

                    if(currentX+dx<width&&currentX+dx>=0&&currentY+dy<height&&currentY+dy>=0&&map.get(currentY+dy)[currentX+dx]!=-1&&map.get(currentY)[currentX]-map.get(currentY+dy)[currentX+dx]>=filternumero+i)
                    {
                        desantCheatNumero++;
                    }
                    dx--;
                    dy++;
                }
                for(int k=0;k<i;k++)
                {

                    if(currentX+dx<width&&currentX+dx>=0&&currentY+dy<height&&currentY+dy>=0&&map.get(currentY+dy)[currentX+dx]!=-1&&map.get(currentY)[currentX]-map.get(currentY+dy)[currentX+dx]>=filternumero+i)
                    {
                        desantCheatNumero++;
                    }
                    dx--;
                    dy--;
                }
                for(int k=0;k<i;k++)
                {

                    if(currentX+dx<width&&currentX+dx>=0&&currentY+dy<height&&currentY+dy>=0&&map.get(currentY+dy)[currentX+dx]!=-1&&map.get(currentY)[currentX]-map.get(currentY+dy)[currentX+dx]>=filternumero+i)
                    {
                        desantCheatNumero++;
                    }
                    dx++;
                    dy--;
                }
                for(int k=0;k<i;k++)
                {

                    if(currentX+dx<width&&currentX+dx>=0&&currentY+dy<height&&currentY+dy>=0&&map.get(currentY+dy)[currentX+dx]!=-1&&map.get(currentY)[currentX]-map.get(currentY+dy)[currentX+dx]>=filternumero+i)
                    {
                        desantCheatNumero++;
                    }
                    dx++;
                    dy++;
                }




            }
            if( currentX>0&&map.get(currentY)[currentX-1]!=-1&&map.get(currentY)[currentX-1]<map.get(currentY)[currentX])
            {

                currentX--;

            }
            else if(currentX<width-1&&map.get(currentY)[currentX+1]!=-1&&map.get(currentY)[currentX+1]<map.get(currentY)[currentX])
            {

                currentX++;
            }
            else if(currentY>0&&map.get(currentY-1)[currentX]!=-1&&map.get(currentY-1)[currentX]<map.get(currentY)[currentX])
            {

                currentY--;

            }
            else if(currentY<height-1&&map.get(currentY+1)[currentX]!=-1&&map.get(currentY+1)[currentX]<map.get(currentY)[currentX])
            {

                currentY++;
            }
        }
        return desantCheatNumero;
    }
    int goodCheatNumber2p(int filternumero)
    {
        int desantCheatNumero=0;
        while (currentX != endX || currentY != endY)
        {
            if(currentX>1&&map.get(currentY)[currentX-2]!=-1&&map.get(currentY)[currentX]- map.get(currentY)[currentX-2]>=filternumero+2)
            { desantCheatNumero++; }

            if(currentX<width-2&&map.get(currentY)[currentX+2]!=-1&&map.get(currentY)[currentX]-map.get(currentY)[currentX+2]>=filternumero+2)
            {      desantCheatNumero++;}
            if(currentY>1&&map.get(currentY-2)[currentX]!=-1&&map.get(currentY)[currentX]-map.get(currentY-2)[currentX]>=filternumero+2)
            {      desantCheatNumero++;}
            if(currentY<height-2&&map.get(currentY+2)[currentX]!=-1&&map.get(currentY)[currentX]-map.get(currentY+2)[currentX]>=filternumero+2)
            {      desantCheatNumero++;}

            if(currentX>0&&currentY>0&&map.get(currentY-1)[currentX-1]!=-1&&map.get(currentY)[currentX]- map.get(currentY-1)[currentX-1]>=filternumero+2)
            {  desantCheatNumero++;  }

            if(currentX<width-1&&currentY>0&&map.get(currentY-1)[currentX+1]!=-1&&map.get(currentY)[currentX]-map.get(currentY-1)[currentX+1]>=filternumero+2)
            {      desantCheatNumero++;}

            if(currentY<height-1&&currentX>0&&map.get(currentY+1)[currentX-1]!=-1&&map.get(currentY)[currentX]-map.get(currentY+1)[currentX-1]>=filternumero+2)
            {      desantCheatNumero++;}
            if(currentY<height-1&&currentX<width-1&&map.get(currentY+1)[currentX+1]!=-1&&map.get(currentY)[currentX]-map.get(currentY+1)[currentX+1]>=filternumero+2)
            {      desantCheatNumero++;}

            if( currentX>0&&map.get(currentY)[currentX-1]!=-1&&map.get(currentY)[currentX-1]<map.get(currentY)[currentX])
            {

                currentX--;

            }
            else if(currentX<width-1&&map.get(currentY)[currentX+1]!=-1&&map.get(currentY)[currentX+1]<map.get(currentY)[currentX])
            {

                currentX++;
            }
            else if(currentY>0&&map.get(currentY-1)[currentX]!=-1&&map.get(currentY-1)[currentX]<map.get(currentY)[currentX])
            {

                currentY--;

            }
            else if(currentY<height-1&&map.get(currentY+1)[currentX]!=-1&&map.get(currentY+1)[currentX]<map.get(currentY)[currentX])
            {

                currentY++;
            }
        }
        return desantCheatNumero;
    }



}
