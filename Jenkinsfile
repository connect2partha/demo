pipeline {
	agent any
	tools {
        jdk 'openjdk11'
        maven 'jenkins_maven'
    }
    environment {
        ARTIFACTORY_ACCESS_TOKEN = credentials('artifactory-access-token')
        JFROG_PASSWORD = credentials('jfrog-password')
    }
	stages {
		stage('Build'){
			steps {
			    sh 'mvn clean install -e -DskipTests'
			}
		}
		stage('Test'){
			steps {
                sh 'mvn test'
			}
		}
		stage('Upload to jFrog Repository'){
            steps {
                sh 'jf rt upload --url http://localhost:8082/artifactory/ --access-token ${ARTIFACTORY_ACCESS_TOKEN} target/demo-0.0.1-SNAPSHOT.jar java-web-app/'
            }
		}
		stage('Deploy') {
			steps {
			    sh 'mvn jar:jar deploy:deploy'
			}
		}
	}
}