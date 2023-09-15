package br.com.poo.banco.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import br.com.poo.banco.contas.Conta;
// Import das classes usadas:
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.pessoas.Gerente;
import br.com.poo.banco.pessoas.Pessoas;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class JRelatorioGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableContasAgencia;
	private JTable tableInfoContas;

	/**
	 * Criação de Frame
	 */
	public JRelatorioGerente(Gerente gerente) {
		String agencia = gerente.getAgencia();
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * Modelos de Tabelas
		 */
		String[] head_A = { "Nº da Conta", "Seleção" };
		DefaultTableModel model_A = new DefaultTableModel(head_A, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		String[] head_B = { "Nº da Conta", "Tipo de Conta", "Nome do Títular", "CPF do Títular", "Saldo" };
		DefaultTableModel model_B = new DefaultTableModel(head_B, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		/*
		 * Tabelas
		 */
		// Tabela para as informações das contas selecionadas:
		tableInfoContas = new JTable(model_B);
		tableInfoContas.setCellSelectionEnabled(true);
		tableInfoContas.setFont(new Font("Tahoma", Font.PLAIN, 10));

		// Tabela para as contas da agência:
		tableContasAgencia = new JTable(model_A);
		tableContasAgencia.setCellSelectionEnabled(true);
		tableContasAgencia.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tableContasAgencia.setBounds(10, 29, 414, 184);

		// gambiarra até a linha 156:

		// Adicionar todas as contas na agências:
		for (Map.Entry<String, List<Conta>> entry : Conta.mapaContas.entrySet()) {
			List<Conta> contas = entry.getValue();

			for (Conta conta : contas) {

				if (conta.getAgencia().equals(agencia)) {
					String[] item = { conta.getNumero(), " " };
					model_A.addRow(item);
				}
			}
		}

		// Responder ao click do mouse:
		tableContasAgencia.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				JTable target = (JTable) me.getSource();
				int row = target.getSelectedRow(); // select a row
				int column = target.getSelectedColumn(); // select a column

				if (column == 0) {
					Object value = tableContasAgencia.getValueAt(row, column);

					// 2 Clicks:
					if (me.getClickCount() == 2) {

						// Adicionar ou remover informações das contas selecionadas
						if (tableContasAgencia.getValueAt(row, 1) == "Selecionado") {
							model_A.setValueAt("", row, 1);

							for (int i = 0; i < tableInfoContas.getRowCount(); i++) {
								if (value == tableInfoContas.getValueAt(i, 0)) {
									model_B.removeRow(i);
									break;
								}
							}
						} else {
							model_A.setValueAt("Selecionado", row, 1);
							for (Map.Entry<String, List<Conta>> entry : Conta.mapaContas.entrySet()) {
								List<Conta> contas = entry.getValue();

								for (Conta conta : contas) {

									if (conta.getNumero().equals(value)) {
										String[] item = { conta.getNumero(), conta.getTipoConta(),
												Pessoas.mapaPessoas.get(conta.getCpfTitular()).getNome(),
												conta.getCpfTitular(), "" + conta.getSaldo() };
										model_B.addRow(item);
									}
								}
							}
						}
					}
				}
			}
		});

		/*
		 * Botões
		 */
		// Imprimir relatório do total de contas:
		JButton btnGerarRelatorio1 = new JButton("Imprimir relatório do total de contas");
		btnGerarRelatorio1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGerarRelatorio1.setBounds(10, 244, 292, 26);
		contentPane.add(btnGerarRelatorio1);

		// Imprimir relatório das contas selecionadas:
		JButton btnGerarRelatorio2 = new JButton("Imprimir relatório das contas selecionadas");
		btnGerarRelatorio2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGerarRelatorio2.setBounds(312, 244, 292, 26);
		contentPane.add(btnGerarRelatorio2);

		// Voltar para o menu do gerente:
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JMenuGerente jMenu = new JMenuGerente(gerente);
				jMenu.setLocationRelativeTo(jMenu);
				jMenu.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBounds(614, 244, 120, 26);
		contentPane.add(btnVoltar);

		/*
		 * Outros
		 */
		// Label dinâmico: Agência
		JLabel lblNewLabel = new JLabel("Contas na agência: " + agencia);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);

		// JScrolls
		JScrollPane scrollConta = new JScrollPane();
		scrollConta.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollConta.setBounds(10, 29, 220, 204);
		contentPane.add(scrollConta);
		scrollConta.setViewportView(tableContasAgencia);

		JScrollPane scrollData = new JScrollPane();
		scrollData.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollData.setBounds(240, 29, 494, 204);
		contentPane.add(scrollData);
		scrollData.setViewportView(tableInfoContas);
	}
}