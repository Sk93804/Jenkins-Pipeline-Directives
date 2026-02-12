pipeline {
    agent any 
    parameters {
        booleanParam(name: 'SKIP_UNIT_TESTS', 
                     defaultValue: false, 
                     description: 'Do you want to skip the tests?')
        booleanParam(name: 'SKIP_PERFORMENCE_TESTS'
                     defaultValue: false 
                     description: 'Do you want to skip the performence tests?') 
    }
    stages {
        stage('checkout') {
            steps {
                echo "checking out the source code"
            }
        }

        stage('Tests') {
            parallel{
                stage('Unit-test'){
                    when{
                        expression{ params.SKIP_UNIT_TESTS.toBoolean() == false }
                    }
                    steps{
                        echo "executing the unit tets"
                    }
                }
                stage('Performence-test'){
                    when{
                        expression{ params.SKIP_PERFORMENCE_TESTS.toBoolean() == false}
                    }
                    steps{
                        echo "Executing the performence tests"
                    }
                }
            }
        }
    }
}