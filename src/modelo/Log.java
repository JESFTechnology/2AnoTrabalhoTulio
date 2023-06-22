/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author johan
 */
public class Log implements Serializable{
    private Integer codLog;
    private String acao;
    private String tabela;
    private String OBS;
    private String usuario;
    private Calendar hora;

    public Integer getCodLog() {
        return codLog;
    }

    public void setCodLog(Integer codLog) {
        this.codLog = codLog;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getOBS() {
        return OBS;
    }

    public void setOBS(String OBS) {
        this.OBS = OBS;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codLog);
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
        final Log other = (Log) obj;
        if (!Objects.equals(this.codLog, other.codLog)) {
            return false;
        }
        return true;
    }
    
    
    
}
