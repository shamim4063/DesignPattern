package io.hmshamim.template;

public abstract class Task {
    private AuditTrial auditTrial;
    public Task(){
        this.auditTrial= new AuditTrial();
    }
    public void execute(){
        auditTrial.record();
        doExecute();
    }
    protected abstract void doExecute();
}
