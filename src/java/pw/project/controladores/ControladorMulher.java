/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw.project.controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import pw.project.necogios.Grupo;
import pw.project.necogios.Mulher;
import pw.project.necogios.Usuario;
import pw.project.repositorios.RepositorioGrupo;
import pw.project.repositorios.RepositorioMulher;

/**
 *
 * @author Grupo Capitão America
 */
@ManagedBean(name="cM")
@SessionScoped
public class ControladorMulher {
    
    Usuario ur = (Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("usuarioLogado");

    Date date;
    RepositorioMulher rm;
    RepositorioGrupo rg;

    public ControladorMulher() {
        this.rm = new RepositorioMulher();
    }

    public void cadastroMulher(Mulher m) {
        
        JOptionPane.showMessageDialog(null, ur.getId());
  
        List<Grupo> g = rg.listAll();
        Grupo a = null;
        for (int i = 0; i < g.size(); i++) {
            if(g.get(i).getLider().getId() == ur.getId()){
                a = g.get(i);
            }
        }
        JOptionPane.showMessageDialog(null, g.get(0));
        //m.setLider(a.getLider());
        
        m.setAndCiclo(date);
        rm.persist(m);
        Mulher mu = rm.searchTxt(m.getNome());
        
        //Date a = uso.get(i).getDataM();
        String formato = "dd/MM/yyyy";
        SimpleDateFormat dataFormatada = new SimpleDateFormat(formato);
        
        Date dataN = m.getAndCiclo();
        JOptionPane.showMessageDialog(null, dataN);
        
        double soma = 0;
        if (m.getCiclo().equals("Regular")) {
            for (int v = 0; v < 28; v++) {
                soma += (24 * 60 * 60 * 1000);
            }
            dataN.setTime((long) (dataN.getTime() + soma));
            //System.out.println("FODASE" + dataN);
            //JOptionPane.showMessageDialog(null, dataN);
        } else if (m.getCiclo().equals("Irregular")) {
            for (int b = 0; b < 23; b++) {
                soma += (24 * 60 * 60 * 1000);
            }
            dataN.setTime((long) (dataN.getTime() + soma));
            //System.out.println("FODASE" + dataN);
            //JOptionPane.showMessageDialog(null, dataN);
        }
        mu.setNovoCiclo(dataN);
        JOptionPane.showMessageDialog(null, dataN);
       
        rm.update(mu);

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
    
    public List<Mulher> lista (){
        return (List<Mulher>) rm.listAll();
    }
    public List<Mulher> listaLider (){
        
         List<Mulher> listaL = rm.listAll();
        
         List<Mulher> listaN = new ArrayList<>();
         for (int i = 0; i < listaL.size(); i++) {
            if(listaL.get(i).getLider().getId() == ur.getId()){
                listaN.add(listaL.get(i));
            }
        }
         
        return listaN;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
