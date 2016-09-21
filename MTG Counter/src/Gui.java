import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui {
	
	String[] labels = {"1","2","3","4","5","6","7","8"};
	
	JFrame frame = new JFrame("MTG Counter");
	JPanel leftPanel = new JPanel();
	JComboBox playerNumber= new JComboBox(labels);
	JRadioButton radioButton;
	JButton button = new JButton("BUTTAN");
	GridBagLayout gc = new GridBagLayout();
	
	public void build() {
		System.out.println("building");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		leftPanel.add(button, gc);
		frame.getContentPane().add(leftPanel, BorderLayout.WEST);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	private class ComboActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("ComboActionListener action event");
		}
	}
	
	private class RadioActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("ComboActionListener action event");
		}
	}
	
	private class ButtonActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("ComboActionListener action event");
		}
	}
}
