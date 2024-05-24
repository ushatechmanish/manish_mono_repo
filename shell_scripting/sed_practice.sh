#!/bin/bash

# Define the text to append
text_to_append="text appended by sed command"

# Use sed to append text to the end of the file
# The following commands are not working
#sed -i '$a\'"${text_to_append}" sample.txt
#sed -i '$ a\' "$text_to_append" sample.txt
#sed -i '$ a\' "$text_to_append" sample.txt

# This line will print each line  twice
#sed 'p' sample.txt
echo "use -n to suppress automatic printing by sed 'p' sample.txt"

sed -n 'p' sample.txt

# Confirm the text has been appended
#echo "Text appended successfully."

#echo "This is the appended text." >> sample.txt

