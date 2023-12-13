package org.example.Usuario;

import com.mysql.cj.jdbc.result.UpdatableResultSet;
import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    Scanner leitor = new Scanner(System.in);

    List<String> emails = new ArrayList<>();
    List<String> senhas = new ArrayList<>();
    private String jdbcUrl = "jdbc:mysql://34.207.57.46:3306/bankSecure";
    private String username = "root";
    private String password = "urubu100";


    public Boolean getDadosBD() {
        boolean credenciaisCorretas = false;

        while (!credenciaisCorretas) {
            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                String sql = "SELECT email, senha FROM usuario";

                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            String email = resultSet.getString("email");
                            String senha = resultSet.getString("senha");

                            emails.add(email);
                            senhas.add(senha);
                        }
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

            System.out.println("Insira seu e-mail:");
            String inputEmail = leitor.nextLine();
            System.out.println("Agora, insira sua senha:");
            String inputSenha = leitor.nextLine();

            credenciaisCorretas = false;

            for (int i = 0; i < emails.size(); i++) {
                if (emails.get(i).equalsIgnoreCase(inputEmail) && senhas.get(i).equalsIgnoreCase(inputSenha)) {
                    System.out.println("E-mail e senha corretos, seja bem-vindo!");
                    credenciaisCorretas = true;
                    break;
                }
            }

            if (!credenciaisCorretas) {
                System.out.println("E-mail ou senha incorretos, tente novamente!");
            }
        }

        return true;
    }
}


