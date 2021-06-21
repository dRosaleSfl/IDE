/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idee;
import java.io.*;
/**
 *
 * @author Hashanah
 */
public class gestion {
 FileInputStream entrada;
 FileOutputStream salida;
 File archivo;
 public gestion(){}
 // abrir el archivo
 public String abrirtexto(File archivo){
     String contenido="";
     try{
       entrada =new FileInputStream(archivo);
       int i;
       while((i=entrada.read())!=-1){
           char caracter = (char)i;
           contenido+=caracter;
       }
     }catch(Exception e){}
     return contenido;
 }
 //guardar el archivo
 public String guardartexto(File archivo, String contenido){
     String respuesta=null;
     try{
         salida= new FileOutputStream(archivo);
         byte[] bytesTxt = contenido.getBytes();
         salida.write(bytesTxt);
         respuesta="se guardo con exiiiito compa";
     }catch(Exception e){}
     return respuesta;
 }

}
