package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.TriskcaseAttachment;

/**
 * TriskcaseAttachmentDAO�ӿ�.
 * @author Administrator.
 */

public interface TriskcaseAttachmentDAO {

    /**
     *  �����������TriskcaseAttachment����.
     *  @param triskcaseAttachmentPrimaryKey TriskcaseAttachment����
     *  @return TriskcaseAttachment.
     */
    TriskcaseAttachment getTriskcaseAttachment(java.lang.String triskcaseAttachmentPrimaryKey);

    /**
     *  ��ȡTriskcaseAttachment�����б�.
     *  @param  triskcaseAttachment TriskcaseAttachment����
     *  @return List.
     */
    List getTriskcaseAttachmentList(TriskcaseAttachment triskcaseAttachment);

    /**
     *  �洢TriskcaseAttachment����.
     *  @param  triskcaseAttachment TriskcaseAttachment����
     *  @return TriskcaseAttachment.
     */
    TriskcaseAttachment saveTriskcaseAttachment(TriskcaseAttachment triskcaseAttachment);

    /**
     *  ɾ��TriskcaseAttachment����.
     *  @param triskcaseAttachmentPrimaryKey TriskcaseAttachment����.
     */
    void removeTriskcaseAttachment(java.lang.String triskcaseAttachmentPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTriskcaseAttachment�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTriskcaseAttachmentListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTriskcaseAttachment�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTriskcaseAttachmentListOfNoAuthorityQuery(Map queryMap);
}
