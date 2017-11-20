package pw.project.necogios;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
   
   @Column(name = "cilco", length = 60)
   private String ciclo;
   
   @Column(name = "andCiclo")
   private Date andCiclo;

    public Mulher(String nome, String idade, String ciclo, Date andCiclo) {
        this.nome = nome;
        this.idade = idade;
        this.ciclo = ciclo;
        this.andCiclo = andCiclo;
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

    public Date getAndCilco() {
        return andCiclo;
    }

    public void setAndCilco(Date andCiclo) {
        this.andCiclo = andCiclo;
    }
   
   
}
