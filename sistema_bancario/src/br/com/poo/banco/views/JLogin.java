package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.enums.PessoaEnum;
import br.com.poo.banco.pessoas.Pessoas;

public class JLogin extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField textSenha;

	/**
	 * Create the frame.
	 */
	public JLogin() {
		setForeground(new Color(255, 128, 255));
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Login = new JLabel("Login");
		Login.setHorizontalAlignment(SwingConstants.CENTER);
		Login.setBounds(145, 10, 140, 36);
		Login.setForeground(new Color(255, 0, 128));
		Login.setFont(new Font("Arial Black", Font.BOLD, 25));
		contentPane.add(Login);
		
		JFormattedTextField textCpf = new JFormattedTextField();
		textCpf.setBackground(new Color(229, 229, 229));
		textCpf.setBounds(145, 120, 140, 20);
		contentPane.add(textCpf);
		
		textSenha = new JPasswordField();
		textSenha.setBackground(new Color(229, 229, 229));
		textSenha.setBounds(145, 165, 140, 20);
		contentPane.add(textSenha);
		
		JLabel labelCpf = new JLabel("CPF");
		labelCpf.setFont(new Font("Arial", Font.PLAIN, 10));
		labelCpf.setBounds(145, 106, 46, 14);
		contentPane.add(labelCpf);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setFont(new Font("Arial", Font.PLAIN, 10));
		labelSenha.setBounds(145, 151, 46, 14);
		contentPane.add(labelSenha);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Presidente", "Diretor", "Gerente"}));
		comboBox.setToolTipText("Cliente");
		comboBox.setBackground(new Color(229, 229, 229));
		comboBox.setBounds(145, 73, 140, 22);
		contentPane.add(comboBox);
		
				
		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textCpf.getText();
				Integer senha = Integer.parseInt(new String(textSenha.getPassword()));
				Pessoas pessoa = Pessoas.mapaPessoas.get(cpf);
				
				/* Verificar se: 
				 1. CPF é correspondente aos dados usuário,
				 2. Tipo do usuário é correspondente ao que foi marcado no comboBox,
				 3. Senha é correspondente aos dados do usuário.
				 */
				if (pessoa.getCpf().equals(cpf) &&
						pessoa.getTipo().equalsIgnoreCase(comboBox.getSelectedItem().toString()) &&
						pessoa.getSenha().equals(senha)) {
						
						//System.out.println(pessoa.getTipo());
						//System.out.println(comboBox.getSelectedItem().toString());
					
					// Abrir Menu de Cliente:
					if(comboBox.getSelectedItem().toString().equalsIgnoreCase(PessoaEnum.CLIENTE.getTipoPessoa())) {
						dispose();
						JMenuCliente jMenuCliente = new JMenuCliente(pessoa);
						jMenuCliente.setLocationRelativeTo(jMenuCliente);
						jMenuCliente.setVisible(true);
					
					// Abrir Menu de Gerente:
					}else if(comboBox.getSelectedItem().toString().equalsIgnoreCase(PessoaEnum.GERENTE.getTipoPessoa())){
						dispose();
						JMenuGerente jMenuGerente = new JMenuGerente(pessoa);
						jMenuGerente.setLocationRelativeTo(jMenuGerente);
						jMenuGerente.setVisible(true);
					
					// Abrir Menu de Diretor:
					}else if(comboBox.getSelectedItem().toString().equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())) {
						dispose();
						//JMenuDiretor jMenuDiretor = new JMenuDiretor(pessoa);
						//jMenuDiretor.setLocationRelativeTo(jMenuDiretor);
						//jMenuDiretor.setVisible(true);
					
					// Abrir Menu de Presidente
					}else if(comboBox.getSelectedItem().toString().equalsIgnoreCase(PessoaEnum.PRESIDENTE.getTipoPessoa())) {
						dispose();
						//JMenuPresidente jMenuPresidente = new JMenuPresidente(pessoa);
						//jMenuPresidente.setLocationRelativeTo(jMenuPresidente);
						//jMenuPresidente.setVisible(true);
					}
				}
				
			}
		});
		botaoEntrar.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoEntrar.setBounds(163, 207, 97, 23);
		contentPane.add(botaoEntrar);
		
		
		JLabel lblTipoDeUsurio = new JLabel("Tipo de Usuário");
		lblTipoDeUsurio.setFont(new Font("Arial", Font.PLAIN, 10));
		lblTipoDeUsurio.setBounds(145, 57, 97, 14);
		contentPane.add(lblTipoDeUsurio);
		
//		JLogin jLogin = new JLogin();
//		jLogin.setLocationRelativeTo(jLogin);
//		jLogin.setVisible(true);
//		dispose();
		
//		JPrincipal jPrincipal = new JPrincipal();
//		jPrincipal.setLocationRelativeTo(jPrincipal);
//		jPrincipal.setVisible(true);
	}

}