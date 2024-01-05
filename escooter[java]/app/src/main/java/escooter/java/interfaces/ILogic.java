package escooter.java.interfaces;

import java.util.Optional;

import escooter.java.exceptions.EScooterNotFoundException;
import escooter.java.exceptions.RideAlreadyEndedException;
import escooter.java.exceptions.RideNotFoundException;
import escooter.java.exceptions.RideNotPossibleException;
import escooter.java.exceptions.UserIdAlreadyExistingException;
import escooter.java.exceptions.UserNotFoundException;

public interface ILogic {
   	void addNewUser(String id, String name, String surname) throws UserIdAlreadyExistingException;
	Optional<User> getUser(String userId) throws UserNotFoundException;

	// void addNewEScooter(String id);
	Optional<EScooter> getNearestEScooterStation(String postion) throws EScooterNotFoundException;
	
	String startNewRide(String id, String userId, String escooterId) throws RideNotPossibleException;
	Optional<Ride> getRide(String rideId) throws RideNotFoundException; 
	void endRide(String rideId) throws RideNotFoundException, RideAlreadyEndedException;

	void payRide(Ride ride) throws RideNotFoundException, RideAlreadyEndedException;
}
