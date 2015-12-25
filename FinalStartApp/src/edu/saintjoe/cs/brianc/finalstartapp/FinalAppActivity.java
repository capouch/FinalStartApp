package edu.saintjoe.cs.brianc.finalstartapp;

import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.TextBox;

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

// This method, known as a "callback" is invoked by the runtime system
// It will only be called when a delegated event occurs
@Override
public boolean dispatchEvent(Component component, String id, String eventName,
       Object[] args) {
	
	// This code is equivalent to the "Blocks" part of App Inventor
	    if (component.equals(onlyButton) && eventName.equals("Click")){
	    	onlyLabel.Text("OUCH!!!");
	    	onlyButton.Text("Do It Again");
	        return true;
	     } // 
	    

	    // This line is syntactically required  
	    return true;
} // end dispatchEvent
}
