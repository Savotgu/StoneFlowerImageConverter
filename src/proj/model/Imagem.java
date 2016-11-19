package proj.model;

import org.opencv.core.Core;
import org.opencv.core.Mat; 
import org.opencv.imgcodecs.Imgcodecs; 
import proj.annotation.AnnotationImagem;

@AnnotationImagem(camadas = 0,extensao = "", colunas = 0, linhas = 0, nome = "", pixels = "")
public class Imagem {
    
    public Imagem(String caminhoParaImagem)
    {
        imagem = Imgcodecs.imread(caminhoParaImagem);
    }
    
        public Imagem(Mat imagem)
    {
        this.imagem = imagem;
    }
    
    private Mat imagem;
    
    public Mat getImagem()
    {
        return imagem;
    }
    
}
