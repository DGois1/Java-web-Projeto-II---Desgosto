package pw.project.necogios;

import java.util.ArrayList;
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
   private int idLider;
   
   @ManyToMany
   @Cascade(value = CascadeType.DELETE)
   private List<Usuario> estagiarios;
   
   @Column(name="nomeGrupo", length = 100)
   private String nomeGrupo;

    public Grupo() {
        this.estagiarios = new ArrayList<Usuario>();
    }
    
    

    public int getIdLider() {
        return idLider;
    }

    public void setIdLider(int idLider) {
        this.idLider = idLider;
    }

    public List<Usuario> getEstagiarios() {
        return estagiarios;
    }

    public void setEstagiarios(List<Usuario> estagiarios) {
        this.estagiarios = estagiarios;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }
   
 
   
   
}
