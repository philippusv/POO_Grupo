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

import br.com.poo.banco.io.RelatorioCliente;
import br.com.poo.banco.pessoas.Pessoas;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JExtrato extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
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
	 */
	public JExtrato(Pessoas pessoa) {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelSaudacao = new JLabel("Olá, " + pessoa.getNome()+ "!!");
		LabelSaudacao.setBounds(0, 0, 379, 14);
		contentPane.add(LabelSaudacao);
		
		
		JLabel LabelExtrato = new JLabel("Extrato");
		LabelExtrato.setBounds(176, 11, 94, 48);
		LabelExtrato.setForeground(new Color(255, 0, 128));
		LabelExtrato.setBackground(new Color(255, 255, 255));
		LabelExtrato.setFont(new Font("Impact", Font.PLAIN, 28));
		contentPane.add(LabelExtrato);
		
		JButton botaoImprimir = new JButton("Imprimir");
		botaoImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		botaoImprimir.setBounds(181, 238, 89, 23);
		contentPane.add(botaoImprimir);
		
		 
		
		
	}
}
