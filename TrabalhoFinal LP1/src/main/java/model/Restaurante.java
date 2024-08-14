package model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe Restaurante.
 *
 * @author Davi
 * @author Gabriel
 * @see java.lang.String
 * @version 1.0
 * @since 24/04/2024
 */

@Entity
@Table (name="Restaurante")
public class Restaurante {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE , generator="restaurante_generator")
    @TableGenerator(name="restaurante_generator",
            table="chave",
            pkColumnName="id",
            valueColumnName="valor",
            allocationSize=1)
    @Column(name = "id")
    private Integer id;

    @OneToMany (fetch = FetchType.LAZY)
    private List<Voto> votos;
    @Column (name="nome", length=45, nullable=false)
    private String Nome;

    public Restaurante( String nome) {
        Nome = nome;
    }
    public Restaurante() {
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
    public String toString() {
        return "restaurante{" +
                "id=" + id +
                ", nome='" + Nome + '\''+
                '}';
    }
}
