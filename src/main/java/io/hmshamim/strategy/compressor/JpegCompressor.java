package io.hmshamim.strategy.compressor;

public class JpegCompressor implements Compressor{
    @Override
    public void compress(String fileName) {
        System.out.println("Compressing File "+fileName+ " To Jpeg.");
    }
}
