package br.com.poo.banco.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JLogin extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoEntrar.setBounds(160, 196, 97, 23);
		contentPane.add(botaoEntrar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Presidente", "Diretor", "Gerente"}));
		comboBox.setToolTipText("Cliente");
		comboBox.setBackground(new Color(229, 229, 229));
		comboBox.setBounds(145, 73, 140, 22);
		contentPane.add(comboBox);
		
		JLabel lblTipoDeUsurio = new JLabel("Tipo de Usuário");
		lblTipoDeUsurio.setFont(new Font("Arial", Font.PLAIN, 10));
		lblTipoDeUsurio.setBounds(145, 57, 97, 14);
		contentPane.add(lblTipoDeUsurio);
		
		JButton botaoCadastro = new JButton("Cadastre-se");
		botaoCadastro.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoCadastro.setBounds(160, 227, 97, 23);
		contentPane.add(botaoCadastro);
		
//		JLogin jLogin = new JLogin();
//		jLogin.setLocationRelativeTo(jLogin);
//		jLogin.setVisible(true);
//		dispose();
		
//		JPrincipal jPrincipal = new JPrincipal();
//		jPrincipal.setLocationRelativeTo(jPrincipal);
//		jPrincipal.setVisible(true);
	}

}
