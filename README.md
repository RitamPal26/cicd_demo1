# cicd_demo1

This repository demonstrates a comprehensive CI/CD implementation using Git, Jenkins, and Spring Boot. It showcases multi-team collaboration through GitFlow branching strategy and automated build and deployment processes.

## Project Structure

cicd_demo1/
├── src/
│   ├── main/java/com/demo/application/
│   │   └── DemoApplication.java
│   └── test/java/com/demo/application/
│       └── DemoApplicationTests.java
├── build.gradle
├── Jenkinsfile
└── README.md

## Features
GitFlow Branching Strategy: Structured approach to collaborative development

Jenkins Pipeline: Multi-stage CI/CD process with automated testing

Security Implementation: Demonstrates security hotfix workflow

Environment-Specific Deployments: Targeted deployments based on branch type

## Branching Strategy
This project follows the GitFlow branching model:

main: Production-ready code

develop: Integration branch for feature development

feature/*: Individual feature implementations

hotfix/*: Critical fixes for production issues

release/*: Preparation for new production releases

## CI/CD Pipeline
The Jenkins pipeline includes the following stages:

Checkout: Retrieves source code from Git

Build: Compiles and packages using Gradle

Test: Runs automated tests

Archive: Stores build artifacts

Deploy to Dev: Deploys to development environment (from develop branch)

Deploy to Staging: Deploys to staging environment (from release branches)

Deploy to Production: Deploys to production environment (from main branch)
