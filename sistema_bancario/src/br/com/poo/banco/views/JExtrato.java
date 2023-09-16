package br.com.poo.banco.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.enums.ContaEnum;
import br.com.poo.banco.enums.PessoaEnum;
import br.com.poo.banco.io.LeituraEscrita;
import br.com.poo.banco.io.RelatorioCliente;
import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.pessoas.Diretor;
import br.com.poo.banco.pessoas.Gerente;
import br.com.poo.banco.pessoas.Pessoas;
import br.com.poo.banco.pessoas.Presidente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class JExtrato extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static int contador = 0;

	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JExtrato frame = new JExtrato();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public JExtrato(Pessoas pessoa, Conta conta) throws IOException {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel LabelSaudacao = new JLabel("Olá, " + pessoa.getNome() + "!!");
		LabelSaudacao.setBounds(0, 0, 379, 14);
		contentPane.add(LabelSaudacao);

		JLabel LabelExtrato = new JLabel("Extrato");
		LabelExtrato.setBounds(176, 11, 94, 48);
		LabelExtrato.setForeground(new Color(255, 0, 128));
		LabelExtrato.setBackground(new Color(255, 255, 255));
		LabelExtrato.setFont(new Font("Impact", Font.PLAIN, 28));
		contentPane.add(LabelExtrato);

		JButton botaoImprimir = new JButton("Voltar");
		botaoImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JMenuCliente jMenuCliente = new JMenuCliente(pessoa);
				jMenuCliente.setLocationRelativeTo(jMenuCliente);
				jMenuCliente.setVisible(true);
			}
		});
		botaoImprimir.setBounds(176, 214, 89, 23);
		contentPane.add(botaoImprimir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 55, 323, 148);
		contentPane.add(scrollPane);
		
		// permissão da leitura do arquivo
		String path = "";
		if(conta.getTipoConta().equalsIgnoreCase("CORRENTE")) {
			path = path.concat("Corrente_" + conta.getCpfTitular());
		}else {
			path = path.concat("Poupanca_" + conta.getCpfTitular());
		}

		BufferedReader buffRead = new BufferedReader(new FileReader("./temp/" + path + ".txt"));
		// definir uma variavel string
		String linha = "";
		String text = "";

		// faço um enquanto para ler
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				contador++;
				text = text.concat(linha + "\n");
			}else {
				break;
			}
		}
		// fechar o buff
		buffRead.close();
		JTextPane txtpnSaque = new JTextPane();
		scrollPane.setViewportView(txtpnSaque);
		txtpnSaque.setText(text);


	}
}
