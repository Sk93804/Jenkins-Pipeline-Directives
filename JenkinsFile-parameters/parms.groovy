pipeline {
    agent any 
    parameters {
        booleanParam(name: 'SKIP_TESTS', 
        defaultValue: false, 
        description: 'Do you want to skip the tests?')
    }
    stages {
        stage('checkout') {
            steps {
                echo "checking out the source code"
            }
        }

        stage('Tests') {
            when {
                expression { 
                    params.SKIP_TESTS == true
                }
            }
            parallel{
                stage('Unit-test'){
                    steps{
                        echo "executing the unit tets"
                    }
                }
                stage('Performence-test'){
                    steps{
                        echo "Executing the performence tests"
                    }
                }
            }
        }
    }
}