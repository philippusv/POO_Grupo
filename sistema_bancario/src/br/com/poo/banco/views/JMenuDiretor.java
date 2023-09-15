package br.com.poo.banco.views;
import  br.com.poo.banco.io.RelatorioDiretor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.poo.banco.pessoas.Pessoas;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class JMenuDiretor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JMenuDiretor(Pessoas pessoa) {
		setTitle("Sistema Bancário");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gerar relatório");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RelatorioDiretor.comprovanterelatorio(pessoa);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
			
			});
		
		btnNewButton.setBounds(0, 232, 115, 21);
		contentPane.add(btnNewButton);
		
		JButton btnCadastrar_1 = new JButton("Cadastrar Gerente");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar_1.setBounds(125, 232, 142, 21);
		contentPane.add(btnCadastrar_1);
		
		JButton btnCadastrar = new JButton(" Cadastrar Cliente");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JCadastroConta jCadastroConta = new JCadastroConta(pessoa);
				jCadastroConta.setLocationRelativeTo(jCadastroConta);
				jCadastroConta.setVisible(true);
				
			}
		});
		btnCadastrar.setBounds(277, 232, 147, 21);
		contentPane.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 45, 348, 177);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
				{"Ana Paula Padrão", "458.998.885-33", 003 },
				{"Giulietta Capuleto","996.990.880-30",004 },
				{"Felipe Felps","174.229.781-02", 004},
				{"Ícaro Gaspar", "222.333.444-55", 002},
				{"Luciana  Brand", "320.123.230-92",001},
				{"Mahyara Paraquett", "123.456.789-11", 001},
				{"Paloma Tavares", "555.444.333-22", 003},
				{"Rafael Vinícius", "111.654.524-66", 005},
				{"Rodrigo Fernandes","427.118.842-15",003},
				{"Romeo Montequio", "624.220.111-43", 004},
				
			},
			new String[] {
				"NOME", "CPF","AGÊNCIA"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("MENU DIRETOR");
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setBackground(new Color(255, 0, 128));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 25));
		lblNewLabel.setBounds(135, 10, 150, 25);
		contentPane.add(lblNewLabel);
	}
}

