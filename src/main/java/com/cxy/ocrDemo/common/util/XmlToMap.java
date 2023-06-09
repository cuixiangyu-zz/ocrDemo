package com.cxy.ocrDemo.common.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.*;

/**
 * XML转Map
 */
public class XmlToMap {
    public static Map<String, Object> xmlToMap(String xml) {
        Map<String, Object> map = new HashMap<String, Object>();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            if (doc == null){
                return map;
            }
            Element root = doc.getRootElement();
            for (Iterator iterator = root.elementIterator(); iterator.hasNext(); ) {
                Element e = (Element) iterator.next();
                List list = e.elements();
                if (list.size() > 0) {
                    map.put(e.getName(), Dom2Map(e));
                } else{
                    map.put(e.getName(), e.getText());
                }
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map Dom2Map(Element e) {
        Map map = new HashMap();
        List list = e.elements();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();
                if (iter.elements().size() > 0) {
                    Map m = Dom2Map(iter);
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!"java.util.ArrayList".equals(obj.getClass().getName())) {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(m);
                        }
                        if ("java.util.ArrayList".equals(obj.getClass().getName())) {
                            mapList = (List) obj;
                            mapList.add(m);
                        }
                        map.put(iter.getName(), mapList);
                    } else{
                        map.put(iter.getName(), m);
                    }
                } else {
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!"java.util.ArrayList".equals(obj.getClass().getName())) {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(iter.getText());
                        }
                        if ("java.util.ArrayList".equals(obj.getClass().getName())) {
                            mapList = (List) obj;
                            mapList.add(iter.getText());
                        }
                        map.put(iter.getName(), mapList);
                    } else{
                        map.put(iter.getName(), iter.getText());
                    }
                }
            }
        } else{
            map.put(e.getName(), e.getText());
        }
        return map;
    }

}
