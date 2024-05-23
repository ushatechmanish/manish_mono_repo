#!/bin/bash

# Prompt user for project name and description
read -p "Enter project name: " project_name
read -p "Enter project description: " project_description

# Construct the spring init command with user inputs
spring init \
--boot-version=3.2.6 \
--type=gradle-project \
--java-version=21 \
--packaging=jar \
--name="$project_name" \
--package-name="com.example.$project_name" \
--groupId=in.ushatech \
--dependencies=web,webflux,actuator,lombok \
--version=0.0.1-SNAPSHOT \
--description="$project_description" \
"$project_name"
