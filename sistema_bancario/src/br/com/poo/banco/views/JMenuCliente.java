package br.com.poo.banco.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JMenuCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenuCliente frame = new JMenuCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JMenuCliente() {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Cliente");
		lblNewLabel.setBounds(144, 15, 166, 48);
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Corrente", "Poupança"}));
		comboBox.setToolTipText("Conta");
		comboBox.setBounds(61, 93, 139, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Conta:");
		lblNewLabel_1.setBounds(61, 73, 88, 18);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Saque /Depósito", "Transferência"}));
		comboBox_1.setToolTipText("operação");
		comboBox_1.setBounds(222, 93, 139, 21);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Operação:");
		lblNewLabel_1_1.setBounds(222, 73, 88, 18);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setBounds(175, 205, 85, 27);
		contentPane.add(btnNewButton);
		
		JButton btnSaldo = new JButton("SALDO");
		btnSaldo.setBounds(115, 141, 85, 27);
		contentPane.add(btnSaldo);
		
		JButton btnExtrato = new JButton("EXTRATO");
		btnExtrato.setBounds(222, 141, 106, 27);
		contentPane.add(btnExtrato);
		
		
	}
}
