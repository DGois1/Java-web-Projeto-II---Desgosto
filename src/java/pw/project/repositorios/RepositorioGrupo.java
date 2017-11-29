package pw.project.repositorios;

import java.util.List;
import pw.project.dao.DaoManagerHiber;
import pw.project.interfaces.InterfaceGeral;
import pw.project.necogios.Grupo;
/**
 *
 * @author Grupo Capitão America
 */
public class RepositorioGrupo implements InterfaceGeral<Grupo> {

    @Override
    public void persist(Grupo t) {
         DaoManagerHiber.persist(t);
    }

    @Override
    public Grupo search(int codigo) {
        try{
        return (Grupo)((List<Grupo>)DaoManagerHiber.recover("from grupo where estagiarios_id="+codigo+"")).get(0);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public void update(Grupo t) {
         DaoManagerHiber.update(t);
    }

    @Override
    public void destroy(Grupo t) {
      DaoManagerHiber.delete(t);
    }

    @Override
    public Grupo searchTxt(String t) {
        try{
        return (Grupo)((List<Grupo>)DaoManagerHiber.recover("from grupo where nomeGrupo='"+t+"'")).get(0);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public List<Grupo> listAll() {
        return DaoManagerHiber.recover("from grupo");    
    }
}
