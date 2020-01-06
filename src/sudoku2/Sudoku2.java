package sudoku2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;



public class Sudoku2 extends JFrame{
	
	private static final long serialVersionUID = 1L;         //????????????????????
	
	
	public JTextField[][] plansza;
	static Border outerBorder = BorderFactory.createLineBorder(Color.black, 2);
    static Border innerBorder = BorderFactory.createLineBorder(Color.gray, 2);	
	
	public static void main(String[] args) throws Exception{

		JFrame frame = new JFrame("SUDOKU  - Pascal van der Sluis 2019");		
		frame.setSize(1200,1000);  
		JButton solutionBtn = new JButton("rozwi¹¿");
		  solutionBtn.setSize(new Dimension(150, 40));
		
		 BufferedImage logo = ImageIO.read(new File("E:\\eclipse-workspace\\Sudoku2\\src\\images\\javalogo.png"));			
		 JLabel logoLabel = new JLabel(new ImageIcon(logo));

		
		GridLayout thegrid = new GridLayout(9,9);
		JPanel gridpanel = new JPanel(thegrid);  
		FlowLayout theflow = new FlowLayout(FlowLayout.LEFT,200,10);
		JPanel flowlayout1 = new JPanel(theflow);
		flowlayout1.add(solutionBtn);
		flowlayout1.add(logoLabel);
		
		
		
		BorderLayout borderlayout = new BorderLayout();
		JPanel mainPanel = new JPanel(borderlayout);
		borderlayout.setHgap(50);
	    borderlayout.setVgap(50);
		JLabel topLabel = new JLabel("HERE IS SOME HEADER");
		
		
		BufferedImage sudokulogo = ImageIO.read(new File("E:\\eclipse-workspace\\Sudoku2\\src\\images\\sudoku.png"));			
		JLabel sudokuLabel = new JLabel(new ImageIcon(sudokulogo));
		JLabel sudokuLabel2 = new JLabel(new ImageIcon(sudokulogo));

		
		mainPanel.add(topLabel, BorderLayout.NORTH);
		mainPanel.add(sudokuLabel, BorderLayout.EAST);
		mainPanel.add(sudokuLabel2, BorderLayout.WEST);
		mainPanel.add(gridpanel,BorderLayout.CENTER);
		mainPanel.add(flowlayout1,BorderLayout.SOUTH);
		frame.add(mainPanel);
		frame.setVisible(true);

		//kolory planszy
		 Color[] col = {Color.blue,Color.white,Color.blue,Color.white,Color.blue,Color.white,
				    Color.blue,Color.white,Color.blue};
		
		
		JTextField[][] plansza = new JTextField[9][9];
		  for(int i=0;i<9;i++)
		  {
		   for(int j=0;j<9;j++)
		   {
		    plansza[i][j] = new JTextField();
		    plansza[i][j].setBounds(25+j*20, 25+i*20, 10, 10);
		    plansza[i][j].setBorder(innerBorder);
		    plansza[i][j].setBackground(col[(i/3)*3+(j/3)]);   
		    gridpanel.add(plansza[i][j]);
		    gridpanel.setBorder(outerBorder);
		   }
		   
		  }
		   
		  solutionBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		     
		   //Start method present in background_code.java
		   // MAGIC.start();
	
		    }
		   } 
		   );	

		  } 
	//Method to return the element present in particular box if not return 0
	 int get_element(int i,int j)
	 {
	  String txt = plansza[i][j].getText();
	  if(txt.isEmpty())
	   
	   return 0;
	  
	  return Integer.parseInt(txt.trim());
	 }
	 
	 
	 //Method to set element in particular box
	 void set_element(int i,int j,int val)
	 {
	  plansza[i][j].setText(String.valueOf(val));
	 }
	 
	 //Method to clear the box
	 void clear()
	 {
	  for(int i=0;i<9;i++)
	  {
	   for(int j=0;j<9;j++)
	   {
	    plansza[i][j].setText("");
	   }
	  }
	   
	 }
}


