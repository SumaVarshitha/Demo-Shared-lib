#!/usr/bin/env groovy
@NonCPS

def call()
{
  sh 'mvn clean install'
  //  sh 'mvn clean package'
} 

