import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.gitHubRelease
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2025.07"

project {

    vcsRoot(HttpsGithubComMarimargaryan86parallelTestsGit)

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        gitHubRelease {
            name = "mono2"
            id = "mono"
            enabled = false
            targetVcsRootId = "SampleMonorepoTc_HttpsGithubComMarimargaryan86parallelTestsGit"
            tagName = "mono2"
            latest = true
            authType = vcsRoot()
        }
    }

    triggers {
        vcs {
        }
    }
})

object HttpsGithubComMarimargaryan86parallelTestsGit : GitVcsRoot({
    name = "https://github.com/marimargaryan86/parallel-tests.git"
    url = "https://github.com/marimargaryan86/parallel-tests.git"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "marimargaryan86"
        password = "credentialsJSON:50c80707-6bd4-4674-a601-522df8ad2c5a"
    }
})
