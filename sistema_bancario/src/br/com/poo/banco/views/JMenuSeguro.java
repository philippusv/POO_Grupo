package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.pessoas.Pessoas;

public class JMenuSeguro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -87089182309408705L;
	private JPanel contentPane;

	public JMenuSeguro(Pessoas pessoa) {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Seguro de Vida");
		lblTitulo.setBounds(67, 25, 159, 48);
		lblTitulo.setForeground(new Color(255, 0, 128));
		lblTitulo.setBackground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Impact", Font.PLAIN, 25));
		contentPane.add(lblTitulo);

		// BOTAO ENTRAR
		JButton btnContratar = new JButton("Contratar Novo Seguro");
		// Chama a tela JSaqueDeposito ou JTransf
		btnContratar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean aux = false;
				// conta corrente selecionada
				for (Conta conta : Conta.mapaContas.get(pessoa.getCpf())) {
					if (conta.getTipoConta().equalsIgnoreCase("CORRENTE")) {
						dispose();
						JContratarSeguro jContratarSeguro = new JContratarSeguro((Cliente) pessoa, conta);
						jContratarSeguro.setLocationRelativeTo(jContratarSeguro);
						jContratarSeguro.setVisible(true);
						aux = true;
					}
				}
				if (!aux) {
					JOptionPane.showMessageDialog(btnContratar, "Não é possível contratar seguro nesta conta.");
				}
			}
		});
		btnContratar.setBounds(64, 76, 159, 27);
		contentPane.add(btnContratar);

		// BOTAO SALDO
		JButton btnConsultar = new JButton("Consultar");
		// Chama a tela JSaldo
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean aux = false;
				// conta corrente selecionada
				for (Conta conta : Conta.mapaContas.get(pessoa.getCpf())) {
					if (conta.getTipoConta().equalsIgnoreCase("CORRENTE")) {
						JConsultaSeguro jConsultaSeguro;
						try {
							Cliente cliente = (Cliente) pessoa;
							if (cliente.getSeguroVida() != null) {
								dispose();
								jConsultaSeguro = new JConsultaSeguro(pessoa, conta);
								jConsultaSeguro.setLocationRelativeTo(jConsultaSeguro);
								jConsultaSeguro.setVisible(true);
								aux = true;
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				if (!aux) {
					JOptionPane.showMessageDialog(btnContratar, "Esta conta não possui seguro.");
				}
			}
		});
		btnConsultar.setBounds(64, 107, 159, 27);
		contentPane.add(btnConsultar);

		JLabel lblSaudacao = new JLabel("Olá, " + pessoa.getNome() + "!!");
		lblSaudacao.setBounds(0, 0, 379, 14);
		contentPane.add(lblSaudacao);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JMenuCliente c = new JMenuCliente(pessoa);
				c.setLocationRelativeTo(c);
				c.setVisible(true);
			}
		});
		btnVoltar.setBounds(64, 149, 159, 27);
		contentPane.add(btnVoltar);

	}
}
