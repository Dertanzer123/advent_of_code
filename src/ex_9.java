package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ex_9 {

    ex_9() throws IOException {
        String path = "src/inputs/day9.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<Integer> list = new ArrayList<Integer>();

        String line;

        line = br.readLine();

        int k = 0;
        for (int i = 0; i < line.length(); i++) {
            if (i % 2 == 0) {
               for (int j = 0; j < Integer.parseInt(""+line.charAt(i)); j++) {
                  list.add(k);

               }
               k++;
            }
            else {
                for (int j = 0; j < Integer.parseInt(""+line.charAt(i)); j++) {
                    list.add(null);
                }
            }


        }

        int index = list.size()-1;
        while(index>0)
        {
            if(list.get(index)==null)
            {
                index--;

            }
            else
            {
                int setter=index;
                int lenght=0;
                while(setter-lenght>=0&& Objects.equals(list.get(setter - lenght), list.get(setter)))
                {
                    lenght++;
                }
                for(int i=0;i<setter-lenght;i++)
                {
                    if(list.get(i)==null)
                    {
                        int emptylenght=0;
                        while(i+emptylenght<=setter-lenght&&list.get(i+emptylenght)==null)
                        {
                            emptylenght++;
                        }
                        if(emptylenght>=lenght)
                        {
                            for(int j=0;j<lenght;j++)
                            {
                                list.set(i+j,list.get(setter-j));
                                list.set(setter-j,null);
                            }

                            break;
                        }
                    }
                }
                index=setter-lenght;
            }

        }
//       for(int i=list.size()-1;i>0;i+=0)
//         {
//             if(list.get(i)==null)
//             {
//                 i--;
//             }
//             if(list.get(i)!=null)
//             {
//                 int setter=i;
//               while(list.get(i)==list.get(setter)&&i>0)
//               {
//                   i--;
//               }
//               for(int j=0;j<i;j++)
//               {
//                   if(list.get(j)==null)
//                   {
//                       int addition =0;
//                       while(list.get(j+addition)==null&&j+addition<=i) {
//                           addition++;
//                       }
//                       if(addition>=setter-i)
//                       {
//                          for(int addingindex=0 ;addingindex<setter-i;addingindex++)
//                          {
//                              list.set(j+addingindex,list.get(setter-addingindex));
//                              list.set(setter-addingindex,null);
//                          }
//                          i++;
//                              break;
//                       }
//                   }
//               }
//
//             }
//
//         }
//
        long sum=0;

        for(int i=0;i<list.size();i++)
        {if(list.get(i)!=null){
            System.out.print(list.get(i)+",");
            sum+=  list.get(i) *i;}
        else
            System.out.print(".");
        }
        System.out.println(sum);


    }


}
