Android Functions Specification
=
Directory
=
* Layout: 
  includes
  `Relative Layout` `Table Layout` `Linear Layout` `List View`
  1. To apply a layout, follows:
    1. copy the layout.xml to `res/layout` folder in your project.
    2. Pick the activity java class then modify `setContentView(R.layout.your_layout_name)`.
  2. To apply `List View` follows:
    1.  for basic list view:
    copy all four files in the `basic` folder seperately to your android project or
    2. `create a class extends ListActivity(import related class)`
    3. `create an XML file for string resources`
    4. `create an XML file for display each item (type: TextView)`
    5. `create ArrayAdapter to get the string[]`
* Icon:
  1. copy icons image seperately to `drawable` folder under `res`;
  2. change `android:icon="@drawable/your_icon_name` in `AndroidManifest.xml`;
* Splash screen:
  1. for basic splash screnn:
  copy all three files into different folders in your project or
  2. create a handler and also use its `.postDelayed()` method to handle a new runnable.
  3. full screen: add `android:theme="@android:style/Theme.NoTitleBar.Fullscreen"` to `AndroidManifest.xml`.


