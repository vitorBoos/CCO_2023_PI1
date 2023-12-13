package org.example.Componentes;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;

import java.util.List;

public class CPU {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    Looca looca = new Looca();

    private Double usoCpuPorcentagem;

    public void obterInformacoesCpu() {
        Processador processador = looca.getProcessador();

        System.out.println(ANSI_PURPLE + "Informações do processadoruashausasu: \n" + ANSI_RESET);
        System.out.println(processador);
    }

    public Double getUsoCpuPorcentagem() {
        Processador processador = looca.getProcessador();
        this.usoCpuPorcentagem = processador.getUso();
        return this.usoCpuPorcentagem;
    }
}
