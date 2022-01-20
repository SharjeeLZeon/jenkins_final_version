multibranchPipelineJob('Test/Job') {
    branchSources { //provide details for the GH repo where app code/Jenkinsfile and resides
        github {
            scanCredentialsId('<credentials_id>')
            repository('<repo>')
            repoOwner('<owner>')
            buildForkPRHead(true/false)
            buildForkPRMerge(true/false)
            buildOriginBranchWithPR(true/false)
            buildOriginPRHead(true/false)
            id('<RANDOM_ID>')
            includes('<branch>')
        }
    }
    configure {
        it / factory(class: "org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory") << {
            scriptPath("<PATH_TO_JENKINSFILE_FROM_APP_GH_REPO>")
        }     
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(10)
        }
    }
}
