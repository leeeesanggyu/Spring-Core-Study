package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status = trace.begin("Hello1");
        TraceStatus status2 = trace.begin("Hello2");
        TraceStatus status3 = trace.begin("Hello3");
        trace.end(status3);
        trace.end(status2);
        trace.end(status);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status = trace.begin("Hello1");
        TraceStatus status2 = trace.begin("Hello2");
        TraceStatus status3 = trace.begin("Hello3");
        trace.exception(status3, new IllegalStateException());
        trace.exception(status2, new IllegalStateException());
        trace.end(status);
    }
}