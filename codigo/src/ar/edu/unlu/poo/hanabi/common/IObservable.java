package ar.edu.unlu.poo.hanabi.common;
import hanabi.model.Event;
/** Contrato de suscripción y notificación de observadores. */
public interface IObservable {
    void addObserver(IObserver observer);
    void notify(Event event);
}
