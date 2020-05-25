pipeline {
    environment {
        registry = "nisarg20/speproject"
        registryCredential = 'dockerhub'
    }
  agent any

  stages {
    stage('Clean') {
        steps{
             sh 'mvn clean'
             echo "clean"
        }
    }

    stage('Compile') {
        steps{
             sh 'mvn package'
             echo "compile"
        }
    }
    stage('Test') {
        steps{
           sh 'mvn test'
           echo "test"
           }
    }

    stage('Deploy Image to Docker Hub') {
        steps{
            script{

               dockerImage = docker.build registry + ":spe"
               docker.withRegistry( '', registryCredential){
                   dockerImage.push()
               }
            }
        }
    }
    /* stage('Execute Rundeck job') {
             steps {
             logstash{
               script {
                 step([$class: "RundeckNotifier",
                       includeRundeckLogs: true,
                       jobId: "eff9b87e-a8c7-4feb-8031-4f2222f5522f",
                       rundeckInstance: "rundeck",
                       shouldFailTheBuild: true,
                       shouldWaitForRundeckJob: true,
                       tailLog: true])
               }
               }
             }
    } */

  }
}