pipeline {
    agent any
    
    tools {
        gradle 'Gradle'  // Changed from 'Gradle 7.4.2'
        jdk 'JDK11'      // Changed from 'JDK 11' (removed the space)
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        
        stage('Test') {
            steps {
                sh './gradlew test'
            }
            post {
                always {
                    junit '**/build/test-results/test/*.xml'
                }
            }
        }
        
        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }
        
        stage('Deploy to Dev') {
            when {
                branch 'develop'
            }
            steps {
                echo "Deploying to Development environment"
                // In a real scenario, you would use deployment scripts here
            }
        }
        
        stage('Deploy to Staging') {
            when {
                branch 'release/*'
            }
            steps {
                echo "Deploying to Staging environment"
                // In a real scenario, you would use deployment scripts here
            }
        }
        
        stage('Deploy to Production') {
            when {
                branch 'main'
            }
            steps {
                echo "Deploying to Production environment"
                // In a real scenario, you would use deployment scripts here
            }
        }
    }
    
    post {
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
