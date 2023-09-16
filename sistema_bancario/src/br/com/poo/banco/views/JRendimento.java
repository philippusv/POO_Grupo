package br.com.poo.banco.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.io.RelatorioCliente;
import br.com.poo.banco.pessoas.Pessoas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class JRendimento extends JFrame {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	
	private JPanel contentPane;

		
	public JRendimento(Pessoas pessoa) {
				
		setTitle("Sistema Bancario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Simulador de Rendimento da Poupança");
		titulo.setBounds(47, 11, 434, 37);
		titulo.setForeground(new Color(255, 0, 128));
		titulo.setFont(new Font("Impact", Font.PLAIN, 25));
		titulo.setBackground(Color.WHITE);
		contentPane.add(titulo);
		
		JLabel lblValor = new JLabel("Valor a ser investido (R$):");
		lblValor.setBounds(39, 89, 174, 14);
		contentPane.add(lblValor);
		
		JLabel lblNewLabel = new JLabel("Bem-vindo(a) ao simulador! Insira os dados abaixo e veja o quanto seu dinheiro iria render!");
		lblNewLabel.setBounds(0, 52, 521, 14);
		contentPane.add(lblNewLabel);
		
		JFormattedTextField txvalor = new JFormattedTextField();
		txvalor.setBounds(10, 114, 203, 20);
		contentPane.add(txvalor);
		
		JLabel lblDias = new JLabel("Insira por quantos dias você deixará aplicado:");
		lblDias.setBounds(235, 89, 308, 14);
		contentPane.add(lblDias);
		
		JFormattedTextField txdias = new JFormattedTextField();
		txdias.setBounds(277, 114, 203, 20);
		contentPane.add(txdias);
		
		JButton botao = new JButton("Simular");
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = txvalor.getText();
				String dias = txdias.getText();
				
				ContaPoupanca conta = new ContaPoupanca();
				
				    				    				
				if(valor.isEmpty() || dias.isEmpty()) {
					JOptionPane.showMessageDialog(botao, "Preencha todos os campos.");
				
				}else {
					double valorD = Double.parseDouble(valor);
				    int valorI = Integer.parseInt(dias);
					JOptionPane.showMessageDialog(botao, "Seu rendimento será de: R$ "
							+ conta.calcularRendimento(valorD, valorI));
						try {
							RelatorioCliente.rendimentoCP(conta, valorD, valorI);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					} 
				}
			});
		botao.setBounds(203, 163, 89, 23);
		contentPane.add(botao);
		
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JLogin l = new JLogin();
				l.setLocationRelativeTo(l);
				l.setVisible(true);
			}
		});
		voltar.setBounds(203, 197, 89, 23);
		contentPane.add(voltar);
	}
}
