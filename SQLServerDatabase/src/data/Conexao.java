package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private Connection conexao;
	private String server = "DESKTOP-239N0J5\\LIMADEVELOPER";
	private int port = 1433;
	private String user = "john";
	private String password = "dba";
	private String database = "TESTE";
	
	public Conexao() throws Exception {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://"+server+":"+port+";user="+user+";password="+password+";databaseName="+database+"";
		
		System.out.println("$ - Driver Loaded");
		System.out.println("URL: "+ url);
		
		conexao = DriverManager.getConnection(url);
	}
	
	public Connection getConexao() {
		return conexao;
	}
}
