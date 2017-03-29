
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JQuadGlg implements DocumentListener {
	JTextField aField, bField, cField;
	JLabel x1Label, x2Label;
	
	public static void main(String[] args) {
		new JQuadGlg();
	}
	
	public JQuadGlg()
	{
		JFrame frame = new JFrame("JQuadGlg");
		
		frame.setBounds(100, 100, 400, 180);
		frame.setLayout(null);
		
		JLabel aLabel = new JLabel("a: ");
		aLabel.setBounds(10, 40, 40, 15);
		JTextField aField = new JTextField("1");
		aField.setBounds(50, 35, 40, 25);
		JLabel bLabel = new JLabel("b: ");
		bLabel.setBounds(10, 70, 40, 15);
		JTextField bField = new JTextField("-3");
		bField.setBounds(50, 65, 40, 25);
		JLabel cLabel = new JLabel("c: ");
		cLabel.setBounds(10, 100, 40, 15);
		JTextField cField = new JTextField("-4");
		cField.setBounds(50, 95, 40, 25);
		
		aField.getDocument().addDocumentListener(this);
		bField.getDocument().addDocumentListener(this);
		cField.getDocument().addDocumentListener(this);
		
		JLabel x1Label = new JLabel("");
		x1Label.setBounds(180, 55, 100, 15);

		JLabel x2Label = new JLabel("");
		x2Label.setBounds(180, 85, 100, 15);
		
		frame.add(aLabel);
		frame.add(aField);
		frame.add(bLabel);
		frame.add(bField);
		frame.add(cLabel);
		frame.add(cField);
		
		frame.add(x1Label);
		frame.add(x2Label);
		
		this.x1Label = x1Label;
		this.x2Label = x2Label;
		this.aField = aField;
		this.bField = bField;
		this.cField = cField;
		
		updateValues();
		
		frame.setVisible(true);
	}

	private void updateValues() {
		double a, b, c;
		try
		{
			a = Double.parseDouble( aField.getText() );
			b = Double.parseDouble( bField.getText() );
			c = Double.parseDouble( cField.getText() );
		}
		catch (Exception e)
		{
			System.out.println(e);
			return;
		}
		
		double D = b*b - 4*a*c;
		if(D < 0)
		{
			x1Label.setText("keine Loesung");
			x2Label.setText("");
		}
		else if(D == 0)
		{
			x1Label.setText( "x = " + (-b / (2*a)) );
			x2Label.setText("");
		}
		else
		{
			x1Label.setText( "x1 = " + ( (-b - Math.sqrt(D)) / (2*a) ) );
			x2Label.setText( "x2 = " + ( (-b + Math.sqrt(D)) / (2*a) ) );
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateValues();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateValues();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		updateValues();
	}
}
