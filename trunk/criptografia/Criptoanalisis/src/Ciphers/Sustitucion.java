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
    public class Sustitucion {

        String text;
        Z26 key;
        public Sustitucion(String unText){

            text=unText;
        }

        public String cifrar(String key){

            ArrayList<Z26> keys= new ArrayList<Z26>(key.length());
            char t[]= text.toCharArray();
            Z26 aux;
            System.out.println(key);
            for(int i=0; i< key.length();i++){
            keys.add(new Z26(key.charAt(i)-97));
            }

            for(int i=0;i<t.length;i++){

                aux=new Z26(t[i]);
                aux=keys.get(aux.getVal());
                t[i]=(char) (aux.getVal()+97);
                System.out.println(aux.getVal());
            }
            text=text.copyValueOf(t);
            return text;
        }

        public String descifrar(String key){

             ArrayList<Z26> keys= new ArrayList<Z26>(key.length());
             ArrayList<Z26> keysinv= new ArrayList<Z26>(key.length());

            char t[]= text.toCharArray();
            Z26 aux;
            System.out.println(key);

            for(int i=0; i< key.length();i++){
                keys.add(new Z26(key.charAt(i)-97));
            }

            System.out.println(keysinv);

            for(int i=0; i< key.length();i++){
                 keysinv.set(keys.get(i).getVal(), new Z26(i));
            }

            for(int i=0;i<t.length;i++){

                aux=new Z26(t[i]);
                aux=keysinv.get(aux.getVal());
                t[i]=(char) (aux.getVal()+97);
                System.out.println(aux.getVal());
            }
            text=text.copyValueOf(t);
            return text;
        }


    }
