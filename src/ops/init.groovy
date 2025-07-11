#!/usr/bin/env groovy

package src

def Init() {

    def startTime = System.currentTimeMillis()
    writeFile file: 'build_start_time.txt', text: "${startTime}"
    echo "构建开始时间（毫秒）已记录: ${startTime}"

}