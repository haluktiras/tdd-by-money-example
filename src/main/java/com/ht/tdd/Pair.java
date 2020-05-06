package com.ht.tdd;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Pair {

    private final @NonNull String from;
    private final @NonNull String to;
}
