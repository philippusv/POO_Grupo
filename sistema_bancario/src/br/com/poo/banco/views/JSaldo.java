package br.com.poo.banco.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.io.RelatorioCliente;
import br.com.poo.banco.pessoas.Pessoas;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class JSaldo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JSaldo frame = new JSaldo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 * @param pessoa 
	 */
	public JSaldo(Pessoas pessoa, Conta conta) {
		
		DecimalFormat df = new DecimalFormat("#,###.##");
				
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Saldo");
		titulo.setBounds(186, 25, 66, 48);
		titulo.setForeground(new Color(255, 0, 128));
		titulo.setBackground(new Color(255, 255, 255));
		titulo.setFont(new Font("Impact", Font.PLAIN, 25));
		contentPane.add(titulo);
		
		JLabel saldo = new JLabel("Saldo: R$ " + df.format(conta.getSaldo()));
		saldo.setBounds(125, 101, 188, 42);
		contentPane.add(saldo);
		
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JMenuCliente jMenuCliente = new JMenuCliente(pessoa);
				jMenuCliente.setLocationRelativeTo(jMenuCliente);
				jMenuCliente.setVisible(true);
			}
		});
		
		
		voltar.setBounds(149, 204, 138, 27);
		contentPane.add(voltar);
		
		JLabel saudacao = new JLabel("Olá, " + pessoa.getNome()+ "!!");
		saudacao.setBounds(0, 0, 379, 14);
		contentPane.add(saudacao);
		
		JButton imprimir = new JButton("Imprimir Relatório");
		imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RelatorioCliente.saldo(conta);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		imprimir.setBounds(149, 170, 138, 27);
		contentPane.add(imprimir);
		
		
	}
}
