package repository;

import model.Funcionario;
import model.Restaurante;
import model.Voto;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
/**
 * Classe VotoRepository.
 *
 * @author Davi
 * @author Gabriel
 * @see java.lang.String
 * @version 1.0
 * @since 24/04/2024
 */
public class VotoRepository {    private EntityManager em;

    public VotoRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EscolaDB");
        em = factory.createEntityManager();
    }
    /**
     * Código Adicionar um Voto a Tabela
     * @param voto
     */
    public void inserir(Voto voto) {
        this.em.getTransaction().begin();
        this.em.persist(voto);
        this.em.getTransaction().commit();
    }
    /**
     * Código Retorna Todos Votos
     * @return Retorna Votos
     */
    public List<Voto> buscar() {
        TypedQuery<Voto> buscarTodosQuery = this.em.createQuery("select e from Voto e", Voto.class);
        try {
            return buscarTodosQuery.getResultList();
        }catch (IllegalArgumentException e){
            return null;
        }
    }
    /**
     * Código buscar um Voto pelo Funcionario e data informado
     * @param data Calendar
     * @param funcionario Funcionario
     * @return Retorna o Voto com o Funcionario e data Correspondente
     */
    public Voto buscarPorData(Funcionario funcionario, Calendar data){
        TypedQuery<Voto> query = this.em.createQuery("select e from Voto e where e.funcionario = :funcionario and e.data = :data", Voto.class);
        query.setParameter("funcionario", funcionario);
        query.setParameter("data", data, TemporalType.DATE);

        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }catch (IllegalArgumentException e) {
        return  null;
    }
        /**
         * Código buscar Votos pela data informado
         * @param data Calendar
         * @return Retorna o Funcionario com o ID Correspondente
         */
    }
    public List<Voto> apurar(Calendar data){
        TypedQuery<Voto> query = this.em.createQuery("select e from Voto e where e.data = :data", Voto.class);
        query.setParameter("data", data, TemporalType.DATE);

        try{
            return query.getResultList();
        }catch (NoResultException e){
            return null;
        }catch (IllegalArgumentException e) {
            return  null;
        }
    }
    /**
     * Código Atualiza Voto
     * @param voto
     */
    public void atualizar(Voto voto) {
        this.em.getTransaction().begin();
        this.em.merge(voto);
        this.em.getTransaction().commit();
    }
}
