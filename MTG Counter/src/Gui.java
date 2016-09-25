import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gui extends JFrame {
	////variables////
	String[] comboLabels = {"1","2","3","4","5","6","7","8"};
	String[] buttonLabels = {"+5","+1","-1","-5"};
	ArrayList<AbstractButton> bArray = new ArrayList<AbstractButton>();
	
	GuiUtils guiUtil = new GuiUtils();

	JPanel leftPanel = new JPanel(new GridBagLayout());
	JPanel topPanel = new JPanel(new GridBagLayout());
	GridBagConstraints gcLeft = new GridBagConstraints();
	GridBagConstraints gcTop = new GridBagConstraints();
	JComboBox playerNumber= new JComboBox(comboLabels);
	ButtonGroup radioGroup;
	AbstractButton radioButton;
	JButton button;
	
	public void build() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		////left panel building////
		for (int i=0; i<4; i++) {
			JButton button = new JButton(buttonLabels[i]);
			button.addActionListener(new ButtonActionListener());
			addComp(leftPanel, button, gcLeft, 0, i, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
		}
		
		playerNumber.addActionListener(new ComboActionListener());
		rebuildButtons();
		
		////top panel building////
		button = new JButton("Reset");
		button.addActionListener(new ClearButtonActionListener());
		addComp(topPanel, button, gcTop, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST);
		addComp(topPanel, playerNumber, gcTop, 1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.EAST);
		
		this.getContentPane().add(leftPanel, BorderLayout.WEST);
		this.getContentPane().add(topPanel, BorderLayout.NORTH);
	
		this.setSize(250, 300);
		this.setVisible(true);
	}
	
	private void rebuildButtons () {
		String previousRadioButton = "";
		try {
			previousRadioButton = guiUtil.getSelectedButtonActionCommand(radioGroup);
			for (int i = 0;i<bArray.size();i++) {
				leftPanel.remove(bArray.get(i));
			}
		} catch (Exception e) {}
		
		////clear the array to rebuild////
		bArray.clear();
		radioGroup = new ButtonGroup();
		
		for (int i=0; i<Player.pArray.size(); i++) {
			radioButton = new JRadioButton("Player " + (i+1) + ": " + Player.pArray.get(i).getHp());
			radioButton.setActionCommand(String.valueOf(i));
			radioButton.addActionListener(new RadioActionListener());
			radioGroup.add(radioButton);
			bArray.add(radioButton);
			
			addComp(leftPanel, radioButton, gcLeft, 1, i, 1, 1, GridBagConstraints.WEST, GridBagConstraints.EAST);	
		}
		
		////restore saved radio button selection////
		guiUtil.setSavedButtonState(radioGroup, previousRadioButton);
		
		////resize and repaint everything////
		this.revalidate();
		this.repaint();
	}
	
	private void addComp (JPanel thePanel, JComponent comp, GridBagConstraints gC, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch) {
		gC.gridx = xPos;
		gC.gridy = yPos;
		gC.gridwidth = compWidth;
		gC.gridheight = compHeight;
		gC.weightx = 100;
		gC.weighty= 100;
		gC.insets = new Insets(5,5,5,5);
		gC.anchor = place;
		gC.fill = stretch;
		
		thePanel.add(comp,gC);
	}

	private class ComboActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JComboBox combo = (JComboBox)e.getSource();
			int selectedNumber = Integer.parseInt((String)combo.getSelectedItem());
			Player.changePlayerCount(selectedNumber);
			rebuildButtons();
		}
	}
	
	private class RadioActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			int x =bArray.indexOf(e.getSource());
			Player.pArray.forEach((a) -> {
				if ( Player.pArray.indexOf(a) != x ) {
					a.setActive(false);
				} 
				if ( Player.pArray.indexOf(a) == x ) {
					a.setActive(true);
				}	
			});
		}
	}
	
	private class ButtonActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			button = (JButton)e.getSource();
			Player.pArray.forEach((a) -> {
				if (a.isActive() == true) {
					a.plusHp(Integer.parseInt(button.getText()));
				}
			});
			rebuildButtons();
		}
	}
	
	private class ClearButtonActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			button = (JButton)e.getSource();
			Player.pArray.forEach((a) -> {
				a.setHp(20);
			});
			rebuildButtons();
		}
	}
}
