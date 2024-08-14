package controller;

import exception.AplicacaoException;
import model.Funcionario;
import model.Restaurante;
import model.Voto;
import repository.FuncionarioRepository;
import repository.RestauranteRepository;
import repository.VotoRepository;

import javax.persistence.PersistenceException;
import java.util.Calendar;
import java.util.List;
/**
 * Classe VotacaoController.
 *
 * @author Davi
 * @author Gabriel
 * @see java.lang.String
 * @version 1.0
 * @since 24/04/2024
 */
public class VotacaoController {
    private FuncionarioRepository funcionarioRepository;
    private RestauranteRepository restauranteRepository;
    private VotoRepository votoRepository;

   public  VotacaoController() {
        this.funcionarioRepository = new FuncionarioRepository();
        this.restauranteRepository = new RestauranteRepository();
        this.votoRepository = new VotoRepository();
    }
    /**
     * Código Insere um Funcionario na Tabela
     * @param nome String
     * @throws AplicacaoException
     */
    public void inserirFuncionario(String nome) throws AplicacaoException {
        try {
            Funcionario funcionario = new Funcionario(nome);

            funcionarioRepository.inserir(funcionario);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new AplicacaoException("Falha ao inserir funcionario", e);
        }
    }
    /**
     * Código Insere um Restaurante na Tabela
     * @param restauranteNome String
     * @throws AplicacaoException
     */
    public void inserirRestaurante(String restauranteNome) throws AplicacaoException{
       try {
           Restaurante restaurante = new Restaurante(restauranteNome);
           restauranteRepository.inserir(restaurante);
       } catch (PersistenceException e) {
           e.printStackTrace();
           throw new AplicacaoException("Falha ao inserir funcionario", e);
       }
        /**
         * Código Insere um Voto na tabela
         * @param idFuncionario Integer
         * @param idRestaurante Integer
         * @throws AplicacaoException
         */
    }
    public void inserirVoto(Integer idFuncionario, Integer idRestaurante) throws  AplicacaoException {
        Funcionario funcionario = funcionarioRepository.buscar(idFuncionario);
        if(funcionario == null) {
            throw new AplicacaoException("Funcionario nao encontrado");
        }
        Restaurante restaurante = restauranteRepository.buscar(idRestaurante);
        if(restaurante == null) {
            throw new AplicacaoException("Restaurante nao encontrado");
        }

        Voto voto = votoRepository.buscarPorData(funcionarioRepository.buscar(idFuncionario),Calendar.getInstance());
        if (voto==null){
            voto = new Voto(restaurante);
            voto.setFuncionario(funcionario);
            try {
                votoRepository.atualizar(voto);
            }catch (PersistenceException e) {
                e.printStackTrace();
                throw new AplicacaoException("Falha ao inserir Voto");
            }
        }else {System.out.println("Funcionario Ja votou Hoje");}
        /**
         * Código Lista os Votos Ocorridos no dia
         * @return Votos do Dia
         */
    }
    public void apurarVotosDoDia(){
        Calendar data = Calendar.getInstance();
        List<Voto> votos = votoRepository.apurar(data);
       for (Voto voto:votos){
            System.out.println("Voto para "+voto.getRestaurante().getNome()+"|Voto ID:"+voto.getId()+"|");
       }
    }
    /**
     * Código Lista os Funcionarios
     * @return Funcionarios
     */
    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.buscar();
    }
    /**
     * Código Lista os Restaurantes
     * @return Restaurantes
     */
    public List<Restaurante> listarRestaurantes() {
        return (List<Restaurante>) restauranteRepository.buscar();
    }
    /**
     * Código Lista os Votos de um Funcinario informado
     * @param idFuncionario Integer
     * @return Votos
     */
    public List<Voto> listarVotos(Integer idFuncionario) throws  AplicacaoException{
        Funcionario funcionario = funcionarioRepository.buscar(idFuncionario);

        if(funcionario == null) {
            throw new AplicacaoException("Aluno nao encontrado");
        }

        return funcionario.getVotos();
    }

}
