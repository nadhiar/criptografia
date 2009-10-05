    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    package Ciphers;

    import Analisis.Determinante;

    /**
     *
     * @author felipe
     */
       public final class Matriz {

         public static int[] producto(int A[], int B[][]){

              System.out.println("vect->"+A[0]+" "+A[1]);

              int suma;
            int result[] = new int[A.length];
            for(int i = 0; i < A.length; i++){
                  suma=0;
                 for(int j = 0; j < A.length; j++){
                         suma=suma+A[j]*B[j][i];
                }
                   result[i] = suma;
            }
            for(int i = 0; i < A.length; i++){
                result[i]=result[i]%26;
            }

             return result;
           }

           /**
         * Multiplica dos matrices
          * @param int[][] A
          * @param int[][] B
          * @return int[][] producto
          */

         public static int[][] producto(int A[][], int B[][]){

            int suma = 0;
            int result[][] = new int[A.length][B.length];
             for(int i = 0; i < A.length; i++){
                 for(int j = 0; j < B.length; j++){
                     suma = 0;
                     for(int k = 0; k < B.length; k++){
                         suma += A[i][k] * B[k][j];
                     }
                     result[i][j] = suma;
                 }
             }
             return result;
           }

          public static int[][] adjunta(int B[][], int m){

            int signo=1;
            int result[][] = new int[m][m];
            int adj[][];// = new int[m-1][m-1];
            for(int i = 0; i < m; i++){

                 for(int j = 0; j < m; j++){
                         adj  =Determinante.getSubmatriz(B,m,m, j, i);
                         result[i][j]=signo*Determinante.determinante(adj);
                        signo*=-1;
                 }
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < m; j++){
                  result[i][j]=result[i][j]%26;
                   if(result[i][j]<0)result[i][j]=result[i][j]+26;
                }
            }

            System.out.println("adj->");
                    for (int i=0;i<m;i++)
                    {
                            for (int j=0;j<m;j++)
                                    System.out.print(result[i][j]+" ");
                            System.out.println();
                    }

             return result;
           }


           public static int[][] inversa(int B[][], int m){

            int signo=1;
            int result[][]=new int[m][m];


            if(m<=2){
              result[0][0]=B[1][1];
              result[0][1]=-B[0][1];
              result[1][0]=-B[1][0];
              result[1][1]=B[0][0];



            }else{
                result=Matriz.adjunta(B, m);
                result=Matriz.transversa(result, m);
             }
             System.out.println("Bbd->");
                for (int i=0;i<m;i++)
                {
                    for (int j=0;j<m;j++)
                        System.out.print(B[i][j]+" ");
                    System.out.println();
                }

             int det=Determinante.determinante(B);
            System.out.println("det->"+det);
                det=Z26.inver(det);
            System.out.println("det->"+det);

            for(int i = 0; i < m; i++){
                for(int j = 0; j < m; j++)
                  result[i][j]=result[i][j]*det;
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < m; j++){
                  result[i][j]=result[i][j]%26;
                    if(result[i][j]<0)result[i][j]=result[i][j]+26;
                }
            }

              System.out.println("invad->");
                for (int i=0;i<m;i++)
                {
                    for (int j=0;j<m;j++)
                        System.out.print(result[i][j]+" ");
                    System.out.println();
                }




             return result;
           }

           public static int[][] transversa(int B[][], int m){

              int signo=1;
            int result[][] = new int[m][m];

            for(int i = 0; i < m; i++){

                 for(int j = 0; j < m; j++){
                        result[i][j]=B[j][i];
                 }
            }
            System.out.println("trv->");
                    for (int i=0;i<m;i++)
                    {
                            for (int j=0;j<m;j++)
                                    System.out.print(result[i][j]+" ");
                            System.out.println();
                    }
             return result;
           }

       }
