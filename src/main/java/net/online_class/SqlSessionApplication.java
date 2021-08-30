package net.online_class;

import net.online_class.dao.VideoMapper;
import net.online_class.dao.VideoOrderMapper;
import net.online_class.domain.User;
import net.online_class.domain.Video;
import net.online_class.domain.VideoOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SqlSessionApplication {

    public static void main(String[] args) throws IOException {
        String resource = "config/mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);
            // resultmap association关联查询
            VideoOrderMapper videoOrderMapper = sqlSession.getMapper(VideoOrderMapper.class);

            // XML配置方式,根据id查找video
            // Video video = videoMapper.selectById(44);
            // System.out.println(video.toString());

            // 使用@Select注解查询videolist
            // List<Video> videoList = videoMapper.selectAll();
            // System.out.println(videoList.toString());

            // XML配置方式,查询videolist
            // List<Video> videoList = videoMapper.selectAllByXml();
            // System.out.println(videoList.toString());

            // List<Video> videoList = videoMapper.selectByPointAndTitleLike(8.7,"HTML");
            // System.out.println(videoList.toString());

            //新增一条记录
            // Video video =  new Video();
            // video.setTitle("小滴课堂面试专题900道");
            // video.setCoverImg("https://file.xdclass.net/video/2020/node/node_detail.png'");
            // video.setPoint(9.4);
            // video.setCreateTime(new Date());
            // video.setPrice(9900);
            // video.setSummary("这个是面试专题概要");

            // int rows = videoMapper.add(video);
            // System.out.println(rows);
            // System.out.println(video.toString());

            // 批量新增Video
            // Video video1 =  new Video();
            // video1.setTitle("Course 1");
            // video1.setCoverImg("xdclass.net/aaa.png");
            // video1.setPoint(9.4);
            // video1.setCreateTime(new Date());
            // video1.setPrice(9900);
            // video1.setSummary("面试概要1");

            // Video video2 =  new Video();
            // video2.setTitle("Course 1");
            // video2.setCoverImg("xdclass.net/aaa.png");
            // video2.setPoint(9.5);
            // video2.setCreateTime(new Date());
            // video2.setPrice(9900);
            // video2.setSummary("面试概要2");

            // List<Video> list = new ArrayList<>();
            // list.add(video1);
            // list.add(video2);
            // int rows = videoMapper.addBatch(list);
            // System.out.println(rows);
            // System.out.println(list.toString());

            // 根据id更新video数据
            // Video video =  new Video();
            // video.setId(48);
            // video.setTitle("Spring Boot 课程");
            // video.setPoint(9.23);
            // video.setCreateTime(new Date());

            // int rows = videoMapper.updateVideoSelective(video);
            // System.out.println(rows);
            // System.out.println(video);

            // Map<String,Object> map = new HashMap<>();
            // map.put("createTime","2021-08-18 18:35:23");
            // map.put("price",9000);

            // int rows = videoMapper.deleteVideo(map);
            // System.out.println(rows);
            // System.out.println(map);

            // Video video =videoMapper.selectBaseFieldByIdWithResultMap(49);
            // System.out.println(video);

            // List<VideoOrder> videoOrderList = videoOrderMapper.queryVideoOrderList();
            // System.out.println(videoOrderList.toString());

            List<User> userList = videoOrderMapper.queryUserOrder();
            System.out.println(userList.toString());
        }
    }

}
