package pw.project.controladores;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pw.project.necogios.Consulta;
import pw.project.repositorios.RepositorioConsulta;

/**
 *
 * @author Grupo Capitão America
 */
@ManagedBean(name="control-consulta")
@SessionScoped
public class ControladorConsulta {
    
    RepositorioConsulta rc;

    public ControladorConsulta() {
        this.rc = new RepositorioConsulta();
    }
    
     public void cadastroUser(Consulta c){
        
    }
    public void atualizar(Consulta c){
        
    }
    public void deletar(Consulta c){
        
    }
    
    public Consulta busca (String nome){
        return null;
    }
    
    public Consulta busca2 (int codigo){
        return null;
    }
    
    public ArrayList<Consulta> lista (){
        return null;
    }
}
