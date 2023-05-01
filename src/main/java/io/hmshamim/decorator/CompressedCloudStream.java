package io.hmshamim.decorator;

public class CompressedCloudStream  implements Stream{
    private Stream stream;
    public CompressedCloudStream(Stream sstream){
        this.stream = sstream;
    }
    @Override
    public void write(String data) {
        var compressed = compress(data);
        stream.write(compressed);
    }
    private String compress(String data){
        return data.substring(0, 5);
    }
}
