    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    package Analisis;

    /**
     *
     * @author felipe
     */

    import java.math.*;
    import Ciphers.*;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.lang.Integer;
    import java.util.ArrayList;
    import java.util.Hashtable;
    import java.util.LinkedList;
    import java.util.Scanner;
    import java.util.Vector;
    import javax.swing.JOptionPane;


    public class Analisis {
        private int claveShift;
    private int[][] claveHill;
    private String clavePermutacion;
        private int claveAffinK;
    private int claveAffinB;

        public static File file=new File("diccionario.txt");
        public static Scanner scan;
        public static Vector<String> palabras=new Vector<String>();
        public ArrayList<String> arreglo = new ArrayList<String>();

        public Analisis() throws FileNotFoundException{

            scan=new Scanner(file);
            while(scan.hasNext())palabras.add(scan.next());

        }

        public int[] contar(String cText){
            int[] c={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

            for(int i=  0; i<cText.length(); i++){

                c[cText.charAt(i)-97]++;
            }

            return c;
        }

        public String shift(String cText){

            int maximo=0;

            String linea= new String();
            String pText= new String();
            int[] rank= new int [26];

            String[] es = new String[26];

            Shift c;
            String aux= new String();


            for(int j= 0; j<26; j++){
               c= new Shift(cText);
               aux=c.descifrar(j);
               es[j]=aux;
               System.out.println(es[j]);

            }

            try {

            maximo = selectMax(es);


            }catch(IOException e){
                System.out.println ("Error al leer");

            }

            claveShift=maximo;



            return es[maximo];


        }

        public int selectMax(String[] texts) throws FileNotFoundException{
            String aux;
            int index=2,maxpoints=0,len=0,points;
            for(int i=0;i<texts.length;i++){

                aux=texts[i];
                points=0;
                for(int j=0;j<palabras.size();j++){
                    len=aux.length();
                    aux=aux.replace(palabras.get(j),"");
                    if(aux.length()<len){
                        points+=len-aux.length();
                        if(i==0)System.out.println(aux);
                    }
                    //System.out.println(palabras.get(j));

                    if(aux.length()==0)break;
                }

                if(points>maxpoints){ index=i; maxpoints=points;}

            }
                //System.out.println("puntaje mas probable:"+maxpoints+"  puntaje maximo: "+texts[0].length());
                return index;
        }

        public int getMax(int[] a){
            int max=a[0];
            for(int i= 1 ; i<a.length; i++){
                if(max>a[i])max=i;
            }

            return max;
        }

        public void setText(){

        }

        /*--------------------------------------------------------------*/

        public String affin(String cText){

            int[] arrayInv = {1,3,5,7,9,11,15,17,19,21,23,25};

            int maximo=0;

            String linea= new String();
            String pText= new String();
            int[] rank= new int [312];

            String[] es = new String[312];
            //ArrayList<String> es= new ArrayList<String>();
            Affine c;
            String aux= new String();
            //aux=c.descifrar(2);
            int k = 0;
            for(int j= 0; j<26; j++){

                for(int i=1; i<26; i+=2){
                   c= new Affine(cText);
                   if(i==13)continue;
               aux=c.descifrar(i,j);
               es[k]=aux;
               System.out.println(es[k]);
               k++;

            }
            }
            try {

            maximo = selectMax(es);
            System.out.println(maximo/12+"   "+maximo%12);

            claveAffinB = maximo/12;
            claveAffinK = arrayInv[maximo%12];
            

            }catch(IOException e){
                System.out.println ("Error al leer");

            }



            return es[maximo];


        }

        public String permutacion(String cText, int m){

            LinkedList<Character> conjunto =new LinkedList<Character>();


            char a = '0';



            for (int i=0; i<m; i++){

                conjunto.add(a++);

            }


            permutar("", conjunto);

            for (int i=0; i<arreglo.size(); i++){

                System.out.println(arreglo.get(i));

            }



            int maximo=0;

            String linea= new String();
            String pText= new String();
            int[] rank= new int [312];

            String[] es = new String[arreglo.size()];
            //ArrayList<String> es= new ArrayList<String>();
            Permutacion c;
            String aux= new String();


            for(int j= 0; j<arreglo.size(); j++){


                   c= new Permutacion(cText);

               aux=c.descifrar(arreglo.get(j));
               es[j]=aux;
               System.out.println(es[j]);



            }
            try {
                clavePermutacion=arreglo.get(maximo);

            maximo = selectMax(es);


            }catch(IOException e){
                System.out.println ("Error al leer");

            }



            //return es[maximo];
            return es[maximo];


        }

        public String hill(String cText, String x, String y, int m){

            String pText= null;
            Hill c=new Hill(cText);

            int[][] Y= new int[m][m];
            int[][] X= new int[m][m];
            int[][] K= new int[m][m];

            int k=0;
            for(int i=0; i<m; i++){

                for(int j=0; j<m; j++){
                    X[i][j]=x.charAt(k)-97;
                    Y[i][j]=y.charAt(k)-97;
                    k++;
               }
            }

            X=Matriz.inversa(X, m);
            K=Matriz.producto(X, Y);

            pText=c.descifrar(K, m);

            claveHill = K;

           return pText;

        }

        /*--------------------------------------------------------------------*/

         public void permutar(String a, LinkedList<Character> conjunto) {

            if (conjunto.size()==1)
            {
                arreglo.add(a+(String.valueOf(conjunto.get(0))));

                System.out.println(a+conjunto.get(0));



            }
            for (int i=0;i<conjunto.size();i++)
            {
                Character b = conjunto.remove(i);
                permutar (a+b, conjunto);
                conjunto.add(i,b);
            }

        }

         /*------------------------------------------------------------------------------*/
         public String Vigenere (String c){
             Vigenere unVigenere = new Vigenere();

             return unVigenere.decrypt(c, calKey(c));


         }

         public double indiceCoincidencia (String s){

             int n=s.length();
            Hashtable<Character,Integer> map=new Hashtable<Character, Integer>();
            int num=1;
            for(int i=0;i<s.length();i++)map.put(s.charAt(i), map.get(s.charAt(i))==null?1:(map.get(s.charAt(i))+1));
            Vector<Integer> nums=new Vector<Integer>(map.values());

            double val=0;
            for(int i=0;i<nums.size();i++){
                num=nums.get(i);
                val+=num*(num-1);

            }
            val/=n*(n-1);
            return val;


         }

         public  int IndiceFriedman(String s){
            double dm=Double.MAX_VALUE, ac=0;
            String aux="";
            int M=-1;
            for(int m=1;dm>0.008;m++){
                ac=0;
                for(int i=1;i<=m;i++){
                    aux="";
                    for(int j=i-1;j<s.length();j+=m)aux+=s.charAt(j);
                    ac+=indiceCoincidencia(aux);
                }
                ac/=m;
                dm=Math.abs(ac-0.065);
                M=m;
                System.out.println("M:" +m+" dm:"+dm);
            }
            return M;
        }


         public String calKey (String s){
             double[] pi={0.082,0.015,0.028,0.043,0.127,0.022,0.020,0.061,0.070,0.002,0.008,0.040,0.024,0.067,0.075,0.019,0.001,0.060,0.063,0.091,0.028,0.010,0.023,0.001,0.020,0,001};

              int m=IndiceFriedman(s);
            Vector<String> y=new Vector<String>();
            double[][] vals=new double[m][26];
            Hashtable<Character,Integer> map=new Hashtable<Character, Integer>();
            String aux;
            for(int i=0;i<m;i++){
                aux="";
                for(int j=i;j<s.length();j+=m){
                    aux+=s.charAt(j);
                }
                y.add(aux);
            }
           for(int i=0;i<m;i++) for(int j=0;j<26;j++)vals[i][j]=0;

            int v=0;
            String st;
            for(int i=0;i<y.size();i++){
                map.clear();
                st=y.get(i);
                for(int c=0;c<st.length();c++)map.put(st.charAt(c), map.get(st.charAt(c))==null?1:(map.get(st.charAt(c))+1));
                for(int k=0;k<26;k++){
                    for(int j=0;j<26;j++){
                        if(map.get((char)((j+k+26)%26+97))==null) v=0;
                        else v=map.get((char)((j+k+26)%26+97));
                        vals[i][k]+=pi[j]*v/(double)st.length();
                    }
                    vals[i][k]=Math.abs(vals[i][k]-0.065);
                }
            }
           st="";
           double min=Double.MAX_VALUE;
            for(int i=0;i<m;i++){
                min=Double.MAX_VALUE;
                for(int j=0;j<26;j++){

                   if(vals[i][j]<min){
                    min=vals[i][j];
                    v=j;
                    }
                }
                st+=(char)(v+97);

            }

            return st;



         }

    /**
     * @return the claveAffinK
     */
    public int getClaveAffinK() {
        return claveAffinK;
    }

    /**
     * @return the claveAffinB
     */
    public int getClaveAffinB() {
        return claveAffinB;
    }

    /**
     * @return the claveShift
     */
    public int getClaveShift() {
        return claveShift;
    }

    /**
     * @return the claveHill
     */
    public int[][] getClaveHill() {
        return claveHill;
    }

    /**
     * @return the clavePermutacion
     */
    public String getClavePermutacion() {
        return clavePermutacion;
    }

    }
