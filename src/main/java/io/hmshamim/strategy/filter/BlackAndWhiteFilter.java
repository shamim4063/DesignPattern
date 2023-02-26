package io.hmshamim.strategy.filter;

public class BlackAndWhiteFilter implements Filter{
    @Override
    public void filter(String fileName) {
        System.out.println("Filtering File "+fileName+ " To Black and White.");
    }
}
