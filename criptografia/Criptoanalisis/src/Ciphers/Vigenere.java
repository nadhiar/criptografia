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
    public class Vigenere {

        String text;
        Z26 key;
        public Vigenere(String unText){

            text=unText;
        }

        public String cifrar(String key){

            ArrayList<Z26> keys= new ArrayList<Z26>(key.length());
            int k=0;
            char t[]= text.toCharArray();
            Z26 aux;

            for(int i=0; i< key.length();i++){
            keys.add(new Z26(key.charAt(i)-97));
            }

            for(int i=0;i<t.length;i++){
                if(k>=key.length())k=0;
                aux=new Z26(t[i]);
                aux=aux.suma(keys.get(k));
                t[i]=(char) (aux.getVal()+97);
                 k++;
            }
            text=text.copyValueOf(t);
            return text;
        }

        public String descifrar(String key){

            ArrayList<Z26> keys= new ArrayList<Z26>(key.length());
            int k=0;
            char t[]= text.toCharArray();
            Z26 aux;

            for(int i=0; i< key.length();i++){
            keys.add(new Z26(key.charAt(i)-97));
            }

            for(int i=0;i<t.length;i++){
                if(k>=key.length())k=0;
                aux=new Z26(t[i]);
                aux=aux.resta(keys.get(k));
                t[i]=(char) (aux.getVal()+97);
                 k++;

            }
            text=text.copyValueOf(t);
            return text;
        }

    }
