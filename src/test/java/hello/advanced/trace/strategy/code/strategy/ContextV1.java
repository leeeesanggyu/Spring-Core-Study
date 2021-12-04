package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 필드에 전략을 보관하는 방식
 */
@Slf4j
public class ContextV1 {

    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        Long startTime = System.currentTimeMillis();
        strategy.call();
        Long endTime = System.currentTimeMillis();

        log.info("resultTime={}", endTime - startTime);
    }
}
