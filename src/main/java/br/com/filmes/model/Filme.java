package br.com.filmes.model;

import java.util.Date;

public class Filme {

    private int id;
    private String nomeFilme;
    private String genero;
    private int duracao;
    private Date dataCadastro;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nomeFilme='" + nomeFilme + '\'' +
                ", genero='" + genero + '\'' +
                ", duracao=" + duracao +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
