package ir.shayandaneshvar.util;

import ir.shayandaneshvar.aop.MyAnnotation;

@MyAnnotation
public class Triple<T, R, U> {
    private final T t;
    private final R r;
    private final U u;

    public Triple(T t, R r, U u) {
        this.t = t;
        this.r = r;
        this.u = u;
    }

    public T getFirst() {
        return t;
    }

    public R getSecond() {
        return r;
    }

    public U getThird() {
        return u;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "t=" + t +
                ", r=" + r +
                ", u=" + u +
                '}';
    }
}
