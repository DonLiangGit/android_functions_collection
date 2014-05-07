Android Functions Specification
=
Directory
=
* layout: 
  includes
  `relative layout` `table layout` `linear layout` `list view`
  1. To apply a layout, follows:
    1. copy the layout.xml to `res/layout` folder in your project.
    2. Pick the activity java class then modify `setContentView(R.layout.your_layout_name)`.
  2. To apply `List View` follows:
    1.  copy all four files in the `basic` folder or
      1. `create a class extends ListActivity(import related class)`
      2. `create an XML file for string resources`
      3. `create an XML file for display each item (type: TextView)`
  	  4. `create ArrayAdapter to get the string[]`


