package br.com.poo.banco.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.pessoas.Gerente;
import br.com.poo.banco.pessoas.Pessoas;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class JMenuGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public JMenuGerente(Pessoas pessoa) {
		setTitle("Sistema Bancário");
		
		// Cast do objeto no mapaPessoas para a subclasse Gerente:
		Gerente gerente = (Gerente) pessoa;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuGerente = new JLabel("Menu Gerente");
		lblMenuGerente.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuGerente.setForeground(new Color(255, 0, 128));
		lblMenuGerente.setFont(new Font("Impact", Font.PLAIN, 25));
		lblMenuGerente.setBackground(Color.WHITE);
		lblMenuGerente.setBounds(129, 21, 166, 42);
		contentPane.add(lblMenuGerente);
		
		
		// Tela para cadastrar uma nova conta de cliente:
		JButton btnCadastroConta = new JButton("Cadastrar Conta");
		btnCadastroConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JCadastroConta jCadastroConta = new JCadastroConta(pessoa);
				jCadastroConta.setLocationRelativeTo(jCadastroConta);
				jCadastroConta.setVisible(true);
			}
		});
		btnCadastroConta.setBounds(129, 111, 166, 23);
		contentPane.add(btnCadastroConta);
		
		// Tela para mostrar o relatório com as informações das contas na agência:
		JButton btnRelatorioContas = new JButton("Relatório de Contas");
		btnRelatorioContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JRelatorioGerente jRelatorio = new JRelatorioGerente(gerente);
				jRelatorio.setLocationRelativeTo(jRelatorio);
				jRelatorio.setVisible(true);
			}
		});
		btnRelatorioContas.setBounds(129, 147, 166, 23);
		contentPane.add(btnRelatorioContas);
		
		// Botão para voltar para a tela de login:
		JButton btnVoltar = new JButton("Sair");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JLogin jLogin = new JLogin();
				jLogin.setLocationRelativeTo(jLogin);
				jLogin.setVisible(true);
			}
		});
		btnVoltar.setBounds(129, 216, 166, 23);
		contentPane.add(btnVoltar);
		
		// Label Dinâmico - Nome:
		JLabel lblNomeGerente = new JLabel("Bem vindo, " + gerente.getNome() + ".");
		lblNomeGerente.setBounds(10, 0, 208, 23);
		contentPane.add(lblNomeGerente);
		
		// Label Dinâmico - Agência:
		JLabel lblAgencia = new JLabel("Agência: " + gerente.getAgencia());
		lblAgencia.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblAgencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgencia.setBounds(129, 59, 166, 23);
		contentPane.add(lblAgencia);
	}
}
