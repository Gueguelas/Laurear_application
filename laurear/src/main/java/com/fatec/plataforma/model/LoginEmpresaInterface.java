package com.fatec.plataforma.model;

public interface LoginEmpresaInterface {
    String org = "";

    boolean AutenticarEmpresa(String email, String senha);
}
