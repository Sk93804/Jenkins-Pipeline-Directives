pipeline {
    agent any 
    parameters {
        string(name: 'DB_NAME', defaultValue: 'production', description: 'Choose the database name')
        booleanParam(name: 'CONFIRM_MIGRATION', defaultValue: true, description: 'Do you want to migrate?')
    }
    stages {
        stage('Database Migration') {
            when {
                expression { 
                    return params.DB_NAME == 'production' && params.CONFIRM_MIGRATION.toBoolean() 
                }
            }
            steps {
                echo "Executing database migration in ${params.DB_NAME}"
            }
        }

        stage('Skipping Migration Notification') {
            when {
                expression { 
                    return !(params.DB_NAME == 'production' && params.CONFIRM_MIGRATION.toBoolean())
                }
            }
            steps {
                echo "Skipping migration: Criteria not met for ${params.DB_NAME}"
            }
        }
    }
}