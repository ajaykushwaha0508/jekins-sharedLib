def call(image , tag ){
  withCredentials([usernamePassword(
                 credentialsId:"dockerHubCreds",
                 passwordVariable: "dockerHubPass",
                 usernameVariable: "dockerHubUser"
                )]){ 
            sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass} "
            sh "docker image tag ${image}:${tag} ${env.dockerHubUser}/${image}:${tag}"
            sh "docker push ${env.dockerHubUser}/${image}:${tag}"
        }
}
