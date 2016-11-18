package proj.model;

import org.opencv.core.Core;
import org.opencv.core.Mat; 
import org.opencv.imgcodecs.Imgcodecs; 
import proj.annotation.AnnotationImagem;

public class Imagem {
    
    public Imagem(String caminhoParaImagem)
    {
        imagem = Imgcodecs.imread(caminhoParaImagem);
    }
    
        public Imagem(Mat imagem)
    {
        this.imagem = imagem;
    }
    
    @AnnotationImagem
    private Mat imagem;
    
    public Mat getImagem()
    {
        return imagem;
    }
    
}
