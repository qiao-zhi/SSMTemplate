package cn.xm.utils.craw;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Iterator;

/**
 * @author: 乔利强
 * @date: 2020/11/25 8:54
 * @description:
 */
public class JsoupCrawClient {

    public static void main(String[] args) {
        // 获取到所有的二手房的基地址
        String baseurl = "https://nanjing.esf.fang.com/newsecond/esfcities.aspx";
        String s = JsoupCrawUtils.requestURL(baseurl);
        Elements elements = JsoupCrawUtils.extractTagBySelector(s, "a[href*=esf.fang.com]", "a[class=red]");
        Iterator<Element> iterator = elements.iterator();
        while (iterator.hasNext()) {
            Element next = iterator.next();
        }

        // 遍历上面的二手房地址收集数据

    }
}
