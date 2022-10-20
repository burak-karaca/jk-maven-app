#!/usr/bin/env groovy
@Library('jenkins-shared-library')
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
         stage("build image"){
            steps{
                script{
                    buildImage 'burakaraca/demo-app:jma-3.0'
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