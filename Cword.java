package Wordc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cword frame = new Cword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cword() {
		setFont(new Font("Times New Roman", Font.BOLD, 15));
		setTitle("Word Counter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsert = new JLabel("Insert the paragraph:");
		lblInsert.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInsert.setBounds(38, 33, 198, 38);
		contentPane.add(lblInsert);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(287, 48, 411, 274);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Word Count: 0");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(52, 297, 155, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Get Word Count");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textArea.getText();
				int len = countWords(s);
				lblNewLabel.setText("Word Count: "+len+"");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(543, 364, 155, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				lblNewLabel.setText("Word Count: 0");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(287, 366, 102, 38);
		contentPane.add(btnNewButton_1);
		
		
	}
	private int countWords(String text) {
        if (text==null||text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
}
