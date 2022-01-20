import jenkins.model.JenkinsLocationConfiguration
import hudson.model.Descriptor
jlc = JenkinsLocationConfiguration.get()
jlc.setUrl("DNS_FOR_JENKINS") 
jlc.save()
println(jlc.getUrl())