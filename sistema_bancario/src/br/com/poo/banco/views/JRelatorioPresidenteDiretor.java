package br.com.poo.banco.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.pessoas.Diretor;
import br.com.poo.banco.pessoas.Gerente;
import br.com.poo.banco.pessoas.Pessoas;
import br.com.poo.banco.pessoas.Presidente;
import br.com.poo.banco.enums.PessoaEnum;
import br.com.poo.banco.io.RelatorioPresidente;

public class JRelatorioPresidenteDiretor extends JFrame {

	private JPanel contentPane;
	private JTable tableDiretorAgGer;
	private JButton btnGerarRelatorio;

	
	public JRelatorioPresidenteDiretor(Pessoas pessoa) {
		setTitle("Sistema Bancário");
		Presidente presidente = (Presidente) pessoa;
		//Diretor diretor = (Diretor) pessoa;
		//Gerente gerente = (Gerente) pessoa;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 31, 479, 229);
		contentPane.add(scrollPane);
		
		
		
		tableDiretorAgGer = new JTable();
		tableDiretorAgGer.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome Diretor", "Agência", "Nome Gerente"
			}
		));
		tableDiretorAgGer.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(tableDiretorAgGer);
		
		String[] informacoes = {"", "", "Nenhum Gerente"};
		List<String[]> dados = new ArrayList<String[]>();
		
		// Pegar diretores
		for (Map.Entry<String, Pessoas> diretor : Pessoas.mapaPessoas.entrySet()){
			if(diretor.getValue().getTipo().equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())){
				informacoes[0] = diretor.getValue().getNome();
				
				// Guardar todas as agências de cada diretor:
				String[] agencias = {
						((Diretor) diretor.getValue()).getagencia1(),	
						((Diretor) diretor.getValue()).getagencia2(),
						((Diretor) diretor.getValue()).getagencia3()
				};
				
				// Executar para cada agência do diretor:
				for(String agencia: agencias) {
					informacoes[1] = agencia;
					
					// Pegar gerentes das agências:
					informacoes[2] = "";
					for(Map.Entry<String, Pessoas> gerente : Pessoas.mapaPessoas.entrySet()) {
						if(gerente.getValue().getTipo().equalsIgnoreCase(PessoaEnum.GERENTE.getTipoPessoa())) {
							if(((Gerente) gerente.getValue()).getAgencia().equalsIgnoreCase(agencia)) {
								informacoes[2] = gerente.getValue().getNome();
								break;
							}
						}
					}
					((DefaultTableModel) tableDiretorAgGer.getModel()).addRow(informacoes);
					//System.out.println(informacoes[0] +  informacoes[1] + informacoes[2]);
					dados.add(informacoes.clone());
					informacoes[0] = "";
				}
			}
		}
		
		btnGerarRelatorio = new JButton("Gerar Relatorio");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[][] _dados = {{null}};
				try {
					RelatorioPresidente.relatorioDiretores(pessoa, dados.toArray(_dados));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnGerarRelatorio.setFont(new Font("Arial", Font.PLAIN, 11));
		btnGerarRelatorio.setBounds(208, 271, 122, 23);
		contentPane.add(btnGerarRelatorio);
	}
}
