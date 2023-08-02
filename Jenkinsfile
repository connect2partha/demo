pipeline {
	agent any
	tools {
        jdk 'openjdk17'
    }
    environment {
        ARTIFACTORY_ACCESS_TOKEN = credentials('artifactory-access-token')
        JFROG_PASSWORD = credentials('jfrog-password')
        mavenHome = tool 'jenkins_maven'
    }
	stages {
		stage('Build'){
			steps {
                bat 'mvn clean install -DskipTests'
			}
		}
		stage('Test'){
			steps{
                bat 'mvn test'
			}
		}
		stage('Upload to jFrog Repository'){
            steps{
                sh 'jf rt upload --url http://localhost:8082/artifactory/ --access-token ${ARTIFACTORY_ACCESS_TOKEN} target/demo-0.0.1-SNAPSHOT.jar java-web-app/'
            }
		}
		stage('Deploy') {
			steps {
			    bat 'mvn jar:jar deploy:deploy'
			}
		}
	}
}