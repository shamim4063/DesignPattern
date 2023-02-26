package io.hmshamim.strategy.filter;

public class HighContrastFilter implements Filter{
    @Override
    public void filter(String fileName) {
        System.out.println("Filtering File "+fileName+ " To HighContrast Filter.");
    }
}
