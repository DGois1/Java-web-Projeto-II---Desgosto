package pw.project.necogios;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Grupo Capitão America
 */

@Entity
@Table(name="Consulta")
@ManagedBean(name = "consulta")
@RequestScoped
public class Consulta {
   @Id
   @GeneratedValue
   @Column(name="id")
   private int id;
   
   @ManyToMany
   @Cascade(value = CascadeType.DELETE)
   private List<Usuario> grupo;
   
   @ManyToOne
   private Mulher paciente;
   
   @Column(name="data")
   private Date data;

    public Consulta(List<Usuario> grupo, Mulher paciente, Date data) {
        this.grupo = grupo;
        this.paciente = paciente;
        this.data = data;
    }
   
    public List<Usuario> getGrupo() {
        return grupo;
    }

    public void setGrupo(List<Usuario> grupo) {
        this.grupo = grupo;
    }

    public Mulher getPaciente() {
        return paciente;
    }

    public void setPaciente(Mulher paciente) {
        this.paciente = paciente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
   
   
}
