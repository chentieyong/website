package com.shenzhou.core.util;

/**
 * Created by Ma-Company on 2016/8/2.
 */

import java.util.regex.Pattern;

/**
 * 过滤标签字符串，返回纯文本
 */
public class ChangePlainText {

    public static void main(String[] args) {

        String test = "<p class=\\\"newtext\\\" style=\\\"padding: 0px; margin-top: 10px; margin-bottom: 10px; clear: both; float: left; width: 640px; font-stretch: normal; line-height: 30px; font-family: arial, Helvetica, &#39;Microsoft Yahei&#39;, &#39;Hiragino Sans GB&#39;, sans-serif; color: rgb(51, 51, 51); text-indent: 2em; word-wrap: break-word; overflow: hidden; white-space: normal; background-color: rgb(255, 255, 255);\\\">【亿账通网讯】5月21日消息，阿里健康发布消息称明早八点将在手机淘宝及天猫客户端上直播手术。</p><p class=\\\"newtext\\\" style=\\\"padding: 0px; margin-top: 10px; margin-bottom: 10px; clear: both; float: left; width: 640px; font-stretch: normal; line-height: 30px; font-family: arial, Helvetica, &#39;Microsoft Yahei&#39;, &#39;Hiragino Sans GB&#39;, sans-serif; color: rgb(51, 51, 51); text-indent: 2em; word-wrap: break-word; overflow: hidden; white-space: normal; background-color: rgb(255, 255, 255);\\\">据<span style=\\\"color: rgb(51, 51, 51); font-family: arial, Helvetica, &#39;Microsoft Yahei&#39;, &#39;Hiragino Sans GB&#39;, sans-serif; line-height: 30px; text-indent: 32px; background-color: rgb(255, 255, 255);\\\">亿账通</span>网了解，此次直播由阿里健康联合和睦家医院，以直播的形式呈现达芬奇手术机器人操作胰头肿瘤切除微创手术。</p><p class=\\\"newtext\\\" style=\\\"padding: 0px; margin-top: 10px; margin-bottom: 10px; clear: both; float: left; width: 640px; font-stretch: normal; line-height: 30px; font-family: arial, Helvetica, &#39;Microsoft Yahei&#39;, &#39;Hiragino Sans GB&#39;, sans-serif; color: rgb(51, 51, 51); text-indent: 2em; word-wrap: break-word; overflow: hidden; white-space: normal; background-color: rgb(255, 255, 255);\\\">达芬奇手术机器人是一种辅助微创手术系统，需要外科医生通过成像系统观察，在控制台操纵床旁机械臂系统，来完成对患者的微创手术。目前被广泛应用于泌尿、胃肠、肝胆胰腺及妇科领域。</p><p class=\\\"newtext\\\" style=\\\"padding: 0px; margin-top: 10px; margin-bottom: 10px; clear: both; float: left; width: 640px; font-stretch: normal; line-height: 30px; font-family: arial, Helvetica, &#39;Microsoft Yahei&#39;, &#39;Hiragino Sans GB&#39;, sans-serif; color: rgb(51, 51, 51); text-indent: 2em; word-wrap: break-word; overflow: hidden; white-space: normal; background-color: rgb(255, 255, 255);\\\">据公开数据显示，达芬奇手术机器人早已经分布在国内47家大型三甲医院，做过的微创手术已经超过万台。</p><p class=\\\"newtext\\\" style=\\\"padding: 0px; margin-top: 10px; margin-bottom: 10px; clear: both; float: left; width: 640px; font-stretch: normal; line-height: 30px; font-family: arial, Helvetica, &#39;Microsoft Yahei&#39;, &#39;Hiragino Sans GB&#39;, sans-serif; color: rgb(51, 51, 51); text-indent: 2em; word-wrap: break-word; overflow: hidden; white-space: normal; background-color: rgb(255, 255, 255);\\\">此次视频直播的胰头肿瘤切除微创手术将由世界临床机器人外科协会(CRSA)创始主席、机器人外科领域知名教授Pier C.Giulianotti亲自操控，北京大学肿瘤医院著名专家郝纯毅主任将进行现场解说。</p><p class=\\\"newtext\\\" style=\\\"padding: 0px; margin-top: 10px; margin-bottom: 10px; clear: both; float: left; width: 640px; font-stretch: normal; line-height: 30px; font-family: arial, Helvetica, &#39;Microsoft Yahei&#39;, &#39;Hiragino Sans GB&#39;, sans-serif; color: rgb(51, 51, 51); text-indent: 2em; word-wrap: break-word; overflow: hidden; white-space: normal; background-color: rgb(255, 255, 255);\\\">阿里健康医疗服务团队的钟聪娣在接受媒体采访时表示，这次手术直播只是阿里健康的初步尝试，接下来还将为两名患者分别提供免费的小儿外科和子宫肌瘤或者妇科肿瘤的达芬奇微创手术，另外阿里健康在其平台上提供了达芬奇机器人辅助手术术前评估套餐的信息展示。</p><p class=\\\"newtext\\\" style=\\\"padding: 0px; margin-top: 10px; margin-bottom: 10px; clear: both; float: left; width: 640px; font-stretch: normal; line-height: 30px; font-family: arial, Helvetica, &#39;Microsoft Yahei&#39;, &#39;Hiragino Sans GB&#39;, sans-serif; color: rgb(51, 51, 51); text-indent: 2em; word-wrap: break-word; overflow: hidden; white-space: normal; background-color: rgb(255, 255, 255);\\\"><span style=\\\"color: rgb(51, 51, 51); font-family: arial, Helvetica, &#39;Microsoft Yahei&#39;, &#39;Hiragino Sans GB&#39;, sans-serif; line-height: 30px; text-indent: 32px; background-color: rgb(255, 255, 255);\\\">亿账通</span>网了解到，今年5月在经过了试运营之后，手机淘宝正式推出“淘宝直播”平台，涵盖母婴、美妆、潮搭、美食、运动健身、全球购等范围，消费者可以通过淘宝直播频道、微淘频道直接收看相关内容。</p><p><br/></p>";

        String b = ChangePlainText.Html2Text(test);

        System.out.println(b);
    }

    public static String Html2Text(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        Pattern p_script;
        java.util.regex.Matcher m_script;
        Pattern p_style;
        java.util.regex.Matcher m_style;
        Pattern p_html;
        java.util.regex.Matcher m_html;

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            // }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            // }
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签

            textStr = htmlStr;

        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }

        return textStr;// 返回文本字符串
    }

}