pipeline {
    agent any
    stages {
        stage ('Build Backend') {
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage ('Unit Tests Backend') {
            steps {
                bat 'mvn test'
            }
        }
        stage ('Deploy Backend') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'TomcatLogin', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
            }
        }
        stage ('Download Frontend') {
            steps {
                dir('frontend') {
                git credentialsId: 'github_login' url: 'https://github.com/westorres9/tasks-frontend'
                }
            }
        }
        stage ('Build Frontend') {
            steps {
                dir('frontend') {
                bat 'mvn clean package -DskipTests=true'
                }
            }
        }
        stage ('Unit Tests Frontend') {
            steps {
                dir('frontend') {
                    bat 'mvn test'
                }
            }
        }
        stage ('Deploy Frontend') {
            steps {
                dir('frontend') {
                    deploy adapters: [tomcat8(credentialsId: 'TomcatLogin', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks', war: 'target/tasks-frontend.war'
                }
            }
        }

    }
}
