package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Validator {
    public static List<String> validate(Object entity) {
        List<String> fields = new ArrayList<>();
        for (Field field : entity.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(entity);
                    if (value == null) {
                        fields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return fields;
    }
    public static Map<String, List<String>> advancedValidate(Object entity) {
        Map<String, List<String>> ret = new HashMap<>();
        var errorNull = "can not be null";
        var errorMinLen = "length less than %s";
        for (Field field : entity.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            MinLength minLen = field.getAnnotation(MinLength.class);
            if (notNull != null || minLen != null) {
                List<String> errors = new ArrayList<>();
                try {
                    field.setAccessible(true);
                    Object value = field.get(entity);
                    if (notNull != null && value == null) {
                        errors.add(errorNull);
                    }
                    if (minLen != null && (value == null || value.toString().length() < minLen.minLength())) {
                        errors.add(String.format(errorMinLen, minLen.minLength()));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (!errors.isEmpty()) {
                    ret.put(field.getName(), errors);
                }
            }
        }
        return ret;
    }
}
// END
