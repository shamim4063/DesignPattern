package io.hmshamim.strategy;

import io.hmshamim.strategy.compressor.Compressor;
import io.hmshamim.strategy.filter.Filter;

public class ImageStorage {
    private Compressor compressor;
    private Filter filter;

    public ImageStorage() {}

    public void store(String fileName, Compressor compressor, Filter filter){
        compressor.compress(fileName);
        filter.filter(fileName);
    }
}
