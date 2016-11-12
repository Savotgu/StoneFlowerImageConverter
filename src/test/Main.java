package test;

import org.opencv.core.Core; //<- Funções principais do opencv
import org.opencv.core.Mat; //<- Variável de armazenamento
import org.opencv.imgcodecs.Imgcodecs; //<-leitor de arquivos

public class Main {

    static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);} //Função para carregar as bibliotecas
    
    public static void main(String[] args) {
        
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        Mat image; // <- Declaração da variável
        image = Imgcodecs.imread("lena.png"); // <- Carregar imagem
        //image = Imgcodecs.imread("Partição:\\pasta\\image.extensão");
        System.out.println(image.channels()); // <- Acesso a quantidade de canais
        System.out.println(image.cols()); // <- Acesso a quantidade de colunas
        System.out.println(image.rows());; // <- Acesso a quantidade de linhas
        
        double [] channelValue = new double[image.channels()]; // <- vetor do tipo double
        
        channelValue[0] = 255; // camada 0
        channelValue[1] = 255; // camada 1
        channelValue[2] = 255; // camada 2
                
        for(int i=0; i<image.rows();i++) // linhas
        {
            for(int j=0; j<image.cols();j++) // colunas
            {
                image.put(i, j, channelValue); // <- insere valores na linha i e coluna j
            }
        }
    }
}
