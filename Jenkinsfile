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
        		sh "docker build -t liammcivor/vehicle-project:$BUILD_NUMBER -t liammcivor/vehicle-project:latest ."
        	}
        }
        stage('--dockerhub-push--') {
        	steps {
        		withDockerRegistry([ credentialsId: "dockerhub-Liam", url: "" ]) {
        			sh "docker push liammcivor/vehicle-project:$BUILD_NUMBER"
                    sh "docker push liammcivor/vehicle-project:latest"
        		}
        	}
        }
        stage('--test-deploy--') {
            steps {
            	sh "ssh -T -i /home/jenkins/key.pem ubuntu@ec2-18-130-253-83.eu-west-2.compute.amazonaws.com ./vehicle-docker-be.sh"
            }
        }
        stage('--deploy--') {
            steps {
                sh "mvn deploy"
            }
        }
    }
}
