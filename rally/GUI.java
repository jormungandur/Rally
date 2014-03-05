package rally;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener
{
	 
	 
	JFrame screen;
	JTextField inputNumber;
	JLabel textSpiral;
	JPanel right;
	JButton inputButton;
	 
	 
	 private JPanel makeLeftSide()
	 {
		 	JPanel lhs = new JPanel();	
		 	
		 	inputNumber = new JTextField(20);
		 	inputNumber.setSize(100, 25);
		 	lhs.add(inputNumber); 
		 	
		 	inputButton = new JButton("Generate Spiral!");
		 	inputButton.addActionListener(this);
		 	lhs.add(inputButton);
		 			 	
		 	return lhs;
	 }
	 
	 
	
	 
	 private void setRightSide(String rightLabel)
	 {
		 JPanel rhs = new JPanel();
		 textSpiral = new JLabel(rightLabel);
		 rhs.add(textSpiral);
		 right = rhs;
	 }
	 
	private void createAndShowGUI(String sendToRight) 
	{
		if(screen == null)
		{
			screen = new JFrame();
			screen.setLayout(new GridLayout(0,2));
			screen.setTitle("Spiral Numbers");
			screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			screen.add(this.makeLeftSide());
		}
		else
		{
			screen.remove(right);
		}
		this.setRightSide(sendToRight);
		screen.add(right);
		        
		//Display the window.
		screen.pack();
		screen.setVisible(true);
		screen.repaint();
	}
	 
	private void invalidEntry()
	{
		createAndShowGUI("Invalid entry.");
 	}
 
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == inputButton)
		{
			try
			{
				int toCountTo = Integer.parseInt(inputNumber.getText());
				if( toCountTo < 0)
				{
					this.invalidEntry();
				}
				else
				{
					createAndShowGUI((new Spiral(toCountTo)).toHtmlString());
				}
			}
			catch(NumberFormatException e)
			{
				this.invalidEntry();
			}
		}
		
	}
		
		
	public static void main(String[] args) 
	{
		//create a runnable that runs my code and pass it into swing
		javax.swing.SwingUtilities.invokeLater
		(
			new Runnable()
			{
			    public void run() 
			    {
			        new GUI().createAndShowGUI("Spiral will appear here.");
			    }
			}
		);
	}
	

		
	}