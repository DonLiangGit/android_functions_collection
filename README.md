Android Functions List
=
Directory:
=
### Screen Layout: 
This folder includes `Relative Layout` `Table Layout` `Linear Layout` `List View` `Swipe Views`.

* To apply a layout, follows:
  1. copy the layout.xml to `res/layout` folder in your project.
  2. Pick the activity java class then modify `setContentView(R.layout.your_layout_name)`.
* `List View` (List item value stored in .xml file):
  1.  for basic list view:
  copy all four files in the `basic` folder seperately to your android project or
  2. `create a class extends ListActivity(import related class)`
  3. `create an XML file for string resources`
  4. `create an XML file for display each item (type: TextView)`
  5. `create ArrayAdapter to get the string[]`
* `List View` (List item value stored in .java file, for activity not extend Listactivity):
  1. `create an XML fiel for displaying each list item`
  2. `create an string array to store value`
  3. `create an Adapter to connect list value and item layout`
  4. `create listview and connect it to xml file`
  5. `setAdapter(listview reference)`
  
### Icon:
  1. copy icons image seperately to `drawable` folder under `res`;
  2. change `android:icon="@drawable/your_icon_name` in `AndroidManifest.xml`;
  
### Splash screen:
  1. for basic splash screen:
  copy all three files into different folders in your project or
  2. create a handler and also use its `.postDelayed()` method to handle a new runnable.
  3. full screen: add `android:theme="@android:style/Theme.NoTitleBar.Fullscreen"` to `AndroidManifest.xml`.
  4. (Optional for splash screen) add `android:screenOrientation="portrait"android:theme="@android:style/Theme.Black.NoTitleBar"`, this will let the splash screen with a status bar and perform perfect sa far.
  
### Nav Drawer:

### Swipe Views:

### Debug:
  1. Using logcat to debug:
  2. create `log` class then using its d method to pass the tag and message.
  3. Using `toast` to test: `Toast.makeText(context, message, duration).show();`, for the context arguement I would like to use this for current class.
