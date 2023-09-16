package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.pessoas.Pessoas;
import br.com.poo.banco.io.RelatorioPresidente;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class JRelatorioPresidenteCapital extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	
	public JRelatorioPresidenteCapital(Pessoas pessoa) {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPresidente = new JLabel("Presidente");
		lblPresidente.setForeground(new Color(255, 0, 128));
		lblPresidente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPresidente.setBounds(10, 0, 70, 22);
		contentPane.add(lblPresidente);
		
		JLabel lblRelatorioCapital = new JLabel("Relatório total capital armazenado");
		lblRelatorioCapital.setForeground(new Color(0, 0, 0));
		lblRelatorioCapital.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRelatorioCapital.setBounds(58, 52, 215, 14);
		contentPane.add(lblRelatorioCapital);
		
		textField = new JTextField();
		textField.setBounds(44, 86, 227, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnGerarRelatorio = new JButton("Gerar Relatório");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText("" + RelatorioPresidente.capitalArmazenado(pessoa));
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGerarRelatorio.setFont(new Font("Arial", Font.PLAIN, 11));
		btnGerarRelatorio.setBounds(86, 125, 153, 23);
		contentPane.add(btnGerarRelatorio);
	}
}
