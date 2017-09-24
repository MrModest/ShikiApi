package ru.shikimori.api.constants;

public class TitleRating {

    public final static String G = "g";
    public final static String PG = "pg";
    public final static String PG_13 = "pg_13";
    public final static String R = "r";
    public final static String R_PLUS = "r_plus";
    public final static String RX = "rx";

    public static String getDescriptionRus(String rating){
        switch (rating){
            case G: return "G - Нет возрастных ограничений";
            case PG: return "PG - Рекомендуется присутствие родителей";
            case PG_13: return "PG-13 - Детям до 13 лет просмотр не желателен";
            case R: return "R - Лицам до 17 лет обязательно присутствие взрослого";
            case R_PLUS: return "R+ - Лицам до 17 лет просмотр запрещен";
            case RX: return "Rx - Хентай";
            default: return rating + " - Описание не найдено";
        }
    }
}
