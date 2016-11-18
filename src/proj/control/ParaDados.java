package proj.control;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import proj.annotation.AnnotationImagem;
import proj.model.Imagem;

public class ParaDados {
    
    public static void Conversor(Imagem imagem,String caminho)
    {
        String[] conjunto = caminho.split("[\\.]");
        
        String nome = conjunto[conjunto.length-2];
        String extensao = conjunto[conjunto.length-1];;
        int camadas;
        int linhas;
        int colunas;
        String matriz = "";
        camadas = imagem.getImagem().channels();
        linhas = imagem.getImagem().rows();
        colunas = imagem.getImagem().cols();
        
        for(int i=0; i<linhas; i++)
        {
            for(int j=0; j<colunas; j++)
            {
                matriz = i+j+Arrays.toString(imagem.getImagem().get(i, j)) +"\n";
            }
        }
        
        final String pixels = matriz;
        
        try 
        {
            final AnnotationImagem anotacaoVelha = imagem.getClass().
                                        getDeclaredField("imagem").
                                        getAnnotation(AnnotationImagem.class);
            
            AnnotationImagem anotacaoNova = new AnnotationImagem() {
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
                    return anotacaoVelha.annotationType();
                }
            };
            
                Field field = Class.class.getDeclaredField("annotations");
                
                field.setAccessible(true);
                
                Map<Class<? extends Annotation>, Annotation> annotations 
                            = (Map<Class<? extends Annotation>, Annotation>) field.get(Imagem.class);
                annotations.put(AnnotationImagem.class, anotacaoNova);
            
        } 
        catch (Exception e) 
        {
            System.err.println(e.toString());
        }
        
    }
}
