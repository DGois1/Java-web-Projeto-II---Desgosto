package pw.project.repositorios;

import java.util.List;
import pw.project.dao.DaoManagerHiber;
import pw.project.interfaces.InterfaceGeral;
import pw.project.necogios.Consulta;
/**
 *
 * @author Grupo Capitão America
 */
public class RepositorioConsulta implements InterfaceGeral<Consulta> {

    @Override
    public void persist(Consulta t) {
         DaoManagerHiber.persist(t);
    }

    @Override
    public Consulta search(int codigo) {
        try{
        return (Consulta)((List<Consulta>)DaoManagerHiber.recover("from Consulta where id="+codigo+"")).get(0);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public void update(Consulta t) {
         DaoManagerHiber.update(t);
    }

    @Override
    public void destroy(Consulta t) {
      DaoManagerHiber.delete(t);
    }

    @Override
    public Consulta searchTxt(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consulta> listAll() {
        return DaoManagerHiber.recover("from Caonsulta");    
    }
}
