package io.hmshamim.strategy.compressor;

public class PngCompressor implements Compressor{
    @Override
    public void compress(String fileName) {
        System.out.println("Compressing File "+fileName+ " To Png.");
    }
}
