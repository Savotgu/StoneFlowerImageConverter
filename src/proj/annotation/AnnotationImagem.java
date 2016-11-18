package proj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationImagem {
    String nome() default "";
    String extensao() default "";
    int camadas() default 0;
    int linhas() default 0;
    int colunas() default 0;
    String valores() default "";
}