package cn.com.brilliance.begen.service;

import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.model.*;

public interface TorganizeUserService {

	public List<TorganizeUser> init(TorganizeUser torganizeUser,Map queryFields);
	
	public void delete(String id);
	
	public  List<TorganizeUser> getTorganizeUserListOfQuery(Map queryFields);
	
	public TorganizeUser saveTorganizeUser(TorganizeUser torganizeUser);
	
	public  TorganizeUser getTorganizeUser(String id);

    public TorganizeUser saveAll(TorganizeUser torganizeUser );
	
	public void deleteAll(List<TorganizeUser> torganizeUsers);
}
