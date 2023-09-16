package br.com.poo.banco.views;
import br.com.poo.banco.contas.Conta;
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
import br.com.poo.banco.pessoas.Diretor;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;
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
				dispose();
				JCadastroGerente cg = new JCadastroGerente(pessoa);
				cg.setLocationRelativeTo(cg);
				cg.setVisible(true);
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
		
		// Tabela
		table = new JTable();
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "CPF","AGÊNCIA"
			}
		));
		scrollPane.setViewportView(table);
		
		String[] agencias = {
				((Diretor) pessoa).getagencia1(), 
				((Diretor) pessoa).getagencia2(), 
				((Diretor) pessoa).getagencia3()
		};
		
		for (Map.Entry<String, List<Conta>> entry : Conta.mapaContas.entrySet()) {
			List<Conta> contas = entry.getValue();
			for (Conta conta : contas) {
				for (String agencia : agencias) {
					if (conta.getAgencia().equalsIgnoreCase(agencia)) {
						String[] informacoes = {
								Pessoas.mapaPessoas.get(conta.getCpfTitular()).getNome(),
								conta.getCpfTitular(),
								agencia
						};
						((DefaultTableModel) table.getModel()).addRow(informacoes);
					}
				}
			}
		}
		
		JLabel lblNewLabel = new JLabel("MENU DIRETOR");
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setBackground(new Color(255, 0, 128));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 25));
		lblNewLabel.setBounds(135, 10, 150, 25);
		contentPane.add(lblNewLabel);
	}
}

