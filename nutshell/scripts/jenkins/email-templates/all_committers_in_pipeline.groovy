def upstreamBuild = null
def cause = build.causes.find {
    if(it instanceof hudson.model.Cause.UpstreamCause) {
        return true 
    }
    return false
}

try {
    while(cause != null) {
        upstreamBuild = hudson.model.Hudson.instance.getItem(cause.upstreamProject).getBuildByNumber(cause.upstreamBuild)
        if(upstreamBuild == null) {
            break;
        }
        cause = upstreamBuild.causes.find {
            if(it instanceof hudson.model.Cause.UpstreamCause) {
                return true 
            }
            return false
        }
    }   
} catch(e) {

}


committers = []

if(upstreamBuild != null && upstreamBuild.changeSet != null) {
    upstreamBuild.changeSet.each() { cs ->
        if(cs.committerEmail != null) {
            committers.add(cs.committerEmail)
        }
    }
}

committers.unique().join(',')