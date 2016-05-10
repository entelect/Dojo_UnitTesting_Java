package za.co.entelect.dojo.services;

public interface CardValidation {

    public boolean isValidCardNumber(String ccNumber);

    public void validateTrackData(String trackData);

}