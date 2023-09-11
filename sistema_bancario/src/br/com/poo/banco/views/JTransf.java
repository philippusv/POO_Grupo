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

public class JTransf extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField textValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTransf frame = new JTransf();
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
	public JTransf() {
		setForeground(new Color(255, 128, 255));
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Titulo = new JLabel("Transferência");
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setBounds(90, 10, 261, 36);
		Titulo.setForeground(new Color(255, 0, 128));
		Titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		contentPane.add(Titulo);
		
		JFormattedTextField textConta = new JFormattedTextField();
		textConta.setBackground(new Color(229, 229, 229));
		textConta.setBounds(145, 120, 140, 20);
		contentPane.add(textConta);
		
		textValor = new JPasswordField();
		textValor.setBackground(new Color(229, 229, 229));
		textValor.setBounds(145, 165, 140, 20);
		contentPane.add(textValor);
		
		JLabel labelConta = new JLabel("Conta Destino");
		labelConta.setFont(new Font("Arial", Font.PLAIN, 10));
		labelConta.setBounds(145, 106, 76, 14);
		contentPane.add(labelConta);
		
		JLabel labelValor = new JLabel("Valor (R$)");
		labelValor.setFont(new Font("Arial", Font.PLAIN, 10));
		labelValor.setBounds(145, 151, 62, 14);
		contentPane.add(labelValor);
		
		JButton botaoTransf = new JButton("Transferir");
		botaoTransf.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoTransf.setBounds(164, 196, 97, 23);
		contentPane.add(botaoTransf);
		
		JComboBox selectConta = new JComboBox();
		selectConta.setModel(new DefaultComboBoxModel(new String[] {"Conta Corrente", "Conta Poupança"}));
		selectConta.setToolTipText("Cliente");
		selectConta.setBackground(new Color(229, 229, 229));
		selectConta.setBounds(145, 73, 140, 22);
		contentPane.add(selectConta);
		
		JLabel lblTipoDeConta = new JLabel("Tipo de Conta");
		lblTipoDeConta.setFont(new Font("Arial", Font.PLAIN, 10));
		lblTipoDeConta.setBounds(145, 57, 97, 14);
		contentPane.add(lblTipoDeConta);
		
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoCancelar.setBounds(164, 227, 97, 23);
		contentPane.add(botaoCancelar);
		
//		JLogin jLogin = new JLogin();
//		jLogin.setLocationRelativeTo(jLogin);
//		jLogin.setVisible(true);
//		dispose();
		
//		JPrincipal jPrincipal = new JPrincipal();
//		jPrincipal.setLocationRelativeTo(jPrincipal);
//		jPrincipal.setVisible(true);
	}

}
