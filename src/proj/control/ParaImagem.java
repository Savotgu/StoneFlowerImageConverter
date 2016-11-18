package proj.control;

import org.opencv.core.CvType;
import org.opencv.core.Mat; 
import proj.model.Imagem;

public class ParaImagem {
    
    //retormar de uma anotação
    public static Imagem Conversor(String nome, String extensao, String strCamadas, String strLinhas, String strColunas, String matriz)
    {
        int tipo = 0;
        int camadas = Integer.parseInt(strCamadas);
        int linhas = Integer.parseInt(strLinhas);
        int colunas = Integer.parseInt(strColunas);
        
        if(camadas==1) tipo = CvType.CV_64FC1;
        else if(camadas==2)tipo = CvType.CV_64FC2;
        else if(camadas==3)tipo = CvType.CV_64FC3;
        else if(camadas==4)tipo = CvType.CV_64FC4;
        
        Mat mat = new Mat(linhas, colunas, tipo);
        
        String[] conjunto = matriz.split("[[],]");
        
        double[] data = new double[camadas];
        
        for(int i=0; i<conjunto.length;)
        {
            int lin = Integer.parseInt(conjunto[i]);
            int col = Integer.parseInt(conjunto[i+1]);
            
            data[0] = Double.parseDouble(conjunto[i+2]);
            if(camadas==2) data[1] = Double.parseDouble(conjunto[i+3]);
            if(camadas==3) data[2] = Double.parseDouble(conjunto[i+4]);
            if(camadas==4) data[3] = Double.parseDouble(conjunto[i+5]);
            
            mat.put(lin, col, data);
            
            i=i+camadas+2;
        }
        
        Imagem imagem = new Imagem(mat);
        
        return imagem;
    }
}
