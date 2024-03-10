package send.message;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello <strong>hi</strong>";
		Font boldFont = new Font("Arial", Font.BOLD, 12);
		
		Font f = new Font("LucidaSans", Font.BOLD, 14);

		AttributedString as= new AttributedString("Example text string");

		as.addAttribute(TextAttribute.FONT, f);
		
		AttributedCharacterIterator x = as.getIterator();
	    String a = "";

	    a+=x.current();
	    while (x.getIndex() < x.getEndIndex())
	        a += x.next();
	    a=a.substring(0,a.length()-1);

	    System.out.println(a);
		
	}

}
