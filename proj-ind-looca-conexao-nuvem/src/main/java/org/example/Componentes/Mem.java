package org.example.Componentes;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
public class Mem {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    Looca looca = new Looca();


    private Double usoMemoriaPorcentagem;

    public void obterInformacoesMemoria() {
        Memoria memoria = looca.getMemoria();

        System.out.println(ANSI_PURPLE + "Informações da mamória: \n" + ANSI_RESET);
        System.out.println(memoria);
    }

    public Double getUsoMemoriaPorcentagem() {
        Memoria memoria = looca.getMemoria();

        Double usoMemoriaGB = memoria.getEmUso() / (1024.0 * 1024.0 * 1024.0);
        Double totalMemoriaGB = memoria.getTotal() / (1024.0 * 1024.0 * 1024.0);

        this.usoMemoriaPorcentagem = (usoMemoriaGB/totalMemoriaGB) * 100;
        return usoMemoriaPorcentagem;

    }
}
