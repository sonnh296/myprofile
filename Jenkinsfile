pipeline {

    agent any

    tools {
        maven 'my-maven'
    }
    environment {
        MYSQL_ROOT_LOGIN = 'mysql-root-login'
        springImageName = "sonnh296/mypro-spring"
        registryCredential = 'dockerhub'
    }
    stages {

        stage('Build with Maven') {
            steps {
                sh 'mvn --version'
                sh 'java -version'
                sh 'echo start building'
                sh 'mvn clean package -DskipTests=true'
            }
        }

        stage('Building image') {
            steps{
                script {
                    dockerImage = docker.build(springImageName, '.')
                }
            }
        }
        stage('Deploy image') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }

        stage('Deploy MySQL to DEV') {
            steps {
                echo 'Deploying and cleaning'
                sh 'docker image pull mysql:8.0'
                sh 'docker network create dev || echo "this network exists"'
                sh 'docker container stop myprofile-mysql || echo "this container does not exist" '
                sh 'echo y | docker container prune '
                sh 'docker volume rm myprofile-mysql-data || echo "no volume"'
                sh "docker run --name myprofile-mysql --rm --network dev -v myprofile-mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_LOGIN_PSW} -e MYSQL_DATABASE=myprofile  -d mysql:8.0 "
                sh 'sleep 20'
                sh "docker exec -i myprofile-mysql mysql --user=root --password=${MYSQL_ROOT_LOGIN_PSW} < script"
            }
        }

        stage('Deploy Spring Boot to DEV') {
            steps {
                echo 'Deploying and cleaning'
                sh 'docker image pull sonnh296/mypro-spring'
                sh 'docker container stop myprofile-springboot || echo "this container does not exist" '
                sh 'docker network create dev || echo "this network exists"'
                sh 'echo y | docker container prune '
                sh 'docker container run -d --rm --name myprofile-springboot -p 8081:8081 --network dev sonnh296/mypro-spring'
            }
        }

    }
    post {
        // Clean after build
        always {
            cleanWs()
        }
    }
}
