package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.enums.PessoaEnum;
import br.com.poo.banco.pessoas.Diretor;
import br.com.poo.banco.pessoas.Pessoas;

public class JCadastroDiretor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeCD;
	private JTextField textFieldCD;
	private JPasswordField passwordFieldCD;
	private JLabel lbSalarioCD;
	private JTextField textFieldSalarioCD;
	private JLabel lbNumFuncionariosCD;
	private JTextField textFieldNumFuncionariosCD;
	private JLabel lbAgenciaCD;
	private JTextField textAgenciaCD_1;
	private JTextField textAgenciaCD_2;
	private JTextField textAgenciaCD_3;

	public JCadastroDiretor(Pessoas pessoa, String cargo) {
		setTitle("Cadastro Diretor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// TITULO
		JLabel lbCadastroDiretor = new JLabel("Cadastro Diretor");
		lbCadastroDiretor.setForeground(new Color(255, 0, 128));
		lbCadastroDiretor.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lbCadastroDiretor.setBounds(103, 11, 233, 27);
		contentPane.add(lbCadastroDiretor);

		// NOME
		JLabel lbNomeCD = new JLabel("Nome");
		lbNomeCD.setBounds(105, 49, 46, 14);
		contentPane.add(lbNomeCD);
		textNomeCD = new JTextField();
		textNomeCD.setFont(new Font("Arial", Font.PLAIN, 10));
		textNomeCD.setBounds(103, 64, 235, 20);
		contentPane.add(textNomeCD);
		textNomeCD.setColumns(10);

		// CPF
		JLabel lbCPFCD = new JLabel("CPF");
		lbCPFCD.setBounds(105, 95, 46, 14);
		contentPane.add(lbCPFCD);
		textFieldCD = new JTextField();
		textFieldCD.setFont(new Font("Arial", Font.PLAIN, 10));
		textFieldCD.setBounds(105, 113, 233, 20);
		contentPane.add(textFieldCD);
		textFieldCD.setColumns(10);

		// SENHA
		JLabel lbSenhaCD = new JLabel("Senha");
		lbSenhaCD.setBounds(105, 144, 231, 14);
		contentPane.add(lbSenhaCD);
		passwordFieldCD = new JPasswordField();
		passwordFieldCD.setFont(new Font("Arial", Font.PLAIN, 10));
		passwordFieldCD.setBounds(105, 159, 233, 20);
		contentPane.add(passwordFieldCD);

		// SALARIO
		lbSalarioCD = new JLabel("Salário(R$): ");
		lbSalarioCD.setBounds(105, 190, 231, 14);
		contentPane.add(lbSalarioCD);
		textFieldSalarioCD = new JTextField();
		textFieldSalarioCD.setFont(new Font("Arial", Font.PLAIN, 10));
		textFieldSalarioCD.setColumns(10);
		textFieldSalarioCD.setBounds(103, 209, 235, 20);
		contentPane.add(textFieldSalarioCD);

		// NUM DE FUNCIONARIOS
		lbNumFuncionariosCD = new JLabel("Número de Funcionários");
		lbNumFuncionariosCD.setBounds(105, 240, 231, 14);
		contentPane.add(lbNumFuncionariosCD);
		textFieldNumFuncionariosCD = new JTextField();
		textFieldNumFuncionariosCD.setFont(new Font("Arial", Font.PLAIN, 10));
		textFieldNumFuncionariosCD.setBounds(104, 257, 234, 20);
		contentPane.add(textFieldNumFuncionariosCD);
		textFieldNumFuncionariosCD.setColumns(10);

		// AGENCIA 1
		lbAgenciaCD = new JLabel("Agências");
		lbAgenciaCD.setBounds(105, 288, 231, 14);
		contentPane.add(lbAgenciaCD);
		textAgenciaCD_1 = new JTextField();
		textAgenciaCD_1.setFont(new Font("Arial", Font.PLAIN, 10));
		textAgenciaCD_1.setBounds(105, 307, 46, 20);
		contentPane.add(textAgenciaCD_1);
		textAgenciaCD_1.setColumns(10);

		// AGENCIA 2
		textAgenciaCD_2 = new JTextField();
		textAgenciaCD_2.setFont(new Font("Arial", Font.PLAIN, 10));
		textAgenciaCD_2.setColumns(10);
		textAgenciaCD_2.setBounds(201, 307, 46, 20);
		contentPane.add(textAgenciaCD_2);

		// AGENCIA 3
		textAgenciaCD_3 = new JTextField();
		textAgenciaCD_3.setFont(new Font("Arial", Font.PLAIN, 10));
		textAgenciaCD_3.setColumns(10);
		textAgenciaCD_3.setBounds(292, 306, 46, 20);
		contentPane.add(textAgenciaCD_3);

		JButton btnCadastrarCD = new JButton("Cadastrar");
		btnCadastrarCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNomeCD.getText();
				String cpf = textFieldCD.getText();
				Integer senha = Integer.parseInt(new String(passwordFieldCD.getPassword()));
				Double salario = Double.parseDouble(textFieldSalarioCD.getText());
				Integer numFuncionarios = Integer.parseInt(textFieldNumFuncionariosCD.getText());
				String agencia1 = textAgenciaCD_1.getText();
				String agencia2 = textAgenciaCD_2.getText();
				String agencia3 = textAgenciaCD_3.getText();

				// Verifica campos vazios
				if (cargo.isEmpty() || nome.isEmpty() || cpf.isEmpty() || senha.toString().isEmpty() || salario.toString().isEmpty()
						|| numFuncionarios.toString().isEmpty() || agencia1.isEmpty() || agencia2.isEmpty()
						|| agencia3.isEmpty()) {
					JOptionPane.showMessageDialog(btnCadastrarCD, "Preencha todos os campos");
				} else {
					
					// Cria objeto Diretor
					Diretor d = new Diretor(cargo, nome, cpf, senha, salario, agencia1, agencia2, agencia3);
					Diretor.mapaPessoas.put(cpf, d);

					// Insere dados no BancoDados
					String dados = "\n" + cargo + ";" + nome + ";" + cpf + ";" + senha + ";" + salario + ";"
							+ numFuncionarios + ";" + agencia1 + ";" + agencia2 + ";" + agencia3;
					String path = "./temp/BancoDados.txt";
					try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
						writer.write(dados);
						writer.newLine();
						JOptionPane.showMessageDialog(btnCadastrarCD, "Cadastro realizado com sucesso");
					} catch (IOException ex) {
						ex.printStackTrace();
					}

					// Limpar os campos após o cadastro
					textNomeCD.setText("");
					textFieldCD.setText("");
					passwordFieldCD.setText("");
					textFieldSalarioCD.setText("");
					textFieldNumFuncionariosCD.setText("");
					textAgenciaCD_1.setText("");
				}
			}
		});
		btnCadastrarCD.setBounds(229, 370, 140, 23);
		contentPane.add(btnCadastrarCD);

		JButton btnVoltarCD = new JButton("Voltar");
		btnVoltarCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					JMenuPresidente mp = new JMenuPresidente(pessoa);
					mp.setLocationRelativeTo(mp);
					mp.setVisible(true);
			}
		});
		btnVoltarCD.setBounds(73, 370, 140, 23);
		contentPane.add(btnVoltarCD);

	}
}
