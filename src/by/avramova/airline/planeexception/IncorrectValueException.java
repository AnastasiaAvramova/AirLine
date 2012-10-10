/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.avramova.airline.planeexception;

/**
 *
 * @author tot
 */
public class IncorrectValueException extends Throwable {
    public IncorrectValueException()
    {
        super();
    }
    public IncorrectValueException(String gripe)
    {
        super(gripe);
    }
}
