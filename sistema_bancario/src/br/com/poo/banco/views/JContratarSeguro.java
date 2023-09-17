package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.enums.ContaEnum;
import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.pessoas.Pessoas;
import javax.swing.JTextField;

public class JContratarSeguro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txValor;

	public JContratarSeguro(Cliente pessoa, Conta conta) {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Seguro de Vida");
		lblTitulo.setBounds(67, 11, 156, 48);
		lblTitulo.setForeground(new Color(255, 0, 128));
		lblTitulo.setBackground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Impact", Font.PLAIN, 25));
		contentPane.add(lblTitulo);

		// Valor inserido
		JLabel lblValor = new JLabel("Valor Segurado (R$):");
		lblValor.setBounds(67, 64, 159, 18);
		contentPane.add(lblValor);
		txValor = new JTextField();
		txValor.setBounds(64, 84, 159, 20);
		contentPane.add(txValor);
		txValor.setColumns(10);
		
		// BOTAO CONTRATAR
		JButton btnContratar = new JButton("Contratar");
		btnContratar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pessoa.contratarSeguroVida(Double.parseDouble(txValor.getText()));
					JOptionPane.showMessageDialog(btnContratar, "Seguro contratado com sucesso!");
					dispose();
					JMenuSeguro s = new JMenuSeguro(pessoa);
					s.setLocationRelativeTo(s);
					s.setVisible(true);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btnContratar.setBounds(64, 128, 159, 27);
		contentPane.add(btnContratar);

		JLabel lblSaudacao = new JLabel("Olá, " + pessoa.getNome() + "!!");
		lblSaudacao.setBounds(0, 0, 379, 14);
		contentPane.add(lblSaudacao);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JMenuSeguro s = new JMenuSeguro(pessoa);
				s.setLocationRelativeTo(s);
				s.setVisible(true);
			}
		});
		btnVoltar.setBounds(64, 159, 159, 27);
		contentPane.add(btnVoltar);

	}
}
