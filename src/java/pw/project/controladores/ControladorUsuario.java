package pw.project.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import pw.project.necogios.Usuario;
import pw.project.repositorios.RepositorioUsuario;
/**
 *
 * @author Grupo Capitão America
 */
@ManagedBean(name="controladoUser")
@SessionScoped
public class ControladorUsuario implements Serializable{
    
   private  RepositorioUsuario rp;
   
   private String senha;
   private String email;

    public ControladorUsuario() {
        this.rp = new RepositorioUsuario();
    }

    public void cadastroUser(Usuario u){
        rp.persist(u);
    }
    public void atualizar(Usuario u){
        rp.update(u);
    }
    public void deletar(Usuario u){
        rp.destroy(u);
    }
    
    public Usuario busca (String nome){
        return rp.searchTxt(nome);
    }
    
    public Usuario busca2 (int codigo){
        return rp.search(codigo);
    }
    
    public ArrayList<Usuario> lista (){
        return (ArrayList<Usuario>) rp.listAll();
    }
    
    public String login(){
         Usuario u = rp.login(email, senha);
        if(u == null){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario","Senha ou Login não Conferem"));
           return null;
         }
         if(!u.getSenha().equals(senha)){
             return null; 
         }
         
       ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("usuarioLogado", u);
       
       
       
       return "welcomePrimefaces.xhtml";
    }

    public RepositorioUsuario getRp() {
        return rp;
    }

    public void setRp(RepositorioUsuario rp) {
        this.rp = rp;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
