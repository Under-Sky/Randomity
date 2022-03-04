package ru.itlab.server.service;

import java.util.List;

public interface RandomService {
    List<Integer> getInteger(int min, int max, int count);

}
