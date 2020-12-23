package com.company;

import java.io.IOException;

public interface ResourceFactory<type> {
    type create();
}
