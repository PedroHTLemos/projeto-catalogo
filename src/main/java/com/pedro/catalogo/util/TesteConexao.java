package com.pedro.catalogo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/catalogo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                "root",
                "phtl2702"
            );
            System.out.println("Conexão bem-sucedida!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
