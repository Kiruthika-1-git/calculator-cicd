pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t calculator-app .'
            }
        }

        stage('Deploy') {
            steps {
                bat 'docker stop calculator-container || echo No old container'
                bat 'docker rm calculator-container || echo No old container'
                bat 'docker run -d -p 8080:8080 --name calculator-container calculator-app'
            }
        }
    }
}
