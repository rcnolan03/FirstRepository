import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
public class GuessingGame extends JFrame 
{
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	int numberOfTries = 0;
	public void checkGuess()
	{
		String guessText = txtGuess.getText();
		String message = "";
		numberOfTries = numberOfTries +1;
		try 
		{
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber)
				message = guess + " is too low. Try again.";
			else if (guess > theNumber)
				message = guess + " is too high. Try again.";
			else
			{
				message = guess + 
						" is correct. You win after! "+numberOfTries+ " tries! Let's play again.";
				newGame();
			}
		} catch (Exception e)
		{
			message = "Invalid character(s). Please enter a whole number between 1 and 100.";
		} finally
		{
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}

	public void newGame()
	{
		theNumber = (int)(Math.random() *100 +1);
	}
	public GuessingGame() 
	{
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Reggie's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblReggiesHiloGuessing = new JLabel("Reggie's Hi-Lo Guessing Game");
		lblReggiesHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		lblReggiesHiloGuessing.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReggiesHiloGuessing.setBounds(-10, 32, 434, 47);
		getContentPane().add(lblReggiesHiloGuessing);

		JLabel lblNewLabel = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel.setBounds(49, 111, 241, 14);
		getContentPane().add(lblNewLabel);

		txtGuess = new JTextField();
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(265, 108, 42, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(160, 157, 89, 23);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(-10, 201, 434, 35);
		getContentPane().add(lblOutput);
	}
	public static void main(String[] args) 
	{
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}