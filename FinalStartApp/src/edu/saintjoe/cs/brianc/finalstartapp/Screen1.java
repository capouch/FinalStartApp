package edu.saintjoe.cs.brianc.finalstartapp;

// Necessary imports for every project
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Form;
//Event-related functionality
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.EventDispatcher;

// Imports for components needed by this app
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.TextBox;


public class Screen1 extends Form implements HandlesEventDispatching {

	// Java Bridge analog to App Inventor "FinalStartApp" project
	//  Coded by Brian Capouch
	//  Project begun 25 December 2015
	//    -- "Finished" version 27 Dec
	
	// We begin with constants, and "global settings" variables
	final int ARRAY_SIZE=20;
	
	// Next are the UI widget references	
	// These objects are equivalent to "components" of App Inventor

	// Vertical arrangement to enforce AI screen layout
	// This is the only component not in the AI version
	private VerticalArrangement screenLayout;
	
	// Two horizontal arrangements
	private HorizontalArrangement horizontalArrangement1, horizontalArrangement2;
	
	// Per our app's Designer screen
	private Label promptLabel, resultLabel, listContentsLabel;
	private Button calcButton, listAddButton, listShowerButton, sumButton;
	private TextBox numberInput;

	// Global variables have to go here, too
	int[] numberList;
	int listIndex = 0;

  // Java Bridger apps all use $define() in place of main()
  protected void $define() {

	// Code in this method is equivalent to the "Designer" part of App Inventor
  
	// Our list needs to be instantiated
	numberList = new int[ARRAY_SIZE];
	
	this.BackgroundColor(COLOR_WHITE);
		
	// Top-level container for entire app
	screenLayout = new VerticalArrangement(this);
	
	// First "row" is input widget
	horizontalArrangement1 = new HorizontalArrangement(screenLayout);
	
	// Add components
	promptLabel = new Label(horizontalArrangement1);
	promptLabel.Text("Enter number: ");
	numberInput = new TextBox(horizontalArrangement1);
	numberInput.NumbersOnly(true);
	
	// calcButton and resultLabel get their own lines
	calcButton = new Button(screenLayout);
	calcButton.Text("Calc");
	
	resultLabel = new Label(screenLayout);

	// Group together the list-related functionality
	horizontalArrangement2 = new HorizontalArrangement(screenLayout);
	
	// Add list-related buttons
	listAddButton = new Button(horizontalArrangement2);
	listAddButton.Text("Add to List");
	listShowerButton = new Button(horizontalArrangement2);
	listShowerButton.Text("Show List");
	sumButton = new Button(horizontalArrangement2);
	sumButton.Text("Compute List Sum");
	
	// Display list label below everything else
	listContentsLabel = new Label(screenLayout);
   
	// Let the runtime system know which events to report to the dispatcher
	EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
	
	// Once control arrives here the app will launch and wait for events
 
  } // end $define()

  // This method runs asynchronously 
  // It's called each time a registered event occurs
  @Override
  public boolean dispatchEvent(Component component, String id, String eventName,
       Object[] args) {
	
	//  From here down is equivalent to the "Blocks" part of App Inventor
	// It consists of event handlers, procedures, functions
	
	//  when calcButton.Click do
	if (component.equals(calcButton) && eventName.equals("Click")){
		// Convert string -> run incrementIt -> convert back -> Display
		resultLabel.Text(Integer.toString(incrementIt(Integer.parseInt(numberInput.Text()))));
		// Clear input box for next operation
		numberInput.Text("");
		//  Indicate that the event has been handled
		return true;
		} // End click handler for calcButton
	
	// when listAddButton.click do
	if (component.equals(listAddButton) && eventName.equals("Click")){
		// Add input value to list
		// Note: we don't check for list overflow (yet)!!!!
		
		// Check to see if box is empty
		// There are other types of bad input it doesn't check for (e.g. '-' or '.')
		if (numberInput.Text().equals("")) return true;
		
		// Add value from input after converting to int
		numberList[listIndex++] = Integer.parseInt(numberInput.Text());
		// Clear widget for next use
		numberInput.Text("");
		return true;
		}
	
	// when listShowerButton.click do
	if (component.equals(listShowerButton) && eventName.equals("Click")){
		// Just like the AI version!!
		showListContents();
		return true;
		}

	// If we got here nobody handled the event  
	return false;
	
	} // end dispatchEvent

  // Procedures and functions
  int incrementIt (int input) {
	return ++input;
	}

  void showListContents() {
	// Local variable
	String display;
	
	display = "Lucky Luke's Lilting List\n";
	// "for" is a type of while loop
	for(int i= 0; i < listIndex; i++)
		// Put together string first, then display it
		display = display + Integer.toString(numberList[i]) + "\n";
	listContentsLabel.Text(display);
	}
} // end class
