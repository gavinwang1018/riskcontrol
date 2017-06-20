package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.Tpermission;

/**
 * TpermissionDAO�ӿ�.
 * @author Administrator.
 */

public interface TpermissionDAO {

    /**
     *  �����������Tpermission����.
     *  @param tpermissionPrimaryKey Tpermission����
     *  @return Tpermission.
     */
    Tpermission getTpermission(java.lang.String tpermissionPrimaryKey);

    /**
     *  ��ȡTpermission�����б�.
     *  @param  tpermission Tpermission����
     *  @return List.
     */
    List getTpermissionList(Tpermission tpermission);

    /**
     *  �洢Tpermission����.
     *  @param  tpermission Tpermission����
     *  @return Tpermission.
     */
    Tpermission saveTpermission(Tpermission tpermission);

    /**
     *  ɾ��Tpermission����.
     *  @param tpermissionPrimaryKey Tpermission����.
     */
    void removeTpermission(java.lang.String tpermissionPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡTpermission�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTpermissionListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡTpermission�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getTpermissionListOfNoAuthorityQuery(Map queryMap);
}
