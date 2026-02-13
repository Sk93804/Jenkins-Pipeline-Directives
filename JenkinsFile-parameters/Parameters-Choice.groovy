pipeline{
    agent any 
    parameters{
        choice(name: 'ENVs', choices: ['DEV', 'UAT', 'PROD'], description: 'Choose the different environments')
    }
    stages{
        stage('Deployment'){
            steps{
                script{
                    switch(params.ENVs) {
                        case 'DEV':
                            echo "Deploying the source code in Development environment"
                        break
                        case 'UAT':
                            echo "Deploying the source code in Staging environment"
                        break
                        case 'PROD':
                            echo "Deploying the source code in Production environment"
                        break
                    }
                }
            }
        }
    }
}