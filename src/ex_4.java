package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ex_4 {

    ex_4() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(""));

        String line;
        int sum=0;
        int x;
        int y=0;
        String[] map = new String[140];
        while ((line = br.readLine()) != null) {
            map[y] = line;

        y++;
        }
        for(y=0;y<map.length;y++)
        {
         for(x=0;x<map[y].length();x++)
         {
             if(map[y].charAt(x)=='A')
             {
                 try {
                 if(map[y-1].charAt(x-1)=='M'&&map[y+1].charAt(x+1)=='S'&&map[y-1].charAt(x+1)=='M'&&map[y+1].charAt(x-1)=='S')
                 {
                     sum++;
                 }}
                 catch (Exception e)
                 {}
                 try {
                     if(map[y-1].charAt(x-1)=='M'&&map[y+1].charAt(x+1)=='S'&&map[y-1].charAt(x+1)=='S'&&map[y+1].charAt(x-1)=='M')
                     {
                         sum++;
                     }}
                 catch (Exception e)
                 {}
                 try {
                     if(map[y-1].charAt(x-1)=='S'&&map[y+1].charAt(x+1)=='M'&&map[y-1].charAt(x+1)=='M'&&map[y+1].charAt(x-1)=='S')
                     {
                         sum++;
                     }}
                 catch (Exception e)
                 {}
                 try {
                     if(map[y-1].charAt(x-1)=='S'&&map[y+1].charAt(x+1)=='M'&&map[y-1].charAt(x+1)=='S'&&map[y+1].charAt(x-1)=='M')
                     {
                         sum++;
                     }}
                 catch (Exception e)
                 {}


//                 try {
//                 if(map[y].charAt(x+1)=='M'&&map[y].charAt(x+2)=='A'&&map[y].charAt(x+3)=='S')
//                 {
//                        sum++;
//                 }}
//                 catch (Exception e)
//                 {
//
//                 }
//                 try {
//                 if(map[y].charAt(x-1)=='M'&&map[y].charAt(x-2)=='A'&&map[y].charAt(x-3)=='S')
//                 {sum++;
//
//                 }}
//                 catch (Exception e)
//                 {
//
//                 }
//                 try {
//                 if(map[y+1].charAt(x)=='M'&&map[y+2].charAt(x)=='A'&&map[y+3].charAt(x)=='S')
//                 {sum++;
//
//                 }}
//                 catch (Exception e)
//                 {
//
//                 }
//                 try {
//                 if(map[y-1].charAt(x)=='M'&&map[y-2].charAt(x)=='A'&&map[y-3].charAt(x)=='S')
//                 {sum++;
//                 }}
//                 catch (Exception e)
//                 {
//
//                 }
//                 try {
//
//                 if(map[y+1].charAt(x+1)=='M'&&map[y+2].charAt(x+2)=='A'&&map[y+3].charAt(x+3)=='S')
//                 {sum++;
//
//                 }}
//                 catch (Exception e)
//                 {
//
//                 }
//                 try {
//                 if(map[y-1].charAt(x-1)=='M'&&map[y-2].charAt(x-2)=='A'&&map[y-3].charAt(x-3)=='S')
//                 {sum++;
//
//                 }}
//                 catch (Exception e)
//                 {
//
//                 }
//                 try {
//                 if(map[y+1].charAt(x-1)=='M'&&map[y+2].charAt(x-2)=='A'&&map[y+3].charAt(x-3)=='S')
//                 {sum++;
//
//                 }}
//                 catch (Exception e)
//                 {
//
//                 }
//                 try {
//                 if(map[y-1].charAt(x+1)=='M'&&map[y-2].charAt(x+2)=='A'&&map[y-3].charAt(x+3)=='S')
//                 {sum++;
//                 }}
//                 catch (Exception e)
//                 {
//
//                 }




             }
         }
        }


        System.out.println(sum);













    }






}
