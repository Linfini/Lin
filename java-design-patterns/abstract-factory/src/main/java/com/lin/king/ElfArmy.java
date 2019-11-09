package com.lin.king;

import java.util.StringJoiner;

public class ElfArmy implements Army {
    static final String DESCRIPTION = "this is the Elven army";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
