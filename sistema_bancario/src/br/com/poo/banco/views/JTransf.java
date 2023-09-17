package br.com.poo.banco.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.pessoas.Pessoas;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JTransf extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textValor;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JTransf frame = new JTransf();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param contaSelecionada 
	 * @param pessoa 
	 */
	public JTransf(Pessoas pessoa, Conta conta) {
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
		
		JLabel labelConta = new JLabel("Número da conta destino");
		labelConta.setFont(new Font("Arial", Font.PLAIN, 10));
		labelConta.setBounds(145, 64, 140, 14);
		contentPane.add(labelConta);
		
		// NUMERO DA CONTA DESTINO
		JFormattedTextField textConta = new JFormattedTextField();
		textConta.setBackground(new Color(229, 229, 229));
		textConta.setBounds(145, 78, 140, 20);
		contentPane.add(textConta);
		
		JLabel labelValor = new JLabel("Valor (R$)");
		labelValor.setFont(new Font("Arial", Font.PLAIN, 10));
		labelValor.setBounds(145, 109, 62, 14);
		contentPane.add(labelValor);
		
		// VALOR DA TRANSFERENCIA
		textValor = new JTextField();
		textValor.setBackground(new Color(229, 229, 229));
		textValor.setBounds(145, 123, 140, 20);
		contentPane.add(textValor);
		
		// BOTAR EFETUAR
		JButton botaoTransf = new JButton("Transferir");
		botaoTransf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Conta contaDestino = Conta.mapaNumContas.get(textConta.getText());
					conta.operacoes(Double.parseDouble(textValor.getText()), contaDestino, 3);
					dispose();
					JMenuCliente jMenuCliente = new JMenuCliente(pessoa);
					jMenuCliente.setLocationRelativeTo(jMenuCliente);
					jMenuCliente.setVisible(true);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		botaoTransf.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoTransf.setBounds(164, 154, 97, 23);
		contentPane.add(botaoTransf);
		
		// BOTAO CANCELAR
		JButton botaoCancelar = new JButton("Cancelar");
		// volta a tela anterior
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JMenuCliente jMenuCliente = new JMenuCliente(pessoa);
				jMenuCliente.setLocationRelativeTo(jMenuCliente);
				jMenuCliente.setVisible(true);
			}
		});
		botaoCancelar.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoCancelar.setBounds(164, 185, 97, 23);
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
