# Learning JavaFX
Code samples and experimentation while learning JavaFX. Tutorials are numbered and progress from simple to more complex examples.

Note: These examples are from me following and/or modifying tutorials from [ProgrammingKnowledge](https://www.youtube.com/playlist?list=PLS1QulWo1RIaUGP446_pWLgTZPiFizEMq "JavaFX Tutorial Playlist by ProgrammingKnowledge").

## Requirements
1. [Install Scene Builder](http://gluonhq.com/products/scene-builder/)
2. [Install e(fx)lipse JavaFX Runtime for eclipse](http://www.eclipse.org/efxclipse/install.html#for-the-lazy)
3. Set the path to SceneBuilder executable under Preferences > JavaFX in Eclipse preferences.

### JFX01
A simple JavaFX GUI Application made purely with java

### JFX02
A Simple JavaFX GUI Application that randomly generates numbers by the click of a button and displays in the windows. This application uses Scene Builder, a development tool to speed up GUI development process by offering drag and drop of GUI elements on screen.

### JFX03
JFX02 application extended to use CSS stylesheet for the entire app for improved modularity and fine tuned styling.

### JFX04
An calculator application with interface generated using Scene Builder and learning how to program logic in Model as well as Controller methods for data handling.

### JFX05
A simple login screen that takes a username: user and password: pass to display some content. If the login information is incorrect, an error message is displayed.

### JFX06
JFX05 with an image added to the scene and a button with image

### JFX07
This project focuses on the use of Combo box (a select box) and ObservableList, a container type that listens for action events to check for updates, adding or removing items from its list (perfect for interfaces).

### JFX08
A demo focusing on how ListView works. ListView is Java's term for select box in HTML. It can be a single or multiselect listbox. This demo also demonstrates how to retrieve selected items as well as adding items to the list after an event has triggered.

### JFX09
A demo showing how TreeView works. TreeView is the familiar directory structure you see when navigating folders in windows. The demo shows how to include icons and how to create the structure. Each TreeItem is represented as a node of the root node.

### JFX10
An extension to JFX09 where MouseEvents are implemented. After linking "On Mouse Click" for TreeView in Scene Builder with a newly created mouseClick() method in the controller, the name of the node clicked in the TreeView will be printed in the console.

### JFX11
A demo of file chooser which contains 2 buttons. The first button allows choosing only 1 file while the other allows multiple file selection. This demo also shows ways to restrict file type selection as well as the initial directory for the file chooser.

### JFX12
A demo that showcases the use of JavaFX Properties, a wrapper class that allows implementaiton of listeners that perform an action when the property of a class is updated.

### JFX13
A demo showing how to work with progress bars and performing uni-directional binding with JavaFX Properties.

### JFX14
A demo showing how bi-directional binding works. The original example uses `NumberFormat.getNumberInstance()` instead of `converter` as shown on line 43 of MainController.java. It is a separate approach to solving the same problem, but the NumberFormat method creates a warning about binding being changed while NumberStringConverter works flawlessly by ensuring the same type is kept in generics (the slider is of type DoubleProperty which implements `Property<Number>` and converter of type `StringConverter<Number>`ensures they are the same type.

### JFX15
A demo showing how to create a menubar and its components: MenuSeparateItem, MenuItem, and Menus.
