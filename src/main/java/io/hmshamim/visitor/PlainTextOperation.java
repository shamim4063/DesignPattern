package io.hmshamim.visitor;

public class PlainTextOperation implements Operation{
    @Override
    public void apply(HeadingNode heading) {
        System.out.println("Extracting Heading Node text.");
    }
    @Override
    public void apply(AnchorNode anchor) {
        System.out.println("Extracting Anchor Node text.");
    }
}
