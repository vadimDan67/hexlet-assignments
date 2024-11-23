package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private String error;
    public NegativeRadiusException(String error) {
        this.error = error;
    }
    public String getError() {
        return error;
    }
}
// END
