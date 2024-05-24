#!/bin/bash

echo "printing file name and arguments "

echo "The current file name is $0"

echo "The parameter 1 is $1"

# shell : set variables

echo "There should be no space before and after the = while setting variables "

name=manish

echo "Printing variable name "$name
# Argument mixes string and array. Use * or separate argument.
#echo "All arguments are $@"

#preferred way $* treats all arguments as a single string
echo "\"\$*\" treats all arguments as a single string"

echo "All arguments are $*"

echo  "\"\$@\" treats all arguments as different strings"
echo "All arguments are $*"


echo " Printing  each argument on a new line "
# $@ treats all args as separate
for arg in "$@"
  do
    echo $arg
  done

