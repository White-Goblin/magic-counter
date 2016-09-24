import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gui {
	////variables////
	String[] comboLabels = {"1","2","3","4","5","6","7","8"};
	//int[] comboLabels = {1,2,3,4,5,6,7,8};
	String[] buttonLabels = {"+5","+1","-1","-5"};
	static ArrayList<JRadioButton> bArray = new ArrayList<JRadioButton>();
	static ArrayList<JLabel> lArray = new ArrayList<JLabel>();
	static ArrayList<ButtonGroup> gArray = new ArrayList<ButtonGroup>();
	
	JFrame frame = new JFrame("MTG Counter");
	JPanel leftPanel = new JPanel(new GridBagLayout());
	JPanel topPanel = new JPanel(new GridBagLayout());
	GridBagConstraints gcLeft = new GridBagConstraints();
	GridBagConstraints gcTop = new GridBagConstraints();
	JComboBox playerNumber= new JComboBox(comboLabels);
	ButtonGroup radioGroup = new ButtonGroup ();
	JRadioButton radioButton;
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
		
		////top panel building////
		gcTop.weightx = 1;
		gcTop.anchor= GridBagConstraints.WEST;
		gcTop.gridx = 0;
		button = new JButton("Reset");
		topPanel.add(button, gcTop);
		
		gcTop.anchor= GridBagConstraints.EAST;
		gcTop.gridx = 1;
		topPanel.add(playerNumber, gcTop);
		
		frame.getContentPane().add(leftPanel, BorderLayout.WEST);
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
	
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	private void rebuildButtons () {
		try {
			for (int i = 0;i<bArray.size();i++) {
				leftPanel.remove(bArray.get(i));
				leftPanel.remove(lArray.get(i));
				//radioGroup.remove(gArray.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
			 System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		}
		bArray.clear();
		lArray.clear();
		
		for (int i=0; i<Player.pArray.size(); i++) {
		gcLeft.gridy = i;
		gcLeft.gridx = 1;
		radioButton = new JRadioButton();
		radioGroup.add(radioButton);
		bArray.add(radioButton);
		leftPanel.add(bArray.get(i),gcLeft);
		
		gcLeft.gridx = 2;
		label = new JLabel();
		label.setText("Player " + (i+1) + ": " + Player.pArray.get(i).getHp());
		lArray.add(label);
		leftPanel.add(lArray.get(i),gcLeft);
		
		leftPanel.add(label,gcLeft);
		}
		frame.repaint();
		frame.revalidate();
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
