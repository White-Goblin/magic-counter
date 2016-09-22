import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui {
	////variables////
	String[] comboLabels = {"1","2","3","4","5","6","7","8"};
	//int[] comboLabels = {1,2,3,4,5,6,7,8};
	String[] buttonLabels = {"+5","+1","-1","-5"};
	
	JFrame frame = new JFrame("MTG Counter");
	JPanel leftPanel = new JPanel(new GridBagLayout());
	JPanel topPanel = new JPanel(new GridBagLayout());
	GridBagConstraints gcLeft = new GridBagConstraints();
	GridBagConstraints gcTop = new GridBagConstraints();
	JComboBox playerNumber= new JComboBox(comboLabels);
	JRadioButton radioButton;
	ButtonGroup radioGroup = new ButtonGroup ();
	JButton button;
	JLabel label;
	
	public void build() {
		//System.out.println("building");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		////left panel building////
		for (int i=0; i<4; i++) {
			JButton button = new JButton(buttonLabels[i]);
			gcLeft.gridy = i;
			leftPanel.add(button, gcLeft);
		}
		
		playerNumber.addActionListener(new ComboActionListener());
		rebuildButtons();
		/*
		for (int i=0; i<8; i++) {
			gcLeft.gridy = i;
			gcLeft.gridx = 1;
			radioButton = new JRadioButton();
			leftPanel.add(radioButton,gcLeft);
			gcLeft.gridx = 2;
			label = new JLabel("Player " + comboLabels[i] + " ");
			//label = new JLabel("Player " + comboLabels[i] + " " + Player.pArray.get(i).getHp());
			leftPanel.add(label,gcLeft);
		} */
		
		////bottom panel building////
		button = new JButton("Print Player Classes");
		frame.getContentPane().add(button, BorderLayout.SOUTH);
		
		////top panel building////
		gcTop.anchor= GridBagConstraints.EAST;
		topPanel.add(playerNumber, gcTop);
		
		frame.getContentPane().add(leftPanel, BorderLayout.WEST);
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
	
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	private void rebuildButtons () {
		for (int i=0; i<Player.pArray.size(); i++) {
		gcLeft.gridy = i;
		gcLeft.gridx = 1;
		radioButton = new JRadioButton();
		leftPanel.add(radioButton,gcLeft);
		gcLeft.gridx = 2;
		label = new JLabel("Player " + comboLabels[i] + " ");
		//label = new JLabel("Player " + comboLabels[i] + " " + Player.pArray.get(i).getHp());
		leftPanel.add(label,gcLeft);
		}
	}
	
	private class ComboActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("ComboActionListener action event");
			JComboBox combo = (JComboBox)e.getSource();
			int selectedNumber = Integer.parseInt((String)combo.getSelectedItem());
			Player.changePlayerCount(selectedNumber);
			rebuildButtons();
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
