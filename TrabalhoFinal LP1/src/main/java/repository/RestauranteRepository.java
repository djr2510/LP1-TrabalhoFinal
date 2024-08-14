package repository;

import model.Funcionario;
import model.Restaurante;

import javax.persistence.*;
import java.util.List;
/**
 * Classe RestauranteRepository.
 *
 * @author Davi
 * @author Gabriel
 * @see java.lang.String
 * @version 1.0
 * @since 24/04/2024
 */
    public class RestauranteRepository {private EntityManager em;

        public RestauranteRepository() {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("EscolaDB");
            em = factory.createEntityManager();
        }
    /**
     * Código Adicionar um restaurante a Tabela
     * @param restaurante
     */
        public void inserir(Restaurante restaurante) {
            this.em.getTransaction().begin();
            this.em.persist(restaurante);
            this.em.getTransaction().commit();
        }
    /**
     * Código Retorna Todos Restaurante
     * @return Retorna Restaurante
     */
        public List<Restaurante> buscar() {
            TypedQuery<Restaurante> buscarTodosQuery = this.em.createQuery("select e from Restaurante e", Restaurante.class);
            try {
                return buscarTodosQuery.getResultList();
            }catch (NullPointerException e){
                return null;
            }
        }
    /**
     * Código buscar um Restaurante pelo ID informado
     * @param id Integer
     * @return Retorna o Restaurante com o ID Correspondente
     */
        public Restaurante buscar(Integer id) {
            return  this.em.find(Restaurante.class, id);
        }
    /**
     * Código Atualiza Restaurante
     * @param restaurante
     */
        public void atualizar(Restaurante restaurante) {
            this.em.getTransaction().begin();
            this.em.merge(restaurante);
            this.em.getTransaction().commit();
        }
    /**
     * Código Remove um Restaurante da tabela
     * @param restaurante
     */
        public void remove(Restaurante restaurante) {
            this.em.remove(restaurante);
        }

        @Override
        public String toString() {
            return "RestauranteRepository{" +
                    "em=" + em +
                    '}';
        }
    }
