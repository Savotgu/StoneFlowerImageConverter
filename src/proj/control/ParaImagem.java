package proj.control;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import org.opencv.core.CvType;
import org.opencv.core.Mat; 
import proj.annotation.AnnotationImagem;
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
        
        String[] conjunto = matriz.split("[[],\n]");
        
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
        
        final String pixels = matriz;
        
        try
        {
            AnnotationImagem anotacaoVelha = imagem.getClass().getAnnotation(AnnotationImagem.class);
        
            AnnotationImagem anotacaoNova = new AnnotationImagem() 
            {
                @Override
                public String nome() {
                return nome;
                }

                @Override
                public String extensao() {
                return extensao;
                }

                @Override
                public int camadas() {
                return camadas;
                }

                @Override
                public int linhas() {
                return linhas;
                }

                @Override
                public int colunas() {
                return colunas;
                }

                @Override
                public String pixels() {
                return  pixels;
                }

                @Override
                public Class<? extends Annotation> annotationType() {
                return anotacaoVelha.getClass();
                }
            };
            
            alterarAnotocao(Imagem.class, AnnotationImagem.class, anotacaoNova);
        } 
        catch (Exception e) 
        {
            System.err.println(e.toString());
        }
        
        return imagem;
    }
    
    private static void alterarAnotocao(
            Class classeASerAtualizado, 
            Class<? extends Annotation> AnotacaoASerAlterado,
            Annotation novaAnotacao) throws NoSuchMethodException
    {
        try{
            Method method = Class.class.getDeclaredMethod("annotationData", null);
            method.setAccessible(true);

            Object annotationData = method.invoke(classeASerAtualizado);

            Field annotations = annotationData.getClass().getDeclaredField("annotations");
            annotations.setAccessible(true);
            Map<Class<? extends Annotation>, Annotation> map =
                (Map<Class<? extends Annotation>, Annotation>) annotations.get(annotationData);
            map.put(AnotacaoASerAlterado, novaAnotacao);
        }
        catch(Exception e)
        {
            System.err.println(e.toString());
        }
    }
}
