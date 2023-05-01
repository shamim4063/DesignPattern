package io.hmshamim.decorator;

public class DecoratorSimulation {
    /*Here in the example we need to store data as string in the cloud.
     * Sometimes we may need to store directly, sometimes by using encryption or compression.
     * That's why we need to decorate our CloudStream class.
     * Here we've defined two decorator class CompressedCloudStream and EncryptedCloudStream.
     * All decorator implemented Stream interface and overrides its write method.
     *
     * We're storing users credits cards here. We'll first encrypt then compress the card information then store in cloud using decorator pattern.
     */
    public static void simulate(){
//        storeCreditCard(new CloudStream());
//        storeCreditCard(new EncryptedCloudStream(new CloudStream()));
        storeCreditCard(new CompressedCloudStream(new CloudStream()));
//        storeCreditCard(new CompressedCloudStream(new EncryptedCloudStream CompressedCloudStream(new CloudStream())));
    }

    public static void storeCreditCard(Stream stream){
        stream.write("2396-4384-5498-1293");
    }
}
