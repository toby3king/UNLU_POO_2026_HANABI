package ar.edu.unlu.poo.hanabi.common;
import hanabi.model.Event;


/** Contrato de los objetos interesados en los cambios del modelo. */
public interface IObserver {
    void update(Event event);
}
