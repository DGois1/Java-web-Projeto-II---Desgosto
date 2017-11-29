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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Grupo Capitão America
 */

@Entity
@Table(name="grupo")
@ManagedBean(name = "grupo")
@RequestScoped
public class Grupo {
   @Id
   @GeneratedValue
   private int id;
   
   @ManyToOne
   private Usuario estagiarios;
   
   @ManyToOne
   private Usuario lider;
   
   @Column(name="nomeGrupo", length = 100)
   private String nomeGrupo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getLider() {
        return lider;
    }

    public void setLider(Usuario lider) {
        this.lider = lider;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public Usuario getEstagiarios() {
        return estagiarios;
    }

    public void setEstagiarios(Usuario estagiarios) {
        this.estagiarios = estagiarios;
    }
   
 
   
   
}
