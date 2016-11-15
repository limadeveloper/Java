package data;

import java.sql.PreparedStatement;
import model.Funcionario;

public class FuncionarioData {

	private Conexao conexao;
	
	public boolean incluir(Funcionario funcionario) throws Exception {
		
		conexao = new Conexao();
		
		String sql = "INSERT INTO FUNCIONARIO VALUES (?, ?, ?)";
		PreparedStatement preparedStatement = conexao.getConexao().prepareStatement(sql);
		
		preparedStatement.setString(1, funcionario.getNome());
		preparedStatement.setString(2, funcionario.getEmail());
		preparedStatement.setInt(3, funcionario.getIdade());
		
		if (preparedStatement.executeUpdate() > 0) {
			return true;
		}
		
		return true;
	}
}
