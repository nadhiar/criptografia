    package Analisis;

    import java.util.Hashtable;
    import java.util.Vector;

    /**
     *
     * @author mekarlos
     */
    public class Vigenere {
        private static StringBuffer s;
        static double[] pi={0.082,0.015,0.028,0.043,0.127,0.022,0.020,0.061,0.070,0.002,0.008,0.040,0.024,0.067,0.075,0.019,0.001,0.060,0.063,0.091,0.028,0.010,0.023,0.001,0.020,0,001};
        public static String encrypt(String text,String key){
              s=new StringBuffer(text);
              for(int i=0;i<s.length();i++){
                s.setCharAt(i,(char) ((s.charAt(i) - 'a'+key.charAt(i%key.length())-'a')%26+'a'));
              }
              return s.toString();
        }

        public static String decrypt(String text,String key){
              s=new StringBuffer(text);
              for(int i=0;i<s.length();i++){
                s.setCharAt(i,(char) ((s.charAt(i) -key.charAt(i%key.length())+26)%26+'a'));
              }
              return s.toString();
        }

        public static int IndiceFriedman(String s){
            double dm=Double.MAX_VALUE, ac=0;
            String aux="";
            int M=-1;
            for(int m=1;dm>0.008;m++){
                ac=0;
                for(int i=1;i<=m;i++){
                    aux="";
                    for(int j=i-1;j<s.length();j+=m)aux+=s.charAt(j);
                    ac+=Ic(aux);
                }
                ac/=m;
                dm=Math.abs(ac-0.065);
                M=m;
                System.out.println("M:" +m+" dm:"+dm);
            }
            return M;
        }
        public static double Ic(String s){
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
        public static String getKey(String s){
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
                  // System.out.print((vals[i][j])+" ");
                   if(vals[i][j]<min){
                    min=vals[i][j];
                    v=j;
                    }
                }
                st+=(char)(v+97);
               // System.out.print("\n");
            }

            return st;
        }



        public static void main(String[] args){
            String a="chreevoahmaeratbiaxxwtnxbeeophbsbqmqeqerbwrvxuoakxaosxxweahbwgjmmqmnkgrfvgxwtrzxwiaklxfpskautemndcmgtsxmxbtuiadngmgpsrelxnjelxvrvprtulhdnqwtwdtygbphxtfaljhasvbfxngllchrzbwelekmsjiknbhwrjgnmgjsglxfeyphagnrbieqjtamrvlcrremndglxrrimgnsnrwchrqhaeyevtaqebbipeewevkakoewadremxmtbhhchrtkdnvrzchrclqohpwqaiiwxnrmgwoiifkee";
            String b="";
            for(int i=0;i<a.length();i+=1){
                b+=a.charAt(i);
            }

            //System.out.println(IndiceFriedman(a));
            //System.out.println(getKey(a));
        }

    }
