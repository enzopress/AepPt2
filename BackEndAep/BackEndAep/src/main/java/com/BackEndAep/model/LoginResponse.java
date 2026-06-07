package com.BackEndAep.model;

public class LoginResponse {

    private boolean sucesso;
    private String mensagem;
    private String nome;
    private String perfil;
    private String identificador;

    public LoginResponse() {
    }

    public LoginResponse(
            boolean sucesso,
            String mensagem,
            String nome,
            String perfil,
            String identificador) {

        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.nome = nome;
        this.perfil = perfil;
        this.identificador = identificador;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}