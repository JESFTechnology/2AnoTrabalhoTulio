/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author johan
 */
public class DAOLocal {
    public Funcionario localizar(Integer id){
        String sql = "SELECT * FROM funcionario WHERE codFuncionario = ?;";
        Funcionario objFuncionario = new Funcionario();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                objFuncionario.setCodigo(rs.getInt("codFuncionario"));
                objFuncionario.setNome(rs.getString("nome"));
                return objFuncionario;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ex.getMessage());
        }
        return null;
    }
}
