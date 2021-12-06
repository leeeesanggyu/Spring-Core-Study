package hello.advanced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {

        Long startTime = System.currentTimeMillis();
        callback.call();
        Long endTime = System.currentTimeMillis();

        log.info("resultTime={}", endTime - startTime);
    }
}
