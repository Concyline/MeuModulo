package siac.com.matemarica;

public class Matematica {

    /**
     * Calcula o Máximo Divisor Comum (MDC) entre dois números inteiros.
     *
     * @param a O primeiro número.
     * @param b O segundo número.
     * @return O MDC de a e b.
     */
    public static int mdc(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // Retorna o valor absoluto, pois MDC é sempre positivo
    }

    public static int soma(int a, int b){
        return a + b;
    }

    /**
     * Calcula o Mínimo Múltiplo Comum (MMC) entre dois números inteiros.
     *
     * @param a O primeiro número.
     * @param b O segundo número.
     * @return O MMC de a e b. Retorna 0 se um dos números for 0, pois o MMC não é definido.
     *         Lança IllegalArgumentException se a ou b for Integer.MIN_VALUE devido a estouro com Math.abs.
     */
    public static int mmc(int a, int b) {
        if (a == 0 || b == 0) {
            return 0; // MMC com zero é geralmente definido como 0 ou indefinido.
            // Retornar 0 é uma convenção comum.
        }
        // Evitar estouro com Math.abs(Integer.MIN_VALUE)
        if (a == Integer.MIN_VALUE || b == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Não é possível calcular o MMC com Integer.MIN_VALUE devido a potencial estouro.");
        }
        int mdcVal = mdc(a, b);
        // Evitar divisão por zero caso mdcVal seja zero (o que não deve acontecer se a e b não são ambos zero)
        if (mdcVal == 0) {
            return 0; // Ou lançar uma exceção, dependendo do comportamento desejado
        }
        // Calcular MMC e lidar com potencial estouro na multiplicação
        long multLong = (long) a * b; // Usar long para a multiplicação intermediária
        return Math.abs((int) (multLong / mdcVal));
    }
}

