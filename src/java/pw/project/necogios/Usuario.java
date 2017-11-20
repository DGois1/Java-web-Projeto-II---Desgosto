package pw.project.necogios;

import java.util.List;
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
@Table(name="Usuario")
@ManagedBean(name = "usu")
@RequestScoped
public class Usuario {
 @Id
 @GeneratedValue
 @Column(name="id")
 private int id;
 
 @Column(name = "nome", length = 150)
 private String nome;
 
 @Column(name = "cpf", length = 15,unique = true)
 private String cpf;
 
 @Column(name = "email", length = 200)
 private String email;
 
 @Column(name = "senha", length = 10)
 private String senha;
 
 @Column(name = "cargo", length = 80)
 private String cargo;

    public Usuario(int id, String nome, String cpf, String email, String senha, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Usuario() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
 
 
 
}
