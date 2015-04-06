--------------------02-Activities,Dialogs,Fragments,Intents----------------------------------------------------------------------
>>Ex01SimpleDialog
- How to use AlertDialog.Builder
- How to have dialog box with single button (ex: "Ok" button)

>>Ex02PassingDataToDialog (using Intent)
- How to use LinearLayout
- How to use EditText (and requestFocus)
- How to center an element in LinearLayout
- How to create OnClickListener as a separate instance (and then attach it to Button click event)
- How to add a new Activity and display it as a dialog 
	- right click on res/layout | New | Activity | Blank Activity
- How to add a second string resource file (exclusive to dialog)
- How to create class level UI fields and access them anywhere in Activity class
- Using MainActivity.instance in a listener (to get access to activity instance for context)
- Using current activity instance in a listener (using a class field)
- How to specify/theme an activity as a dialog (in AndroidManifest.xml)
- How to specify dialog title (in AndroidManifest.xml)
- How to use Intent to fire up an Activity (in this case, a dialog)
- How to use putExtra/getExtra to send/receive data through Intent
- How to create a bundle object to send/receive data through Intent
- How to send/receive a serializable object through Intent

>>Ex03ReturningDataFromDialog
- How to use Intent to fire up an Activity for result (in this case, a dialog)
- How to use request code together with "onActivityResult" method, which gets executed when the dialog sets the result and finishes itself
- How to check for "OK/Cancel" result from dialog
- How to bundle things for sending data from main activity to dialog (using intent)
- How to bundle things for returning data from dialog to main activity (using intent)

>>Ex04SimpleTwoFragments
- How to create a couple of new Fragments (along with layouts)
	- right click on res/layout | New | Fragment | Fragment (Blank)
- How to add Fragments to MainActivity (fragment1 occupying 1/4th of space and fragment2 occupying rest)
- How to comment existing OnFragmentInteractionListener of newly created fragments (which come as part of template) from onAttach
- Fragments should adjust based on rotation as well

>>Ex05FragmentsDuringOrientation
- How to create "layout-land" to have different layout during "landscape mode" (default "layout" is for portrait)
	- right click on res | New | Android Resource Directory | Directory name: layout-land, Resource type: layout
- How to create new layout file under "layout-land"
	- switch to Project View | right click on "layout-land" | New | Layout Resource File | Name: activity_main | switch back to Android App View
- How to show one fragment in portrait and two fragment in landscape
- You can also do the same using "/res/layout-port" specifically for portrait

>>Ex06DynamicFragments
- How to use FrameLayout as place holder to dynamically inject Fragment(s) at runtime
- How to create "/res/values-land" to have different settings for landscape mode alone
	- right click on res | New | Android Resource Directory | Directory name: values-land, Resource type: values
- How to add a new config.xml (with our own settings for portrait layout) to "/res/values" 
	- right click on res/values | New | Values resource file | File name: config
	- do the same for "/res/values-land" (but with different settings in config.xml specific to landscape)
- How to use FragmentManager
- How to use FragmentTransaction
- How to find a Fragment in the current activity
- How to show one Fragment fully occupied in portrait and Two Fragments in Landscape dynamically at runtime

>>Ex07MovingBetweenActivities
- How to switch to other activities (using Intent)
- How to go to navigate to three nested levels (deep)
- Testing:
	- Check back stack - using Android Studio
	- Check automatic back button functionality (after going 'n' levels deep)
	- Write some content in textbox and make sure that the state gets retained during back navigation
	- Ensure rotation loses the state
	
>>Ex08NavigatingUpBetweenActivities
- How to add reference to andorid-support-v4.jar to the project
	- right click on app | Open Module Settings | Dependencies | click on '+' | Library Dependency | choose "support-v4"
- How to add 'Up' navigation to activities (in manifest, in code etc. search for 'Up navigation' everywhere)
- Testing:
	- Check back stack - using Android Studio
	- Check automatic back button functionality (after going 'n' levels deep)
	- Write some content in textbox and make sure that the state gets maintained during back navigation
	- Write some content in textbox and make sure that the state gets retained during up navigation (only the latest)
	- Ensure rotation loses the state
	
