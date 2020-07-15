#!/usr/bin/groovy
def call(sonarorganization,sonarprojectKey,sonarprojectName) 
  def SCANNER_HOME = tool 'sonar scanner'
  withSonarQubeEnv('sonar') {
    sh "${SCANNER_HOME}/bin/sonar-scanner \
                -Dsonar.host.url=https://sonarcloud.io/ \
                -Dsonar.login = 2ccda422b3b6c622bf06b58f5ffeb6402b79bdbd \
                -Dsonar.organization=${sonarorganization} \
                -Dsonar.projectKey=${sonarProjectkey} \
                -Dsonar.projectName=${sonarProjectname} \
                -Dsonar.projectVersion=1.0 \
                -Dsonar.sources=. \
                -Dsonar.language=java \
                -Dsonar.java.binaries=. \
                -Dsonar.java.coveragePlugin=jacoco \
                -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/*.xml \
                -Dsonar.exclusions=**/*.html,**/*.css,**/*.js,src/test/java/com/javatechie/StringPalindrome/AppTest.java \
                -Dsonar.sourceEncoding=UTF-8"
    }  
}
     
