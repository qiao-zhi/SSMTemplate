package cn.xm.utils.craw;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 乔利强
 * @date: 2020/11/25 8:54
 * @description:
 */
public class JsoupCrawClient {

    private static final String BASE_PATH = "https:";

    // 存放所有的区域和三级域名信息
    private static final Map<String, String> AREA_LOCATION = new LinkedHashMap<>();

    // 需要爬的地点名称，如果需要爬取所有地点，将此属性清空即可
    private static final String AREA = "南京";

    public static void main(String[] args) {
        // 收集所有的二手房的基地址
        String baseurl = "https://nanjing.esf.fang.com/newsecond/esfcities.aspx";
        String s = JsoupCrawUtils.requestURL(baseurl);
        Elements elements = JsoupCrawUtils.extractTagBySelector(s, "a[href*=esf.fang.com]", "a[class=red]");
        Iterator<Element> iterator = elements.iterator();
        while (iterator.hasNext()) {
            Element next = iterator.next();
            String text = next.text();
            String href = next.attr("href");
            AREA_LOCATION.put(text, href);
        }
        System.out.println(AREA_LOCATION);

        // 遍历上面的二手房地址收集数据
        AREA_LOCATION.forEach((area, url) -> {
            if (StringUtils.isNotBlank(AREA)) {
                if (AREA.equals(area)) {
                    crawAreaInfo(BASE_PATH + url);
                    return;
                }
            } else {
                crawAreaInfo(BASE_PATH + url);
            }
        });
    }

    /**
     * 分页爬取信息
     *
     * @param url 需要爬的二手房的URL，三级域名地址
     * @author 乔利强
     * @date 2020/11/26 10:03
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     */
    private static List<Map<String, Object>> crawAreaInfo(String url) {
        String s = JsoupCrawUtils.requestURL(url);
        System.out.println(s);
        return null;
    }
}
