#!/usr/bin/groovy
def call() {
  echo "code-coverage-check"
   timeout(time: 4, unit: 'MINUTES') {
      waitForQualityGate abortPipeline: true
    }
}
