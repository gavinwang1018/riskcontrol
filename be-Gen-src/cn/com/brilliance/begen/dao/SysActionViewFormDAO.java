package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysActionViewForm;

/**
 * SysActionViewFormDAO�ӿ�.
 * @author Administrator.
 */

public interface SysActionViewFormDAO {

    /**
     *  �����������SysActionViewForm����.
     *  @param sysActionViewFormPrimaryKey SysActionViewForm����
     *  @return SysActionViewForm.
     */
    SysActionViewForm getSysActionViewForm(java.lang.String sysActionViewFormPrimaryKey);

    /**
     *  ��ȡSysActionViewForm�����б�.
     *  @param  sysActionViewForm SysActionViewForm����
     *  @return List.
     */
    List getSysActionViewFormList(SysActionViewForm sysActionViewForm);

    /**
     *  �洢SysActionViewForm����.
     *  @param  sysActionViewForm SysActionViewForm����
     *  @return SysActionViewForm.
     */
    SysActionViewForm saveSysActionViewForm(SysActionViewForm sysActionViewForm);

    /**
     *  ɾ��SysActionViewForm����.
     *  @param sysActionViewFormPrimaryKey SysActionViewForm����.
     */
    void removeSysActionViewForm(java.lang.String sysActionViewFormPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysActionViewForm�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysActionViewFormListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysActionViewForm�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysActionViewFormListOfNoAuthorityQuery(Map queryMap);
}
