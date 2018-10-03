Reviewer: James Frampton Reid (u6079329)
Component: <Waldo>
Author: Lachlan McVicar (u6406312)

Review Comments:

1.  ImageAnal and ImageAnal_String have good functionality being small tasks that break down the larger problem

2.  The code is not well documented, the class name and many of the function names are not descriptive
"waldo", "ImageAnal", these do not describe what the class or functions do

3.  Some of program decomposition is appropriate, with smaller functions being, however the same types of code are repeated
namely if statements that look very similar and maybe can be just done in a function instead.  Some functions seem to specfic
making them more difficult to use in a variety of situations

4. Most conventions are followed with most variable names being camel case, however ImageAnal and ImageAnal_String
start with capital letters which usually indicates a class or a constant

5. ImageAnal_String seems to be susseptical to breaking as it relies on an image of being the a certain size to determine
it's type, this seems arbitrary and will break if the image's size changes before this function is called