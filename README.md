specifications
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
  

### Staggered GridView(Etsy):
* Setting up(ADT):
* Customization:
  1. TextView aligned on the bottom of layout: `android:layout_gravity="bottom"`
  2. TextView background transparent with color, for example: `android:background="#B3000000"`, for other opacity refer bottom Reference.


=

### Icon:
  1. copy icons image seperately to `drawable` folder under `res`;
  2. change `android:icon="@drawable/your_icon_name` in `AndroidManifest.xml`;
  
=

### Splash screen:
  1. for basic splash screen:
  copy all three files into different folders in your project or
  2. create a handler and also use its `Handler().postDelayed(new Runnable(), SPLASH_DISPLAY_LENGTH)`
  3. Override `run()` method.
  4. full screen: add `android:theme="@android:style/Theme.NoTitleBar.Fullscreen"` to `AndroidManifest.xml`.
  5. (Optional for splash screen) add `android:screenOrientation="portrait"android:theme="@android:style/Theme.Black.NoTitleBar"`, this will let the splash screen with a status bar and perform perfect sa far.


= 

### Nav Drawer:
=

### Swipe Views:
=

### Debug:
  1. Using logcat to debug:
  2. create `log` class then using its d method to pass the tag and message.
  3. Using `toast` to test: `Toast.makeText(context, message, duration).show();`, for the context arguement I would like to use this for current class.

=

### Reference:
=

| Hex Values Opacity   |
| ------------- |
|100% — FF
|95% — F2
|90% — E6
|85% — D9
|80% — CC
|75% — BF
|70% — B3
|65% — A6
|60% — 99
|55% — 8C
|50% — 80
|45% — 73
|40% — 66
|35% — 59
|30% — 4D
|25% — 40
|20% — 33
|15% — 26
|10% — 1A
|5% — 0D
|0% — 00 
