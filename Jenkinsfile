pipeline {
  agent any

  options {
    disableConcurrentBuilds()
    buildDiscarder logRotator(daysToKeepStr: '30')
  }

  stages {
    stage('Build') {
      steps {
        sh './gradlew clean assemble'
      }
    }

    stage('Test') {
      steps {
        sh './gradlew test'
      }
    }
  }

  post {
    cleanup { cleanWs() }
  }
}
