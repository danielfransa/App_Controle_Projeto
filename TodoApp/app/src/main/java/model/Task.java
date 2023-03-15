package model;

import java.util.Date;
import javax.swing.JFormattedTextField;

public class Task {
    
    private int id;
    private String nome;
    private String descricao;
    private boolean status;
    private String observacao;
    private Date prazo;
    private Date dataCriacao;
    private Date dataModificacao;
    private int idProj;

    public Task(int id, String nome, String descricao, boolean status, String observacao, Date prazo, Date dataCriacao, Date dataModificacao, int idProj) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.observacao = observacao;
        this.prazo = prazo;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
        this.idProj = idProj;
    }
    
    public Task() {
        this.dataCriacao = new Date();
        this.dataModificacao = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public int getIdProj() {
        return idProj;
    }

    public void setIdProj(int idProj) {
        this.idProj = idProj;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", status=" + status + ", observacao=" + observacao + ", prazo=" + prazo + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + ", idProj=" + idProj + '}';
    }
    
}
