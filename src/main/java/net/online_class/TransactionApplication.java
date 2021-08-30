package net.online_class;

import net.online_class.dao.VideoMapper;
import net.online_class.dao.VideoOrderMapper;
import net.online_class.domain.Video;
import net.online_class.domain.VideoOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TransactionApplication {

    public static void main(String[] args) throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //Innodb 存储引擎支持事务  openSession参数为true表示为自动commit false或者不传表示手动commit
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{

            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);

            Video video = new Video();
            video.setTitle("新增课程--数据库事务");
            videoMapper.add(video);
            // sqlSession.commit();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}
