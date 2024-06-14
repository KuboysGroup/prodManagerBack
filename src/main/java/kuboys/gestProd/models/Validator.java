package kuboys.gestProd.models;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

public class Validator {

    private static final Map<Class<?>, Class<?>> PRIMITIVES_TO_WRAPPERS = Map.of(
            boolean.class, Boolean.class,
            byte.class, Byte.class,
            char.class, Character.class,
            double.class, Double.class,
            float.class, Float.class,
            int.class, Integer.class,
            long.class, Long.class,
            short.class, Short.class,
            void.class, Void.class
    );

    private Validator() {
    }

    public static boolean tipoTemValor(Object valor) {
        if (valor == null) {
            return false;
        }

        Class<?> valorClasse = valor.getClass();
        Class<?> wrapperClasse = PRIMITIVES_TO_WRAPPERS.getOrDefault(valorClasse, valorClasse);

        if (Number.class.isAssignableFrom(wrapperClasse)) {
            return !valor.equals(0);
        } else if (Character.class.isAssignableFrom(wrapperClasse)) {
            return !valor.equals(' ');
        } else if (BigDecimal.class.isAssignableFrom(wrapperClasse)) {
            return ((BigDecimal) valor).doubleValue() != 0;
        } else if (valor instanceof String) {
            return !((String) valor).trim().isEmpty();
        } else if (valor.getClass().isArray()) {
            return Array.getLength(valor) > 0;
        } else if (valor instanceof Collection) {
            Collection<?> col = (Collection<?>) valor;
            return !col.isEmpty();
        } else if (valor instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) valor;
            return !map.isEmpty();
        } else if (valor instanceof Boolean) {
            return (Boolean) valor;
        } else if (valor instanceof byte[]) {
            return ((byte[]) valor).length > 0;
        } else {
            throw new IllegalArgumentException(
                    "Tipo " + valorClasse.getSimpleName() + " não tratado em Validator.temValor");
        }
    }

    public static boolean tipoNaoTemValor(Object valor){
        return !tipoTemValor(valor);
    }
}
