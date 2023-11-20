package eu.frezilla.tools.datastructure.map;

import lombok.Data;
import lombok.NonNull;

@Data
final class UniqueValueContainer<T> {

    private final UniqueValueContainer<?> linkedContainer;
    private final T object;

    public UniqueValueContainer(@NonNull T object, @NonNull UniqueValueContainer<?> linkeContainer) {
        this.linkedContainer = linkeContainer;
        this.object = object;
    }
}
