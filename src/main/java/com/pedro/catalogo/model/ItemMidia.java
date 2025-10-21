package com.pedro.catalogo.model;

public class ItemMidia {
    private int id;
    private String titulo;
    private String autorDiretor;
    private int anoLancamento;
    private String genero;
    private String tipoMidia;
    private String sinopse;
    private int avaliacao;

    public ItemMidia() {}

    public ItemMidia(String titulo, String autorDiretor, int anoLancamento, String genero, String tipoMidia, String sinopse, int avaliacao) {
        this.titulo = titulo;
        this.autorDiretor = autorDiretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.tipoMidia = tipoMidia;
        this.sinopse = sinopse;
        this.avaliacao = avaliacao;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutorDiretor() { return autorDiretor; }
    public void setAutorDiretor(String autorDiretor) { this.autorDiretor = autorDiretor; }

    public int getAnoLancamento() { return anoLancamento; }
    public void setAnoLancamento(int anoLancamento) { this.anoLancamento = anoLancamento; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getTipoMidia() { return tipoMidia; }
    public void setTipoMidia(String tipoMidia) { this.tipoMidia = tipoMidia; }

    public String getSinopse() { return sinopse; }
    public void setSinopse(String sinopse) { this.sinopse = sinopse; }

    public int getAvaliacao() { return avaliacao; }
    public void setAvaliacao(int avaliacao) { this.avaliacao = avaliacao; }
}
