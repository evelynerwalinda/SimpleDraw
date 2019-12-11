package simpledraw.view;

import simpledraw.view.DrawingPanel;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import simpledraw.controller.ButtonController;
import simpledraw.model.Drawing;

/**
 * Main Frame of SimpleDraw
 * @author Rémi Bastide
 * @version 1.0
 */

public class MainFrame
	extends JFrame {
	JToggleButton mySelectButton = new JToggleButton("Select");
	JToggleButton myLineButton = new JToggleButton("Line");
	JToggleButton myCircleButton = new JToggleButton("Circle");
	DrawingPanel myDrawingPanel = new DrawingPanel();

        MiniPanel myMiniPanel = new MiniPanel();        
        ButtonController bc = new ButtonController();
        Drawing myModel = new Drawing();
        
	/**Construct the frame*/
	public MainFrame() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**Component initialization*/
	private void jbInit() throws Exception {
		getContentPane().setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
                
                JPanel container = new JPanel();
                container.setLayout(new BorderLayout());
                
		mySelectButton.setSelected(true);
		mySelectButton.setToolTipText("Select and move shapes");
		myCircleButton.setToolTipText("Draw a Circle");
		myLineButton.setToolTipText("Draw a Line");

		//getContentPane().add(buttonPanel, BorderLayout.NORTH);
                
		buttonPanel.add(mySelectButton, null);
		buttonPanel.add(myLineButton, null);
		buttonPanel.add(myCircleButton, null);
		//getContentPane().add(myDrawingPanel, BorderLayout.CENTER);

                JPanel viewContainer = new JPanel();
                viewContainer.setLayout(new BorderLayout());
                viewContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
                viewContainer.add(buttonPanel, BorderLayout.NORTH);
                viewContainer.add(myMiniPanel);
                
                container.add(viewContainer, BorderLayout.WEST);
                
                container.add(myDrawingPanel);                                
                
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(mySelectButton);
		buttonGroup.add(myLineButton);
		buttonGroup.add(myCircleButton);
                
                getContentPane().add(container);

		setSize(new Dimension(500, 300));
		setTitle("Simple Draw");

                bc.action(this);
		
                myModel.addView(myDrawingPanel);
                myModel.addView(myMiniPanel);
	}

	/**Overridden so we can exit when window is closed*/
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}

    public JToggleButton getMySelectButton() {
        return mySelectButton;
    }

    public JToggleButton getMyLineButton() {
        return myLineButton;
    }

    public JToggleButton getMyCircleButton() {
        return myCircleButton;
    }

    public DrawingPanel getMyDrawingPanel() {
        return myDrawingPanel;
    }
        
        
}
