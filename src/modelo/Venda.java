/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author johan
 */
public class Venda implements Serializable{
    
    private Integer codCliente;
    private Integer codProdutos;
    private Double quantidadeCompra;
    private String dados;

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCodProdutos() {
        return codProdutos;
    }

    public void setCodProdutos(Integer codProdutos) {
        this.codProdutos = codProdutos;
    }

    public Double getQuantidadeCompra() {
        return quantidadeCompra;
    }

    public void setQuantidadeCompra(Double quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codCliente);
        hash = 97 * hash + Objects.hashCode(this.codProdutos);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.codCliente, other.codCliente)) {
            return false;
        }
        if (!Objects.equals(this.codProdutos, other.codProdutos)) {
            return false;
        }
        return true;
    }
    
    
}
