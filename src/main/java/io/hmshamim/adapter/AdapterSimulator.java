package io.hmshamim.adapter;

import io.hmshamim.adapter.thirdPartyFilters.Retro;

public class AdapterSimulator {
    /*
    * Here in this simulation of Adapter pattern we want to apply different filters on images.
    * We have an Image class and ImageView class will display images(objects/object of Image class) by applying our required filter.
    * So we have a Filter interface with apply method.
    * All of our filter classes like VintageFilter class will implement the Filter interface and Override its apply method.
    *
    * Now we need to introduce a third party image filter library and use it in our own ImageView class.
    * as that third party library doesn't have its apply method, here we've created a class RetroFilter as an adapter.
    *  */
    public static void simulate(){
        var imageView = new ImageView(new Image());
//        imageView.apply(new VintageFilter());
        imageView.apply(new RetroFilter(new Retro()));
    }
}
