    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    package Analisis;
    import java.io.*;
    /**
     *
     * @author felipe
     */
    public class ReadFile {

        String filePath;
        public ReadFile(String file){
            filePath=file;
        }
    public BufferedReader leer (){
        BufferedReader fd = null;
        String linea = "";
        try {
            fd = new BufferedReader (new FileReader (filePath));
        }
        catch (FileNotFoundException e) {
            System.out.println ("No pude abrir el archivo");
        }
        try {
        while ((linea = fd.readLine ()) != null)
            //System.out.println (linea);
            fd.close ();
        }
        catch (IOException e) {
            System.out.println ("Error al leer");
        }
            return fd;
    }

    }
