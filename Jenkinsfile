pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('--test--') {
            steps {
                sh "mvn test"
            }
        }
        stage('--package--') {
            steps {
                sh "mvn package"
            }
        }
        stage('--docker-build--') {
        	steps {
        		sh "docker build -t liammcivor/vehicle-project:$BUILD_NUMBER ."
        	}
        }
        stage('--dockerhub-push--') {
        	steps {
        		withDockerRegistry([ credentialsId: "dockerhub-Liam", url: "" ]) {
        			sh "docker push liammcivor/vehicle-project:$BUILD_NUMBER"
        		}
        	}
        }
        stage('--deploy--') {
            steps {
                sh "mvn deploy"
            }
        }
    }
}
