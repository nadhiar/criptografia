    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    package Analisis;

    import Ciphers.Matriz;
    import java.util.LinkedList;

    /**
     *
     * @author AlucarD
     */
    public class Permutaciones {

         public static void main(String[] args) {
            LinkedList<Character> conjunto =new LinkedList<Character>();
            conjunto.add('1');
            conjunto.add('2');
            conjunto.add('3');
            conjunto.add('4');
            conjunto.add('5');
            conjunto.add('6');
            conjunto.add('7');
            conjunto.add('8');

            escribe ("", conjunto);

            int [][] matriz = {
                                    {5,5},
                                    {1,6}
                    };

              matriz=Matriz.inversa(matriz, 2);
        }

        public static void escribe(String a, LinkedList<Character> conjunto) {
            if (conjunto.size()==1)
            {
                System.out.println(a+conjunto.get(0));
            }
            for (int i=0;i<conjunto.size();i++)
            {
                Character b = conjunto.remove(i);
                escribe (a+b, conjunto);
                conjunto.add(i,b);
            }
        }


    }
