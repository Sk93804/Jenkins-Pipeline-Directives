# JENKINS PARAMETERS:
  Parameters are the dynamic user-based inputs that are passed during the runtime of the pipeline, and the parameters are passed as environment variables; they can be accessed by params ex: params.ENV.

The following are the different types of parameters that Jenkins supports in the pipeline script:

## 1) String: it's  a text-based input 

Common Use cases: 
Versions: 1.2.3, v2-stable
Environment Names: production, staging-blue
Git Branches: feature/login-fix, main
Usernames or API Keys: (Though for keys, we usually use the "Secret Text" type for safety ).
