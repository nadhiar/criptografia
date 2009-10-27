/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ciphers;

/**
 *
 * @author AlucarD
 */
public class SPN {

    public static void exec(String[] key,String x){
        String[] K=new String[5];
        for(int i=0;i<5;i++){
            K[i]="";
            for(int j=0;j<4;j++){
                K[i]+=key[(fibonacci(i+j+1))%key.length]+" ";
            }
        }
        for(int i=0;i<5;i++){
            System.out.println(K[i]);
        }
    }
    public static int fibonacci(int i){
        return i<2?i:fibonacci(i-1)+fibonacci(i-2);
    }
    public static String[][] keySchedule(String[] key){
        return null;
    }
    public static String[] encrypt(String[] key,String[] x,int[] Ps,int[] Pp,String[][] K){
        StringBuffer buffer=new StringBuffer();
        String[] w=new String[x.length];
        String[] u=new String[x.length];
        String[] v=new String[x.length];
        for(int i=0;i<x.length;i++){
            w[i]="";
            w[i]=x[i];
        }
        for(int i=0;i<K.length-2;i++){
            System.out.print("\nu:");
            for(int j=0;j<x.length;j++){
                //System.out.println((Integer.parseInt(w[j], 2))^(Integer.parseInt(K[i][j], 2)));
                u[j]=Integer.toBinaryString((Integer.parseInt(w[j], 2))^(Integer.parseInt(K[i][j], 2)));
                while(u[j].length()<x[0].length()) u[j]="0"+u[j];
                System.out.print(u[j]+" ");
            }
            System.out.println();
            System.out.print("v:");
            for(int j=0;j<x.length;j++){
                v[j]=Integer.toBinaryString(Ps[Integer.parseInt(u[j],2)]);
                while(v[j].length()<x[0].length()) v[j]="0"+v[j];
                System.out.print(v[j]+" ");
            }
            System.out.println();
            System.out.print("w:");
            for(int j=0;j<x.length;j++){
                buffer=new StringBuffer(v[j]);
                for(int k=0;k<x[0].length();k++){
                    buffer.setCharAt( k , v[ Pp[j*x[0].length()+k]/x[0].length() ].charAt( Pp[j*x[0].length()+k]%x[0].length() ) );
                }
                w[j]=buffer.toString();
                System.out.print(w[j]+" ");
            }
        }
        System.out.println();
        System.out.print("u:");
        for(int j=0;j<x.length;j++){
                u[j]=Integer.toBinaryString(Integer.parseInt(w[j], 2)^Integer.parseInt(K[K.length-2][j], 2));
                while(u[j].length()<x[0].length()) u[j]="0"+u[j];
                System.out.print(u[j]+" ");
        }
        System.out.print("\nv:");
        for(int j=0;j<x.length;j++){
                v[j]=Integer.toBinaryString(Ps[Integer.parseInt(u[j],2)]);
                while(v[j].length()<x[0].length()) v[j]="0"+v[j];
                System.out.print(v[j]+" ");
        }
        System.out.print("\ny:");
        for(int j=0;j<x.length;j++){
                w[j]=Integer.toBinaryString(Integer.parseInt(v[j], 2)^Integer.parseInt(K[K.length-1][j], 2));
                while(w[j].length()<x[0].length()) w[j]="0"+w[j];
                System.out.print(w[j]+" ");
        }
        return w;
    }
    public static String[] decrypt(String[] key,String[] y,int[] Ps,int[] Pp,String[][] K){
        StringBuffer buffer=new StringBuffer();
        String[] w=new String[y.length];
        String[] u=new String[y.length];
        String[] v=new String[y.length];
        System.out.println("----------------------");
        System.out.print("\nv:");
        for(int j=0;j<y.length;j++){
                v[j]=Integer.toBinaryString(Integer.parseInt(y[j], 2)^Integer.parseInt(K[K.length-1][j], 2));
                while(v[j].length()<y[0].length()) v[j]="0"+v[j];
                System.out.print(v[j]+" ");
        }
        System.out.print("\nu:");
        for(int j=0;j<y.length;j++){
                u[j]=Integer.toBinaryString(Ps[Integer.parseInt(v[j],2)]);
                while(u[j].length()<y[0].length()) u[j]="0"+u[j];
                System.out.print(u[j]+" ");
        }
        System.out.print("\nw:");
        for(int j=0;j<y.length;j++){
                w[j]=Integer.toBinaryString(Integer.parseInt(u[j], 2)^Integer.parseInt(K[K.length-2][j], 2));
                while(w[j].length()<y[0].length()) w[j]="0"+w[j];
                System.out.print(w[j]+" ");
        }

        for(int i=0;i<K.length-2;i++){
            System.out.print("\n-v:");
            for(int j=0;j<y.length;j++){
                 buffer=new StringBuffer(w[j]);
                for(int k=0;k<y[0].length();k++){
                    buffer.setCharAt( k , w[ Pp[j*y[0].length()+k]/y[0].length() ].charAt( Pp[j*y[0].length()+k]%y[0].length() ) );
                }
                v[j]=buffer.toString();
                System.out.print(v[j]+" ");
            }
            System.out.println();
            System.out.print("u:");
            for(int j=0;j<y.length;j++){
                u[j]=Integer.toBinaryString(Ps[Integer.parseInt(v[j],2)]);
                while(u[j].length()<y[0].length()) u[j]="0"+u[j];
                System.out.print(u[j]+" ");
            }
            System.out.println();
            System.out.print("w:");
            for(int j=0;j<y.length;j++){
               w[j]=Integer.toBinaryString(Integer.parseInt(u[j], 2)^Integer.parseInt(K[K.length-3-i][j], 2));
               while(w[j].length()<y[0].length()) w[j]="0"+w[j];
               System.out.print(w[j]+" ");
            }
        }
        return w;
    }

}
