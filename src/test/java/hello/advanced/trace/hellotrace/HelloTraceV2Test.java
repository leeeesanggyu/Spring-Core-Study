package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class HelloTraceV2Test {

    @Test
    void begin_end() {
        HelloTraceV2 trace = new HelloTraceV2();

        TraceStatus status = trace.begin("Hello1");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "Hello2");
        TraceStatus status3 = trace.beginSync(status.getTraceId(), "Hello3");
        trace.end(status3);
        trace.end(status2);
        trace.end(status);
    }

    @Test
    void begin_exception() {
        HelloTraceV2 trace = new HelloTraceV2();

        TraceStatus status = trace.begin("Hello1");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "Hello2");
        TraceStatus status3 = trace.beginSync(status.getTraceId(), "Hello3");
        trace.end(status3);
        trace.exception(status2, new IllegalStateException());
        trace.exception(status, new IllegalStateException());
    }
}
