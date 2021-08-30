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
import java.util.List;

public class SqlSessionCacheApplication {

    public static void main(String[] args) throws IOException {
        String resource = "config/mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try{
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            VideoMapper videoMapper1 = sqlSession1.getMapper(VideoMapper.class);

            // XML配置方式,根据id查找video
            // Video video1 = videoMapper1.selectById(44);
            // System.out.println(video1.toString());
            // sqlSession1.commit();

            // SqlSession sqlSession2 = sqlSessionFactory.openSession();
            // VideoMapper videoMapper2 = sqlSession2.getMapper(VideoMapper.class);

            // XML配置方式,根据id查找video
            // Video video2 = videoMapper2.selectById(44);
            // System.out.println(video2.toString());
            // sqlSession1.commit();


            VideoOrderMapper videoOrderMapper = sqlSession1.getMapper(VideoOrderMapper.class);
            List<VideoOrder> videoOrderList = videoOrderMapper.queryVideoOrderListLazy();
            System.out.println(videoOrderList.toString());
            //课程里面演示是6条订单记录，但是只查询3次用户信息，是因为部分用户信息走了一级缓存sqlsession
            for(VideoOrder videoOrder : videoOrderList){
                System.out.println(videoOrder.getVideoTitle());
                System.out.println(videoOrder.getUser().getName());
            }


        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
