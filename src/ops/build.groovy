#!/usr/bin/env groovy

package src


def CodeTypeMain(env, codeType, serviceName) {
    switch(codeType.toLowerCase()) {
        case 'java':
            runCodeTypeJava(env, serviceName)
            break
        case 'nodejs':
            runCodeTypeNodeJs(env, serviceName)
            break
        case 'common':
            runCodeTypeCommon(env, serviceName)
            break
        case 'go':
            runCodeTypeGo(env, serviceName)
            break
        case 'python':
            runCodeTypePython(env, serviceName)
            break
        default:
            error("Unsupported code type: ${codeType}")
    }
}

// java 代码类型构建
def runCodeTypeJava(env, serviceName) {
    echo "开始 Java 构建: ${serviceName}"
    sh 'chmod +x ./gradlew'
    sh './gradlew clean build'
}

// nodejs 代码类型构建
def runCodeTypeNodeJs(serviceName) {

}

// common 代码类型构建
def runCodeTypeCommon(serviceName) {

}

def runCodeTypeGo(env, serviceName) {
    echo "开始 Go 构建: ${serviceName}"
    sh "ls -l" // 可选，调试用，查看当前目录内容
    sh "go mod tidy" // 确保依赖拉取
    sh "go build -o ${serviceName} main.go"
}

def runCodeTypePython(env, serviceName) {
    echo "开始 Python 构建: ${serviceName}"
    sh 'python -m pip install -r requirements.txt'
}