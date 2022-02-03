package hr.crosig.contact.exception;

/**
 * @author Guilherme Kfouri
 */
public class CityException extends Exception {

	public CityException() {
	}

	public CityException(String msg) {
		super(msg);
	}

	public CityException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public CityException(Throwable throwable) {
		super(throwable);
	}

}