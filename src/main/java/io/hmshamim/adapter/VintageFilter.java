package io.hmshamim.adapter;

public class VintageFilter implements Filter{
    @Override
    public void apply(Image image) {
        System.out.println("Applying Vintage Filter");
    }
}
