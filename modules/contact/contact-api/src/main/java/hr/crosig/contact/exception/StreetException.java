package hr.crosig.contact.exception;

/**
 * @author Guilherme Kfouri
 */
public class StreetException extends Exception {

	public StreetException() {
	}

	public StreetException(String msg) {
		super(msg);
	}

	public StreetException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public StreetException(Throwable throwable) {
		super(throwable);
	}

}