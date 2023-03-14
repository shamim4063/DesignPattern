package io.hmshamim.strategy;

import io.hmshamim.strategy.compressor.JpegCompressor;
import io.hmshamim.strategy.compressor.PngCompressor;
import io.hmshamim.strategy.filter.BlackAndWhiteFilter;
import io.hmshamim.strategy.filter.HighContrastFilter;

public class StrategySimulation {
    /*
    * Here in this example, ImageStorage class is our context class, where we want to apply different
    * image compressing and filtering algorithm at runtime such as:
    * Jpeg, Png image compressing as well as Black&White, HighContrast filtering.
    * So we need two strategy interface, named here as Compressor and Filter whose have
    * compress and filter algorithm successively. Two of those strategy interface have two concretes implementation
    * JpegCompressor, PngCompressor and BlackAndWhiteFilter, HighContrastFilter.
    * This is how a family of interchangeable algorithms and encapsulate each one as an object.
    */
    public static void simulate(){
        var imageStorage = new ImageStorage();
        imageStorage.store("StrategyImage", new JpegCompressor(), new BlackAndWhiteFilter());
        imageStorage.store("StrategyImage", new PngCompressor(), new HighContrastFilter());
    }
}
