package edu.saintjoe.cs.brianc.finalstartapp;

// Necessary imports
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.TextBox;
// Event-related functionality
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.EventDispatcher;

public class FinalAppActivity extends Form implements HandlesEventDispatching {

	// Java Bridge analog to App Inventor "FinalStartApp" project
	//   Coded by Brian Capouch
	//   Project begun 25 December 2015
	
	// We begin with constants, and "global settings" variables
	// -- This app has none for now
	
	// Next are the UI widget references	
	// These objects are equivalent to "components" of App Inventor

	// Only two for this simple demo
	private Button onlyButton;	
	private Label onlyLabel;
	
	// Variable to control app behavior
	boolean pristineBehavior = true;

// Java Bridger apps all use $define() in place of main()
protected void $define() {

	// Code in this block is equivalent to the "Designer" part of App Inventor
  
	this.BackgroundColor(COLOR_WHITE);
   
	// Create our button
	onlyButton = new Button(this);
	onlyButton.Text("Please push me!!");

	// And our only label
	onlyLabel = new Label(this);
   
	// Let the runtime system know which events to report to the dispatcher
	EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
 
} // end $define()

// This method runs asynchronously 
// It's called each time a registered event occurs
@Override
public boolean dispatchEvent(Component component, String id, String eventName,
       Object[] args) {
	
	// This code is equivalent to the "Blocks" part of App Inventor
	//   i.e. this is "when onlyButton.Click do"
	if (component.equals(onlyButton) && eventName.equals("Click")){
		// Present alternate displays
		if (pristineBehavior) {
			onlyLabel.Text("OUCH!!!");
			onlyButton.Text("Push Again");
	    } else {
	    	onlyLabel.Text("Ooooh!!");
	    	onlyButton.Text("Please push me!");
	    }
	// Toggle display mode
	pristineBehavior = ( pristineBehavior ? false : true );
	
	//  All is well
	return true;
	} // End click handler for onlyButton
	
	// One complete event handled  
	return true;
	} // end dispatchEvent
} // end class
