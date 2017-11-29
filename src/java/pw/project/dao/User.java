/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw.project.dao;

import java.util.List;
import pw.project.controladores.ControladorUsuario;
import pw.project.necogios.Grupo;
import pw.project.necogios.Usuario;
import pw.project.repositorios.RepositorioGrupo;
import pw.project.repositorios.RepositorioUsuario;

/**
 *
 * @author Grupo Capitão America
 */
public class User {
    public static void main(String[] args) {
        ControladorUsuario user = new ControladorUsuario();
        RepositorioUsuario p = new RepositorioUsuario();
        Usuario a = p.login("13@");
      /*  a.setNome("Denis1");
        a.setCpf("086.912.544-33");
        a.setEmail("denisgm1010@hotmail.com");
        a.setSenha("fodase0");
        a.setCargo("adm");
        user.cadastroUser(a);*/
      
        //System.out.print(a.getNome());
       
       
        
        RepositorioGrupo RG = new RepositorioGrupo();
       List<Grupo> g = RG.listAll();
        System.out.print(g.get(0).getNomeGrupo());
        
    }
}
