package za.co.entelect.dojo.services;

public interface CardValidation {

    boolean isValidCardNumber(String ccNumber);

    void validateTrackData(String trackData);

}