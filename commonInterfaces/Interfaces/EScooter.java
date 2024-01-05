import java.util.Optional;

import io.vertx.core.json.JsonObject;

public interface EScooter {
	public String getId();

	public EScooterState getState();

	public boolean isAvailable();

	public void updateState(EScooterState state);

	public void updateLocation(Location newLoc);

	public Optional<Location> getCurrentLocation();

	public JsonObject toJson();
	
}