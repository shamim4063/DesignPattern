package io.hmshamim.adapter;

import io.hmshamim.adapter.thirdPartyFilters.Retro;

public class RetroFilter implements Filter{
    private Retro retro;

    public RetroFilter(Retro retro) {
        this.retro = retro;
    }

    @Override
    public void apply(Image image) {
        retro.init();
        retro.render(image);
    }
}

