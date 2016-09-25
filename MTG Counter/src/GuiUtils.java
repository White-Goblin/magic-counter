import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class GuiUtils {
	
	public String getSelectedButtonActionCommand(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); 
				buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();
					
					if (button.isSelected()) {
						return button.getActionCommand();
					}
				}
		return "";
	}
	
	public void setSavedButtonState (ButtonGroup buttonGroup, String previouslySelectedActionCommand) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); 
		buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
					
					//System.out.println("Currently Iterated Button Action Command: " + button.getActionCommand());
					//System.out.println("Previously Iterated Button Action Command: " + previouslySelectedActionCommand);
					//System.out.println("\n");
					
			if (button.getActionCommand().equals(previouslySelectedActionCommand)) {
				button.setSelected(true);
			}
		}
	} 
}
