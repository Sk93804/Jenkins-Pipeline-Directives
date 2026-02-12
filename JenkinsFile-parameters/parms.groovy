pipeline{
    agent any 
    parameters{
        string(name: 'DB_NAME', defaultValue: 'production', description: 'Choose the database name')
        booleanParam(name:'CONFIRM_MIGRATION', defaultValue: true , description: 'Do you want to migrate?')
    }
    stages{
        stage('Database Migration'){
            when{
                allOf{ expression {params.DB_NAME == 'production'}
                       expression  {params.CONFIRM_MIGRATION == true }
            }
            steps{
                echo "executing database migration in ${params.DB_NAME}"
            }
        }
    }
    stage('Skipping Migration Notification'){
        when{
            not{
                allOf{
                     expression {params.DB_NAME == 'production'}
                     expression  {params.CONFIRM_MIGRATION == true }
                }
            }
        }
        steps{
            echo " Skipping migration: Criteria not met for ${params.DB_NAME}"
        }
    }
}