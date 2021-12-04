package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 전략을 파라미터로 전달받는 방식
 */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        Long startTime = System.currentTimeMillis();
        strategy.call();
        Long endTime = System.currentTimeMillis();

        log.info("resultTime={}", endTime - startTime);
    }
}
