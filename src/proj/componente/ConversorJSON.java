/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj.componente;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class ConversorJSON {
    
    public static String ConversorJSON(Object o, Class c)
    {

        String json = "";
        try
        {
            List<String> nome = new ArrayList<String>();
            List<String> valor = new ArrayList<String>();

            Annotation[] annotations = c.getDeclaredAnnotations();
            for(Annotation a : annotations)
            {
                for(Method m : a.getClass().getDeclaredMethods())
                {
                    nome.add(m.getName());
                    valor.add(m.invoke(o).toString());
                }
            }
        }
        catch(Exception e)
        {
            System.err.println(e.toString());
        }
        
        return json;
    }
    
}
