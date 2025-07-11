#!/usr/bin/env groovy

package src

// CheckoutCode 克隆代码
def CheckoutCode(gitUrl, branch) {
    // Clean workspace before checking out code
    deleteDir()
    checkout scmGit(
        // userRemoteConfigs: [[credentialsId:  'git_pull_secret', url: gitUrl]],
        userRemoteConfigs: [[url: gitUrl]],
        branches: [[name: branch]]
    )
}

