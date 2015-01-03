
**************************************Purpose*******************************************

The purpose of this program is to count the total number of unique diads, two character
sequences, in a piece of text. It would then report the top 10 most frequent diads and
then produce a calculation of how long the text would be printed using either a 
qwerty of dvorak keyboard

********************************** data structure **************************************

The data structure used to store the unique diads is a 2D array. As each has a unique
ASCII value attached to each character, I built a 128x128 array, with all values in the
2D array initialized to 0. For example is the diad is "Za" then the identification number 
on the 2D array would be 90x97, if the frequency had then 0, then it would change to 1,
if it had already existed, the counter would go up by 1 each time. 

Using a 2D array makes the program very efficient and can locate and change values in the
designated blocks quickly. I had first used an ArrayList to store the values and ended up 
with a run time of 8 minutes. When I switched to a 2D array, it can down to under 2 seconds.

********************************* Reading Process *************************************

The files are read using the typical Buffered Reader.read method, this is so that it read
one character at a time, and it read until it gets to the end of the line. As the buffered
reader reads the first character, it turns it into an ASCII value for the 1st identification
number. Then it creates a variable called "lastChar" that temporarily stores the value of the 
first ASCII value. The program then reads the next character and labels is as the "current" or
current character. Then values are turned into a Diad object before being added into the 2D
array. It is also in this loop that the calculations for the qwerty and dvorak keyboard occurs
to decrease run time and increase efficiency.