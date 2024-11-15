package com.fatec.plataforma.model;

public interface LoginColaboradorInterface {
    int matricula = 0;

    boolean AutenticarColaborador(int matricula, String senha);
}
