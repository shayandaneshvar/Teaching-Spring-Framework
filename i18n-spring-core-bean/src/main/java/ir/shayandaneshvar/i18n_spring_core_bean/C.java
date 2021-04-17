package ir.shayandaneshvar.i18n_spring_core_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "c")
public class C {

    private D d;

    @Autowired
    public C(D d) {
        this.d = d;
    }

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }
}
