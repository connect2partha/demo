pipeline {
	agent any
	tools {
        jdk 'openjdk17'
    }
    environment {
        ARTIFACTORY_ACCESS_TOKEN = credentials('artifactory-access-token')
        JFROG_PASSWORD = credentials('jfrog-password')
    }
	stages {
		stage('Build'){
			steps {
                withMaven(maven : 'apache-maven-3.8.5') {
                    bat 'mvn clean install -DskipTests'
                }
			}
		}
		stage('Test'){
			steps{
                withMaven(maven : 'apache-maven-3.8.5') {
                    bat 'mvn test'
                }
			}
		}
		stage('Upload to jFrog Repository'){
            steps{
                sh 'jf rt upload --url http://localhost:8082/artifactory/ --access-token ${ARTIFACTORY_ACCESS_TOKEN} target/demo-0.0.1-SNAPSHOT.jar test_repository/'
            }
		}
		stage('Deploy') {
			steps {
			    withMaven(maven : 'apache-maven-3.8.5') {
                    bat 'mvn jar:jar deploy:deploy'
                }
			}
		}
	}
}