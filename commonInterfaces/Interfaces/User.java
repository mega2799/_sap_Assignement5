import io.vertx.core.json.JsonObject;

public interface User {
	public String getId();

	public String getName();

	public String getSurname();

	public JsonObject toJson();
}
