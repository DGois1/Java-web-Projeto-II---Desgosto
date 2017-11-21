package pw.project.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import pw.project.necogios.Grupo;
import pw.project.necogios.Usuario;
import pw.project.repositorios.RepositorioGrupo;
import pw.project.repositorios.RepositorioUsuario;
/**
 *
 * @author Grupo Capitão America
 */
@ManagedBean(name="controladoUser")
@SessionScoped
public class ControladorUsuario implements Serializable{
    
   private  RepositorioUsuario rp;
   private RepositorioGrupo rg;
   
   private String senha;
   private String email;

    public ControladorUsuario() {
        this.rp = new RepositorioUsuario();
        this.rg = new RepositorioGrupo();
    }

    public void cadastroUser(Usuario u){
        
        Usuario ur =(Usuario)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("usuarioLogado");
         // JOptionPane.showMessageDialog(null, ur.getId());
        if(u.getCargo().equals("lider")){
             rp.persist(u);
             Usuario b = rp.searchTxt(u.getNome());
             Grupo g = new Grupo();
             g.setIdLider(b.getId());
             g.setNomeGrupo(b.getNome());
             g.getEstagiarios().add(b);
             rg.persist(g);
             
        }else if(u.getCargo().equals("estagiario")){
             rp.persist(u);
             Usuario b = rp.searchTxt(u.getNome());
             Grupo t = rg.search(ur.getId());

             if(t == null){
                JOptionPane.showMessageDialog(null, "erro!"); 
             }else{
                 t.getEstagiarios().add(b);
                 rg.update(t);
             }
             
        }else if (u.getCargo().equals("adm")){
          rp.persist(u); 
        }
       
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
    
    public String login(String login, String senha){
         Usuario uso = rp.login(login);
        if(uso == null){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario","Senha ou Login não Conferem"));
           return null;
         }
         if(!uso.getSenha().equals(senha)){
             return null; 
         }
       ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("usuarioLogado", uso);
       
       JOptionPane.showMessageDialog(null, uso.getId());
       return "home.xhtml";
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
