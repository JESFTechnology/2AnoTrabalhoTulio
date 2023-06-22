/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author johan
 */
public class DAOGeral {
    
    DAOLocal objDAOLocal = new DAOLocal();
    
    public List<Cidade> getListaCidade() {
        String sql = "SELECT * FROM cidade;";
        List<Cidade> listaCidade = new ArrayList<>();
        try{
            
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            
            {
                Cidade objCidade = new Cidade();
                objCidade.setCodigo(rs.getInt("codCidade"));
                objCidade.setNome(rs.getString("cid"));
                objCidade.setUf(rs.getString("uf"));
                listaCidade.add(objCidade);
            }
            
        }
        
        catch(SQLException ex)
        
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ex.getMessage());
        }
        
        return listaCidade;
    }
    
    public boolean salvarCidade(Cidade obj) {
        if (obj.getCodigo() == null) {
            return incluirCidade(obj);
        }
        else
        {
            return alterarCidade(obj);
        }
    }
    
    public boolean incluirCidade(Cidade objCidade){
        String sql = "INSERT INTO cidade (cidade, uf) values (?,?)";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objCidade.getNome());
            pst.setString(2, objCidade.getUf());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Cidade Incluida com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Cidade não Incluida com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarCidade(Cidade objCidade){
        String sql = "UPDATE cidade SET cidade = ?, uf = ? WHERE codCidade = ?;";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objCidade.getNome());
            pst.setString(2, objCidade.getUf());
            pst.setInt(3, objCidade.getCodigo());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Cidade Alterada com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Cidade não Alterada com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public boolean removerCidade(Cidade objCidade){
        String sql = "DELETE FROM cidade WHERE codCidade = ?;";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, objCidade.getCodigo());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Cidade Apagada com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Cidade não Apagada com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public List<Funcionario> getListaFuncionario() {
        String sql = "SELECT * FROM funcionario;";
        List<Funcionario> listaFuncionario = new ArrayList<>();
        try{
            
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            
            {
                Funcionario objFuncionario = new Funcionario();
                objFuncionario.setCodigo(rs.getInt("codFuncionario"));
                objFuncionario.setNome(rs.getString("nome"));
                objFuncionario.setEmail(rs.getString("email"));
                objFuncionario.setSenha(rs.getString("senha"));
                objFuncionario.setQrcode(rs.getString("qrcode"));
                java.sql.Date dt = rs.getDate("nascimento");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                objFuncionario.setNascimento(c);
                objFuncionario.setSalario(rs.getDouble("salario"));
                objFuncionario.setCargo(rs.getString("cargo"));
                listaFuncionario.add(objFuncionario);
            }
            
        }
        
        catch(SQLException ex)
        
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ex.getMessage());
        }
        
        return listaFuncionario;
    }
    
    public boolean salvarFuncionario(Funcionario obj) {
        if (obj.getCodigo() == null) {
            return incluirFuncionario(obj);
        }
        else
        {
            return alterarFuncionario(obj);
        }
    }
    
    public boolean incluirFuncionario(Funcionario objFuncionario){
        String sql = "INSERT INTO funcionario (nome, email, senha, salario, cargo, nascimento) values (?,?,?,?,?,?)";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objFuncionario.getNome());
            pst.setString(2, objFuncionario.getEmail());
            pst.setString(3, objFuncionario.getSenha());
            pst.setDouble(4, objFuncionario.getSalario());
            pst.setString(5, objFuncionario.getCargo());
            pst.setDate(6, new java.sql.Date
            (objFuncionario.getNascimento().getTimeInMillis()));
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Funcionario Incluida com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Funcionario não Incluida com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarFuncionario(Funcionario objFuncionario){
        String sql = "UPDATE Funcionario SET nome = ?, email = ?, senha = ?, salario = ?, cargo = ? WHERE codFuncionario = ?;";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objFuncionario.getNome());
            pst.setString(2, objFuncionario.getEmail());
            pst.setString(3, objFuncionario.getSenha());
            pst.setDouble(4, objFuncionario.getSalario());
            pst.setString(5, objFuncionario.getCargo());
            pst.setInt(6, objFuncionario.getCodigo());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Funcionario Alterada com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Funcionario não Alterada com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public boolean removerFuncionario(Funcionario objFuncionario){
        String sql = "DELETE FROM funcionario WHERE codFuncionario = ?;";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, objFuncionario.getCodigo());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Funcionario Apagad0 com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Funcionario não Apagado com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public List<Veiculo> getListaVeiculo() {
        String sql = "SELECT * FROM veiculo;";
        List<Veiculo> listaVeiculo = new ArrayList<>();
        try{
            
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            
            {
                Veiculo objVeiculo = new Veiculo();
                objVeiculo.setCodigo(rs.getInt("codVeiculo"));
                objVeiculo.setNome(rs.getString("nome"));
                objVeiculo.setAno(rs.getDouble("ano"));
                objVeiculo.setQuantidade(rs.getDouble("quantidade"));
                objVeiculo.setEspaco(rs.getDouble("espaco"));
                java.sql.Date dt = rs.getDate("compra");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                objVeiculo.setCompra(c);
                objVeiculo.setObjFuncionario(objDAOLocal.localizar(rs.getInt("motorista")));
                objVeiculo.setStatus(rs.getString("status"));
                listaVeiculo.add(objVeiculo);
            }
            
        }
        
        catch(SQLException ex)
        
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ex.getMessage());
        }
        
        return listaVeiculo;
    }
    
    public boolean salvarVeiculo(Veiculo obj) {
        if (obj.getCodigo() == null) {
            return incluirVeiculo(obj);
        }
        else
        {
            return alterarVeiculo(obj);
        }
    }
    
    public boolean incluirVeiculo(Veiculo objVeiculo){
        String sql = "INSERT INTO veiculo (nome, ano, quantidade, status) values (?,?,?,?)";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objVeiculo.getNome());
            pst.setDouble(3, objVeiculo.getAno());
            pst.setDouble(4, objVeiculo.getQuantidade());
            pst.setString(5, objVeiculo.getStatus());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Veiculo Incluido com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Veiculo não Incluido com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarVeiculo(Veiculo objVeiculo){
        String sql = "UPDATE veiculo SET nome = ?, ano = ?, quantidade = ?, status = ? WHERE codVeiculo = ?;";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objVeiculo.getNome());
            pst.setDouble(2, objVeiculo.getAno());
            pst.setDouble(3, objVeiculo.getQuantidade());
            pst.setString(4, objVeiculo.getStatus());
            pst.setInt(5, objVeiculo.getCodigo());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Veiculo Alterado com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Veiculo não Alterado com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public boolean removerVeiculo(Veiculo objVeiculo){
        String sql = "DELETE FROM veiculo WHERE codVeiculo = ?;";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, objVeiculo.getCodigo());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Veiculo Apagado com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Veiculo não Apagado com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public List<Log> getListaLog() {
        String sql = "SELECT * FROM log;";
        List<Log> listaLog = new ArrayList<>();
        try{
            
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            
            {
                Log objLog = new Log();
                objLog.setCodLog(rs.getInt("codLog"));
                objLog.setTabela(rs.getString("tabela"));
                objLog.setAcao(rs.getString("acao"));
                objLog.setOBS(rs.getString("observacao"));
                java.sql.Date dt = rs.getDate("hora");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                objLog.setUsuario(rs.getString("usuario"));
                listaLog.add(objLog);
            }
            
        }
        
        catch(SQLException ex)
        
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ex.getMessage());
        }
        
        return listaLog;
    }
    
    public List<Venda> getListaVenda(){
        String sql = "SELECT * FROM venda;";
        List<Venda> listaVenda = new ArrayList<>();
        try{
            
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            
            {
                Venda objVenda = new Venda();
                objVenda.setCodCliente(rs.getInt("codCliente"));
                objVenda.setCodProdutos(rs.getInt("codProdutos"));
                objVenda.setQuantidadeCompra(rs.getDouble("quantidadeCompra"));
                objVenda.setDados(rs.getString("dados"));
                listaVenda.add(objVenda);
            }
            
        }
        
        catch(SQLException ex)
        
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ex.getMessage());
        }
        
        return listaVenda;
    }
    
    public List<Cliente> getListaCliente(){
        String sql = "SELECT * FROM cliente;";
        List<Cliente> listaCliente = new ArrayList<>();
        try{
            
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            
            {
                Cliente objCliente = new Cliente();
                objCliente.setCodigo(rs.getInt("codCliente"));
                objCliente.setNome(rs.getString("nome"));
                objCliente.setEmail(rs.getString("email"));
                objCliente.setPix(rs.getString("pix"));
                objCliente.setRedesocial(rs.getString("redesocial"));
                objCliente.setLogradouro(rs.getString("logradouro"));
                objCliente.setBairro(rs.getString("bairro"));
                listaCliente.add(objCliente);
            }
            
        }
        
        catch(SQLException ex)
        
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ex.getMessage());
        }
        
        return listaCliente;
    }
    
    public List<Marca> getListaMarca(){
        String sql = "SELECT * FROM marca;";
        List<Marca> listaMarca = new ArrayList<>();
        try{
            
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            
            {
                Marca objMarca = new Marca();
                objMarca.setCodigo(rs.getInt("codMarca"));
                objMarca.setMarca(rs.getString("marca"));
                listaMarca.add(objMarca);
            }
            
        }
        
        catch(SQLException ex)
        
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ex.getMessage());
        }
        
        return listaMarca;
    }
    
    public boolean salvarMarca(Marca obj) {
        if (obj.getCodigo() == null) {
            return incluirMarca(obj);
        }
        else
        {
            return alterarMarca(obj);
        }
    }
    
    public boolean incluirMarca(Marca objMarca){
        String sql = "INSERT INTO marca (marca) values (?)";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objMarca.getMarca());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Marca Incluida com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Marca não Incluida com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarMarca(Marca objMarca){
        String sql = "UPDATE marca SET marca = ? WHERE codMarca = ?;";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objMarca.getMarca());
            pst.setInt(2, objMarca.getCodigo());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Marca Alterada com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Marca não Alterada com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public boolean removerMarca(Marca objMarca){
        String sql = "DELETE FROM marca WHERE codMarca = ?;";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, objMarca.getCodigo());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Marca Apagada com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Marca não Apagada com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public List<Produto> getListaProduto() {
        String sql = "SELECT * FROM produtos;";
        List<Produto> listaProduto = new ArrayList<>();
        try{
            
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            
            {
                Produto objProduto = new Produto();
                objProduto.setCodigo(rs.getInt("codProduto"));
                objProduto.setNome(rs.getString("nome"));
                objProduto.setPreco(rs.getDouble("quantidade"));
                objProduto.setQuantidade(rs.getDouble("quantidade"));
                objProduto.setEstoque(rs.getDouble("estoque"));
                //objFuncionario.setNascimento(rs.get("nascimento"));
                listaProduto.add(objProduto);
            }
            
        }
        
        catch(SQLException ex)
        
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ex.getMessage());
        }
        
        return listaProduto;
    }

    public boolean salvarProduto(Produto obj) {
        if (obj.getCodigo() == null) {
            return incluirProduto(obj);
        }
        else
        {
            return alterarProduto(obj);
        }
    }
    
    public boolean incluirProduto(Produto objProduto){
        String sql = "INSERT INTO produtos (nome, preco, quantidade, estoque) values (?,?,?,?)";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objProduto.getNome());
            pst.setDouble(2, objProduto.getPreco());
            pst.setDouble(3, objProduto.getQuantidade());
            pst.setDouble(4, objProduto.getEstoque());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Veiculo Incluido com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Veiculo não Incluido com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarProduto(Produto objProduto){
        String sql = "UPDATE produtos SET nome = ?, preco = ?, quantidade = ?, estoque = ? WHERE codVeiculo = ?;";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objProduto.getNome());
            pst.setDouble(4, objProduto.getPreco());
            pst.setDouble(3, objProduto.getQuantidade());
            pst.setDouble(4, objProduto.getEstoque());
            pst.setInt(5, objProduto.getCodigo());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Veiculo Alterado com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Veiculo não Alterado com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public boolean removerProduto(Produto objProduto){
        String sql = "DELETE FROM produtos WHERE codProduto = ?;";
        
        try
            
        {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, objProduto.getCodigo());
            
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Produto Apagado com sucesso");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Produto não Apagado com sucesso");
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de SQL"+ex.getMessage());
            return false;
        }
    }
    
    public List<Chat> getListaChat() {
        String sql = "SELECT * FROM chat;";
        List<Chat> listaChat = new ArrayList<>();
        try{
            
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            
            {
                Chat objChat = new Chat();
                objChat.setMensagem(rs.getString("mensagem"));
                listaChat.add(objChat);
            }
            
        }
        
        catch(SQLException ex)
        
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ex.getMessage());
        }
        
        return listaChat;
    }
    
    
    
    
    public List<Avisos> getListaAvisos() {
        String sql = "SELECT * FROM avisos;";
        List<Avisos> listaAvisos = new ArrayList<>();
        try{
            
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            
            {
                Avisos objAvisos = new Avisos();
                objAvisos.setCodigo(rs.getInt("codAviso"));
                objAvisos.setProduto(rs.getString("produto"));
                objAvisos.setAviso(rs.getString("aviso"));
                java.sql.Date dt = rs.getDate("data");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                objAvisos.setData(c);
                objAvisos.setStatus(rs.getString("status"));
                listaAvisos.add(objAvisos);
            }
            
        }
        
        catch(SQLException ex)
        
        {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ex.getMessage());
        }
        
        return listaAvisos;
    }
}
