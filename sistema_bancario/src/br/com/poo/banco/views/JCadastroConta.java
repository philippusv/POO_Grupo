package br.com.poo.banco.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

public class JCadastroConta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lbCadastroCliente = new JLabel("Cadastro de Cliente");
	private JPasswordField pswSenhaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroConta frame = new JCadastroConta();
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
	public JCadastroConta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lbCadastroCliente.setBounds(103, 10, 227, 29);
		lbCadastroCliente.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbCadastroCliente.setVerticalAlignment(SwingConstants.TOP);
		lbCadastroCliente.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbCadastroCliente);
		
		JLabel lbTipoConta = new JLabel("Tipo de Conta:");
		lbTipoConta.setBounds(103, 50, 227, 14);
		lbTipoConta.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbTipoConta);
		
		JComboBox cbTipoConta = new JComboBox();
		cbTipoConta.setModel(new DefaultComboBoxModel(new String[] {"Conta Corrente", "Conta Poupança"}));
		cbTipoConta.setBounds(103, 64, 227, 22);
		contentPane.add(cbTipoConta);
		
		JLabel lbAgencia = new JLabel("Agência:");
		lbAgencia.setHorizontalAlignment(SwingConstants.LEFT);
		lbAgencia.setBounds(103, 94, 227, 14);
		contentPane.add(lbAgencia);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton.setBounds(119, 407, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 10));
		btnVoltar.setBounds(228, 407, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lbNomeCliente = new JLabel("Nome do Cliente:");
		lbNomeCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lbNomeCliente.setBounds(103, 247, 227, 14);
		contentPane.add(lbNomeCliente);
		
		JLabel lbSenhaCliente = new JLabel("Senha do Cliente:");
		lbSenhaCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lbSenhaCliente.setBounds(103, 291, 227, 14);
		contentPane.add(lbSenhaCliente);
		
		JLabel lbCPF = new JLabel("CPF:");
		lbCPF.setHorizontalAlignment(SwingConstants.LEFT);
		lbCPF.setBounds(103, 337, 227, 14);
		contentPane.add(lbCPF);
		
		pswSenhaCliente = new JPasswordField();
		pswSenhaCliente.setBounds(103, 304, 227, 22);
		contentPane.add(pswSenhaCliente);
		
		JFormattedTextField txNomeCliente = new JFormattedTextField();
		txNomeCliente.setBounds(103, 260, 227, 20);
		contentPane.add(txNomeCliente);
		
		JFormattedTextField txAgencia = new JFormattedTextField();
		txAgencia.setBounds(103, 108, 227, 20);
		contentPane.add(txAgencia);
		
		JFormattedTextField txCPF = new JFormattedTextField();
		txCPF.setBounds(103, 350, 227, 20);
		contentPane.add(txCPF);
		
		JFormattedTextField txGerente = new JFormattedTextField();
		txGerente.setBounds(103, 152, 227, 20);
		contentPane.add(txGerente);
		
		JLabel lbGerente = new JLabel("Gerente:");
		lbGerente.setHorizontalAlignment(SwingConstants.LEFT);
		lbGerente.setBounds(103, 139, 227, 14);
		contentPane.add(lbGerente);
		
		JFormattedTextField txNumConta = new JFormattedTextField();
		txNumConta.setBounds(103, 196, 227, 20);
		contentPane.add(txNumConta);
		
		JLabel lbNumConta = new JLabel("Número da Conta:");
		lbNumConta.setHorizontalAlignment(SwingConstants.LEFT);
		lbNumConta.setBounds(103, 183, 227, 14);
		contentPane.add(lbNumConta);
	}
}
