package org.example.InserirBanco;

import com.github.britooo.looca.api.group.discos.Disco;
import org.example.Componentes.CPU;
import org.example.Componentes.Discos;
import org.example.Componentes.Mem;

import java.sql.*;

public class InserirComponentesBanco {
    CPU cpu = new CPU();
    Discos discos = new Discos();
    Mem mem = new Mem();

    String jdbcUrl = "jdbc:mysql://34.207.57.46:3306/bankSecure";
    String username = "root";
    String password = "urubu100";

    public void exibirMensagensComponente() {
        cpu.obterInformacoesCpu();
        System.out.println("\n");
        discos.obterInformacoesDisco();
        System.out.println("\n");
        mem.obterInformacoesMemoria();
    }

    public void inserirCompoenentesBanco() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
            String sql1 = "Insert into registros (fkMaquina, fkComponente, valor, dataHora) values (2, 1, ?, ?)";
            String sql2 = "Insert into registros (fkMaquina, fkComponente, valor, dataHora) values (2, 2, ?, ?)";
            String sql3 = "Insert into registros (fkMaquina, fkComponente, valor, dataHora) values (2, 3, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql1)){
                statement.setDouble(1, cpu.getUsoCpuPorcentagem());
                statement.setTimestamp(2, new Timestamp(new java.util.Date().getTime()));

                statement.executeUpdate();
            }

            try (PreparedStatement statement = connection.prepareStatement(sql2)){
                statement.setDouble(1, discos.getVolumeEmUsoPorcentagem());
                statement.setTimestamp(2, new Timestamp(new java.util.Date().getTime()));

                statement.executeUpdate();
            }

            try (PreparedStatement statement = connection.prepareStatement(sql3)){
                statement.setDouble(1, mem.getUsoMemoriaPorcentagem());
                statement.setTimestamp(2, new Timestamp(new java.util.Date().getTime()));

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
