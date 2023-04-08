package io.hmshamim.visitor;

public class SimulateVisitor {
    public static void simulate(){
        var document = new HtmlDocument();

        document.add(new HeadingNode());
        document.add(new AnchorNode());

        document.execute(new HighLightOperation());

        //document.execute(new PlainTextOperation());
    }
}
