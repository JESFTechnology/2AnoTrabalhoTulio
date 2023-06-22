/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.Transient;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author johan
 */
public class Veiculo implements Serializable{
    private Integer codigo;
    private String nome;
    private Double ano;
    private Calendar compra;
    private Funcionario objFuncionario;
    private Produto objProduto;
    private Double quantidade;
    private String status;
    private Double espaco;

    public Integer getCodigo() {
        return codigo;
    }

    public Funcionario getObjFuncionario() {
        return objFuncionario;
    }

    public void setObjFuncionario(Funcionario objFuncionario) {
        this.objFuncionario = objFuncionario;
    }

    public Double getEspaco() {
        return espaco;
    }

    public void setEspaco(Double espaco) {
        this.espaco = espaco;
    }
    
    

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getAno() {
        return ano;
    }

    public void setAno(Double ano) {
        this.ano = ano;
    }

    public Calendar getCompra() {
        return compra;
    }

    public void setCompra(Calendar compra) {
        this.compra = compra;
    }

    public Produto getObjProduto() {
        return objProduto;
    }

    public void setObjProduto(Produto objProduto) {
        this.objProduto = objProduto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    @Transient  // não persistente na lista e no banco de dados 
   public String getAnoFormatado(){
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       return sdf.format(compra.getTime());
   }
   
   @Override
    public String toString(){
        return nome;
    }
}
