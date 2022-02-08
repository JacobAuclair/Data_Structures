import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FamilyTreeDemo extends JFrame
{
    private FamilyTree binTree = new FamilyTree();   
    private JLabel directionsLabel;
    private JLabel cmdLabel;
    private JTextField cmdTextField;   
    public FamilyTreeDemo()
    {
        setTitle("Binary Search Tree Operations");
        JPanel dirPanel = new JPanel(new GridLayout(1,2));
        directionsLabel = new JLabel("You must start by adding 'root name' to start the tree.");
        dirPanel.add(directionsLabel);
        add(dirPanel, BorderLayout.NORTH);
        cmdLabel = new JLabel("Command: ");
        cmdTextField = new JTextField();
        JPanel cmdPanel = new JPanel(new GridLayout(1,2));
        cmdPanel.add(cmdLabel);
        cmdPanel.add(cmdTextField);
        ActionListener cmdLis = new CmdTextListener();
        cmdTextField.addActionListener(cmdLis);
        add(cmdPanel, BorderLayout.SOUTH);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);
    }
    JPanel view = null;
    private class CmdTextListener
    implements ActionListener
    {		  
        public void actionPerformed(ActionEvent evt)
        {
            String cmdStr = cmdTextField.getText();
            Scanner sc = new Scanner(cmdStr);
            String cmd = sc.next();
            if (cmd.equals("root"))
            {
                String value = sc.next();
                binTree.root(value);
                if (view != null)
                    remove(view);
                view = binTree.getView();            
                add(view);
                pack();
                validate(); 
                directionsLabel.setText("Now add to the tree with 'left/right parent child'");
            }
            if (cmd.equals("left"))
            {
                String parent = sc.next();     
                String value = sc.next();
                binTree.addLeft(parent,value);
                if (view != null)
                    remove(view);
                view = binTree.getView();            
                add(view);
                pack();
                validate(); 
            }
            if (cmd.equals("right"))
            {
                String parent = sc.next();       
                String value = sc.next();
                binTree.addRight(parent,value);
                if (view != null)
                    remove(view);
                view = binTree.getView();            
                add(view);
                pack();
                validate(); 
            }
        }
    }
    public static void main(String[ ]args)
    {	  
        new FamilyTreeDemo();	 
    }   
}