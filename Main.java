import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Main {

	
		
	
		public static void main(String[] args) {
			
			Display display = new Display();
			Shell shell = new Shell(display);
			
			ShellContainer shellContainer = new ShellContainer(shell);
			
			
			shell.open();

			// run the event loop as long as the window is open
			while (!shell.isDisposed()) {
			    // read the next OS event queue and transfer it to a SWT event
			    if (!display.readAndDispatch())
			     {
			    // if there are currently no other OS event to process
			    // sleep until the next OS event is available
			        display.sleep();
			     }
			}

			// disposes all associated windows and their components
			display.dispose();
		}
}
