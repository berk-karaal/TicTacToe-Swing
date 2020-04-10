package _008_TTT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToe extends JFrame {
	
	static boolean xPlaying = true; // if turn is for x, its true
	static boolean gameOn = true; // if game is still alive, its true
	
	static int areas[] = new int[9]; // These are for areas of game
	// 0--> empty area | 1--> X | 2-->O
	
	JLabel hintLabel;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe frame = new TicTacToe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void fillArea(JButton btn,int areaIndex) {
		if(areas[areaIndex] == 0 && gameOn) {
			btn.setText((xPlaying) ? "X" : "O"); //Set clicked btn text as playing user
			areas[areaIndex] = (xPlaying) ? 1 : 2; //Set which user clicked the selected area
			xPlaying = !xPlaying; //Change turn
			hintLabel.setText("Turn -> "+ ((xPlaying) ? "X" : "O")); //Change hint label
			
			checkAreas(); //Did anyone win the game? Check it
		}
	}
	
	void checkAreas() {
		for(int i = 0;i<=6;i+=3) {
			if(areas[i] == areas[i+1] && areas[i] == areas[i+2] && areas[i] != 0) {
				finishGame(areas[i]);
				return ;
			}
		}
		for(int i = 0;i<=2;i++) {
			if(areas[i] == areas[i+3] && areas[i] == areas[i+6] && areas[i] != 0) {
				finishGame(areas[i]);
				return ;
			}
		}
		if(areas[0] == areas[4] && areas[0] == areas[8] && areas[0] != 0) {
			finishGame(areas[0]);
			return ;
		}else if(areas[2] == areas[4] && areas[2] == areas[6] && areas[2] != 0) {
			finishGame(areas[2]);
			return ;
		}
		
		int emptyCount = 0;
		for(int i : areas) {
			if(i == 0) {
				emptyCount ++;
			}
		}
		if(emptyCount > 0) return; // If there are at least one empty area then still game is on
		
		//If empty count is still 0 that means there aren't any empty area and no one won the game
		//So tell user "game draws"
		
		gameOn = false;
		hintLabel.setText("DRAW :/ "); //Change hint label		
 		
	} 
	
	void finishGame(int winner) {
		gameOn = false; //Stop the game
		hintLabel.setText("Winner is " + ((winner==1) ? "X" : "O")); //Change hint label
	}

	/**
	 * Create the frame.
	 */
	public TicTacToe() {
		setBackground(new Color(105, 105, 105));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRockPaperScissors = new JLabel("TIC TAC TOE");
		lblRockPaperScissors.setForeground(new Color(47, 79, 79));
		lblRockPaperScissors.setFont(new Font("Bungee Inline", Font.PLAIN, 17));
		lblRockPaperScissors.setHorizontalAlignment(SwingConstants.CENTER);
		lblRockPaperScissors.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblRockPaperScissors.setBounds(10, 10, 376, 40);
		contentPane.add(lblRockPaperScissors);
		
		JButton btn0 = new JButton("");
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillArea(btn0,0);
			}
		});
		btn0.setOpaque(false);
		btn0.setFocusable(false);
		btn0.setFocusTraversalKeysEnabled(false);
		btn0.setFocusPainted(false);
		btn0.setFont(new Font("Source Code Pro Black", Font.PLAIN, 53));
		btn0.setBounds(74, 101, 70, 70);
		contentPane.add(btn0);
		
		JButton btn1 = new JButton("");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillArea(btn1,1);
			}
		});
		btn1.setOpaque(false);
		btn1.setFocusable(false);
		btn1.setFocusTraversalKeysEnabled(false);
		btn1.setFocusPainted(false);
		btn1.setFont(new Font("Source Code Pro Black", Font.PLAIN, 53));
		btn1.setBounds(154, 101, 70, 70);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillArea(btn2,2);
			}
		});
		btn2.setOpaque(false);
		btn2.setFocusable(false);
		btn2.setFocusTraversalKeysEnabled(false);
		btn2.setFocusPainted(false);
		btn2.setFont(new Font("Source Code Pro Black", Font.PLAIN, 53));
		btn2.setBounds(234, 101, 70, 70);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillArea(btn3,3);
			}
		});
		btn3.setOpaque(false);
		btn3.setFocusable(false);
		btn3.setFocusTraversalKeysEnabled(false);
		btn3.setFocusPainted(false);
		btn3.setFont(new Font("Source Code Pro Black", Font.PLAIN, 53));
		btn3.setBounds(74, 181, 70, 70);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillArea(btn4,4);
			}
		});
		btn4.setOpaque(false);
		btn4.setFocusable(false);
		btn4.setFocusTraversalKeysEnabled(false);
		btn4.setFocusPainted(false);
		btn4.setFont(new Font("Source Code Pro Black", Font.PLAIN, 53));
		btn4.setBounds(154, 181, 70, 70);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillArea(btn5,5);
			}
		});
		btn5.setOpaque(false);
		btn5.setFocusable(false);
		btn5.setFocusTraversalKeysEnabled(false);
		btn5.setFocusPainted(false);
		btn5.setFont(new Font("Source Code Pro Black", Font.PLAIN, 53));
		btn5.setBounds(234, 181, 70, 70);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("");
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillArea(btn6,6);
			}
		});
		btn6.setOpaque(false);
		btn6.setFocusable(false);
		btn6.setFocusTraversalKeysEnabled(false);
		btn6.setFocusPainted(false);
		btn6.setFont(new Font("Source Code Pro Black", Font.PLAIN, 53));
		btn6.setBounds(74, 261, 70, 70);
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("");
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillArea(btn7,7);
			}
		});
		btn7.setOpaque(false);
		btn7.setFocusable(false);
		btn7.setFocusTraversalKeysEnabled(false);
		btn7.setFocusPainted(false);
		btn7.setFont(new Font("Source Code Pro Black", Font.PLAIN, 53));
		btn7.setBounds(154, 261, 70, 70);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillArea(btn8,8);
			}
		});
		btn8.setOpaque(false);
		btn8.setFocusable(false);
		btn8.setFocusTraversalKeysEnabled(false);
		btn8.setFocusPainted(false);
		btn8.setFont(new Font("Source Code Pro Black", Font.PLAIN, 53));
		btn8.setBounds(234, 261, 70, 70);
		contentPane.add(btn8);
		
		hintLabel = new JLabel("Turn --> X");
		hintLabel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		hintLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hintLabel.setFocusable(false);
		hintLabel.setBounds(102, 60, 170, 37);
		contentPane.add(hintLabel);
		
	}
}
