pipeline {
    agent any

    stages {
        stage('Get Source Code') {
            steps {
                git branch: 'main', credentialsId: 'bf78fb2b-9bbc-46ed-b96d-e542c3ec4dff', url: 'https://github.com/insiderqabootcampefinalproject/insiderbootcampproject-bahadir223.git'
                echo 'Hello World'
            }
        }
        stage('Build Code')
                {
                    steps{
                        bat script: 'mvn compile'
                    }
                }
        stage('Run Test')
                {
                    steps{
                        bat script: 'mvn test -Dbrowser=localchrome'
                    }
                }
        stage('Publish Report')
                {
                    steps{
                        publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: '', reportFiles: 'target/surefire-reports/index.html', reportName: 'Pipeline Report', reportTitles: ''])
                        publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: '', reportFiles: 'screenshots/', reportName: 'Pipeline ScreenShots', reportTitles: ''])
                    }
                }
    }
}
