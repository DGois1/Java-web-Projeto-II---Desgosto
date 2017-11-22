package pw.project.necogios;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Grupo Capitão America
 */

@Entity
@Table(name="Mulher")
@ManagedBean(name = "mulher")
@RequestScoped
public class Mulher {
   @Id
   @GeneratedValue
   @Column(name="id")
   private int id;
   
   @Column(name = "nome", length = 60)
   private String nome;
   
   @Column(name = "idade", length = 60)
   private String idade;
   
   @Column(name = "ciclo", length = 60)
   private String ciclo;
   
   @Column(name = "andCiclo")
   private Date andCiclo;
   
   @Column(name = "novoCiclo")
   private Date novoCiclo;
   
   @OneToOne
   private Usuario lider;

    public Mulher(int id, String nome, String idade, String ciclo, Date andCiclo, Date novoCiclo, Usuario lider) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.ciclo = ciclo;
        this.andCiclo = andCiclo;
        this.novoCiclo = novoCiclo;
        this.lider = lider;
    }
    public Mulher() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Date getAndCiclo() {
        return andCiclo;
    }

    public void setAndCiclo(Date andCiclo) {
        this.andCiclo = andCiclo;
    }

    public Date getNovoCiclo() {
        return novoCiclo;
    }

    public void setNovoCiclo(Date novoCiclo) {
        this.novoCiclo = novoCiclo;
    }

    public Usuario getLider() {
        return lider;
    }

    public void setLider(Usuario estagiario) {
        this.lider = lider;
    }
    
    
   
   
}
