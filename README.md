# LaLista
Grocery List Manager
The purpose of this program is to neatly show produce that a person may get whenever they go grocery shopping.
A user should be able to click on different categories and different produce to then be placed on the left textArea which will
then be sent to whoever they desire using gmail. They could also click on any text on the left textArea to remove the item. The program
does not allow repeating the same produce. This is done by checking names, I will eventually generalize this to account for misspellings 
and random capitalizations. Clicking Save will save the grocery to a text file. This text file will then be loaded when load is clicked.
Clicking send will prompt the user to input a sender email, password, and receiving email. Upon checking the categories in the combobox,
the user will see "1 semana" and "2 semana" which are produce that have not been bought for more than 6 days. This is done by tracking the 
last day that a produce was sent and subtracting them to the day it is being the program is being used. There is also a button named "otro" 
with a text field next to it, in case a produce is not already in the list. The produce will then be added to a file named AddMe.txt so 
the user can transfer that produce text to the relevant text file it should be in.
