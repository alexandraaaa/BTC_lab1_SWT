import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


class Requirements {
	
	private String name;
	private String description;
	
	public Requirements(String name, String description) {
		
		this.name = name;
		this.description = description;
	}

	public String toString() {
		
		return "Name: " + name + " " + "Description: " + description; 
	}
	
	public String getName() {
		
		return name;
	}
	
	public String getDescription() {
		
		return description;
	}
}


public class ShellContainer {

	private Shell shell;
	
	private ArrayList<Requirements> requirements = new ArrayList<Requirements>();
	
	private int i = 0;
	
	public ShellContainer(Shell shell) {
		
		this.shell = shell;
		
		createUI(shell);
	}
	
	public void createUI(Shell shell){
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		
		shell.setLayout(gridLayout);

		shell.setSize(500, 400);
		
		//GridData labelNameGrid = new GridData();
		
		//labelNameGrid.horizontalAlignment = GridData.FILL;
		
		Label labelName = new Label(shell, SWT.NONE );
		
		//labelName.setLayoutData(labelNameGrid);
		
		labelName.setText("Name: ");
		
		GridData gridDataTextName = new GridData();
		gridDataTextName.horizontalAlignment = GridData.FILL;
		gridDataTextName.horizontalSpan = 2;
		
		Text textName = new Text(shell, SWT.BORDER);
		textName.setLayoutData(gridDataTextName);
		
		
		Label labelDescription = new Label(shell, SWT.NONE);
		labelDescription.setText("Description: ");
		
		GridData gridDataTextDescription = new GridData();
		gridDataTextDescription.horizontalAlignment = GridData.FILL;
		gridDataTextDescription.horizontalSpan = 2;
		
		Text textDescription = new Text(shell, SWT.BORDER);
		textDescription.setLayoutData(gridDataTextDescription);
		
		GridData gridDataAddButton = new GridData();
		gridDataAddButton.horizontalAlignment = GridData.FILL;
		gridDataAddButton.horizontalSpan = 3;
		
		Button addButton = new Button(shell, SWT.BORDER);
		addButton.setText("Add requirement");
		addButton.setLayoutData(gridDataAddButton);
		
		addButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
				requirements.add(new Requirements(textName.getText(), textDescription.getText()));
				
				textName.setText("");
				textDescription.setText("");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		GridData gridDataDisplayButton = new GridData();
		gridDataDisplayButton.horizontalAlignment = GridData.FILL;
		gridDataDisplayButton.horizontalSpan = 3;
		
		Button displayButton = new Button(shell, SWT.BORDER);
		displayButton.setText("Display Requirements");
		displayButton.setLayoutData(gridDataDisplayButton);
		
		displayButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
			
				for(Requirements r: requirements)
					System.out.println(r);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		GridData gridDataPrevButton = new GridData();
		gridDataPrevButton.verticalAlignment = GridData.FILL;
		gridDataPrevButton.verticalSpan = 2;
		
		Button prevButton = new Button(shell, SWT.BORDER);
		prevButton.setText("prev");
		
		prevButton.setLayoutData(gridDataPrevButton);
		
		Text nameText = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		
		GridData gridDataNextButton = new GridData();
		gridDataNextButton.verticalAlignment = GridData.FILL;
		gridDataNextButton.verticalSpan = 2;
		
		Button nextButton = new Button(shell, SWT.BORDER);
		nextButton.setText("next");
		nextButton.setLayoutData(gridDataNextButton);
		
		Text descriptionText = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		
		prevButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
				try{
					if(i!=0) {
						
						nameText.setText(requirements.get(i).getName());
						descriptionText.setText(requirements.get(i).getDescription());
						i++;
					}
					else System.out.println("Nu exista element anterior");
					
				}catch(IndexOutOfBoundsException ee) {
					
					System.out.println("Nu exista element anterior");
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
		
		
		nextButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
				try{
					
					nameText.setText(requirements.get(i).getName());
					descriptionText.setText(requirements.get(i).getDescription());
					i++;
				}catch(IndexOutOfBoundsException ee) {
					
					System.out.println("Nu exista element urmator");
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
