/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw.project.controladores;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pw.project.necogios.Mulher;
import pw.project.repositorios.RepositorioMulher;

/**
 *
 * @author Grupo Capitão America
 */
@ManagedBean(name="cM")
@SessionScoped
public class ControladorMulher {
    
    RepositorioMulher rm;

    public ControladorMulher() {
        this.rm = new RepositorioMulher();
    }

    public void cadastroMulher(Mulher m){
        rm.persist(m);
    }
    public void atualizar(Mulher m){
        rm.update(m);
    }
    public void deletar(Mulher m){
        rm.destroy(m);
    }
    
    public Mulher busca (String nome){
        return rm.searchTxt(nome);
    }
    
    public Mulher busca2 (int codigo){
        return rm.search(codigo);
    }
    
    public ArrayList<Mulher> lista (){
        return (ArrayList<Mulher>) rm.listAll();
    }
}
