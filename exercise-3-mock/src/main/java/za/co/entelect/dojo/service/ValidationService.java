package za.co.entelect.dojo.service;

public interface ValidationService {

    boolean isValidCardNumber(String ccNumber);

    void validateTrackData(String trackData);

}