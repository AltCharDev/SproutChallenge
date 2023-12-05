package Pages;

public class SearchPage {
    public static String GridLink = "//*[@href='/GridDemo']";

    public static String pageNum = "//*[@class='awe-pager']/button[6]";
    public static String tableId (int id) {
        return "(//*[@data-g='Grid1']/td)[" + id +"]";
    }
    public static String pageNumSearch (String id) {
        return "//*[@data-p='" + id + "']";
    }
    public static String id (String id) {
        return "(//*[@data-k='" + id + "']/td)[1]";
    }
    public static String person (String id) {
        return "(//*[@data-k='" + id + "']/td)[2]";
    }
    public static String food (String id) {
        return "(//*[@data-k='" + id + "']/td)[3]";
    }
    public static String country (String id) {
        return "(//*[@data-k='" + id + "']/td)[4]";
    }
    public static String date (String id) {
        return "(//*[@data-k='" + id + "']/td)[5]";
    }
    public static String chef (String id) {
        return "(//*[@data-k='" + id + "']/td)[6]";
    }
}
