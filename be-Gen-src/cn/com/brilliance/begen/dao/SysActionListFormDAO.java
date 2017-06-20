package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysActionListForm;

/**
 * SysActionListFormDAO�ӿ�.
 * @author Administrator.
 */

public interface SysActionListFormDAO {

    /**
     *  �����������SysActionListForm����.
     *  @param sysActionListFormPrimaryKey SysActionListForm����
     *  @return SysActionListForm.
     */
    SysActionListForm getSysActionListForm(java.lang.String sysActionListFormPrimaryKey);

    /**
     *  ��ȡSysActionListForm�����б�.
     *  @param  sysActionListForm SysActionListForm����
     *  @return List.
     */
    List getSysActionListFormList(SysActionListForm sysActionListForm);

    /**
     *  �洢SysActionListForm����.
     *  @param  sysActionListForm SysActionListForm����
     *  @return SysActionListForm.
     */
    SysActionListForm saveSysActionListForm(SysActionListForm sysActionListForm);

    /**
     *  ɾ��SysActionListForm����.
     *  @param sysActionListFormPrimaryKey SysActionListForm����.
     */
    void removeSysActionListForm(java.lang.String sysActionListFormPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysActionListForm�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysActionListFormListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysActionListForm�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysActionListFormListOfNoAuthorityQuery(Map queryMap);
}
