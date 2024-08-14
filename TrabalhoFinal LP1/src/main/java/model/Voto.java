package model;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
/**
 * Classe Voto.
 *
 * @author Davi
 * @author Gabriel
 * @see java.lang.String
 * @version 1.0
 * @since 24/04/2024
 */
@Entity
@Table (name="Voto")
public class Voto {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE , generator="voto_generator")
    @TableGenerator(name="voto_generator",
            table="chave",
            pkColumnName="id",
            valueColumnName="valor",
            allocationSize=1)
    @Column(name = "id")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private Calendar data;
    //data
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id")
    private Restaurante restaurante;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private Funcionario funcionario;

    public Voto(Restaurante restaurante) {
        this.restaurante = restaurante;
        data = Calendar.getInstance();
    }

    public Voto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", funcionario='" + funcionario.getNome() + '\''+
                ", restaurante='" + restaurante.getNome() + '\''+
                ", data='" + data + '\''+
                '}';
    }
}
