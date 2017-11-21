package pw.project.controladores;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pw.project.necogios.Grupo;
import pw.project.repositorios.RepositorioGrupo;

/**
 *
 * @author Grupo Capitão America
 */
@ManagedBean(name="control-consulta")
@SessionScoped
public class ControladorConsulta {
    
    RepositorioGrupo rc;

    public ControladorConsulta() {
        this.rc = new RepositorioGrupo();
    }
    
     public void cadastroUser(Grupo c){
        
    }
    public void atualizar(Grupo c){
        
    }
    public void deletar(Grupo c){
        
    }
    
    public Grupo busca (String nome){
        return null;
    }
    
    public Grupo busca2 (int codigo){
        return null;
    }
    
    public ArrayList<Grupo> lista (){
        return null;
    }
}
