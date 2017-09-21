package ru.shikimori.api.constants;

public class TitleProgressStatus {

    private TitleProgressStatus() {} //Don't create object of class.

    public final static String PLANNED = "planned";

    public final static String IN_PROGRESS = "watching";

    public final static String COMPLETED = "completed";

    public final static String ON_HOLD = "on_hold";

    public final static String DROPPED = "dropped";

    public final static String REWATCHING = "rewatching";

    public final static int PLANNED_ID = 0;

    public final static int IN_PROGRESS_ID = 1;

    public final static int COMPLETED_ID = 2;

    public final static int ON_HOLD_ID = 3;

    public final static int DROPPED_ID = 4;

    public final static int REWATCHING_ID = 9;

    public final static String PLANNED_RUS = "Запланировано";

    public final static String IN_PROGRESS_RUS_A = "Смотрю";

    public final static String IN_PROGRESS_RUS_M = "Читаю";

    public final static String COMPLETED_RUS_A = "Просмотрено";

    public final static String COMPLETED_RUS_M = "Прочитано";

    public final static String ON_HOLD_RUS = "Отложено";

    public final static String DROPPED_RUS = "Брошено";

    public final static String REWATCHING_RUS_A = "Пересматриваю";

    public final static String REWATCHING_RUS_M = "Перечитываю";

    public static int convertNameToId(String name){
        switch (name){
            case PLANNED: return PLANNED_ID;
            case IN_PROGRESS: return IN_PROGRESS_ID;
            case COMPLETED: return COMPLETED_ID;
            case ON_HOLD: return ON_HOLD_ID;
            case DROPPED: return DROPPED_ID;
            case REWATCHING: return REWATCHING_ID;
            default: return -1;
        }
    }

    public static String convertIdToName(int id){
        switch (id){
            case PLANNED_ID: return PLANNED;
            case IN_PROGRESS_ID: return IN_PROGRESS;
            case COMPLETED_ID: return COMPLETED;
            case ON_HOLD_ID: return ON_HOLD;
            case DROPPED_ID: return DROPPED;
            case REWATCHING_ID: return REWATCHING;
            default: return null;
        }
    }

    public static int convertRusNameToId(String rusName){
        switch (rusName){
            case PLANNED_RUS: return PLANNED_ID;

            case IN_PROGRESS_RUS_A:
            case IN_PROGRESS_RUS_M: return IN_PROGRESS_ID;

            case COMPLETED_RUS_A:
            case COMPLETED_RUS_M: return COMPLETED_ID;

            case ON_HOLD_RUS: return ON_HOLD_ID;

            case DROPPED_RUS: return DROPPED_ID;

            case REWATCHING_RUS_A:
            case REWATCHING_RUS_M: return REWATCHING_ID;

            default: return -1;
        }
    }

    public static String convertRusNameToName(String rusName){
        return convertIdToName(convertRusNameToId(rusName));
    }

    public static String convertIdToRusName(int id, String type){
        switch (id){
            case PLANNED_ID: return PLANNED_RUS;
            case IN_PROGRESS_ID: return (type == "Anime") ? IN_PROGRESS_RUS_A : IN_PROGRESS_RUS_M;
            case COMPLETED_ID: return (type == "Anime") ? COMPLETED_RUS_A : COMPLETED_RUS_M;
            case ON_HOLD_ID: return ON_HOLD_RUS;
            case DROPPED_ID: return DROPPED_RUS;
            case REWATCHING_ID: return (type == "Anime") ? REWATCHING_RUS_A : REWATCHING_RUS_M;

            default: return null;
        }
    }

    public static String convertNameToRusName(String status, String type){
        return convertIdToRusName(convertNameToId(status), type);
    }
}
