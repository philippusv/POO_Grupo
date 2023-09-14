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
								
				if (pessoa.getCpf().equals(cpf) && 
						pessoa.getSenha().equals(senha)) {
					if(comboBox.getSelectedItem().toString().equalsIgnoreCase(PessoaEnum.CLIENTE.getTipoPessoa())) {
						dispose();
						JMenuCliente jMenuCliente = new JMenuCliente();
						jMenuCliente.setLocationRelativeTo(jMenuCliente);
						jMenuCliente.setVisible(true);
						
					}else if(comboBox.getSelectedItem().toString().equalsIgnoreCase(PessoaEnum.GERENTE.getTipoPessoa())){
						//JMenuGerente
					}else if(comboBox.getSelectedItem().toString().equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())) {
						//JMenuDiretor
					}else if(comboBox.getSelectedItem().toString().equalsIgnoreCase(PessoaEnum.PRESIDENTE.getTipoPessoa())) {
						//JMenuPresidente
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
