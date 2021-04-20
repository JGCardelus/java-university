import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Util 
{
    public static HashMap<Integer,Integer> encontrarPareja(int[] numeros, int sum) 
    {
        HashMap<Integer, Integer> output = new HashMap<Integer, Integer>();
        
        for (int a : numeros) {
            for (int b : numeros) {
                if (a + b == sum) {
                    if (!output.containsKey(a) && !output.containsKey(b)) {
                        output.put(a,b);
                    }
                }
            }
        }

        return output;
    }

    // Este método es más rápido
    public static HashMap<Integer,Integer> encontrarPareja2(int[] numeros, int sum) 
    {
        HashMap<Integer, Integer> output = new HashMap<Integer, Integer>();

        for (int i = 0; i < numeros.length; i++) {
            int a = numeros[i];
            for (int j = numeros.length - 1; j >= i; j--) {
                int b = numeros[j];
                if (a + b == sum) {
                    if (!output.containsKey(a) && !output.containsKey(b)) {
                        output.put(a,b);
                    }
                }
            }
        }

        return output;
    }

    public static HashMap<Integer, Integer> escribirParejasSimetricas(HashMap<Integer,Integer> hm) 
    {
        /* Código a desarrollar
        *
        *
        *
        * */
        return null;
    }


    public static boolean tieneTodosNumConsecutivos(int[] b) 
    {
        for (int i = 0; i < b.length; i++) {
            int now = b[i];
            if (i > 0) {
                int before = b[i - 1];
                if (now != before + 1) {
                    return false;
                }
            }
        }
        return true;
    }
}