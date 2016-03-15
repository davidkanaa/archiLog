package com.mustream.app.rcp.parts;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.mustream.app.models.entities.Item;
import com.mustream.app.models.entities.Track;
import com.mustream.app.models.modules.searcher.Searcher;

public class SearchPart {

	  private Text text;
	  private Searcher searcher;
	  private Table table;
	
	  @PostConstruct
	  public void createControls(Composite parent) {
	    parent.setLayout(new GridLayout(1, false));
	    
	    Composite comp = new Composite(parent, SWT.NONE);
	    comp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    comp.setLayout(new GridLayout(2, false));
	
	    text = new Text(comp, SWT.SEARCH | SWT.ICON_SEARCH | SWT.CANCEL | SWT.BORDER);
	    text.setMessage("Search for tracks ...");
	    text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    
	    
		
	    Button button = new Button(comp, SWT.PUSH);
	    button.setText("Search");
	    button.addSelectionListener(new SelectionAdapter() {
	      @Override
	      public void widgetSelected(SelectionEvent e) {
	        String terms = text.getText();
	        if (terms.isEmpty()) {
	          return;
	        }
	        
	        /*new Thread(new Runnable() {
				
				@Override
				public void run() {
					searcher.search(terms);
					System.out.println(searcher.getResults().size());
					
					table.removeAll();
			        
			        for(Item result : searcher.getResults()){
			        	TableItem item = new TableItem(table, SWT.NONE);
			        	item.setText(0, ((Track)result).getTitle());
			        	item.setText(1, ((Track)result).getAlbumName());
			        	item.setText(2, ((Track)result).getArtitsNames().toString());
			        }
			        for (int i=0; i<3; i++) {
			    		table.getColumn (i).pack ();
			    	}
			        
			        table.layout(true);
				}
			}).run();*/
	        
	        searcher.search(terms);
	        
	        table.removeAll();
	        
	        for(Item result : searcher.getResults()){
	        	TableItem item = new TableItem(table, SWT.NONE);
	        	item.setText(0, ((Track)result).getTitle());
	        	item.setText(1, ((Track)result).getAlbumName());
	        	item.setText(2, ((Track)result).getArtitsNames().toString());
	        }
	        for (int i=0; i<3; i++) {
	    		table.getColumn (i).pack ();
	    	}
	        
	        table.layout(true);
	        
	      }
	    });
		
		searcher = new Searcher();
	    
	    
	    table = new Table(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	    GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
	    data.heightHint = 200;
	    table.setLayoutData(data);
	    String[] titles = {"Title", "Album", "Artist(s)"};
		for (int i=0; i<titles.length; i++) {
			TableColumn column = new TableColumn (table, SWT.NONE);
			column.setText (titles [i]);
		}
	
	  }
	
	  @Focus
	  public void onFocus() {
	    text.setFocus();
	  } 
	  
}
