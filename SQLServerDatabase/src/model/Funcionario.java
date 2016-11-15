package model;

public class Funcionario {

	private int id;
	private int idade;
	private String nome;
	private String email;
	
	public Funcionario() {}
	
	public Funcionario(int id, int idade, String nome, String email) {
		this.setId(id);
		this.setIdade(idade);
		this.setNome(nome);
		this.setEmail(email);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
