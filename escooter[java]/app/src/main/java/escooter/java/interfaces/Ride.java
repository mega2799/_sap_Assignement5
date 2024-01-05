package escooter.java.interfaces;
import java.util.Date;
import java.util.Optional;

import io.vertx.core.json.JsonObject;

public interface Ride {

	public String getId();

	public Date getStartedDate();

	public boolean isOngoing();

	public Optional<Date> getEndDate();

	public User getUser();

	public EScooter getEScooter();

	public JsonObject toJson();
}