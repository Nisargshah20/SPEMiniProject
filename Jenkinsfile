pipeline {
    environment {
        registry = "nisarg20/speproject"
        registryCredential = 'dockerhub'
    }
  agent any

  stages {
    stage('Clean') {
        steps{
           logstash{
             sh 'mvn clean'
             echo "clean"
           }
        }
    }

    stage('Compile') {
        steps{
           logstash{
             sh 'mvn package'
             echo "compile"
           }
        }
    }

    stage('Test') {
        steps{
           logstash{
            sh 'mvn test'
            echo "test"
           }
        }
    }

    stage('Deploy Image to Docker Hub') {
        steps{
          logstash{
            script{
               dockerImage = docker.build registry + ":spe"
               docker.withRegistry( '', registryCredential){
                   dockerImage.push()
               }
            }
          }
        }
    }
     stage('Execute Rundeck job') {
         steps {
             logstash{
               script {
                 step([$class: "RundeckNotifier",
                       includeRundeckLogs: true,
                       jobId: "e52690ae-a6ec-47ac-95ef-9ce87e9f4829",
                       rundeckInstance: "Rundeck",
                       shouldFailTheBuild: true,
                       shouldWaitForRundeckJob: true,
                       tailLog: true])
               }
             }
         }
     }
  }
}