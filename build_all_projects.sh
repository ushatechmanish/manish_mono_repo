#!/bin/bash

# Function to build Maven projects
build_maven() {
    echo "Building Maven project in $1"
    cd "$1" || exit
    mvn clean install
    cd ..
}

# Function to build Gradle projects
build_gradle() {
    echo "Building Gradle project in $1"
    cd "$1" || exit
    ./gradlew clean build
    cd ..
}

# Function to recursively search for Maven projects
search_maven() {
    for file in "$1"/*; do
        if [ -d "$file" ]; then
            if [ -f "$file/pom.xml" ]; then
                build_maven "$file"
            else
                search_maven "$file"
            fi
        fi
    done
}

# Function to recursively search for Gradle projects
search_gradle() {
    for file in "$1"/*; do
        if [ -d "$file" ]; then
            if [ -f "$file/build.gradle" ]; then
                build_gradle "$file"
            else
                search_gradle "$file"
            fi
        fi
    done
}

# Main function
main() {
    search_maven .
    search_gradle .
}

# Run main function
main
