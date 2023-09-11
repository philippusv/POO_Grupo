package br.com.poo.banco.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCadastroClientePF extends JFrame {

	/**
	 * Launch the application
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordFieldPF;
	private JTextField textNomePF;
	private JTextField textCpfCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroClientePF frame = new JCadastroClientePF();
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
	public JCadastroClientePF() {
		setTitle("Sistema Bancário - Cadastro Pessoa Física");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloCadastro = new JLabel("Cadastro");
		lblTituloCadastro.setForeground(new Color(0, 0, 160));
		lblTituloCadastro.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblTituloCadastro.setBounds(154, 11, 126, 27);
		contentPane.add(lblTituloCadastro);
		
		JLabel lblTituloPessoaFisica = new JLabel("Pessoa Física");
		lblTituloPessoaFisica.setForeground(new Color(0, 0, 160));
		lblTituloPessoaFisica.setFont(new Font("Arial", Font.BOLD, 16));
		lblTituloPessoaFisica.setBounds(10, 47, 126, 14);
		contentPane.add(lblTituloPessoaFisica);
		
		JLabel lblNomePF = new JLabel("Nome Cliente");
		lblNomePF.setForeground(new Color(0, 0, 160));
		lblNomePF.setFont(new Font("Arial", Font.BOLD, 12));
		lblNomePF.setBounds(10, 80, 104, 14);
		contentPane.add(lblNomePF);
		
		JLabel lblCpfCliente = new JLabel("CPF Cliente");
		lblCpfCliente.setForeground(new Color(0, 0, 160));
		lblCpfCliente.setFont(new Font("Arial", Font.BOLD, 12));
		lblCpfCliente.setBounds(10, 124, 104, 14);
		contentPane.add(lblCpfCliente);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(0, 0, 160));
		lblSenha.setFont(new Font("Arial", Font.BOLD, 12));
		lblSenha.setBounds(10, 168, 49, 14);
		contentPane.add(lblSenha);
		
		passwordFieldPF = new JPasswordField();
		passwordFieldPF.setBounds(10, 181, 146, 20);
		contentPane.add(passwordFieldPF);
		
		textNomePF = new JTextField();
		textNomePF.setBounds(10, 93, 414, 20);
		contentPane.add(textNomePF);
		textNomePF.setColumns(10);
		
		textCpfCliente = new JTextField();
		textCpfCliente.setColumns(10);
		textCpfCliente.setBounds(10, 137, 146, 20);
		contentPane.add(textCpfCliente);
		
		JButton btnCadastrarPF = new JButton("Cadastrar");
		btnCadastrarPF.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String cpf = textCpfCliente.getText();
		        String senha = new String(passwordFieldPF.getPassword());
		        if (cpf != null && senha != null && !cpf.isEmpty() && !senha.isEmpty()) {
		            JOptionPane.showMessageDialog(btnCadastrarPF, "Bem-vindo(a), " + cpf);
		        } else {
		            JOptionPane.showMessageDialog(btnCadastrarPF, "Há erro no cadastro. Verifique todos os campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});
		btnCadastrarPF.setBounds(174, 227, 116, 23);
		contentPane.add(btnCadastrarPF);
	}
}
