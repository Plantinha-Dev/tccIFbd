package br.com.odontofast.ConexaoBD;
import java.sql.*;


public class ConexaoBanco {

    // Dados de conexão
    private static final String URL = "jdbc:postgresql://localhost:5432/Odontofast"; // URL do seu banco
    private static final String USUARIO = "postgres"; // Seu usuário do banco de dados
    private static final String SENHA = "postgres"; // Sua senha do banco de dados

    public static Connection conectar() throws SQLException {
        try {
            // Registra o driver JDBC
            Class.forName("org.postgresql.Driver");
            // Estabelece a conexão
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver JDBC não encontrado.");
        }
    }

}
