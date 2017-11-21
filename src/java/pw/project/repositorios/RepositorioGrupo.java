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
        return (Grupo)((List<Grupo>)DaoManagerHiber.recover("from Consulta where id="+codigo+"")).get(0);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Grupo> listAll() {
        return DaoManagerHiber.recover("from Consulta");    
    }
}
