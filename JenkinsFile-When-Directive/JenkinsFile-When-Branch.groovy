pipeline{
    agent any
    stages{
        stage('Code_checkout'){
            steps{
                echo "Checkingout the source code from the remote repo with ${env.BRANCH_NAME}"
                git branch: 'main', url: 'https://github.com/Sk93804/Jenkins-Pipeline-Directives.git'
            }
        }
        stage('Tests'){
            parallel{
                stage('Unit_Test'){
                    when{
                        branch 'main'
                    }
                    steps{
                        echo "executing the unit tests"
                    }
                }
                stage('Functon_test'){
                    when{
                        branch 'Feat/*'
                    }
                    steps{
                        echo "Executing the functional tests"
                    }
                }
            }
        }
    }
}