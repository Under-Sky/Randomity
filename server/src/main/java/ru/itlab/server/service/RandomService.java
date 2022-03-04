package ru.itlab.server.service;

import java.util.List;

public interface RandomService {
    public List<Integer> getInteger(int min, int max, int count);

}
