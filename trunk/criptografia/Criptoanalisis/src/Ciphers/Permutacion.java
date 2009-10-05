    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    package Ciphers;

    import java.util.ArrayList;

    /**
     *
     * @author felipe
     */
    public class Permutacion {


        String text;
        Z26 key;
        public Permutacion (String unText){

            text=unText;
        }

        public String cifrar(String key){

            //ArrayList<Z26> keys= new ArrayList<Z26>(key.length());
            char t[]= text.toCharArray();
            Z26 aux;
            System.out.println(key);
            String textAux;
             String textAux2;
             int m=key.length();
            int k=0;


            for(int i=0;i<t.length/m;i++){
                 textAux2=text.substring(m*i, m*i+m);
                for(int j=0;j<m;j++){
                   t[k]=textAux2.charAt(key.charAt(j)-48);
                    k++;
                }
            }


            text=text.copyValueOf(t);
            return text;
        }

        public String descifrar(String key){


            char t[]= text.toCharArray();
            Z26 aux;
            System.out.println("probando probando probando");
            System.out.println(key+"KEY");
            String textAux;
             String textAux2;
             int m=key.length();
            int k=0;

            char keysinv[]= new char [key.length()];

            char keys[]=key.toCharArray();

             for(int i=0; i< key.length();i++){
                 keysinv[keys[i]-48]=(char) (i+48);
                 System.out.println(keysinv[i]+"++");
            }



            key=String.copyValueOf(keysinv);

            for(int i=0;i<t.length/m;i++){
                 textAux2=text.substring(m*i, m*i+m);
                for(int j=0;j<m;j++){
                   t[k]=textAux2.charAt(key.charAt(j)-48);
                    k++;
                }
            }

            text=text.copyValueOf(t);
            return text;
        }


    }
