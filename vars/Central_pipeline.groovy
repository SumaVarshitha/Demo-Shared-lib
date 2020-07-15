#!/usr/bin/env groovy
def call(branchName,urllink,dockerimage,mavenBuild,sonarorganization,sonarprojectKey,sonarprojectName){
        pipeline {
            agent any
            tools {
                   maven 'Maven_Home'
            }
            stages {
               
                stage('CleanUp'){
                    steps{
                         deleteDir()
                    }
                }
                stage('Code Checkout'){
                    steps{
                           gitCheckout(branchName,urllink)
                    }
                }
               
                stage('Build_In_Container'){
                    steps{
                            maven_build(dockerimage,mavenBuild)
                    }
                }
                stage('SonarStage'){
                    steps{
                       sonar_analyse(sonarorganization,sonarprojectKey,sonarprojectName)
                    }
                }
                stage('QualityGate'){
                    steps{
                       sonar_quality_gate()
                    }
                }
            }
      }
}
