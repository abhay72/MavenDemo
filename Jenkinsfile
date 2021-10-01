pipeline 
{
    agent any

    stages 
    {
        stage('start') 
        {
            steps 
            {
                echo 'Project starts from here11'
            }
        }
        stage('checkout')
        {
            steps
            {
                checkout([$class: 'GitSCM', branches: [[name: '*/Sonartest']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Yj8055/MavenDemo.git']]])
            }
        }
        stage('build')
        {
            steps
            {
                bat "mvn clean"
            }
        }
        stage('package')
        {
            steps
            {
                bat "mvn package"
            }
        }
        stage('sonartest')
        {
            steps{
                withSonarQubeEnv('SonarQubeDefault') {
                bat 'mvn sonar:sonar'
              }
            }
        }
        stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
        stage('success')
        {
            steps
            {
                echo "project succeeded"
            }
        }
        
    }
}
