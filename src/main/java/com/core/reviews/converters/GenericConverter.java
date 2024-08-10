package com.core.reviews.converters;

public interface GenericConverter<T1,T2> {
    void convert(T1 SOURCE, T2 TARGET);
}
