package ru.shikimori.api.constants;

public class TitleKind {

    private TitleKind(){} //Don't create object of class.

    public static class Anime{

        private Anime(){} //Don't create object of class.

        public final static String TV = "tv";

        public final static String TV_SHORT = "tv_13";

        public final static String TV_AVERAGE = "tv_24";

        public final static String TV_LONG = "tv_48";

        public final static String MOVIE = "movie";

        public final static String OVA = "ova";

        public final static String ONA = "ona";

        public final static String SPECIAL = "special";

        public final static String MUSIC = "music";
    }

    public static class Manga{

        private Manga(){} //Don't create object of class.

        public final static String MANGA = "manga";

        public final static String MANHWA = "manhwa";

        public final static String MANHUA = "manhua";

        public final static String NOVEL = "novel";

        public final static String ONE_SHOT = "one_shot";

        public final static String DOUJIN = "doujin";
    }
}
