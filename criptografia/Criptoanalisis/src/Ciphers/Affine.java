    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    package Ciphers;

    /**
     *
     * @author felipe
     */
    public class Affine {

         String text;
         Z26 key1;
         Z26 key2;
        public Affine(String unText){

            text=unText;

        }

        public String cifrar(int keya, int keyb){

            char t[]= text.toCharArray();
            key1= new Z26(keya);
            key2= new Z26(keyb);
            Z26 aux;

            for(int i=0;i<t.length;i++){
                aux=new Z26(t[i]);
                aux=key2.suma(key1.producto(aux));
                t[i]=(char)(aux.getVal()+97);
            }

            text=text.copyValueOf(t);
            return text;
        }

        public String descifrar(int keya, int keyb){

            char t[]= text.toCharArray();
            key1= new Z26(keya);
            key2= new Z26(keyb);
            key1=key1.inverso();
            Z26 aux;

            for(int i=0;i<t.length;i++){
                aux=new Z26(t[i]);
                aux=key1.producto(aux.resta(key2));
                t[i]=(char)(aux.getVal()+97);

            }

            text=text.copyValueOf(t);
            return text;
        }

    }
