package kuboys.models;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Validator {

    private static final Map<Class<?>, Class<?>> PRIMITIVES_TO_WRAPPERS = new HashMap<Class<?>, Class<?>>();

    static {
        PRIMITIVES_TO_WRAPPERS.put(boolean.class, Boolean.class);
        PRIMITIVES_TO_WRAPPERS.put(byte.class, Byte.class);
        PRIMITIVES_TO_WRAPPERS.put(char.class, Character.class);
        PRIMITIVES_TO_WRAPPERS.put(double.class, Double.class);
        PRIMITIVES_TO_WRAPPERS.put(float.class, Float.class);
        PRIMITIVES_TO_WRAPPERS.put(int.class, Integer.class);
        PRIMITIVES_TO_WRAPPERS.put(long.class, Long.class);
        PRIMITIVES_TO_WRAPPERS.put(short.class, Short.class);
        PRIMITIVES_TO_WRAPPERS.put(void.class, Void.class);
    }

    private Validator() {
    }

    public static boolean tipoTemValor(Object valor) {
        if (valor == null) {
            return false;
        }
        if (valor instanceof Integer) {
            return (Integer) valor != 0;
        } else if (valor instanceof Long) {
            return (Long) valor != 0;
        } else if (valor instanceof Double) {
            return (Double) valor != 0d;
        } else if (valor instanceof Character) {
            return (Character) valor != ' ';
        } else if (valor instanceof BigDecimal) {
            return ((BigDecimal) valor).doubleValue() != 0;
        } else if (valor instanceof Data) {
            return !valor.equals(Data.ZERO);
        } else if (valor instanceof String) {
            return !((String) valor).trim().equals("");
        } else if (valor.getClass().isArray()) {
            return Array.getLength(valor) > 0;
        } else if (valor instanceof Collection) {
            Collection<?> col = (Collection<?>) valor;
            return !col.isEmpty();
        } else if (valor instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) valor;
            return !map.isEmpty();
        } else if (valor instanceof Boolean) {
            return (Boolean) valor != null;
        } else if (valor instanceof byte[]) {
            return ((byte[]) valor).length > 0;
        } else {
            throw new IllegalArgumentException(
                    "Tipo " + valor.getClass().getSimpleName() + " não tratado em Validator.temValor");
        }
    }

}
