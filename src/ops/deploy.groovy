#!/usr/bin/env groovy

package src

def DeployToCluster(namespace, serviceName, imageTag) {

    script {
    // def imageTag = "myrepo/${serviceName}:${params.branch}-${env.BUILD_ID}"
    // def namespace = params.env

    sh """
        echo kubectl set image deployment/${serviceName} ${serviceName}=${imageTag} -n ${namespace}
        echo kubectl rollout status deployment/${serviceName} -n ${namespace}
    """
    }
}


def RollbackFromCluster(namespace, serviceName, imageTag) {
    sh """
        echo kubectl set image deployment/${serviceName} ${serviceName}=${imageTag} -n ${namespace}
        echo kubectl rollout status deployment/${serviceName} -n ${namespace}
    """
}