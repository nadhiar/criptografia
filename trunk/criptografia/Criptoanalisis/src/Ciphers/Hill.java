    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    package Ciphers;

    import java.util.ArrayList;
    import Analisis.Determinante;

    /**
     *
     * @author felipe
     */

    public class Hill {


         String text;
        Z26 key;
        public Hill(String unText){

            text=unText;
        }

        public String cifrar(int[][] key, int m){


            int k=0;
            int l=0;
            char t[]= text.toCharArray();
            int[] aux=new int[m];

            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++)
                   System.out.print(key[i][j]+" ");
                System.out.println();
            }

            for(int i=0;i<t.length;i++){

                aux[k]=(int)t[i]-97;
                k++;
                if(k>=m){
                    k=0;
                aux=Matriz.producto(aux, key);
                System.out.println(aux[0]+" "+aux[1]);
                for(int h=0;h<m;h++)
                   t[l++]=(char) (aux[h]+97);
                }
                System.out.println(t);
            }
            text=text.copyValueOf(t);
            return text;
        }

        public String descifrar(int[][] key, int m){


            int k=0;
            int l=0;
            char t[]= text.toCharArray();
            int[] aux=new int[m];

            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++)
                   System.out.print(key[i][j]+" ");
                System.out.println();
            }

            key=Matriz.inversa(key, m);

            System.out.println("key inv");

            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++)
                   System.out.print(key[i][j]+" ");
                System.out.println();
            }


            for(int i=0;i<t.length;i++){

                aux[k]=(int)t[i]-97;
                k++;
                if(k>=m){
                    k=0;
                aux=Matriz.producto(aux, key);
                System.out.println(aux[0]+" "+aux[1]);
                for(int h=0;h<m;h++)
                   t[l++]=(char) (aux[h]+97);
                }
                System.out.println(t);
            }
            text=text.copyValueOf(t);
            return text;
        }

    }
