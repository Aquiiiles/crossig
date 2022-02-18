pipeline {
  agent any

  options {
    disableConcurrentBuilds()
    buildDiscarder logRotator(daysToKeepStr: '30')
  }

  stages {
    stage('Build') {
      environment {
        CI = 'false'
      }
      steps {
        sh './gradlew clean build'
      }
    }
  }

  post {
    cleanup { cleanWs() }
  }
}