>>Ex09MultipleActivitiesAndDynamicFragments
- How to nest LinearLayout
- How to add a couple of fragments (with textbox controls) to an activity 
- How to identify elements in fragments (using its own view)
- How to switch from one activity (with fragments) to another activity (with its own set of fragments)
- How to replace an existing fragment with another dynamically at runtime (as part of another activity) and maintain backstack
	- The code in first fragment replaces its own, with another fragment (pushing itself to backstack)
- How to add a nested fragment (a fragment inside another) using getChildFragmentManager from within fragment
- Testing:	
	- Ensure all textboxes retain state by default (with no code) during device rotation and back button (even with fragments)

>>Ex10ActivityRetainState
- How to use log
- Getting to know the life-cycle of Activity
- How to maintain state (of our own variables) during rotate, home, back, switching to another activity etc.
- Testing:
	- Set a message, rotate the device and show the message (it should show the one which was set)
	- Set a message in main activity, go to another activity, return back and show the message (should show the one which was set earlier)

>>Ex11FragmentRetainState
- Getting to know the life-cycle of Fragment (in relation with Activity)
- How to maintain state (of our own variables) during rotate, home, back, switching to another activity etc. for Fragment
- Testing:
	- Set a message (both Activity and Fragment), rotate the device and show the message (it should show the one which was set)
	- Set a message (both Activity and Fragment), go to another activity, return back and show the message (should show the one which was set earlier)

>>Ex12PassingDataFromActivityToFragment
- How to get data from parent activity from within a child Fragment, by calling parent activity method (Activity01)	
- How to send data from parent activity to child Fragment, during fragment creation (Activity02)
- How to send data from Parent activity to child Fragment, by calling fragment method (Activity02)
- How to get data from parent activity from within a child Fragment, by fetching from parent activity intent (Activity03)
- How to create interface
- How to get data from parent activity from within a child Fragment, by fetching using parent activity interface (Activity04)
- How to send data from Parent activity to child Fragment, by calling fragment interface method (Activity05)
- Testing:
	- Ensure that all data remains in place during device rotation and back button (with/without fragments)
	
>>Ex13PassingDataFromFragmentToActivity
- How to send data from child Fragment to parent Activity using fragment interface (Activity01)
- Testing:
	- Ensure that all data remains in place during device rotation and back button (with/without fragments)

>>Ex14ListFragment
- How to create a simple Fragment which inherits from ListFragment class (with no layout file)
- using "simple_list_item1" as default layout (for built-in ListView of ListFragment)
- How to use ArrayAdapter<String> to set as data source to ListFragment
- How to show the selected (touch clicked) item to user
- Does not maintain selection in this case

>>Ex15ListFragmentWithActiveSelection
- using "simple_list_item_activated_1" to enable selection 
- How to persist ListFragment selections made by user
- Testing:
	- Ensure that all data remains in place during device rotation and back button (with/without fragments)

>>Ex16SimpleMasterDetailWorkflow
- How to use ListFragment with its own design-time layout (with @android:id/list and @id/android:empty)
- How to support Portrait based and Landscape based Master Detail workflow
	- Portrait works with Master Activity (with Master Fragment) firing up Detail Activity (with Detail Fragment)
	- Landscape works with Master Activity (with Master Fragment) showing Detail Fragment along side.
- How to use one interface across all activities and fragments for passing selected information
- Works with both layout based and dynamic fragments

>>Ex17SimpleDialogFragment
- How to use DialogFragment to create a Dialog with just a simple class and no design-time layout
- How to Pass data to DialogFragment
- How to return data to activity from DialogFragment

>>Ex18DialogFragmentWithLayout
- How to use DialogFragment to create a Dialog with just a simple class and load a design-time layout dynamically
- How to access elements available in the layout within the fragment



