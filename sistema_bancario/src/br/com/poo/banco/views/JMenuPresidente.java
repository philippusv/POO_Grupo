package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.enums.PessoaEnum;
import br.com.poo.banco.pessoas.Pessoas;

public class JMenuPresidente extends JFrame {

	private JPanel contentPane;

	
	
	public JMenuPresidente(Pessoas pessoa) {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 274);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelatorio = new JLabel("Relatório");
		lblRelatorio.setForeground(new Color(0, 0, 0));
		lblRelatorio.setFont(new Font("Arial", Font.BOLD, 16));
		lblRelatorio.setBounds(65, 82, 98, 23);
		contentPane.add(lblRelatorio);
		
		JComboBox comboBoxRelatorio = new JComboBox();
		comboBoxRelatorio.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxRelatorio.setModel(new DefaultComboBoxModel(new String[] {"Selecione uma opção ", "Diretor", "Capital Armazenado"}));
		comboBoxRelatorio.setBounds(27, 117, 155, 22);
		contentPane.add(comboBoxRelatorio);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setForeground(new Color(0, 0, 0));
		lblCadastro.setFont(new Font("Arial", Font.BOLD, 16));
		lblCadastro.setBounds(276, 78, 85, 30);
		contentPane.add(lblCadastro);
		
		JComboBox comboBoxCadastro = new JComboBox();
		comboBoxCadastro.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxCadastro.setModel(new DefaultComboBoxModel(new String[] {"Selecione uma opção ","Cliente", "Gerente", "Diretor"}));
		comboBoxCadastro.setBounds(227, 117, 155, 22);
		contentPane.add(comboBoxCadastro);
		
		JButton btnGerarRelatorio = new JButton("Gerar Relatório");
		btnGerarRelatorio.setFont(new Font("Arial", Font.PLAIN, 10));
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String relatorio = comboBoxRelatorio.getSelectedItem().toString();
				if(relatorio.equalsIgnoreCase(PessoaEnum.DIRETOR.name())) {
					dispose();
					JRelatorioPresidenteDiretor rj = new JRelatorioPresidenteDiretor(pessoa);
					rj.setLocationRelativeTo(rj);
					rj.setVisible(true);					
				}else if(relatorio.equals("Capital Armazenado")) {
					dispose();
					JRelatorioPresidenteCapital rc = new JRelatorioPresidenteCapital(pessoa);
					rc.setLocationRelativeTo(rc);
					rc.setVisible(true);
			        }
			}
		});
		btnGerarRelatorio.setBounds(48, 150, 116, 23);
		contentPane.add(btnGerarRelatorio);
		
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcao = comboBoxCadastro.getSelectedItem().toString();
				if(opcao.equalsIgnoreCase(PessoaEnum.CLIENTE.getTipoPessoa())){
					dispose();
					JCadastroConta cc = new JCadastroConta(pessoa);
					cc.setLocationRelativeTo(cc);
					cc.setVisible(true);
				}else if(opcao.equalsIgnoreCase(PessoaEnum.GERENTE.getTipoPessoa())) {
					dispose();
				/*	JCadastroGerente cg = new JCadastroGerente(pessoa);
					cg.setLocationRelativeTo(cg);
					cg.setVisible(true);
					*/
				}else if(opcao.equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())) {
					dispose();
				/*	JCadastroDiretor cd = new JCadastroDiretor(pessoa);
					cd.setLocationRelativeTo(cd);
					cd.setVisible(true);
					*/
				}
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 10));
		btnCadastrar.setBounds(249, 150, 116, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblMenuPresidente = new JLabel("Menu Presidente");
		lblMenuPresidente.setForeground(new Color(255, 0, 128));
		lblMenuPresidente.setFont(new Font("Arial", Font.BOLD, 20));
		lblMenuPresidente.setBounds(119, 30, 184, 30);
		contentPane.add(lblMenuPresidente);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JLogin lg = new JLogin();
				lg.setLocationRelativeTo(lg);
				lg.setVisible(true);
				
			}
		});
		btnSair.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSair.setBounds(177, 201, 89, 23);
		contentPane.add(btnSair);
	}
}
