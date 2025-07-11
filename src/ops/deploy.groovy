#!/usr/bin/env groovy

package src

def DeployToCluster(namespace, serviceName, imageTag) {
    sh """
        echo kubectl set image deployment/${serviceName} ${serviceName}=${imageTag} -n ${namespace}
        echo kubectl rollout status deployment/${serviceName} -n ${namespace}

        
    """

    // 方式 官方文档 https://www.jenkins.io/doc/pipeline/steps/kubernetes-cli/#wrapclass-kubectlbuildwrapper-configure-kubernetes-cli-kubectl-deprecated-use-the-multi-credentials-one-instead
    withKubeConfig([credentialsId: 'user1', serverUrl: 'https://api.k8s.my-company.com']) {
      sh 'kubectl apply -f my-kubernetes-directory'
    }
}


def RollbackFromCluster(namespace, serviceName, imageTag) {
    sh """
        echo kubectl set image deployment/${serviceName} ${serviceName}=${imageTag} -n ${namespace}
        echo kubectl rollout status deployment/${serviceName} -n ${namespace}
    """
}