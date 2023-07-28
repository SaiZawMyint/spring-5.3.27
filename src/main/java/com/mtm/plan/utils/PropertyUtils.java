package com.mtm.plan.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Write your property utilities here...<br>
 * This is the place to configure your properties.
 * <br>
 * <pre style='color: orange;'>Note::Please do not use the data access logic here!</pre>
 *
 * @author SaiZawMyint
 *
 */
public class PropertyUtils {
    public static List<String> parseStringListProperty(String properties){
        List<String> datas = new ArrayList<>();
        if(!properties.contains(",")) return datas;
        String[] propertyList = properties.split(",");
        for(String prop:propertyList) {
            datas.add(prop.trim());
        }
        return datas;
    }
}
