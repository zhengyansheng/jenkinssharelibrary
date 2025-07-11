#!/usr/bin/env groovy

package src

def BuildImage(namespace, serviceName, imageTag) {

    sh """
        echo docker build -t xxx/xx:1.0 .
    """
}