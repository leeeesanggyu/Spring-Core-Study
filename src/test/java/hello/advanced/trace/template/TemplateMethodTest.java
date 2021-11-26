package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodVO() {
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
     * 템플릿 메소드 패턴 적용
     */
    @Test
    void templateMethodV1() {
        AbstractTemplate at1 = new SubClassLogic1();
        AbstractTemplate at2 = new SubClassLogic2();

        at1.execute();
        at2.execute();

    }

    /**
     * 템플릿 메소드 - 익명 내부 클래스 사용
     */
    @Test
    void templateMethodV2() {
        AbstractTemplate at1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비지니스 로직1 실행 !");
            }
        };

        at1.execute();
        // 익명 클래스 이름 확인
        log.info("class name = {}", at1.getClass());

        AbstractTemplate at2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비지니스 로직2 실행 !");
            }
        };

        at2.execute();
        // 익명 클래스 이름 확인
        log.info("class name = {}", at2.getClass());

    }
}
