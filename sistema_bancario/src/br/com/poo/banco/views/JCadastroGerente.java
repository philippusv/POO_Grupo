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
import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.pessoas.Gerente;
import br.com.poo.banco.pessoas.Pessoas;

public class JCadastroGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCargosCG;
	private JTextField textNomeCG;
	private JTextField textFieldCG;
	private JPasswordField passwordFieldCG;
	private JLabel lbSalarioCG;
	private JLabel lbNumFuncionariosCG;
	private JTextField textFieldNumFuncionariosCG;
	private JLabel lbAgenciaCG;
	private JTextField textAgenciaCG;
	private JTextField textFieldSalarioCG;

	public JCadastroGerente(Pessoas pessoa) {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbCadastroGerente = new JLabel("Cadastro Gerente");
		lbCadastroGerente.setForeground(new Color(255, 0, 128));
		lbCadastroGerente.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lbCadastroGerente.setBounds(93, 11, 276, 27);
		contentPane.add(lbCadastroGerente);
		
		JLabel lbCargosCG = new JLabel("Cargo");
		lbCargosCG.setFont(new Font("Arial", Font.PLAIN, 10));
		lbCargosCG.setBounds(103, 50, 46, 14);
		contentPane.add(lbCargosCG);
		
		textCargosCG = new JTextField();
		textCargosCG.setFont(new Font("Arial", Font.PLAIN, 10));
		textCargosCG.setBounds(101, 68, 235, 20);
		contentPane.add(textCargosCG);
		textCargosCG.setColumns(10);
		
		JLabel lbNomeCG = new JLabel("Nome");
		lbNomeCG.setBounds(103, 98, 46, 14);
		contentPane.add(lbNomeCG);
		
		textNomeCG = new JTextField();
		textNomeCG.setFont(new Font("Arial", Font.PLAIN, 10));
		textNomeCG.setBounds(101, 113, 235, 20);
		contentPane.add(textNomeCG);
		textNomeCG.setColumns(10);
		
		JLabel lbCPFCG = new JLabel("CPF");
		lbCPFCG.setBounds(103, 144, 46, 14);
		contentPane.add(lbCPFCG);
		
		textFieldCG = new JTextField();
		textFieldCG.setFont(new Font("Arial", Font.PLAIN, 10));
		textFieldCG.setBounds(103, 162, 233, 20);
		contentPane.add(textFieldCG);
		textFieldCG.setColumns(10);
		
		JLabel lbSenhaCG = new JLabel("Senha");
		lbSenhaCG.setBounds(103, 193, 46, 14);
		contentPane.add(lbSenhaCG);
		
		passwordFieldCG = new JPasswordField();
		passwordFieldCG.setFont(new Font("Arial", Font.PLAIN, 10));
		passwordFieldCG.setBounds(103, 208, 233, 20);
		contentPane.add(passwordFieldCG);
		
		lbSalarioCG = new JLabel("Salário");
		lbSalarioCG.setBounds(103, 239, 46, 14);
		contentPane.add(lbSalarioCG);
		
		lbNumFuncionariosCG = new JLabel("Número de Funcionários");
		lbNumFuncionariosCG.setBounds(103, 289, 212, 14);
		contentPane.add(lbNumFuncionariosCG);
		
		textFieldNumFuncionariosCG = new JTextField();
		textFieldNumFuncionariosCG.setFont(new Font("Arial", Font.PLAIN, 10));
		textFieldNumFuncionariosCG.setBounds(102, 306, 234, 20);
		contentPane.add(textFieldNumFuncionariosCG);
		textFieldNumFuncionariosCG.setColumns(10);
		
		lbAgenciaCG = new JLabel("Agência");
		lbAgenciaCG.setBounds(103, 337, 46, 14);
		contentPane.add(lbAgenciaCG);
		
		textAgenciaCG = new JTextField();
		textAgenciaCG.setFont(new Font("Arial", Font.PLAIN, 10));
		textAgenciaCG.setBounds(100, 356, 236, 20);
		contentPane.add(textAgenciaCG);
		textAgenciaCG.setColumns(10);
		
		JButton btnCadastrarCG = new JButton("Cadastrar");
		btnCadastrarCG.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String cargo = textCargosCG.getText();
		        String nome = textNomeCG.getText();
		        String cpf = textFieldCG.getText();
		        Integer senha = Integer.parseInt(new String(passwordFieldCG.getPassword()));
		        Double salario = Double.parseDouble(textFieldSalarioCG.getText());
		        Integer numFuncionarios = Integer.parseInt(textFieldNumFuncionariosCG.getText());
		        String agencia = textAgenciaCG.getText();
		        
		        // Tratamento de erro se os campos estiverem vazios
		        if(cargo.isEmpty() || nome.isEmpty() || cpf.isEmpty() || senha.toString().isEmpty() || salario.toString().isEmpty() || numFuncionarios.toString().isEmpty()
		        		|| agencia.isEmpty()) {
		        	JOptionPane.showMessageDialog(btnCadastrarCG, "Preencha todos os campos");
       	        }else {	
       	        	
       	        // Colocando no mapa	
       	        	Pessoas g = new Gerente(cargo, nome, cpf, senha, salario, numFuncionarios, agencia);
					Cliente.mapaPessoas.put(cpf, g);
       	     
		        // Criar uma string com os dados formatados
		        String dados = "\n" + cargo + ";" + nome + ";" + cpf + ";" + senha + ";" + salario + ";" + numFuncionarios + ";" + agencia;

		        // Caminho para o arquivo .txt
		        String path = "./temp/BancoDados.txt";

		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
		         // Escrever os dados no arquivo
		            writer.write(dados);
		         // Pule para a próxima linha para cada registro
		            writer.newLine(); 
		            
		         // Exibir mensagem de sucesso
	                JOptionPane.showMessageDialog(btnCadastrarCG, "Cadastro realizado com sucesso");
		        } catch (IOException ex) {
		         // Lidar com exceções de I/O, se ocorrerem
		            ex.printStackTrace();
		        }

		        // Limpar os campos após o cadastro
		        textCargosCG.setText("");
		        textNomeCG.setText("");
		        textFieldCG.setText("");
		        passwordFieldCG.setText("");
		        textFieldSalarioCG.setText("");
		        textFieldNumFuncionariosCG.setText("");
		        textAgenciaCG.setText("");
		    }
		}});
		btnCadastrarCG.setBounds(229, 395, 140, 23);
		contentPane.add(btnCadastrarCG);
		
		JButton btnVoltarCG = new JButton("Voltar");
		btnVoltarCG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pessoa.getTipo().equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())) {
					dispose();
					JMenuDiretor md = new JMenuDiretor(pessoa);
					md.setLocationRelativeTo(md);
					md.setVisible(true);
				} else {
					dispose();
					JMenuPresidente mp = new JMenuPresidente(pessoa);
					mp.setLocationRelativeTo(mp);
					mp.setVisible(true);
				}
			}
		});
		btnVoltarCG.setBounds(73, 395, 140, 23);
		contentPane.add(btnVoltarCG);
		
		textFieldSalarioCG = new JTextField();
		textFieldSalarioCG.setFont(new Font("Arial", Font.PLAIN, 10));
		textFieldSalarioCG.setColumns(10);
		textFieldSalarioCG.setBounds(101, 258, 235, 20);
		contentPane.add(textFieldSalarioCG);
	}
}

