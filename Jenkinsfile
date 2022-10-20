pipeline {
    agent any
    tool {
        maven 'maven-3.8.6'
    }
    stages {
         stage("build jar"){
            steps {
                script {
                    echo "building the application"
                    sh 'mvn package'
                }
            }
         }
         stage("build image"){
            steps{
                script{
                    echo "building the docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-burak', passwordVariable: 'PASS', usernameVariable: "USER")]){
                        sh 'docker build -t burakaraca/demo-app:jma-1.0 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push burakaraca/demo-app:jma:1.0'
                    }
                }
            }
         }
         stage("deploy"){
            steps{
                script{
                    echo "deploying"
                    
                }
            }
         }
    }
}