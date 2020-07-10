#!/usr/bin/env groovy
@NonCPS

def call(branch, url) {

    
  def branchName = branch
   def urllink = url
    echo "aaa"
    
    echo "$branchName"
     echo  "hello world"
    echo "$urllink"
    checkout([
        $class: 'GitSCM',
     
        branches: [[name: "$branchName" ]],
        userRemoteConfigs: [[ url: "$urllink" ]]
    ])
}
