package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysActionEditForm;

/**
 * SysActionEditFormDAO�ӿ�.
 * @author Administrator.
 */

public interface SysActionEditFormDAO {

    /**
     *  �����������SysActionEditForm����.
     *  @param sysActionEditFormPrimaryKey SysActionEditForm����
     *  @return SysActionEditForm.
     */
    SysActionEditForm getSysActionEditForm(java.lang.String sysActionEditFormPrimaryKey);

    /**
     *  ��ȡSysActionEditForm�����б�.
     *  @param  sysActionEditForm SysActionEditForm����
     *  @return List.
     */
    List getSysActionEditFormList(SysActionEditForm sysActionEditForm);

    /**
     *  �洢SysActionEditForm����.
     *  @param  sysActionEditForm SysActionEditForm����
     *  @return SysActionEditForm.
     */
    SysActionEditForm saveSysActionEditForm(SysActionEditForm sysActionEditForm);

    /**
     *  ɾ��SysActionEditForm����.
     *  @param sysActionEditFormPrimaryKey SysActionEditForm����.
     */
    void removeSysActionEditForm(java.lang.String sysActionEditFormPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysActionEditForm�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysActionEditFormListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysActionEditForm�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysActionEditFormListOfNoAuthorityQuery(Map queryMap);
}
