package com.jackfrank.exception;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jack on 17-12-28.
 */
public class MultipleTaskException extends RuntimeException{

    /**
     * Serial
     */
    private static final long serialVersionUID = 7139972070262446093L;

    /**
     * Lista de excecoes
     */
    private final Set<ExpensesException> exceptions = new HashSet<ExpensesException>();

    /**
     * Constroi uma instancia desta classe.
     *
     * @param message mensagem de erro
     */
    public MultipleTaskException(final ExpensesException message) {
        exceptions.add(message);
    }

    /**
     * Constroi uma instancia desta classe.
     *
     * @param messageList mensagem de erro
     */
    public MultipleTaskException(final Collection<? extends ExpensesException> messageList) {
        exceptions.addAll(messageList);
    }

    public MultipleTaskException() {
        //Construtor padrao
    }


    /**
     * Setter dos parametros para formatacao da mensagem.
     *
     * @param message a mensagem de detalhe
     */
    public void addException(final ExpensesException message) {
        exceptions.add(message);
    }

    /**
     * Setter dos parametros para formatacao da mensagem.
     *
     * @param messageList a mensagem de detalhe
     */
    public void addExceptionList(final Collection<? extends ExpensesException> messageList) {
        exceptions.addAll(messageList);
    }

    public Set<ExpensesException> getExceptions() {
        return exceptions;
    }

    public boolean contains(final ExpensesException ex) {
        return (null != exceptions && !exceptions.isEmpty()) && exceptions.contains(ex);
    }
}
