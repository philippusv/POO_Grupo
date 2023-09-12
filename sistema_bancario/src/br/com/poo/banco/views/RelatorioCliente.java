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
				{"Mahyara Paraquett", "123456-1", "Poupan\u00E7a"},
				{"Icaro Gaspar", "200000-1", "Poupan\u00E7a"},
				{"Paloma Tavares", "521485-1", "Poupan\u00E7a"},
				{"Luciana Brand", "789000-1", "Poupan\u00E7a"},
				{"Rafael Vinicius", "101099-1", "Poupan\u00E7a"},
				{"Rafael Vinicius", "660800-2", "Corrente"},
				{"Ana Paula Padrao", "889002-2", "Corrente"},
				{"Helena Rizzo", "112233-2", "Corrente"},
				{"Giulietta Capuleto", "210593-2", "Corrente"},
				{"Romeu Montequio", "190823-2", "Corrente"},
			},
			new String[] {
				"Nome_Cliente", "Conta", "Tipo_Conta"
			}
		));
		tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(96);
		
		JButton botaoRelatorio = new JButton("Gerar Relatório");
		botaoRelatorio.setBounds(147, 227, 145, 23);
		contentPane.add(botaoRelatorio);
	}
}
