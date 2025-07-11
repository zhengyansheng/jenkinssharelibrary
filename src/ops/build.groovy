#!/usr/bin/env groovy

package src


def CodeTypeMain(env, codeType, serviceName) {

    switch(codeType.toLowerCase()) {
        case 'java':
            runCodeTypeJava(env, serviceName)
            break
        case 'nodejs':
            if (serviceName == 'xt-web-index') {
                runCodeTypeNodeJs_xt_web_index(env, serviceName)
            } else if (serviceName == 'xt-web-micro-header') {
                runCodeTypeNodeJs_xt_web_micro_header(env, serviceName)
            } else {
                runCodeTypeNodeJs(env, serviceName)
            }
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
    sh '''
        chmod +x ./gradlew
        ./gradlew --no-daemon clean ${serviceName}:build -x test
    '''
}

// nodejs 代码类型构建
def runCodeTypeNodeJs(env, serviceName) {
    echo "开始 Nodejs 构建: ${serviceName}"
    sh '''
        source ~/.nvm/nvm.sh && nvm install 14.15.1 && nvm use && npm -v && node -v
        npm install --unsafe-perm --registry=https://registry.npmjs.org && npm run build
    '''
}

// xt-web-trade-ssr
def runCodeTypeNodeJs_xt_web_index(env, serviceName) {
    echo "开始 Nodejs 构建: ${serviceName}"
    sh '''
        npm install --registry=http://maven-pub.hmswork.space:99/repository/npm-group/
        npm run lokalise && sh env.sh ${env} && npm run build && npm run build:prod
    '''
}

def runCodeTypeNodeJs_xt_web_micro_header(env, serviceName) {
    echo "开始 Nodejs 构建: ${serviceName} (micro-header 特殊处理)"
    sh '''
        npm install --registry=https://registry.npmjs.org
        npm run build
    '''
}

// common 代码类型构建
def runCodeTypeCommon(serviceName) {

}

def runCodeTypeGo(env, serviceName) {
    echo "开始 Go 构建: ${serviceName}"
    sh '''
        ls -l
        go mod tidy
        go build -o ${serviceName} main.go
    '''
}

def runCodeTypePython(env, serviceName) {
    echo "开始 Python 构建: ${serviceName}"
}

