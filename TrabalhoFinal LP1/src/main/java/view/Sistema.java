package view;

import controller.VotacaoController;
import exception.AplicacaoException;
import util.TecladoUtil;
/**
 * Classe Sistema.
 *
 * @author Davi
 * @author Gabriel
 * @see java.lang.String
 * @version 1.0
 * @since 24/04/2024
 */
public class Sistema {
    private static VotacaoController controller = new VotacaoController();
    private static boolean sair = false;



    public static void main(String[] args) {
        while (!sair) {
            menu();
            int opcao = TecladoUtil.lerInteiro("Informa uma Opcao:");
            executaAcao(opcao);
        }
    }

    /**
     * Código Escolhe um metodo a ser inicializado
     * @param opcao
     */
    private static void executaAcao(int opcao) {
        try {
            switch (opcao) {
                case 1:
                    inserirFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    inserirRestaurante();
                    break;
                case 4:
                    listarRestaurantes();
                    break;
                case 5:
                    cadastrarVoto();
                    break;
                case 6:
                    listarVotos();
                    break;
                case 7:
                    controller.apurarVotosDoDia();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opcao invalida!!");
                    break;
            }
        }catch (AplicacaoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Código Insere um Funcionario na Tabela
     * @throws AplicacaoException
     */
    private static void inserirFuncionario() throws  AplicacaoException{
        String nome = TecladoUtil.lerString("Informe um nome:");

        controller.inserirFuncionario(nome);
    }
    /**
     * Código Insere um Restaurante na Tabela
     * @throws AplicacaoException
     */
    private static void inserirRestaurante()throws  AplicacaoException{
        String nome=TecladoUtil.lerString("Informe um nome");

        controller.inserirRestaurante(nome);
    }
    /**
     * Código Lista os Funcionarios na Tabela
     * @throws AplicacaoException
     */
    private static  void  listarFuncionarios() {
        System.out.println(controller.listarFuncionarios());
    }
    /**
     * Código Lista os Restaurante na Tabela
     * @throws AplicacaoException
     */
    private static  void  listarRestaurantes() {
        System.out.println(controller.listarRestaurantes());
    }

    /**
     * Código Cadastra o Voto na Tabela
     * @throws AplicacaoException
     */
    private static  void cadastrarVoto() throws  AplicacaoException {
        Integer idFuncionario = TecladoUtil.lerInteiro("Informa e o codigo do Funcionário:");
        Integer idRestaurante = TecladoUtil.lerInteiro("Informa o codigo da restaurante: ");

        controller.inserirVoto(idFuncionario,idRestaurante);
        System.out.println("voto cadastrado!");
    }
    /**
     * Código Lista os Votos na Tabela
     * @throws AplicacaoException
     */
    private static  void listarVotos() throws  AplicacaoException{
        Integer idFuncionario = TecladoUtil.lerInteiro("Informa e o codigo do funcionario:");
        System.out.println(controller.listarVotos(idFuncionario));
    }
    /**
     * Código Imprime o "Visor"
     *
     */
    private static void menu() {
        System.out.println("________________________");
        System.out.println("(1) Cadastrar Funcionario");
        System.out.println("(2) Listar Funcionarios");
        System.out.println("(3) Cadastrar Restaurante");
        System.out.println("(4) Listar Restaurantes");
        System.out.println("(5) Cadastrar voto");
        System.out.println("(6) Listar votos por Funcionario");
        System.out.println("(7) Apurar votos do dia");
        System.out.println("(0) Sair");
        System.out.println("________________________");
    }
}
