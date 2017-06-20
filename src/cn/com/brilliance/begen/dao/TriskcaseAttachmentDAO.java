package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TriskcaseAttachment;

/**
 * TriskcaseAttachmentDAO接口.
 * @author Administrator.
 */

public interface TriskcaseAttachmentDAO {

    /**
     *  根据主键获得TriskcaseAttachment对象.
     *  @param triskcaseAttachmentPrimaryKey TriskcaseAttachment主键
     *  @return TriskcaseAttachment.
     */
    TriskcaseAttachment getTriskcaseAttachment(java.lang.String triskcaseAttachmentPrimaryKey);

    /**
     *  获取TriskcaseAttachment对象列表.
     *  @param  triskcaseAttachment TriskcaseAttachment对象
     *  @return List.
     */
    List getTriskcaseAttachmentList(TriskcaseAttachment triskcaseAttachment);

    /**
     *  存储TriskcaseAttachment对象.
     *  @param  triskcaseAttachment TriskcaseAttachment对象
     *  @return TriskcaseAttachment.
     */
    TriskcaseAttachment saveTriskcaseAttachment(TriskcaseAttachment triskcaseAttachment);

    /**
     *  删除TriskcaseAttachment对象.
     *  @param triskcaseAttachmentPrimaryKey TriskcaseAttachment主键.
     */
    void removeTriskcaseAttachment(java.lang.String triskcaseAttachmentPrimaryKey);

    /**
     *  根据查询条件获取TriskcaseAttachment对象列表.
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTriskcaseAttachmentListOfQuery(Map queryMap);

    /**
     *  根据查询条件获取TriskcaseAttachment对象列表(无用户权限限制).
     *  @param  queryMap 查询条件Map
     *  @return List.
     */
    List getTriskcaseAttachmentListOfNoAuthorityQuery(Map queryMap);
}
