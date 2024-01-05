package escooter.java.interfaces;
import java.util.Optional;

import io.vertx.core.json.JsonObject;

public interface EScooter {
	public String getId();

	public EscooterState getState();

	public boolean isAvailable();

	public void updateState(EscooterState state);

	public void updateLocation(Location newLoc);

	public Optional<Location> getCurrentLocation();

	public JsonObject toJson();
	
}