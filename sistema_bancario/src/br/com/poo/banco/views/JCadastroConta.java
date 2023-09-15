package br.com.poo.banco.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.enums.ContaEnum;
import br.com.poo.banco.enums.PessoaEnum;
import br.com.poo.banco.io.LeituraEscrita;
import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.pessoas.Diretor;
import br.com.poo.banco.pessoas.Gerente;
import br.com.poo.banco.pessoas.Pessoas;
import br.com.poo.banco.pessoas.Presidente;

public class JCadastroConta extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lbCadastroCliente = new JLabel("Cadastro de Cliente");
	private JPasswordField pswSenhaCliente;


	public JCadastroConta(Pessoas pessoa) {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lbCadastroCliente.setForeground(new Color(255, 0, 128));
		lbCadastroCliente.setBounds(132, 10, 272, 29);
		lbCadastroCliente.setFont(new Font("Arial Black", Font.BOLD, 20));

		lbCadastroCliente.setVerticalAlignment(SwingConstants.TOP);
		lbCadastroCliente.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbCadastroCliente);

		JLabel lbTipoConta = new JLabel("Tipo de Conta:");
		lbTipoConta.setBounds(10, 119, 128, 14);
		lbTipoConta.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbTipoConta);

		JComboBox cbTipoConta = new JComboBox();
		cbTipoConta.setModel(new DefaultComboBoxModel(new String[] { "Conta Corrente", "Conta Poupança" }));
		cbTipoConta.setBounds(10, 144, 134, 22);
		contentPane.add(cbTipoConta);

		JLabel lbAgencia = new JLabel("Agência:");
		lbAgencia.setHorizontalAlignment(SwingConstants.LEFT);
		lbAgencia.setBounds(192, 119, 89, 14);
		contentPane.add(lbAgencia);

		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pessoa.getTipo().equalsIgnoreCase(PessoaEnum.GERENTE.getTipoPessoa())) {
					dispose();
					JMenuGerente menuG = new JMenuGerente(pessoa);
					menuG.setLocationRelativeTo(menuG);
					menuG.setVisible(true);
				}else if(pessoa.getTipo().equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())) {
					dispose();
					JCadastroConta menu = new JCadastroConta(pessoa);
					menu.setLocationRelativeTo(menu);
					menu.setVisible(true);
				}else {
					dispose();
					JMenuPresidente mp = new JMenuPresidente(pessoa);
					mp.setLocationRelativeTo(mp);
					mp.setVisible(true);
				}
				
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 10));
		btnVoltar.setBounds(157, 259, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lbSaldo = new JLabel("Saldo:");
		lbSaldo.setHorizontalAlignment(SwingConstants.LEFT);
		lbSaldo.setBounds(192, 181, 128, 14);
		contentPane.add(lbSaldo);

		JLabel lbSenhaCliente = new JLabel("Senha do Cliente:");
		lbSenhaCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lbSenhaCliente.setBounds(373, 62, 100, 14);
		contentPane.add(lbSenhaCliente);

		JLabel lbCPF = new JLabel("CPF:");
		lbCPF.setHorizontalAlignment(SwingConstants.LEFT);
		lbCPF.setBounds(192, 62, 66, 14);
		contentPane.add(lbCPF);

		pswSenhaCliente = new JPasswordField();
		pswSenhaCliente.setBounds(373, 87, 134, 22);
		contentPane.add(pswSenhaCliente);

		JFormattedTextField txNomeCliente = new JFormattedTextField();
		txNomeCliente.setBounds(10, 88, 134, 20);
		contentPane.add(txNomeCliente);

		JFormattedTextField txCPF = new JFormattedTextField();
		txCPF.setBounds(192, 88, 134, 20);
		contentPane.add(txCPF);
		
		if(pessoa.getTipo().equalsIgnoreCase(PessoaEnum.GERENTE.getTipoPessoa())) {
			Gerente gerente = (Gerente) pessoa;
			JLabel User = new JLabel(gerente.getNome());
			User.setBounds(20, 212, 182, 14);
			contentPane.add(User);
		}else if(pessoa.getTipo().equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())) {
			Diretor diretor = (Diretor) pessoa;
			JLabel User = new JLabel(diretor.getNome());
			User.setBounds(20, 212, 182, 14);
			contentPane.add(User);
		}else {
			Presidente presidente = (Presidente) pessoa;
			JLabel User = new JLabel(presidente.getNome());
			User.setBounds(20, 212, 182, 14);
			contentPane.add(User);
		}
		
		JLabel lbFuncionario = new JLabel("Responsável pela abertura:");
		lbFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		lbFuncionario.setBounds(10, 181, 182, 14);
		contentPane.add(lbFuncionario);

		JFormattedTextField txNumConta = new JFormattedTextField();
		txNumConta.setBounds(373, 146, 134, 20);
		contentPane.add(txNumConta);

		JLabel lbNumConta = new JLabel("Número da Conta:");
		lbNumConta.setHorizontalAlignment(SwingConstants.LEFT);
		lbNumConta.setBounds(373, 119, 134, 14);
		contentPane.add(lbNumConta);

		JLabel lbNomeCliente = new JLabel("Nome do Cliente:");
		lbNomeCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lbNomeCliente.setBounds(10, 62, 128, 14);
		contentPane.add(lbNomeCliente);

		JFormattedTextField txSaldo = new JFormattedTextField();
		txSaldo.setBounds(196, 206, 134, 20);
		contentPane.add(txSaldo);

		JFormattedTextField txChequeEspecial = new JFormattedTextField();
		txChequeEspecial.setBounds(373, 206, 134, 20);
		contentPane.add(txChequeEspecial);

		JLabel lblChequeEspecial = new JLabel("Cheque Especial:");
		lblChequeEspecial.setHorizontalAlignment(SwingConstants.LEFT);
		lblChequeEspecial.setBounds(373, 181, 134, 14);
		contentPane.add(lblChequeEspecial);

		JComboBox cbAgencia = new JComboBox();
		cbAgencia.setModel(new DefaultComboBoxModel(new String[] { "001", "002", "003", "004", "005" }));
		cbAgencia.setToolTipText("");
		cbAgencia.setBounds(192, 144, 134, 22);
		contentPane.add(cbAgencia);

		JButton botaoConfirma = new JButton("Confirmar");
		botaoConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txNomeCliente.getText();
				String cpf = txCPF.getText();
				String numConta = txNumConta.getText();
				String saldo = txSaldo.getText();
				String chequeEspecial = txChequeEspecial.getText();
				String agencia = cbAgencia.getSelectedItem().toString();
				String senha = new String(pswSenhaCliente.getPassword());
				String tipoConta = cbTipoConta.getSelectedItem().toString();
				if (nome.isEmpty() || cpf.isEmpty() || senha.isEmpty()) {
					JOptionPane.showMessageDialog(botaoConfirma, "Preencha todos os campos.");
				} else {
					Pessoas c = new Cliente(PessoaEnum.CLIENTE.getTipoPessoa(), nome, cpf, Integer.parseInt(senha),
							numConta);
					Cliente.mapaPessoas.put(cpf, c);
					String cliente = "\n" + PessoaEnum.CLIENTE.getTipoPessoa() + ";" + nome + ";" + cpf + ";" + senha
							+ ";" + numConta + ";";
					String conta = null;
					if (tipoConta.contains(ContaEnum.CORRENTE.getTipoConta())) {
						ContaCorrente cc = new ContaCorrente(tipoConta, numConta, cpf, Double.parseDouble(saldo),
								agencia, Double.parseDouble(chequeEspecial));
						Conta.mapaContas.computeIfAbsent(cpf, k -> new ArrayList<>()).add(cc);
						conta = "\n" + ContaEnum.CORRENTE.getTipoConta() + ";" + numConta + ";" + cpf + ";" + saldo
								+ ";" + agencia + ";" + chequeEspecial + ";";
					} else if (tipoConta.contains(ContaEnum.POUPANCA.getTipoConta())) {
						ContaPoupanca cp = new ContaPoupanca(tipoConta, numConta, cpf, Double.parseDouble(saldo),
								agencia);
						Conta.mapaContas.computeIfAbsent(cpf, k -> new ArrayList<>()).add(cp);
						conta = "\n" + ContaEnum.POUPANCA.name() + ";" + numConta + ";" + cpf + ";" + saldo
								+ ";" + agencia + ";";
					}
					JOptionPane.showMessageDialog(botaoConfirma, "Cliente cadastrado com sucesso!");
					try {
						LeituraEscrita.escritor("BancoDados", cliente, conta);
						dispose();
						
						if(pessoa.getTipo().equalsIgnoreCase(PessoaEnum.GERENTE.getTipoPessoa())) {
							JMenuGerente menuG = new JMenuGerente(pessoa);
							menuG.setLocationRelativeTo(menuG);
							menuG.setVisible(true);
						}else if(pessoa.getTipo().equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())) {
							JCadastroConta menu = new JCadastroConta(pessoa);
							menu.setLocationRelativeTo(menu);
							menu.setVisible(true);
						}else {
							JMenuPresidente mp = new JMenuPresidente(pessoa);
							mp.setLocationRelativeTo(mp);
							mp.setVisible(true);
						}
						
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		botaoConfirma.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoConfirma.setBounds(295, 259, 89, 23);
		contentPane.add(botaoConfirma);

	}
}
