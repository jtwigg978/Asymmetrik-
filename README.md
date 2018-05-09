# Asymmetrik-
Asymmetrik Coding Problem
Business Card OCR


  I have the 3 files I used in this project on this page. There is the Main driver, which is what initializes all of the objects and where the document to be parsed is introduced. In order to run this program, you will have to change the text file path to wherever necessary. I had a file created on my desktop, where I tested different inputs that would then be sent into the program as a String variable "document". With all 3 files downloaded in the same project, the only change necessary is this file path and it should run. I also have a ContactInfo class, which basically only consists of getters and setters for the ContactInfo object. And lastly, I have a BusinessCardParser class, where most of the code is. I used this class to find all of the information from the document necessary, before sending it back to the driver and having it printed.
   
   If no name is inputted, then the name field will print as "null". If no phone is inputted, then there will be no number displayed. And lastly, if there is no email, then both the email and name fields will be "null". This is due to the fact that I thought the best way of finding out which line the name was on is through the email address. The code will work and output everything as long as all 3 of those are inputted somewhere in the document - which I believe would be on every business card anyways. 
   
   I apologize if my files are not formatted correctly on github, I have never uploaded a document here before. However, I think that it should all work correctly. 
