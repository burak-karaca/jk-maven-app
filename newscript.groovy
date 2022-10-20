def buildJar() {
    echo "building the application"
    sh 'mvn package'
}

def buildImage() {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-burak', passwordVariable: 'PASS', usernameVariable: "USER")]){
        sh 'docker build -t burakaraca/demo-app:jma-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push burakaraca/demo-app:jma-1.0'
        }
}

def deployApp() {
    echo 'deploy the app..'
}
return this