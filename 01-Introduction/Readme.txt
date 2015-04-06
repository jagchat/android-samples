>>Ex01HelloWorld
- A default android application created using Android Developer studio wizard 

>>Ex02OnClickDemo
- How to create a Button (using Button View)
- A simple Button click event (using configuration in layout)
- Wiring up an (button click) event handler
- Using "Toast" to display message in a simple popup 
- Using res/values/strings (as part of Button Caption)
- Demonstrates the following Button attributes:
	    android:id
		android:text
        android:textAllCaps
        android:layout_centerHorizontal
        android:onClick
		
>>Ex03WorkingWithLibraryProject
- Add a new android library module to an existing Android app project
	- File | New Module | Android Library | Give name (SomeLib) | No Activity
- Add a simple class and a method (MathUtils.GetSum() in this case) to the library
	- right click on SomeLib/java/com....lib (and not 'androidTest' project) | New Java Class | MathUtils
- Add the library module as a dependency to Android app project
	- right click on app | Open Module Settings | Dependencies | click on '+' | Module Dependency | choose "SomeLib"
- In the button click event handler, import the package, instantiate the class in the library module and execute the method

>>Ex02OnClickWithListenerDemo
- Finding a control in Activity (using findViewById)
- Wiring up an (button click listener) event handler dynamically (with no configuration in layout)
