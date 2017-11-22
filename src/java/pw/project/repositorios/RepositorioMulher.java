package pw.project.repositorios;
import java.util.List;
import pw.project.dao.DaoManagerHiber;
import pw.project.interfaces.InterfaceGeral;
import pw.project.necogios.Mulher;
import pw.project.necogios.Usuario;

/**
 *
 * @author Grupo Capitão America
 */
public class RepositorioMulher implements InterfaceGeral<Mulher>{

    @Override
    public void persist(Mulher t) {
         DaoManagerHiber.persist(t);
    }

    @Override
    public Mulher search(int codigo) {
        try{
        return (Mulher)((List<Mulher>)DaoManagerHiber.recover("from Mulher where id="+codigo+"")).get(0);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public void update(Mulher t) {
         DaoManagerHiber.update(t);
    }

    @Override
    public void destroy(Mulher t) {
         DaoManagerHiber.delete(t);
    }

    @Override
    public Mulher searchTxt(String t) {
        try{
        return (Mulher)((List<Mulher>)DaoManagerHiber.recover("from Mulher where nome='"+t+"'")).get(0);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public List<Mulher> listAll() {
         return DaoManagerHiber.recover("from Mulher");
    }
    
    
    public List<Mulher> listLider(Usuario lider) {
         return DaoManagerHiber.recover("from Mulher where lider_id="+lider.getId());
         
    }
    
}
