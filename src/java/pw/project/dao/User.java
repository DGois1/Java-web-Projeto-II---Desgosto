/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw.project.dao;

import pw.project.controladores.ControladorUsuario;
import pw.project.necogios.Usuario;

/**
 *
 * @author Grupo Capitão America
 */
public class User {
    public static void main(String[] args) {
        ControladorUsuario user = new ControladorUsuario();
        Usuario a = new Usuario();
        a.setNome("Flavio");
        a.setCpf("111.475.524-95");
        a.setEmail("flavioedez@hotmail.com");
        a.setSenha("050615");
        a.setCargo("adm");
        user.cadastroUser(a);
    }
}
