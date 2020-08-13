package apiBuilders;

import java.util.HashMap;
import java.util.Map;

public class PostAPIBuilder {

	public Map<String, String> postRequestBody() {
		Map<String, String> body = new HashMap<String, String>();
		body.put("firstname", "munirathnam");
		body.put("lastname", "singiri");
		body.put("subjectId", "3");
		return body;
	}
}
