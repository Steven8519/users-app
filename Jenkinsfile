pipeline {
  environment {
    imagename = "steven8519/user-service"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }

  agent any
  stages {
    stage('Chechout') {
      steps {
        git([url: 'https://github.com/Steven8519/users-app.git', branch: 'master', credentialsId: 'github'])

      }
    }

    stage('Maven Build') {
        steps{
           script {
              sh " mvn clean install -P prod -X"
            }
        }
    }

    stage('Maven Test') {
        steps{
           script {
             sh " mvn test"
            }
         }
    }

    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build imagename
        }
      }
    }
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push("$BUILD_NUMBER")
             dockerImage.push('latest')

          }
        }
      }
    }

    stage("Deploy To Kuberates Cluster") {
       steps {
           sh 'kubectl apply -f deployment.yml'
        }
     }

    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $imagename:$BUILD_NUMBER"
         sh "docker rmi $imagename:latest"

      }
    }
  }
}