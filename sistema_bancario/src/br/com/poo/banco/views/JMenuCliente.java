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
	private JTextField textField;

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
		lblNewLabel.setBounds(152, 10, 132, 32);
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Corrente", "Poupança"}));
		comboBox.setToolTipText("Conta");
		comboBox.setBounds(152, 67, 139, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Conta:");
		lblNewLabel_1.setBounds(152, 52, 88, 18);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Saldo", "Extrato", "Pix", "Transferência"}));
		comboBox_1.setToolTipText("operação");
		comboBox_1.setBounds(152, 114, 139, 21);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Operação:");
		lblNewLabel_1_1.setBounds(152, 98, 88, 18);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(154, 162, 140, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Valor R$:");
		lblNewLabel_1_1_1.setBounds(154, 145, 88, 18);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setBounds(115, 203, 85, 27);
		contentPane.add(btnNewButton);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit (0);
			}
		});
		btnSair.setBounds(255, 203, 85, 27);
		contentPane.add(btnSair);
		
		
	}

}
