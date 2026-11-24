pipeline {
    agent any

    tools {
        maven 'Maven3'   // name configured in Jenkins > Global Tool Configuration
        jdk 'JDK17'
    }

    triggers {
        cron('H 2 * * 1-5')   // nightly run on weekdays
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Run Tests') {
            steps {
                // Flipkart may block headless browsers; use an agent with a display (xvfb) if needed
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/extent-report/**, target/cucumber-reports/**', allowEmptyArchive: true
        }
    }
}
