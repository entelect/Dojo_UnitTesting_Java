package za.co.entelect.dojo.services;

public interface ValidationService {

    public boolean isValidCardNumber(String ccNumber);

    public void validateTrackData(String trackData);

}