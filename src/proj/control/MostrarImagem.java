/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj.control;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import proj.model.Imagem;

/**
 *
 * @author Gustavo
 */
public class MostrarImagem {
    //Retornar buffer a ser aplicado em uma imagem
    public static BufferedImage mostrar(Imagem imagem)
    {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        
        if ( imagem.getImagem().channels() > 1 ) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        
        int bufferSize = imagem.getImagem().channels()*imagem.getImagem().cols()*imagem.getImagem().rows();
        
        byte [] b = new byte[bufferSize];
        
        imagem.getImagem().get(0,0,b); // get all the pixels
        
        BufferedImage image = new BufferedImage(imagem.getImagem().cols(),imagem.getImagem().rows(), type);
        
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        
        System.arraycopy(b, 0, targetPixels, 0, b.length);  
        
        return image;
    }
}
