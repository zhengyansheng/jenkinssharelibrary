#!/usr/bin/env groovy

package src

def BuildImage(namespace, serviceName, imageTag) {

    sh """
        echo docker build -t xxx/xt-ssr-web-cosmos:1.0 .
        echo docker push xxx/xt-ssr-web-cosmos:1.0
    """
}