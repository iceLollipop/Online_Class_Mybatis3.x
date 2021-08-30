package net.online_class.dao;

import net.online_class.domain.User;
import net.online_class.domain.VideoOrder;

import java.util.List;

public interface VideoOrderMapper {

    /**
     * 关联查询 一对一
     * @return
     */
    List<VideoOrder> queryVideoOrderList();

    /**
     * 关联查询 一对一 懒加载
     * @return
     */
    List<VideoOrder> queryVideoOrderListLazy();

    /**
     * 关联查询 一对多
     * @return
     */
    List<User> queryUserOrder();
}
