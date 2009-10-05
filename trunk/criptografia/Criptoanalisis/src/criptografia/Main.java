/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package criptografia;

import Vista.Criptoanalisis;
import Vista.Vista;

/**
 *
 * @author felipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vista unaVista = new Vista();
        unaVista.setVisible(true);
        Criptoanalisis unCriptoanalisis = new Criptoanalisis ();
        unCriptoanalisis.setVisible(true);
    }


}
