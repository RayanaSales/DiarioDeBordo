package regrasDeNegocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao
{
    static String status = "";

    private static Conexao con = null;

//	private Conexao()
//	{
//		
//	}
    public static Conexao getInstance()
    {
        if (con == null)
        {
            con = new Conexao();
        }

        return con;
    }

    public Connection getConnection()
    {
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/diariodebordo", "root", "root");
            status = "Conection opened";
        } catch (SQLException e)
        {
            status = e.getMessage();
        } catch (ClassNotFoundException e)
        {
            status = e.getMessage();
        } catch (Exception e)
        {
            status = e.getMessage();
        }
        return conn;
    }
}
