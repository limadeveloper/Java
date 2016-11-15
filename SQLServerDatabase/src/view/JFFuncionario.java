package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.FuncionarioData;
import model.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFFuncionario extends JFrame {

	// Properties
	private JPanel contentPane;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel emailLabel;
	private JLabel idadeLabel;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField idadeTextField;
	private JButton newButton;
	private JButton saveButton;
	private JButton cancelButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton searchButton;
	private Funcionario funcionario;
	private static FuncionarioData DAO;
	private static final long serialVersionUID = 1L;

	// LifeCycle
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFFuncionario frame = new JFFuncionario();
					frame.setVisible(true);
					DAO = new FuncionarioData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFFuncionario() {
		
		// Content Panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		// Labels
		idLabel = new JLabel("ID:");
		idLabel.setBounds(15, 14, 50, 14);
		
		nameLabel = new JLabel("Nome:");
		nameLabel.setBounds(15, 42, 50, 14);
		
		emailLabel = new JLabel("Email:");
		emailLabel.setBounds(15, 69, 50, 14);
		
		idadeLabel = new JLabel("Idade:");
		idadeLabel.setBounds(15, 97, 50, 14);
		
		// Text Fields
		idTextField = new JTextField();
		idTextField.setBounds(75, 10, 242, 20);		
		idTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setEnabled(false);
		nameTextField.setBounds(75, 38, 242, 20);
		nameTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setEnabled(false);
		emailTextField.setBounds(75, 65, 242, 20);
		emailTextField.setColumns(10);
		
		idadeTextField = new JTextField();
		idadeTextField.setEnabled(false);
		idadeTextField.setBounds(75, 92, 242, 20);
		idadeTextField.setColumns(10);
		
		// Buttons
		newButton = new JButton("Novo");
		newButton.setBounds(396, 10, 89, 23);
		
		saveButton = new JButton("Salvar");
		saveButton.setBounds(396, 177, 89, 23);
		saveButton.setEnabled(false);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(396, 143, 89, 23);
		cancelButton.setEnabled(false);
		
		editButton = new JButton("Editar");
		editButton.setBounds(396, 109, 89, 23);
		editButton.setEnabled(false);
		
		deleteButton = new JButton("Excluir");
		deleteButton.setBounds(396, 42, 89, 23);
		deleteButton.setEnabled(false);
		
		searchButton = new JButton("Pesquisar");
		searchButton.setBounds(396, 75, 89, 23);
		
		// Content Panel
		contentPane.add(idLabel);
		contentPane.add(nameLabel);
		contentPane.add(emailLabel);
		contentPane.add(idadeLabel);
		contentPane.add(idTextField);
		contentPane.add(nameTextField);
		contentPane.add(emailTextField);
		contentPane.add(idadeTextField);
		contentPane.add(newButton);
		contentPane.add(saveButton);
		contentPane.add(cancelButton);
		contentPane.add(editButton);
		contentPane.add(deleteButton);
		contentPane.add(searchButton);
		
		setContentPane(contentPane);
		
		// Actions
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				idTextField.setEnabled(false);
				nameTextField.setEnabled(true);
				emailTextField.setEnabled(true);
				idadeTextField.setEnabled(true);
				newButton.setEnabled(false);
				saveButton.setEnabled(true);
				editButton.setEnabled(false);
				deleteButton.setEnabled(false);
				cancelButton.setEnabled(true);
				searchButton.setEnabled(false);
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelAction();
			}
		});
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
					if (validarCampos()) {
						if (preencherObjeto()) {
							if (DAO.incluir(funcionario)) {
								salvo();
								cancelAction();
							}
						}
					}else {
						saveError();
					}
				}catch (Exception e) {
					// TODO: handle exception
					showError(e);
				}
			}
		});
	}
	
	// Actions
	public void cancelAction() {
		limparCampos();
		idTextField.setEnabled(true);
		nameTextField.setEnabled(false);
		emailTextField.setEnabled(false);
		idadeTextField.setEnabled(false);
		newButton.setEnabled(true);
		saveButton.setEnabled(false);
		editButton.setEnabled(false);
		deleteButton.setEnabled(false);
		cancelButton.setEnabled(false);
		searchButton.setEnabled(true);
	}
	
	public void limparCampos() {
		idTextField.setText("");
		nameTextField.setText("");
		emailTextField.setText("");
		idadeTextField.setText("");
	}
	
	public boolean validarCampos() {
		if (nameTextField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Preencha o campo de texto Nome!");
			nameTextField.requestFocus();
			return false;
		}
		if (emailTextField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Preencha o campo de texto Email!");
			emailTextField.requestFocus();
			return false;
		}
		if (idadeTextField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Preencha o campo de texto Idade!");
			idadeTextField.requestFocus();
			return false;
		}
		return true;
	}
	
	public boolean preencherObjeto() {
		funcionario = new Funcionario();
		funcionario.setNome(nameTextField.getText());
		funcionario.setEmail(emailTextField.getText());
		funcionario.setIdade(Integer.parseInt(idadeTextField.getText()));
		return true;
	}
	
	public void salvo() {
		JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
	}
	
	public void saveError() {
		JOptionPane.showMessageDialog(this, "Não foi posséivel salvar o registro");
	}
	
	public void showError(Exception error) {
		JOptionPane.showMessageDialog(this, "Error "+ error.getMessage());
	}
	
}
