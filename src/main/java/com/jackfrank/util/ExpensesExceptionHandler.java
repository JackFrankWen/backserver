package com.jackfrank.util;

import com.jackfrank.exception.ExpensesException;
import com.jackfrank.exception.MultipleTaskException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 17-12-28.
 */
public class ExpensesExceptionHandler {
    public static List<String> getExcetionError(final Exception e){
        final List<String> excessoes= new ArrayList<>();
        if (e instanceof MultipleTaskException) {
            final MultipleTaskException me = (MultipleTaskException) e;
            for (final ExpensesException exception : me.getExceptions()) {
                excessoes.add(exception.getMessage());
            }
        }else if (e instanceof ExpensesException){
            final ExpensesException exception = (ExpensesException) e;
            excessoes.add(exception.getMessage());
        }else{
            excessoes.add("erro generico");
        }
        return excessoes;
    }
}
