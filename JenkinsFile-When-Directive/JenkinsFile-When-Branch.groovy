pipeline{
    agent any
    options{
        buildDiscarder(logRotator(numToKeepStr: '5'))
        timestamps()
    }
    environment {
        BRANCH = 'main'
    }
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
                        expression{ env.BRANCH == 'main'}
                    }
                    steps{
                        echo "executing the unit tests"
                    }
                }
                stage('Function_test'){
                    //Note: The branch keyword inside 'when' block works only for the Multipipeline branches.
                    // Branch name is injected to  the jenkins built in var called "BRANCH_NAME"
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