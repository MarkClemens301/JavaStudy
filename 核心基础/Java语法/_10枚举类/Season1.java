package Java语法._10枚举类;/* 2020/9/10 15:20 */

//import java.lang.*;

enum Season1 {
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰封万里"); //逗号分隔

    private final String SeasonName;
    private final String SeasonDesc;

    Season1(String seasonName, String seasonDesc) {
        SeasonName = seasonName;
        SeasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return SeasonName;
    }

    public String getSeasonDesc() {
        return SeasonDesc;
    }

    // TODO: 2020/8/28 enum类继承于java.lang.Enum类
    @Override
    public String toString() {
        return "Season1{" +
                "SeasonName='" + SeasonName + '\'' +
                ", SeasonDesc='" + SeasonDesc + '\'' +
                '}';
    }
}
