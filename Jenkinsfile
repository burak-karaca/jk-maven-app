#!/usr/bin/env groovy
// CODE_CHANGES = getGitChanges()

pipeline {
    agent none
    parameters { // exp. select which version you want to deploy on gui
        // string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    // tools {  //provides build tools for your project
    //     maven 'Maven' // in global tool conf. you need to provide
    // }
    // environment { // to define your own environmental variables
    //     NEW_VERSION = '1.3.0'  
    //     SERVER_CREDENTIALS = credentials('testing-env-variable') // takes the ID & you need Credentials Binding plugin!
    // }
    stages {
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                    // echo "version ${NEW_VERSION}"
                }
            }
        }
        stage('test') {
            when {
                expression {
                    params.executeTests == true 
                }
            }
            // when {
                // expression {
                    // BRANCH_NAME == 'dev' // only executed if the current branch is DEV 
                    // BRANCH_NAME == 'dev' || BRANCH_NAME == 'master'
                    // BRANCH_NAME == 'dev' && CODE_CHANGES == true
                // }
            // }
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                    echo "deploying version ${VERSION}"
                    //echo "deploying with ${SERVER_CREDENTIALS}"  //when you define it in env variable
                    //sh "${SERVER_CREDENTIALS}" // when you define it in env variable
                    //withCredentials([ //instead of defining in the env variable. you can define it here
                    //    usernamePassword(credentials: 'testing-env-variable', usernameVariable: USER, passwordVariable: PWD)
                    //]) {
                    //    sh "some script ${USER} ${PWD}"
                    //}
                }
            }
        }
    }

    // post {
    //     always {
    //         // doesn't matter if build failed or succeed, its always executed
    //     }
    //     success {
    //         // relevant only when succeed
    //     }
    //     failure {
    //         // relevant only when failed
    //     }
    // }
}
