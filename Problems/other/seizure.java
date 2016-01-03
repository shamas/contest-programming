import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class seizure {
	public static void main(String[] args) {
		final JFrame frame = new JFrame();
		final Canvas canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(800, 400));
		frame.add(canvas);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		new Timer(1, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				canvas.repaint();
			}
		}).start();
	}
	public static class Canvas extends JPanel {
		public void paintComponent(Graphics g) {
			Random random = new Random();
			g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
			g.fillOval(random.nextInt(getWidth()), random.nextInt(getHeight()), random.nextInt(getWidth()), random.nextInt(getHeight()));
		}
	}
}
