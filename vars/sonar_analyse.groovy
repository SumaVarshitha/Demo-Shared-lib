#!/usr/bin/env groovy


def call() {
  def SCANNER_HOME = tool 'sonar scanner'
  withSonarQubeEnv('sonar') {
   sh """
${SCANNER_HOME}/bin/sonar-scanner \
-Dsonar.host.url=https://sonarcloud.io/ \
-Dsonar.login=2ccda422b3b6c622bf06b58f5ffeb6402b79bdbd \
-Dsonar.organization=samlee \
-Dsonar.projectKey=samlee_sonar_analysis \
-Dsonar.projectName=samlee_sonar_analysis \
 -Dsonar.projectVersion=1.0 \
-Dsonar.language=java \
-Dsonar.sources=. \
-Dsonar.tests=src/test \
-Dsonar.junit.reportsPath=target/surefire-reports \
-Dsonar.surefire.reportsPath=target/surefire-reports \
-Dsonar.jacoco.reportPath=target/jacoco.exec \
-Dsonar.exclusions=**/*.html,**/*.css,**/*.js,**/*.xml,src/test/java/com/javatechie/StringPalindrome \
-Dsonar.binaries=target/classes \
-Dsonar.java.coveragePlugin=jacoco \
-Dsonar.sourceEncoding=UTF-8 \


""" 
}

 

 
}
     
