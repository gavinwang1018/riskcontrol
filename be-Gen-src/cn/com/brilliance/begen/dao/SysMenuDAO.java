package cn.com.brilliance.begen.dao;

import java.util.List;
import java.util.Map;
import cn.com.brilliance.begen.model.SysMenu;

/**
 * SysMenuDAO�ӿ�.
 * @author Administrator.
 */

public interface SysMenuDAO {

    /**
     *  �����������SysMenu����.
     *  @param sysMenuPrimaryKey SysMenu����
     *  @return SysMenu.
     */
    SysMenu getSysMenu(java.lang.String sysMenuPrimaryKey);

    /**
     *  ��ȡSysMenu�����б�.
     *  @param  sysMenu SysMenu����
     *  @return List.
     */
    List getSysMenuList(SysMenu sysMenu);

    /**
     *  �洢SysMenu����.
     *  @param  sysMenu SysMenu����
     *  @return SysMenu.
     */
    SysMenu saveSysMenu(SysMenu sysMenu);

    /**
     *  ɾ��SysMenu����.
     *  @param sysMenuPrimaryKey SysMenu����.
     */
    void removeSysMenu(java.lang.String sysMenuPrimaryKey);

    /**
     *  ���ݲ�ѯ������ȡSysMenu�����б�.
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysMenuListOfQuery(Map queryMap);

    /**
     *  ���ݲ�ѯ������ȡSysMenu�����б�(���û�Ȩ������).
     *  @param  queryMap ��ѯ����Map
     *  @return List.
     */
    List getSysMenuListOfNoAuthorityQuery(Map queryMap);
}
