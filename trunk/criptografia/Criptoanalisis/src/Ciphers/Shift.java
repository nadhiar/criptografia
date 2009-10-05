    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    package Ciphers;

    /**
     *
     * @author felipe
     */
    public class Shift {

        String text;
        Z26 key;
        public Shift(String unText){

            text=unText;
        }

        public String cifrar(int unKey){

            key=new Z26(unKey);
            char t[]= text.toCharArray();
            Z26 aux;

            for(int i=0;i<t.length;i++){
                aux= new Z26(t[i]);
                aux=aux.suma(key);
                t[i]=(char) (aux.getVal()+97);
            }

            text=text.copyValueOf(t);
            return text;
        }

        public String descifrar(int unKey){

            key=new Z26(unKey);
            char t[]= text.toCharArray();
            Z26 aux;

            for(int i=0;i<t.length;i++){
                aux= new Z26(t[i]);
                aux=aux.resta(key);
                t[i]=(char) (aux.getVal()+97);
            }


            text=text.copyValueOf(t);
            return text;
        }
    }
