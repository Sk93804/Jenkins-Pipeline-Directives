pipeline{
    agent any 
    parameters{
        string(name: 'BRANCH',  defaultValue: 'main', description: 'Choose the branch name to build')
    }
    stages{
        stage('Checkout'){
            when{
                expression{ params.BRANCH == 'main'}          
           }
           steps{
            sh 'Checking out the repository with main branch'
           }
        }
    }
}