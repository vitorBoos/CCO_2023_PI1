package org.example;

import org.example.Usuario.Login;
import org.example.InserirBanco.InserirComponentesBanco;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        InserirComponentesBanco inserirComponentesBanco = new InserirComponentesBanco();

        login.getDadosBD();

        inserirComponentesBanco.exibirMensagensComponente();
        inserirComponentesBanco.inserirCompoenentesBanco();

    }
}
