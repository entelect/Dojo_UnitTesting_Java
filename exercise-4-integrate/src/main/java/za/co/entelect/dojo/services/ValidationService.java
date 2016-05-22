package za.co.entelect.dojo.services;

public interface ValidationService {

    boolean isValidCardNumber(String ccNumber);

    void validateTrackData(String trackData);

}