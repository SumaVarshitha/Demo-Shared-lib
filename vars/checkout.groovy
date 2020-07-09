def call(branch, url) {

    
  def branchName = branch
   def urllink = url
    
    
    echo "$branchName"
    echo "$urllink"
    checkout([
        $class: 'GitSCM',
      //  branches: [[name:  stageParams.branch_name ]],
      //  userRemoteConfigs: [[ url: stageParams.url_name ]]
        
        branches: [[name: branchName ]],
        userRemoteConfigs: [[ url: urllink ]]
    ])
}
