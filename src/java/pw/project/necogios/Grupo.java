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
@Table(name="Grupo")
@ManagedBean(name = "grupo")
@RequestScoped
public class Grupo {
   @Id
   @GeneratedValue
   @Column(name="id")
   private int id;
   
   @ManyToMany
   @Cascade(value = CascadeType.DELETE)
   private List<Usuario> grupo;
   
   @ManyToOne
   private Usuario lider;
   
   @Column(name="nomeGrupo", length = 100)
   private String nomeGrupo;
   
    public Grupo(List<Usuario> grupo, Usuario lider) {
        this.grupo = grupo;
        this.lider = lider;
    }
   
    public List<Usuario> getGrupo() {
        return grupo;
    }

    public void setGrupo(List<Usuario> grupo) {
        this.grupo = grupo;
    }

    public Usuario lider() {
        return lider;
    }

    public void setlider(Usuario lider) {
        this.lider = lider;
    }
   
}
