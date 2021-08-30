package net.online_class.dao;

import net.online_class.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface VideoMapper {

    /**
     * 方式1 使用mybatis xml配置Sql执行语句
     * 根据video_id 返回视频对象
     * @param videoId
     * @return
     */
    Video selectById(@Param("video_id") int videoId);

    /**
     * 使用@Select (sql function) 执行Sql语句
     * 即使不使用xml配置Sql执行语句,也需要声明对应namespace的mapper
     * @return
     */
    // @Select("select * from video")
    // List<Video> selectAll();

    /**
     * 通过XML配置方式
     * @return
     */
    List<Video> selectAllByXml();

    /**
     * 多参数需要设置别名alias,再通过#{alias}来获取当前的值
     * @param point
     * @param title
     * @return
     */
    List<Video> selectByPointAndTitleLike(@Param("point") double point,@Param("title") String title);

    /**
     * 插入一条video新记录
     * @param video
     * @return
     */
    int add(Video video);

    /**
     * 批处理添加video,XML配置<foreach collection="list" item="video" separator=",">循环插入数据
     * @param videoList
     * @return
     */
    int addBatch(List<Video> videoList);


    /**
     * 根据id更新video,如果没有配置OGNL表达式会更新,所列的字段数据不存在会设置为数据库默认值
     * @param video
     * @return
     */
    int updateVideo(Video video);

    /**
     * 根据id更新video,配置了OGNL表达式,实现部分更新
     * @param video
     * @return
     */
    int updateVideoSelective(Video video);

    /**
     * 根据条件删除video数据,参数是map.具体是map中的createTime and price
     * @param map
     * @return
     */
    int deleteVideo(Map<String,Object> map);

    /**
     *
     * @param map
     * @return
     */
    Video selectBaseFieldByIdWithResultMap(@Param("video_id") int videoId);

}
