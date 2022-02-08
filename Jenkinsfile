pipeline {
  agent any

  options {
    disableConcurrentBuilds()
    buildDiscarder logRotator(daysToKeepStr: '30')
  }

  stages {
    stage('Build') {
      steps {
        bitbucketStatusNotify(buildState: 'INPROGRESS')
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
    success      { bitbucketStatusNotify(buildState: 'SUCCESSFUL') }
    unsuccessful { bitbucketStatusNotify(buildState: 'FAILED') }
    cleanup      { cleanWs() }
  }
}
