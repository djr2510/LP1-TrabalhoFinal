package model;
import repository.VotoRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Classe Funcionario.
 *
 * @author Davi
 * @author Gabriel
 * @see java.lang.String
 * @version 1.0
 * @since 24/04/2024
 */
@Entity
@Table (name="Funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE , generator="funcionario_generator")
    @TableGenerator(name="funcionario_generator",
            table="chave",
            pkColumnName="id",
            valueColumnName="valor",
            allocationSize=1)
    @Column(name = "id")
    private Integer id;
    @Column (name="nome", length=45, nullable=false)
    private String Nome;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<Voto> votos;

    public void add(Voto voto) {
        if(votos == null) {
            votos = new ArrayList<>();
        }

        voto.setFuncionario(this);
        votos.add(voto);
    }
    public Funcionario() {

    }

    public Funcionario(String nome) {
        Nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + Nome + '\''+
                '}';
    }
}
