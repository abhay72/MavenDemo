pipeline 
{
    agent any

    stages 
    {
        stage('checkout')
        {
            steps
            {
                git 'https://github.com/Yj8055/MavenDemo.git'
            }
        }
        stage('build')
        {
            steps
            {
                bat "mvn clean"
            }
        }
        stage('Test')
        {
            steps
            {
                bat "mvn test compile"
            }
        }
        stage('package')
        {
            steps
            {
                bat "mvn package"
            }
        }
        stage('Deploy')
        {
            steps
            {
                bat "mvn deploy"
            }
        }
        stage('sonartest')
        {
            steps
            {
                withSonarQubeEnv('SonarQubeDefault')
                {
                bat 'mvn sonar:sonar'
                }
            }
        }
        stage("Quality Gate") 
        {
            steps
            {
              timeout(time: 1, unit: 'HOURS') 
              {
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
