package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;

public class ex_19 {
    tree towels = new tree();
    int maxLength = 0;
    ex_19() throws Exception
    {
        String path="src/inputs/day19.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line;
        ArrayList<color> towel = new ArrayList<>();
        while (!Objects.equals(line = reader.readLine(), ""))
        {
            for(String s : line.split(", "))
            {
                if (s.length() > maxLength)
                {
                    maxLength = s.length();
                }
                for(char c : s.toCharArray())
                {

                    towel.add(color.valueOf(c));
                }
                towels.add(towel);

                towel.clear();
            }
        }
        int constructible = 0;
        while ((line = reader.readLine())!= null) {

            if (isConstructible(line))
            {
             constructible++;
            }
        }
        System.out.println(constructible);




    }


    boolean isConstructible(String line)
    {
        PriorityQueue<Integer> indexes = new PriorityQueue<>();
        for(int i=1;i<=maxLength;i++)
        {
            if(i>=line.length())
            {
                break;
            }
            ArrayList<color> newtowel = new ArrayList<>();
            for(char c :line.substring(0,i).toCharArray())
            {
                newtowel.add(color.valueOf(c));
            }
            if(towels.isPresent(newtowel))
            {
                indexes.add(i);
            }
            newtowel.clear();
        }
        if(indexes.isEmpty())
        {

        }
        else
        {
            while(!indexes.isEmpty()){
                if(indexes.peek()>line.length())
                {
                    indexes.clear();

                    return false;
                }
                int index = indexes.poll();
                while(!indexes.isEmpty()&&index==indexes.peek())
                {
                    indexes.poll();
                }


                for(int i=index+1;i<=index+maxLength;i++)
                {
                    if(i>line.length())
                    {
                        break;
                    }
                    ArrayList<color> newtowel = new ArrayList<>();
                    for(char c :line.substring(index,i).toCharArray())
                    {
                        newtowel.add(color.valueOf(c));
                    }
                    if(towels.isPresent(newtowel))
                    {
                        indexes.add(i);
                    }
                    newtowel.clear();
                }
                if(!indexes.isEmpty()&&indexes.contains(line.length()))
                {
                    return true;
                }
            }
        }
        return false;


    }



    enum color{
        white,blue,black,red,green;
        public static color valueOf(char c)
        {
            switch ((c+"").toLowerCase())
            {
                case "w":
                    return white;
                case "u":
                    return blue;
                case "r":
                    return red;
                case "g":
                    return green;
                case "b":
                    return black;
                default:
                    return null;
            }
        }
    }

 class tree
 {
     treeNode root;

     tree()
     {
         root = new treeNode(false,null);
     }
     void add(ArrayList<color> colorstrip)
     {
         treeNode current = root;

         for (color color : colorstrip)
         {

             if (current.getChildren().isEmpty()||!current.getChildren().contains(new treeNode(false,color)))
             {

                 current.addChild(new treeNode(false,color));
                 current = current.getChildren().get(current.getChildren().size()-1);
             }
             else
             {
                 current = current.getChildren().get(current.getChildren().indexOf(new treeNode(false,color)));
             }

         }
         current.isPresent = true;
     }
     public boolean isPresent( ArrayList<color> colorstrip)
     {
         treeNode current = root;
         for (color color : colorstrip)
         {
             if (current.getChildren().isEmpty()||!current.getChildren().contains(new treeNode(false,color)))
             {

                 return false;
             }
             else
             {
                 current = current.getChildren().get(current.getChildren().indexOf(new treeNode(false,color)));
             }

         }
         return current.isPresent;
     }






     class treeNode
     {
         boolean isPresent;
         private color color;
         private ArrayList<treeNode> children;

         treeNode(boolean isPresent, color color)
         {
             this.color = color;
             this.isPresent = isPresent;
             children = new ArrayList<>();
         }

         void addChild(treeNode child)
         {
             children.add(child);
         }

         ArrayList<treeNode> getChildren()
         {
             return children;
         }
         @ Override
         public boolean equals(Object o)
         {
             if (o instanceof treeNode)
             {
                 return color == ((treeNode) o).color;
             }
             return false;
         }



     }
 }

}
