package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TpermissionService {

	public List<Tpermission> init(Tpermission tpermission,Map queryFields);
	
	public void delete(String id);
	
	public  List<Tpermission> getTpermissionListOfQuery(Map queryFields);
	
	public Tpermission saveTpermission(Tpermission tpermission);
	
	public  Tpermission getTpermission(String id);

    public Tpermission saveAll(Tpermission tpermission );
	
	public void deleteAll(List<Tpermission> tpermissions);
}
