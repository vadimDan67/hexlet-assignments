package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        try {
            return new ObjectMapper().
                       writeValueAsString(new Car(this.id,
                          this.brand,
                          this.model,
                          this.color,
                          this.owner));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Car deserialize(String json) {
        try {
            return new ObjectMapper().readValue(json, Car.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // END
}
