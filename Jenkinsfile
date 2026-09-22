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
                bat 'call "C:/Users/Universal/Downloads/apache-maven-3.9.16-bin/apache-maven-3.9.16/bin/mvn.cmd" clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'call "C:/Users/Universal/Downloads/apache-maven-3.9.16-bin/apache-maven-3.9.16/bin/mvn.cmd" test'
            }
        }

        stage('Docker Build') {
            steps {
                bat '"C:/Users/Universal/AppData/Local/Programs/DockerDesktop/resources/bin/docker.exe" build -t calculator-app .'
            }
        }

        stage('Deploy') {
            steps {
                bat '"C:/Users/Universal/AppData/Local/Programs/DockerDesktop/resources/bin/docker.exe" stop calculator-container || echo No old container'
                bat '"C:/Users/Universal/AppData/Local/Programs/DockerDesktop/resources/bin/docker.exe" rm calculator-container || echo No old container'
                bat '"C:/Users/Universal/AppData/Local/Programs/DockerDesktop/resources/bin/docker.exe" run -d -p 8080:8080 --name calculator-container calculator-app'
            }
        }
    }
}
