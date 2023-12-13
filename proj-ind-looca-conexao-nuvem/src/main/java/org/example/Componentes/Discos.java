package org.example.Componentes;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;

import java.util.List;

public class Discos {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    Looca looca = new Looca();

    private Double volumeTotal;
    private Double volumeDisponivel;
    private Double volumeEmUso;
    private Double volumeEmUsoPorcentagem;

    public void obterInformacoesDisco() {
        DiscoGrupo discoGrupo = looca.getGrupoDeDiscos();

        System.out.println(ANSI_PURPLE + "Informações do disco: \n" + ANSI_RESET);
        System.out.println(discoGrupo);
    }

    public Double getVolumeTotal() {
        DiscoGrupo discoGrupo = looca.getGrupoDeDiscos();
        List<Volume> volumes = discoGrupo.getVolumes();

        for (Volume volume: volumes) {
            this.volumeTotal = (double) volume.getTotal();
        }

        return this.volumeTotal;
    }

    public Double getVolumeDisponivel() {
        DiscoGrupo discoGrupo = looca.getGrupoDeDiscos();
        List<Volume> volumes = discoGrupo.getVolumes();

        for (Volume volume: volumes) {
            this.volumeDisponivel = (double) volume.getDisponivel();
        }

        return this.volumeDisponivel;
    }

    public Double getVolumeEmUso() {
        this.volumeEmUso = getVolumeTotal() - getVolumeDisponivel();
        return this.volumeEmUso;
    }

    public Double getVolumeEmUsoPorcentagem() {
        this.volumeEmUsoPorcentagem = (getVolumeEmUso()/getVolumeTotal()) * 100;

        return volumeEmUsoPorcentagem;
    }
}
