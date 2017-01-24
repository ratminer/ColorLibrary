package colorHelper;

import java.awt.*;

import javax.swing.*;

public class Main extends JFrame {

	public Main() {
		setSize(640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container pane = getContentPane();
		
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel middle = new JPanel();
		
		pane.add(left, BorderLayout.LINE_START);
		pane.add(right, BorderLayout.LINE_END);
		pane.add(middle, BorderLayout.CENTER);
		
		Color c1 = new Color(0x0000ff);
		
		Matcher m = new Matcher();
		Color c2 = new Color(m.getMatchingColors(c1.getRGB()).get(0));
		Color c3 = new Color(m.getMatchingColors(c1.getRGB()).get(1));
		
		//Color c2 = new Color(ColorDatabase.getClosestColor(c1.getRGB()));
		left.setBackground(c3);
		right.setBackground(c2);
		
		Color compliment = new Color(new ComplimentaryAlgorithm().getMatchingColors(c1.getRGB()).get(0));
		
		middle.setBackground(compliment);
		
		AnalogousAlgorithm a = new AnalogousAlgorithm();
		System.out.println(a.isMatch(compliment.getRGB(), c2.getRGB()));
		System.out.println(a.isMatch(compliment.getRGB(), c3.getRGB()));
		
	}
	
	public static void main(String args[]) {
		new Main();
	}
	
}

