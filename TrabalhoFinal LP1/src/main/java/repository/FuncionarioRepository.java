package repository;

import model.Funcionario;
import model.Voto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
/**
 * Classe FuncionarioRepository.
 *
 * @author Davi
 * @author Gabriel
 * @see java.lang.String
 * @version 1.0
 * @since 24/04/2024
 */
public class FuncionarioRepository {private EntityManager em;

    public FuncionarioRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EscolaDB");
        em = factory.createEntityManager();
    }

    /**
     * Código Adicionar um Funcionario a Tabela
     * @param funcionario
     */

    public void inserir(Funcionario funcionario) {
        this.em.getTransaction().begin();
        this.em.persist(funcionario);
        this.em.getTransaction().commit();
    }

    /**
     * Código Retorna Todos Funcionarios
     * @return Retorna Funcionarios
     */
    public List<Funcionario> buscar() {
        TypedQuery<Funcionario> buscarTodosQuery = this.em.createQuery("select e from Funcionario e", Funcionario.class);
       try {
           return buscarTodosQuery.getResultList();
       }catch (NullPointerException e){
           return null;
       }
    }
    /**
     * Código buscar um Funcionario pelo ID informado
     * @param id Integer
     * @return Retorna o Funcionario com o ID Correspondente
     */
    public Funcionario buscar(Integer id) {
        return  this.em.find(Funcionario.class, id);
    }

    /**
     * Código Atualiza Funcionario
     * @param funcionario
     */

    public void atualizar(Funcionario funcionario) {
        this.em.getTransaction().begin();
        this.em.merge(funcionario);
        this.em.getTransaction().commit();
    }

    /**
     * Código Remove um Funcionario da tabela
     * @param funcionario
     */
    public void remove(Funcionario funcionario) {
        this.em.remove(funcionario);
    }

    @Override
    public String toString() {
        return "FuncionarioRepository{" +
                "em=" + em +
                '}';
    }
}
