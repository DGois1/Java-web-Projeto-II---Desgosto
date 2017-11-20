package pw.project.repositorios;

import java.util.List;
import pw.project.dao.DaoManagerHiber;
import pw.project.interfaces.InterfaceGeral;
import pw.project.necogios.Usuario;

/**
 *
 * @author Grupo Capitão America
 */
public class RepositorioUsuario implements InterfaceGeral<Usuario>{

    @Override
    public void persist(Usuario t) {
         DaoManagerHiber.persist(t);
    }

    @Override
    public Usuario search(int codigo) {
        try{
        return (Usuario)((List<Usuario>)DaoManagerHiber.recover("from Usuario where id="+codigo+"")).get(0);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public void update(Usuario t) {
       DaoManagerHiber.update(t);  
    }

    @Override
    public void destroy(Usuario t) {
        DaoManagerHiber.delete(t);    
    }

    @Override
    public Usuario searchTxt(String t) {
        try{
        return (Usuario)((List<Usuario>)DaoManagerHiber.recover("from Usuario where nome='"+t+"'")).get(0);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public List<Usuario> listAll() {
         return DaoManagerHiber.recover("from Usuario");
    }
    
    public Usuario login (String login, String senha){
       try{
        return (Usuario)((List<Usuario>)DaoManagerHiber.recover("from Usuario where email='"+login+"'")).get(0);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }
    
}
