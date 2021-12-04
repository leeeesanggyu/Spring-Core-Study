package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        Long startTime = System.currentTimeMillis();
        log.info("비지니스 로직1 실행 !");
        Long endTime = System.currentTimeMillis();

        log.info("resultTime={}", endTime - startTime);
    }

    private void logic2() {
        Long startTime = System.currentTimeMillis();
        log.info("비지니스 로직2 실행 !");
        Long endTime = System.currentTimeMillis();

        log.info("resultTime={}", endTime - startTime);
    }

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategyLogic3 = new Strategy(){

            @Override
            public void call() {
                log.info("비지니스 로직 3 실행");
            }
        };

        ContextV1 contextV1 = new ContextV1(strategyLogic3);
        contextV1.execute();

        Strategy strategyLogic4 = new Strategy(){

            @Override
            public void call() {
                log.info("비지니스 로직 4 실행");
            }
        };

        ContextV1 context2 = new ContextV1(strategyLogic4);
        context2.execute();
    }

    /**
     * 전략 패턴 쉽게 사용
     */
    @Test
    void strategyV3() {
        ContextV1 contextV1 = new ContextV1(new Strategy(){
            @Override
            public void call() {
                log.info("비지니스 로직 3 실행");
            }
        });
        contextV1.execute();

        ContextV1 context2 = new ContextV1(new Strategy(){
            @Override
            public void call() {
                log.info("비지니스 로직 4 실행");
            }
        });
        context2.execute();
    }

    /**
     * lambda (interface에 메소드가 한개일 경우)
     */
    @Test
    void strategyV4() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("비지니스 로직 3 실행"));
        contextV1.execute();

        ContextV1 context2 = new ContextV1(() -> log.info("비지니스 로직 4 실행"));
        context2.execute();
    }

}
