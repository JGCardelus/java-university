import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args)
    {
        //Encontrar todas las parejas que sumen 10
        int[] numeros = { 8, 7, 2, 5, 3, 1 };
        int sum = 10;
        System.out.println("Parejas encontradas que suman " + sum);
        HashMap<Integer,Integer> hm0 = Util.encontrarPareja2(numeros, sum);
        for (Map.Entry<Integer,Integer> m : hm0.entrySet())
            System.out.println("{" + m.getKey()+ ", " + m.getValue() +"}");
            /*Salida esperada
            {2, 8}
            {3, 7}
            */

        // // Encontrar todas las parejas simétricas del hashmap que se facilita
        // HashMap<Integer,Integer> hm1 = new HashMap<>();
        // hm1.put(3,4);
        // hm1.put(1,2);
        // hm1.put(5,2);
        // hm1.put(7,10);
        // hm1.put(4,3);
        // hm1.put(2,5);
        // System.out.println("Parejas encontradas con duplicados");
        // HashMap<Integer,Integer> hm2 = Util.escribirParejasSimetricas(hm1);
        // for (Map.Entry<Integer,Integer> m : hm2.entrySet())
        //     System.out.println("{"+m.getKey()+", "+m.getValue()+"} | {" + m.getValue() +", " +m.getKey()+"}");
        // /*Salida esperada
        // {2, 5} | {5, 2}
        // {3, 4} | {4, 3}
        // {4, 3} | {3, 4}
        // {5, 2} | {2, 5}
        // */
        // /*También se considerará válida esta salida
        // {2, 5} | {5, 2}
        // {3, 4} | {4, 3}
        // */
        
        
        // Encontrar si un array está formado sólo por números consecutivos
        int[] B = { -1, 5, 4, 2, 0, 3, 1 };
        if (Util.tieneTodosNumConsecutivos(B))
            System.out.print("Tiene todos los elementos consecutivos");
        else
            System.out.print("No tiene todos los elementos consecutivos");
        /*Salida esperada
        Tiene todos los elementos consecutivos
        */
    }
}
