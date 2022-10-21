#!/usr/bin/env groovy


// global level scope
// @Library('jenkins-shared-library@branch-name')
@Library('jenkins-shared-library')

// below is project level scope
// library identifier: 'jenkins-shared-library@main', retriever: modernSCM(
//         [$class: 'GitSCMSource',
//         remote: 'https://github.com/burak-karaca/jenkins-shared-library',
//         credentialsId: 'burak-karaca'
//         ]
)

def gv
pipeline {
    agent any
    tools {
        maven 'maven-3.8.6'
    }
    stages {
         stage("init"){
            steps {
                script {
                    gv = load 'pipelinejob.groovy'
                }
            }
         }
         stage("build jar"){
            steps {
                script {
                    buildJar()
                }
            }
         }
         stage("build and push image"){
            steps{
                script{
                    buildImage 'burakaraca/demo-app:jma-3.0'
                    dockerLogin()
                    dockerPush 'burakaraca/demo-app:jma-3.0'
                }
            }
         }
         stage("deploy"){
            steps{
                script{
                    gv.deployApp()
                }
            }
         }
    }
}