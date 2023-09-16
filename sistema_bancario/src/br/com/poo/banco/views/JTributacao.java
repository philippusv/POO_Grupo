package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.pessoas.Pessoas;
import javax.swing.JScrollPane;

public class JTributacao extends JFrame {

	private JPanel contentPane;

	public JTributacao(Pessoas pessoa, ContaCorrente conta) throws IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelSaudacao = new JLabel("Olá, " + pessoa.getNome() + "!!");
		LabelSaudacao.setBounds(0, 0, 265, 14);
		contentPane.add(LabelSaudacao);
		
		
		JLabel LabelTributacao = new JLabel("Tributação");
		LabelTributacao.setBounds(137, 11, 196, 35);
		LabelTributacao.setForeground(new Color(255, 0, 128));
		LabelTributacao.setBackground(new Color(255, 255, 255));
		LabelTributacao.setFont(new Font("Impact", Font.PLAIN, 28));
		contentPane.add(LabelTributacao);
		
		
		// permissão da leitura do arquivo
		String path = "TributacaoCC" + "_" + conta.getNumero() + "_" + conta.getCpfTitular();;
		BufferedReader buffRead = new BufferedReader(new FileReader("./temp/" + path + ".txt"));
		
		// definir uma variavel string
		String linha = "";
		String text = "";
		
		// faço um enquanto para ler
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				text = text.concat(linha + "\n");
			}else {
				break;
			}
		}
		// fechar o buff
		buffRead.close();
		
		//Passar o relatório pra cá
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 414, 156);
		contentPane.add(scrollPane);
		
		JTextPane txtpnToAqui = new JTextPane();
		scrollPane.setViewportView(txtpnToAqui);
		txtpnToAqui.setText(text);
		
					
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JMenuCliente jMenuCliente = new JMenuCliente(pessoa);
				jMenuCliente.setLocationRelativeTo(jMenuCliente);
				jMenuCliente.setVisible(true);
			}
		});
		botaoVoltar.setBounds(176, 214, 89, 23);
		contentPane.add(botaoVoltar);
		
		
	}
}
