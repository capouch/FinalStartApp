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


public class FinalAppActivity extends Form implements HandlesEventDispatching {

	// Java Bridge analog to App Inventor "FinalStartApp" project
	//  Coded by Brian Capouch
	//  Project begun 25 December 2015
	//    -- first translation effort begun 27 Dec
	
	// We begin with constants, and "global settings" variables
	// -- This app has none for now
	
	// Next are the UI widget references	
	// These objects are equivalent to "components" of App Inventor

	// Vertical arrangement to enforce AI screen layout
	private VerticalArrangement screenLayout;
	
	// Two horizontal arrangements
	private HorizontalArrangement horizontalArrangement1, horizontalArrangement2;
	
	// Per our app's Designer screen
	private Label promptLabel, resultLabel, listContentsLabel;
	// Only two for this simple demo
	private Button calcButton, listAddButton, listShowerButton, sumButton;
	// One TextBox for input
	private TextBox numberInput;

	// Global variables have to go here, too
	int[] numberList;

// Java Bridger apps all use $define() in place of main()
protected void $define() {

	// Code in this block is equivalent to the "Designer" part of App Inventor
  
	this.BackgroundColor(COLOR_WHITE);
	
	// Top-level container for entire app
	screenLayout = new VerticalArrangement(this);// By convention, create container components first
	
	// First "row" is input widget
	horizontalArrangement1 = new HorizontalArrangement(screenLayout);
	
	promptLabel = new Label(horizontalArrangement1);
	promptLabel.Text("Enter number: ");
	numberInput = new TextBox(horizontalArrangement1);
	numberInput.NumbersOnly(true);
	
	// calcButton and resultLabel get their own lines
	calcButton = new Button(screenLayout);
	calcButton.Text("Calc");
	
	resultLabel = new Label(screenLayout);

	// Bunch together the list-related functionality
	horizontalArrangement2 = new HorizontalArrangement(screenLayout);
	// Add list-related buttons
	listAddButton = new Button(horizontalArrangement2);
	listAddButton.Text("Add to List");
	listShowerButton = new Button(horizontalArrangement2);
	listShowerButton.Text("Show List");
	sumButton = new Button(horizontalArrangement2);
	sumButton.Text("Compute List Sum");
	
	// Display list contents below everything else
	listContentsLabel = new Label(screenLayout);
   
	// Let the runtime system know which events to report to the dispatcher
	EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
 
} // end $define()

// This method runs asynchronously 
// It's called each time a registered event occurs
@Override
public boolean dispatchEvent(Component component, String id, String eventName,
       Object[] args) {
	
	int i; // temporary integer storage
	String s; // Ditto for string
	
	// This code is equivalent to the "Blocks" part of App Inventor
	//   i.e. this is "when onlyButton.Click do"
	if (component.equals(calcButton) && eventName.equals("Click")){
		// Do some minimal little thing
		i = Integer.parseInt(numberInput.Text());
		resultLabel.Text(Integer.toString(incrementIt(i)));
		//  All is well
		return true;
		} // End click handler for onlyButton
	// One complete event handled  
	return true;
	
	} // end dispatchEvent

// Here are service routines
int incrementIt (int input) {
	return ++input;
	}
} // end class
