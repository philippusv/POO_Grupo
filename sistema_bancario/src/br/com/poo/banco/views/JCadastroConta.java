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
import java.awt.Color;

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
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lbCadastroCliente.setForeground(new Color(255,0,128));
		lbCadastroCliente.setBounds(157, 9, 227, 29);
		lbCadastroCliente.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		lbCadastroCliente.setVerticalAlignment(SwingConstants.TOP);
		lbCadastroCliente.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbCadastroCliente);
		
		JLabel lbTipoConta = new JLabel("Tipo de Conta:");
		lbTipoConta.setBounds(10, 119, 128, 14);
		lbTipoConta.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbTipoConta);
		
		JComboBox cbTipoConta = new JComboBox();
		cbTipoConta.setModel(new DefaultComboBoxModel(new String[] {"Conta Corrente", "Conta Poupança"}));
		cbTipoConta.setBounds(10, 144, 134, 22);
		contentPane.add(cbTipoConta);
		
		JLabel lbAgencia = new JLabel("Agência:");
		lbAgencia.setHorizontalAlignment(SwingConstants.LEFT);
		lbAgencia.setBounds(192, 119, 89, 14);
		contentPane.add(lbAgencia);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton.setBounds(295, 259, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 10));
		btnVoltar.setBounds(157, 259, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lbNomeCliente = new JLabel("Saldo:");
		lbNomeCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lbNomeCliente.setBounds(192, 181, 128, 14);
		contentPane.add(lbNomeCliente);
		
		JLabel lbSenhaCliente = new JLabel("Senha do Cliente:");
		lbSenhaCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lbSenhaCliente.setBounds(373, 62, 100, 14);
		contentPane.add(lbSenhaCliente);
		
		JLabel lbCPF = new JLabel("CPF:");
		lbCPF.setHorizontalAlignment(SwingConstants.LEFT);
		lbCPF.setBounds(192, 62, 66, 14);
		contentPane.add(lbCPF);
		
		pswSenhaCliente = new JPasswordField();
		pswSenhaCliente.setBounds(373, 87, 134, 22);
		contentPane.add(pswSenhaCliente);
		
		JFormattedTextField txNomeCliente = new JFormattedTextField();
		txNomeCliente.setBounds(10, 88, 134, 20);
		contentPane.add(txNomeCliente);
		
		JFormattedTextField txCPF = new JFormattedTextField();
		txCPF.setBounds(192, 88, 134, 20);
		contentPane.add(txCPF);
		
		JFormattedTextField txGerente = new JFormattedTextField();
		txGerente.setBounds(10, 206, 134, 20);
		contentPane.add(txGerente);
		
		JLabel lbGerente = new JLabel("Gerente:");
		lbGerente.setHorizontalAlignment(SwingConstants.LEFT);
		lbGerente.setBounds(10, 181, 134, 14);
		contentPane.add(lbGerente);
		
		JFormattedTextField txNumConta = new JFormattedTextField();
		txNumConta.setBounds(373, 146, 134, 20);
		contentPane.add(txNumConta);
		
		JLabel lbNumConta = new JLabel("Número da Conta:");
		lbNumConta.setHorizontalAlignment(SwingConstants.LEFT);
		lbNumConta.setBounds(373, 119, 134, 14);
		contentPane.add(lbNumConta);
		
		JLabel lbNomeCliente_1 = new JLabel("Nome do Cliente:");
		lbNomeCliente_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbNomeCliente_1.setBounds(10, 62, 128, 14);
		contentPane.add(lbNomeCliente_1);
		
		JFormattedTextField txSaldo = new JFormattedTextField();
		txSaldo.setBounds(196, 206, 134, 20);
		contentPane.add(txSaldo);
		
		JFormattedTextField txChequeEspecial = new JFormattedTextField();
		txChequeEspecial.setBounds(373, 206, 134, 20);
		contentPane.add(txChequeEspecial);
		
		JLabel lblChequeEspecial = new JLabel("Cheque Especial:");
		lblChequeEspecial.setHorizontalAlignment(SwingConstants.LEFT);
		lblChequeEspecial.setBounds(373, 181, 134, 14);
		contentPane.add(lblChequeEspecial);
		
		JComboBox cbAgencia = new JComboBox();
		cbAgencia.setModel(new DefaultComboBoxModel(new String[] {"001", "002", "003", "004", "005"}));
		cbAgencia.setToolTipText("");
		cbAgencia.setBounds(192, 144, 134, 22);
		contentPane.add(cbAgencia);
	}
}
