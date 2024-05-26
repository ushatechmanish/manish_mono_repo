#!/bin/bash

# Function to create a project using spring init
create_project() {
  local project_name=$1
  local project_description=$2

  spring init \
  --boot-version=3.2.6 \
  --type=gradle-project \
  --java-version=21 \
  --packaging=jar \
  --name="$project_name" \
  --package-name="in.ushatech.$project_name" \
  --groupId=in.ushatech \
  --dependencies=webflux,actuator,lombok \
  --version=0.0.1-SNAPSHOT \
  --description="$project_description" \
  "$project_name"
}

# Prompt user for root folder name if not provided
if [ -z "$1" ]; then
  read -rp "Enter root folder name: " root_folder
else
  root_folder=$1
fi

# Create root folder if it doesn't exist
mkdir -p "$root_folder" || {
  echo "Error: Failed to create root folder $root_folder"
  exit 1
}

# Move to the root folder
cd "$root_folder" || {
  echo "Error: Failed to navigate to root folder $root_folder"
  exit 1
}

# Create microservices folder
mkdir -p microservices || {
  echo "Error: Failed to create microservices folder"
  exit 1
}

# Move to the microservices folder
cd microservices || {
  echo "Error: Failed to navigate to microservices folder"
  exit 1
}

# Prompt user for project names and descriptions
read -rp "Enter project names (space-separated): " -a projects
read -rp "Enter project descriptions (space-separated in the same order): " -a descriptions

# Create each project
for i in "${!projects[@]}"; do
  create_project "${projects[i]}" "${descriptions[i]}"
done

# Move back to the root folder
cd ..

# Move gradle wrapper files to the root folder
for project in "${projects[@]}"; do
  cp -rf "microservices/$project/gradle" .
  cp "microservices/$project/gradlew" .
   cp "microservices/$project/gradlew.bat" .
  cp "microservices/$project/.gitignore" .
done

# Remove gradle wrapper from each project
for project in "${projects[@]}"; do
  rm -rfv "microservices/$project/gradle"
  rm -fv "microservices/$project/gradlew"*
  rm -fv "microservices/$project/.gitignore"
done

# Create settings.gradle with all module names
cat > settings.gradle <<EOL
rootProject.name = '$root_folder'
EOL

for project in "${projects[@]}"; do
  echo "include 'microservices:$project'" >> settings.gradle
done

echo "Multi-module project setup complete in '$root_folder'. You can build the project from the root folder with ./gradlew build"
