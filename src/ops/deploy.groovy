#!/usr/bin/env groovy

package src

def DeployToCluster(namespace, serviceName, imageTag) {

    script {
    // def imageTag = "myrepo/${serviceName}:${params.branch}-${env.BUILD_ID}"
    // def namespace = params.env

    echo "🚀 更新 Kubernetes 中 Deployment 的镜像: ${imageTag}"

    sh """
        echo kubectl set image deployment/${serviceName} ${serviceName}=${imageTag} -n ${namespace}
        echo kubectl rollout status deployment/${serviceName} -n ${namespace}
    """
    }
}