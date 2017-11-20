package pw.project.interfaces;

import java.util.List;
/**
 *
 * @author Grupo Capitão America
 */
public interface InterfaceGeral <T> {
    public void persist (T t);
    public T search(int codigo);
    public void update (T t);
    public void destroy (T t);
    public T searchTxt(String t);
    public List<T> listAll();
}
