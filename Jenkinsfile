pipeline {
  agent any
  stages {
<<<<<<< HEAD
    stage('Build Dev') {
      parallel {
        stage('Build Dev') {
=======
	  
	  
        stage('Test Run On Dev') {
>>>>>>> 96812ca6d3e4d2789d88cae645556d2a55a5fbd6
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

      }
    }

    stage('Build QA') {
      parallel {
        stage('Build QA') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

        stage('firefox') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=firefox'
          }
<<<<<<< HEAD
        }

      }
    }

    stage('Build Stage') {
      parallel {
        stage('Build Stage') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('firefox') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=firefox'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

        stage('safari') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=safari'
          }
        }

      }
    }

    
    stage('Publish reports') {
           steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: '/allure-results']]
                    ])
                }
            }
        }
    
    

  }
  tools {
    maven 'M3'
  }
}
=======
        }         
      
		stage('final'){
		  steps{
      		sh 'echo "test execution is done"'
      	  }
      	}
      	
    }
}
      

      
>>>>>>> 96812ca6d3e4d2789d88cae645556d2a55a5fbd6
