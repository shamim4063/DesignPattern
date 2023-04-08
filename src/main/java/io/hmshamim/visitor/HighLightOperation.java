package io.hmshamim.visitor;

public class HighLightOperation implements Operation{
    @Override
    public void apply(HeadingNode heading) {
        System.out.println("Highlighting heading");
    }
    @Override
    public void apply(AnchorNode anchor) {
        System.out.println("Highlighting anchor");
    }
}
