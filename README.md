Android Functions Specification
=
Directory
=
* layout: 
  includes
  `Relative Layout` `Table Layout` `Linear Layout` `List View`
  1. To apply a layout, follows:
    1. copy the layout.xml to `res/layout` folder in your project.
    2. Pick the activity java class then modify `setContentView(R.layout.your_layout_name)`.
  2. To apply `List View` follows:
    1.  for basic list view:
    copy all four files in the `basic` folder seperately to your project or
    2. `create a class extends ListActivity(import related class)`
    3. `create an XML file for string resources`
    4. `create an XML file for display each item (type: TextView)`
    5. `create ArrayAdapter to get the string[]`


