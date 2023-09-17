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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JSaqueDeposito extends JFrame {

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
//					JSaqueDeposito frame = new JSaqueDeposito(null, null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * @param contaSelecionada
	 * @param pessoa
	 */
	public JSaqueDeposito(Pessoas pessoa, Conta conta) {
		setForeground(new Color(255, 128, 255));
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Titulo = new JLabel("Saque/Depósito");
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setBounds(90, 10, 261, 36);
		Titulo.setForeground(new Color(255, 0, 128));
		Titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		contentPane.add(Titulo);

		JLabel labelOp = new JLabel("Operação:");
		labelOp.setFont(new Font("Arial", Font.PLAIN, 10));
		labelOp.setBounds(145, 65, 97, 14);
		contentPane.add(labelOp);

		// SELECT OPERACAO
		JComboBox selectOp = new JComboBox();
		selectOp.setModel(new DefaultComboBoxModel(new String[] { "Saque", "Depósito" }));
		selectOp.setToolTipText("Operação a ser realizada");
		selectOp.setBackground(new Color(229, 229, 229));
		selectOp.setBounds(145, 81, 140, 22);
		contentPane.add(selectOp);

		JLabel labelValor = new JLabel("Valor (R$)");
		labelValor.setFont(new Font("Arial", Font.PLAIN, 10));
		labelValor.setBounds(145, 119, 62, 14);
		contentPane.add(labelValor);

		// VALOR DO SAQUE/DEPOSITO
		textValor = new JTextField();
		textValor.setBackground(new Color(229, 229, 229));
		textValor.setBounds(145, 133, 140, 20);
		contentPane.add(textValor);

		// BOTAO EFETUAR
		JButton botaoEfetuar = new JButton("Efetuar");
		botaoEfetuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectOp.getSelectedItem().toString().equalsIgnoreCase("SAQUE")) {
					try {
						conta.operacoes(Double.parseDouble(textValor.getText()), null, 1);
						dispose();
						JMenuCliente jMenuCliente = new JMenuCliente(pessoa);
						jMenuCliente.setLocationRelativeTo(jMenuCliente);
						jMenuCliente.setVisible(true);
					} catch (NumberFormatException | IOException e1) {
						e1.printStackTrace();
					}
				}else if(selectOp.getSelectedItem().toString().equalsIgnoreCase("DEPÓSITO")) {
					try {
						conta.operacoes(Double.parseDouble(textValor.getText()), null, 2);
						dispose();
						JMenuCliente jMenuCliente = new JMenuCliente(pessoa);
						jMenuCliente.setLocationRelativeTo(jMenuCliente);
						jMenuCliente.setVisible(true);
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		botaoEfetuar.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoEfetuar.setBounds(164, 176, 97, 23);
		contentPane.add(botaoEfetuar);

		// BOTAR CANCELA
		JButton botaoCancela = new JButton("Cancelar");
		// volta pra tela anterior
		botaoCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JMenuCliente jMenuCliente = new JMenuCliente(pessoa);
				jMenuCliente.setLocationRelativeTo(jMenuCliente);
				jMenuCliente.setVisible(true);
			}
		});
		botaoCancela.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoCancela.setBounds(164, 207, 97, 23);
		contentPane.add(botaoCancela);

	}

}
