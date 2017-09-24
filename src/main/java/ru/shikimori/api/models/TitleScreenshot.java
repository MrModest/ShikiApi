package ru.shikimori.api.models;

import ru.shikimori.api.models.json._TitleScreenshot;

public class TitleScreenshot {

    private String original;
    private String preview;

    private TitleScreenshot(){}

    public String getOriginal() {
        return original;
    }

    public String getPreview() {
        return preview;
    }

    public static TitleScreenshot convertFromJsonModel(_TitleScreenshot _titleScreenshot){
        if (_titleScreenshot == null) { return null; }

        TitleScreenshot titleScreenshot = new TitleScreenshot();
        titleScreenshot.original = _titleScreenshot.original;
        titleScreenshot.preview = _titleScreenshot.preview;

        return titleScreenshot;
    }

    public static  TitleScreenshot[] convertFromJsonModel(_TitleScreenshot[] _titleScreenshots){
        if (_titleScreenshots == null || _titleScreenshots.length == 0) { return null; }

        TitleScreenshot[] titleScreenshots = new TitleScreenshot[_titleScreenshots.length];
        for (int i = 0; i < _titleScreenshots.length; i++){
            titleScreenshots[i] = TitleScreenshot.convertFromJsonModel(_titleScreenshots[i]);
        }

        return titleScreenshots;
    }
}
