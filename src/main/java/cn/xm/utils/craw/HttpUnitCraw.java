package cn.xm.utils.craw;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author: 乔利强
 * @date: 2020/11/23 13:59
 * @description:
 */
public class HttpUnitCraw {

    public static void main(String[] args) throws Exception {
        HttpUnitCraw crawl = new HttpUnitCraw();
        crawl.crawlPageWithAnalyseJs("https://hn.esf.fang.com/");
    }

    /**
     * 功能描述：抓取页面时不解析页面的js
     *
     * @param url
     * @throws Exception
     */
    public void crawlPageWithoutAnalyseJs(String url) throws Exception {
        //1.创建连接client
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //2.设置连接的相关选项
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setTimeout(10000);
        //3.抓取页面
        HtmlPage page = webClient.getPage(url);
        System.out.println(page.asXml());
        //4.关闭模拟窗口
        webClient.closeAllWindows();
    }

    /**
     * 功能描述：抓取页面时并解析页面的js
     *
     * @param url
     * @throws Exception
     */
    public void crawlPageWithAnalyseJs(String url) throws Exception {
        //1.创建连接client
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //2.设置连接的相关选项
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);  //需要解析js
        webClient.getOptions().setThrowExceptionOnScriptError(false);  //解析js出错时不抛异常
        webClient.getOptions().setTimeout(10000);  //超时时间  ms
        //3.抓取页面
        HtmlPage page = webClient.getPage(url);
        //4.将页面转成指定格式
        webClient.waitForBackgroundJavaScript(10000);   //等侍js脚本执行完成
        System.out.println(page.asXml());
        //5.关闭模拟的窗口
        webClient.closeAllWindows();
    }
}
