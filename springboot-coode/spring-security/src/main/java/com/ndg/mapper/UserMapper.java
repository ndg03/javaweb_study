package com.ndg.mapper;

import com.ndg.domain.MyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: UserMapper
 * @author: ndg
 * @date: 2023/7/5 14:02
 */
@Mapper
public interface UserMapper {

    /**
     * 新增
     * @author ndg
     * @date 2023/07/05
     **/
    int insert(MyUser MyUser);

    /**
     * 刪除
     * @author ndg
     * @date 2023/07/05
     **/
    int delete(int id);

    /**
     * 更新
     * @author ndg
     * @date 2023/07/05
     **/
    int update(MyUser MyUser);

    /**
     * 查询 根据主键 id 查询
     * @author ndg
     * @date 2023/07/05
     **/
    MyUser load(int id);

    /**
     * 查询 分页查询
     * @author ndg
     * @date 2023/07/05
     **/
    List<MyUser> pageList(int offset, int pagesize);

    /**
     * 查询 分页查询 count
     * @author ndg
     * @date 2023/07/05
     **/
    int pageListCount(int offset,int pagesize);

    MyUser selectByPrimaryKey(String username);
}
