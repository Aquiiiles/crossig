package hr.crosig.common.ws.response;

/**
 * @author Leonardo Miyagi
 */
public class ServiceResponse {

	public ServiceResponse(int code, String content) {
		_code = code;
		_content = content;
	}

	public int getCode() {
		return _code;
	}

	public String getContent() {
		return _content;
	}

	private int _code;
	private String _content;

}