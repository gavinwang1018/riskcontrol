package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysTemplate;

/**
 * SysTemplateDAO�ӿ�.
 * @author Administrator.
 */

public interface SysTemplateDAO {

    /**
     *  �����������SysTemplate����.
     *  @param sysTemplatePrimaryKey SysTemplate����
     *  @return SysTemplate.
     */
    SysTemplate getSysTemplate(java.lang.String sysTemplatePrimaryKey);

    /**
     *  ��ȡSysTemplate�����б�.
     *  @param  sysTemplate SysTemplate����
     *  @return List.
     */
    List getSysTemplateList(SysTemplate sysTemplate);

    /**
     *  �洢SysTemplate����.
     *  @param  sysTemplate SysTemplate����
     *  @return SysTemplate.
     */
    SysTemplate saveSysTemplate(SysTemplate sysTemplate);

    /**
     *  ɾ��SysTemplate����.
     *  @param sysTemplatePrimaryKey SysTemplate����.
     */
    void removeSysTemplate(java.lang.String sysTemplatePrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysTemplate�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysTemplateListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysTemplate�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysTemplateListOfNoAuthorityQuery(Map queryMap);
}
