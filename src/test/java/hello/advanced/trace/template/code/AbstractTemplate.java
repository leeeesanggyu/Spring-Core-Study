package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        Long startTime = System.currentTimeMillis();
        
        // 로직 실행
        call();
        
        Long endTime = System.currentTimeMillis();
        log.info("resultTime={}", endTime - startTime);
    }

    protected abstract void call();
}
