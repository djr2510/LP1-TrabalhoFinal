package util;
import java.util.Scanner;

/**
 * Classe TecladoUtil.
 *
 * @author Davi
 * @author Gabriel
 * @see java.lang.String
 * @version 1.0
 * @since 24/04/2024
 */
public class TecladoUtil {
    /**
     * Código
     * @param mensagem
     * @return inicializaTeclado
     */
    public static String lerString(String mensagem) {
        return  inicializaTeclado(mensagem).next();
    }
    /**
     * Código
     * @param mensagem
     * @return inicializaTeclado
     *//**
     * Código
     * @param mensagem
     * @return inicializaTeclado
     */
    public static  Integer lerInteiro(String mensagem) {
        return  inicializaTeclado(mensagem).nextInt();
    }
    /**
     * Código
     * @param mensagem
     * @return inicializaTeclado
     */
    private static Scanner inicializaTeclado(String mensagem) {
        System.out.println(mensagem);
        return new Scanner(System.in);
    }
}
