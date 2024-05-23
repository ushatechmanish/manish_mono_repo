#!/bin/bash

# Default values
default_root_folder="sample-multi-module-project"
default_library_project_names=("api" "util")
default_microservice_project_names=("product-composite-service" "product-service" "recommendation-service" "review-service")
default_microservice_project_descriptions=("product-composite-service" "product-service" "recommendation-service" "review-service")

# Function to create a library project using spring init
create_library_project() {
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
  --dependencies=lombok \
  --version=0.0.1-SNAPSHOT \
  --description="$project_description" \
  "$project_name"
  

  echo "trying to delete Application.java"
  
  # Remove unnecessary files and folders
  rm -f "$project_name/src/main/java/in/ushatech/$project_name/"*.java
  rm -rf "$project_name/src/main/resources"
  rm -rf "$project_name/src/test"

  # Remove unnecessary files
  rm -f "$project_name/.gitignore"
  rm -rf "$project_name/gradle"
  rm -f "$project_name/gradlew"
  rm -f "$project_name/gradlew.bat"

  # Create new build.gradle file
  cat > "$project_name/build.gradle" <<EOL
plugins {
    id 'java'
    id 'io.spring.dependency-management' version '1.1.5'
}

group = 'in.ushatech'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = '21'
}

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

ext {
    springBootVersion = '3.2.6'
}

dependencies {
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    implementation platform("org.springframework.boot:spring-boot-dependencies:\${springBootVersion}")
}

tasks.named('test') {
    useJUnitPlatform()
}
EOL

  echo "Library project created: $project_name"
}

# Function to create a microservice project using spring init
create_microservice_project() {
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
  --dependencies=web,webflux,actuator,lombok \
  --version=0.0.1-SNAPSHOT \
  --description="$project_description" \
  "microservices/$project_name"
}

# Prompt user to accept default values or provide new ones
read -p "Use default root folder name ($default_root_folder)? (y/n): " use_default_root_folder
if [[ "$use_default_root_folder" =~ ^[Nn]$ ]]; then
  read -p "Enter root folder name: " root_folder
else
  root_folder=$default_root_folder
fi

read -p "Use default library project names (${default_library_project_names[*]})? (y/n): " use_default_library_project_names
if [[ "$use_default_library_project_names" =~ ^[Nn]$ ]]; then
  read -p "Enter library project names (space-separated): " -a library_project_names
else
  library_project_names=("${default_library_project_names[@]}")
fi

read -p "Use default microservice project names and descriptions (${default_microservice_project_names[*]})? (y/n): " use_default_microservice_project_names
if [[ "$use_default_microservice_project_names" =~ ^[Nn]$ ]]; then
  read -p "Enter microservice project names (space-separated): " -a microservice_project_names
  read -p "Enter microservice project descriptions (space-separated in the same order): " -a microservice_project_descriptions
else
  microservice_project_names=("${default_microservice_project_names[@]}")
  microservice_project_descriptions=("${default_microservice_project_descriptions[@]}")
fi

# Create root folder if it doesn't exist
mkdir -p "$root_folder"

# Move to the root folder
cd "$root_folder" || exit

# Create each library project
for i in "${!library_project_names[@]}"; do
  create_library_project "${library_project_names[i]}" "${library_project_names[i]}"
done

# Create each microservice project
for i in "${!microservice_project_names[@]}"; do
  create_microservice_project "${microservice_project_names[i]}" "${microservice_project_descriptions[i]}"
done

# Modify settings.gradle to include all projects
cat > settings.gradle <<EOL
rootProject.name = '$root_folder'
EOL

for project in "${library_project_names[@]}"; do
  echo "include '$project'" >> settings.gradle
done

for project in "${microservice_project_names[@]}"; do
  echo "include 'microservices:$project'" >> settings.gradle
done

# Move gradle wrapper files to the root folder from one of the microservice projects
if [ -d "microservices/${microservice_project_names[0]}" ]; then
  cp -rf "microservices/${microservice_project_names[0]}/gradle" .
  cp "microservices/${microservice_project_names[0]}/gradlew" .
  cp "microservices/${microservice_project_names[0]}/gradlew.bat" .
  cp "microservices/${microservice_project_names[0]}/.gitignore" .
fi

# Remove gradle wrapper and .gitignore from each microservice project
for project in "${microservice_project_names[@]}"; do
  rm -rf "microservices/$project/gradle"
  rm "microservices/$project/gradlew"
  rm "microservices/$project/gradlew.bat"
  rm "microservices/$project/.gitignore"
done

echo "Multi-module project setup complete in '$root_folder'. You can build the project from the root folder with ./gradlew build."

