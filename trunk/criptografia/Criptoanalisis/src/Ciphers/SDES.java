/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ciphers;

/**
 *
 * @author AlucarD
 */
public class SDES {

    char K []= {'0','0','0','0','0','0','0','0','0','0'};
    char EP1 []={'0','0','0','0','0','0','0','0'};
    char K1 [] ={'0','0','0','0','0','0','0','0'};
    char suma1 [] ={'0','0','0','0','0','0','0','0'};
    char suma2 [] ={'0','0','0','0','0','0','0','0'};
    char K2 [] ={'0','0','0','0','0','0','0','0'};
    int P10 []= {2,4,1,6,3,9,0,8,7,5};
    int P8 []= {5,2,6,3,7,4,9,8};
    int IP []= {1,5,3,1,3,7,4,6};
    char L [] = {'0','0','0','0'};
    char R [] = {'0','0','0','0'};
    char L1 [] = {'0','0','0','0'};
    char R1 [] = {'0','0','0','0'};
    char IPM []= {'0','0','0','0','0','0','0','0'};
    int IPinv [] = {3,0,2,4,6,1,7,5};
    int EP []= {3,0,1,2,1,2,3,0};
    int P4 []={1,3,2,0};
    //String S0 [10][10] = new String []();
    /*String S0 [][]= {"S0","00","01","10","11";"00","01","00","11","10"};


    "00","01","00","11","10";
    "01","11","10","01","00";
    "10","00","10","01","11";
    "11","11","01","11","10"};*/
    String S1 [][]={};

    String m;
    char texto [];
    public SDES (String unTexto){

        m=unTexto;
        texto = m.toCharArray();




    }

    public void genClave (){

        char temp []={'0','0','0','0','0','0','0','0','0','0'};
        for(int i=0;i<P10.length;i++){

            K1[i]=K[P10[i]];


        }

        char L []={'0','0','0','0','0'};
        char R []={'0','0','0','0','0'};

        L[4]=temp[0];
        L[0]=temp[1];
        L[1]=temp[2];
        L[2]=temp[3];
        L[3]=temp[4];

        R[4]=temp[5];
        R[0]=temp[6];
        R[1]=temp[7];
        R[2]=temp[8];
        R[3]=temp[9];

        for(int i=0; i<4;i++){

            temp[i]=L[i];



        }

        for(int i=5; i<9;i++){

            temp[i]=R[i];



        }

        for(int i=0; i<P8.length;i++){

            K1[i]=temp[P8[i]];

        }

        L[2]=temp[4];
        L[1]=temp[3];
        L[0]=temp[2];
        L[4]=temp[1];
        L[3]=temp[0];

        R[3]=temp[5];
        R[4]=temp[6];
        R[0]=temp[7];
        R[1]=temp[8];
        R[2]=temp[9];
        
        for(int i=0; i<4;i++){

            K2[i]=L[i];



        }

        for(int i=5; i<9;i++){

            K2[i]=R[i];



        }
      


    }

    public void cifrar (String unTexto){
        texto=unTexto.toCharArray();
        IPM=permutar8(texto,IP);
        L=dividirIzq(IPM);
        R=dividirDer(IPM);
        EP1=permutar8(R,EP);
        L1=dividirIzq(EP1);
        R1=dividirDer(EP1);
        
        





    }


    public void descifrar(){


    }


    public char[] permutar8 (char [] texto, int [] unPer){

        char [] temp={'0','0','0','0','0','0','0','0'};
        for(int i=0; i<unPer.length; i++){
            temp[i]=texto[unPer[i]];


        }

        return temp;

    }


    public void permutar4 (){



    }


    public char[] sumar8(char [] unEP, char [] unK) {

        char [] temp={'0','0','0','0','0','0','0','0'};

        for(int i=0; i<unK.length; i++){

            if(unK[i]==unEP[i]){

                temp[i]='0';


            }else{

                temp[i]='1';


            }

        }

        return temp;


    }


    public void sumar4 (){


    }

    public void buscar(){


    }


    public void concatenar(){


    }


    public void intercambiar(){


    }

    public char [] dividirIzq (char [] unIMP){

        char [] unL={'0','0','0','0'};
        
         for(int i=0; i<4;i++){

           unL[i]=unIMP[i];



        }
         
         return unL;


        
    }

     public char [] dividirDer (char [] unIMP){

        char [] unR={'0','0','0','0'};

         for(int i=5; i<9;i++){

           unR[i]=unIMP[i];



        }

         return unR;



    }




}
