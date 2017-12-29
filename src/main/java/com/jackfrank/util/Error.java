package com.jackfrank.util;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jack on 17-12-27.
 */
public class Error implements Serializable {

    private static final long serialVersionUID = 6457740208480413838L;
    private int cod;
    private List<String> error;

    public int getCod() {
        return cod;
    }
    public void setCode(final int cod) {
        this.cod = cod;
    }
    public Error(final int cod, final List<String> error) {
        super();
        this.cod = cod;
        this.error = error;
    }
    public List<String> getError() {
        return error;
    }
    public void setError(final List<String> error) {
        this.error = error;
    }
}
