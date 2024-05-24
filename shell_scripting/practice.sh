#!/bin/bash

echo "printing file name and arguments "

echo "The current file name is $0"

echo "The parameter 1 is $1"


# Argument mixes string and array. Use * or separate argument.
#echo "All arguments are $@"

#preferred way
echo "All arguments are $*"
