package br.com.poo.banco.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;

public class RelatorioCliente extends JFrame {

	private JPanel contentPane;
	private JTable tabelaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioCliente frame = new RelatorioCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RelatorioCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 31, 290, 172);
		contentPane.add(scrollPane);
		
		tabelaCliente = new JTable();
		tabelaCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(tabelaCliente);
		tabelaCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{"Mahyara Paraquett", "1234567-9"},
				{"Icaro Gaspar", "2424583-2"},
				{"Paloma Tavares", "3568254-7"},
				{"Luciana Brand", "4561237-6"},
				{"Rafael Vinicius", "8945621-1"},
				{"Ricardo Soares", "5553337-5"},
				{"Ana Paula Padrao", "6631445-3"},
				{"Helena Rizzo", "8456321-8"},
				{"Giulietta Capuleto", "7777555-5"},
				{"Romeu Montequio", "4448888-2"},
			},
			new String[] {
				"Nome_Cliente", "Conta"
			}
		));
		tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(96);
		
		JButton botaoRelatorio = new JButton("Gerar Relatório");
		botaoRelatorio.setBounds(147, 227, 145, 23);
		contentPane.add(botaoRelatorio);
	}
}
