package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.pessoas.Pessoas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class JConsultaSeguro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public JConsultaSeguro(Pessoas pessoa, Conta conta) throws IOException {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel LabelSaudacao = new JLabel("Olá, " + pessoa.getNome() + "!!");
		LabelSaudacao.setBounds(0, 0, 379, 14);
		contentPane.add(LabelSaudacao);

		JLabel LblTitulo = new JLabel("Seguro de Vida");
		LblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		LblTitulo.setBounds(56, 11, 323, 48);
		LblTitulo.setForeground(new Color(255, 0, 128));
		LblTitulo.setBackground(new Color(255, 255, 255));
		LblTitulo.setFont(new Font("Impact", Font.PLAIN, 28));
		contentPane.add(LblTitulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 55, 323, 148);
		contentPane.add(scrollPane);
		
		// permissão da leitura do arquivo
		String path = "SeguroVida_" + conta.getCpfTitular();
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
		
		// TEXTPANE
		JTextPane txtpnSaque = new JTextPane();
		scrollPane.setViewportView(txtpnSaque);
		txtpnSaque.setText(text);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JMenuSeguro s = new JMenuSeguro(pessoa);
				s.setLocationRelativeTo(s);
				s.setVisible(true);
			}
		});
		botaoVoltar.setBounds(176, 214, 89, 23);
		contentPane.add(botaoVoltar);
	}
}
