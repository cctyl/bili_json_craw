package cn.tyl.test;

import cn.tyl.bean.Video;
import cn.tyl.dao.VideoMapper;
import cn.tyl.utils.JsonToBean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class GetJsonTest {


    @Test
    public void test1() throws InterruptedException {

        for (int page = 0; page < 11; page++) {
            getVideo(page);
            Thread.sleep(2000);
        }

    }

    private void getVideo(int pn) {

        //CloseableHttpClient：建立一个可以关闭的httpClient
        //这样使得创建出来的HTTP实体，可以被Java虚拟机回收掉，不至于出现一直占用资源的情况。
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        //设置请求超时时间

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(60000)
                .setConnectTimeout(60000)
                .setConnectionRequestTimeout(60000)
                .build();

        try {

            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.addParameter("pn",pn+"");
            HttpGet request = new HttpGet(uriBuilder.build());

            //给这个请求设置请求配置
            request.setConfig(requestConfig);
//         request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) ...");

            CloseableHttpResponse response = closeableHttpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity());// 返回json格式

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(result);
                JsonNode videoJson = jsonNode.get("data").get("videos");
                for (int i = 0; i <= 19 ;i++) {
                    JsonNode vidoeNode = videoJson.get(i);
                    Video video = JsonToBean.toVideo(vidoeNode);

                    String resource = "mybatis-config.xml";
                    InputStream inputStream = Resources.getResourceAsStream(resource);
                    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                    SqlSession sqlSession = sqlSessionFactory.openSession();

                    VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
                    mapper.insert(video);

                }




            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {                //关闭流并释放资源
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //数据存储
    @Test
    public void saveData() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
        Video video = mapper.selectByPrimaryKey(111);
        video.toString();

    }
}
