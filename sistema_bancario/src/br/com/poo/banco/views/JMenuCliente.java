package br.com.poo.banco.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.enums.PessoaEnum;
import br.com.poo.banco.pessoas.Pessoas;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JMenuCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JMenuCliente frame = new JMenuCliente();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param pessoa
	 */
	public JMenuCliente(Pessoas pessoa) {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Menu Cliente");
		lblNewLabel.setBounds(64, 21, 166, 48);
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Corrente", "Poupança" }));
		comboBox.setToolTipText("Conta");
		comboBox.setBounds(64, 95, 139, 21);
		contentPane.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Conta:");
		lblNewLabel_1.setBounds(64, 80, 88, 18);
		contentPane.add(lblNewLabel_1);

		// COMBOBOX OPERACAO
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Saque/Depósito", "Transferência" }));
		comboBox_1.setToolTipText("operação");
		comboBox_1.setBounds(63, 156, 139, 21);
		contentPane.add(comboBox_1);

		// LABEL OPERACAO
		JLabel lblNewLabel_1_1 = new JLabel("Operação:");
		lblNewLabel_1_1.setBounds(64, 141, 88, 18);
		contentPane.add(lblNewLabel_1_1);

		// BOTAO ENTRAR
		JButton btnNewButton = new JButton("Executar");
		// Chama a tela JSaqueDeposito ou JTransf
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conta contaSelecionada = null;
				String op = null;
				
				// Definindo a conta selecionada
				if (comboBox.getSelectedItem().toString().equalsIgnoreCase("corrente")) {
					// conta corrente selecionada
					for (Conta conta : Conta.mapaContas.get(pessoa.getCpf())) {
						if (conta.getTipoConta().equalsIgnoreCase("CORRENTE")) {
							contaSelecionada = conta;
						}
					}
				} else {
					// conta poupanca selecionada
					for (Conta conta : Conta.mapaContas.get(pessoa.getCpf())) {
						if (!conta.getTipoConta().equalsIgnoreCase("CORRENTE")) {
							contaSelecionada = conta;
						}
					}
				}
				
				// Chamando tela JSaqueDeposito ou JTransf
				if(comboBox_1.getSelectedItem().toString().equalsIgnoreCase("Saque/Depósito")) {
					dispose();
					JSaqueDeposito jSaqueDeposito = new JSaqueDeposito(pessoa, contaSelecionada);
					jSaqueDeposito.setLocationRelativeTo(jSaqueDeposito);
					jSaqueDeposito.setVisible(true);
				}else {
					JTransf jTransf = new JTransf(pessoa, contaSelecionada);
					jTransf.setLocationRelativeTo(jTransf);
					jTransf.setVisible(true);
				}
				
			}
		});
		btnNewButton.setBounds(78, 202, 102, 27);
		contentPane.add(btnNewButton);

		// BOTAO SALDO
		JButton btnSaldo = new JButton("Abrir Saldo");
		// Chama a tela JSaldo 
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().equalsIgnoreCase("corrente")) {
					// chama a tela passando a conta corrente
					for (Conta conta : Conta.mapaContas.get(pessoa.getCpf())) {
						if (conta.getTipoConta().equalsIgnoreCase("CORRENTE")) {
							dispose();
							JSaldo jSaldo = new JSaldo(pessoa, conta);
							jSaldo.setLocationRelativeTo(jSaldo);
							jSaldo.setVisible(true);
						}
					}
				} else {
					// chama a tela passando a conta poupanca
					for (Conta conta : Conta.mapaContas.get(pessoa.getCpf())) {
						if (!conta.getTipoConta().equalsIgnoreCase("CORRENTE")) {
							System.out.println("CORRENTE --> " + conta);
							dispose();
							JSaldo jSaldo = new JSaldo(pessoa, conta);
							jSaldo.setLocationRelativeTo(jSaldo);
							jSaldo.setVisible(true);
						}
					}
				}
			}
		});
		btnSaldo.setBounds(78, 240, 102, 27);
		contentPane.add(btnSaldo);

		JButton btnExtrato = new JButton("Abrir Extrato");
		btnExtrato.setBounds(78, 278, 102, 27);
		contentPane.add(btnExtrato);

		JLabel lblNewLabel_2 = new JLabel("Olá, " + pessoa.getNome() + "!!");
		lblNewLabel_2.setBounds(0, 0, 379, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoSair.setBounds(78, 316, 102, 27);
		contentPane.add(botaoSair);

	}
}
