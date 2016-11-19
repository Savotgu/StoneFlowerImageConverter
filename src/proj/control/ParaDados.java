package proj.control;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import org.opencv.core.Core;
import proj.annotation.AnnotationImagem;
import proj.model.Imagem;

public class ParaDados {
    static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    public static void Conversor(Imagem imagem,String caminho) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        String[] conjunto = caminho.split("[\\\\.]");
        
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
        
        alterarAnotocao(imagem.getClass(), AnnotationImagem.class, anotacaoNova);
        
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