package br.com.poo.banco.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

public class JRelatorioPresidenteDiretor extends JFrame {

	private JPanel contentPane;
	private JTable tableDiretorAgGer;
	private JButton btnGerarRelatorio;

	
	public JRelatorioPresidenteDiretor(Pessoas pessoa) {
		setTitle("Sistema Bancário");
		Presidente presidente = (Presidente) pessoa;
		Diretor diretor = (Diretor) pessoa;
		Gerente gerente = (Gerente) pessoa;
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
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tableDiretorAgGer.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(tableDiretorAgGer);
		/*for (Map.Entry<String, Pessoas> diretoria : Pessoas.mapaPessoas.entrySet()){
			if(diretoria.getValue().getTipo().equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())){
				String[] agencias = {
						((Diretor) diretoria.getValue()).getagencia1(),	
						((Diretor) diretoria.getValue()).getagencia2(),
						((Diretor) diretoria.getValue()).getagencia3()
				};
				for(String agencia: agencias) {
					for(Map.Entry<String, Pessoas> gerentes : Pessoas.mapaPessoas.entrySet()) {
						if(((Gerente)gerentes.getValue()).getAgencia().equalsIgnoreCase(agencia)) {
							String[] informacoes = {
									diretoria.getValue().getNome(),
									agencia,
									gerentes.getValue().getNome()
							};
							((DefaultTableModel) tableDiretorAgGer.getModel()).addRow(informacoes);
						}
					}
				}
			}

		}*/

								
		btnGerarRelatorio = new JButton("Gerar Relatorio");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			static final String PATH_BASICO = "./temp/";
			static final String EXTENSAO = ".txt";
			
			public void actionPerformed(ActionEvent e) {
				String path = "RelatorioPresidente";
				try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO))){
					
					buffWrite.append("************* DIRETOR ************\n");
					buffWrite.append("Nomes: \n" + diretor.getNome());
					buffWrite.append("************* AGÊNCIA ************\n");
					buffWrite.append("Agências: \n" + gerente.getAgencia());
					buffWrite.append("************* GERENTE ************\n");
					buffWrite.append("Nomes: \n" + gerente.getNome());
						
				} catch (IOException e1) {
				
					e1.printStackTrace();
				}
			
			
			}
		});
		btnGerarRelatorio.setFont(new Font("Arial", Font.PLAIN, 11));
		btnGerarRelatorio.setBounds(208, 271, 122, 23);
		contentPane.add(btnGerarRelatorio);
	}
}
