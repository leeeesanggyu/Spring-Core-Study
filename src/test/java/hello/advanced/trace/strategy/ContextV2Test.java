package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     */
    @Test
    void strategy() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }

    /**
     * 익명 내부 클래스 사용
     */
    @Test
    void strategy2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직1 실행");
            }
        });

        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직2 실행");
            }
        });
    }

    /**
     * lambda 사용
     */
    @Test
    void strategy3() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(() -> log.info("비지니스 로직1 실행"));
        contextV2.execute(() -> log.info("비지니스 로직2 실행"));

    }
}
