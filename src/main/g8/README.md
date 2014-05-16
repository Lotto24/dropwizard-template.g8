$name$
==================

Welcome to your new dropwizard service!


##Usage
###Jenkins jobs
Run

    ./gradlew updateJenkinsJobs

**once** only to auto-generated Jenkins jobs for your service.
One of the jobs generated is a meta job *'Create Jobs for $name$'* which will watch for changes to the job configuration in jenkins.gradle and apply them automatically.
So, no need to run ./gradlew updateJenkinsJobs manually again.

See [Gradle-Jenkins-Plugin][gjp] and [Jenkins Job DSL plugin][jjdp] for more information about how to configure the jobs.


[gjp]: https://github.com/ghale/gradle-jenkins-plugin
[jjdp]: https://github.com/jenkinsci/job-dsl-plugin/wiki/Job-DSL-Commands
