/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import org.opencv.core.Core;
import proj.annotation.AnnotationImagem;
import proj.control.ParaDados;
import proj.model.Imagem;

public class Main {
    
    static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    public static void main(String [] args)
    {
        Imagem imagem = new Imagem("C:\\Users\\Gustavo\\Desktop\\lena.png");
        
        try
        {
            ParaDados.Conversor(imagem, "C:\\Users\\Gustavo\\Desktop\\lena.png");
            Imagem image = new Imagem("C:\\Users\\Gustavo\\Desktop\\lena.png");
            
            System.out.println(image.getClass().getDeclaredAnnotation(AnnotationImagem.class).nome());
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
}
