#!/usr/bin/env groovy

package src

def CheckoutCode(gitUrl, branch) {
    // Clean workspace before checking out code
    deleteDir()
    checkout scmGit(
        // userRemoteConfigs: [[credentialsId:  'git_pull_secret', url: gitUrl]],
        userRemoteConfigs: [[url: gitUrl]],
        branches: [[name: branch]]
    )
}
