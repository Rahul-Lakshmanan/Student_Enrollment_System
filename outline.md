# Project Planning Outline

### Frontend Package

Will consist of a collection of *JPanels* that can all be added to the main *JFrame* to create different screens:

- **Main Screen** 
  - *Panels*: contains title and buttons panel 
  - *Buttons*: Details | ENROLL | View Students
  
- **Details Screen** 
  - *Panels*: discription panels
  - *Buttons*: back 
  
- **Enroll Screen**
  - **Information Selection**
    - *Panels*: textfield to enter student first and last name ; drop down menu to select grade to enroll ; checkbox grid of classes (class number | class title | description | cost ) ; buttons panel
    - *Buttons*: cancel and confirm student
  - **Confirmation**
    - *Panels*: student name and id ; summary of selected classes ; total cost of taking selected classes
    - *Buttons*: back and confirm 

- **View Students Screen**
  - *Panels*: Grid panel displaying enrolled students information in order of: student id | name | classes | balance
  - *Buttons*: home screen
  

### Backend Package

- **Main Screen** is initially displayed when the program runs ; each button will remove current panels on screen and add replace them with panels associated with the appropriate next screen
  
- **Details Screen** displays a description of the project
  
- **Enroll Screen** (screens displayed in order of occurance)
  - **Information Selection**: rows of selected classes should be highlighted and cost label should be updated when a class is checked or unchecked
  - **Confirmation**: when the confirm button is clicked, the details of the student should be saved to a file

- **Student View Screen** should display the contents of the file containing all the enrolled students information
