/**
 * 
 */
package cn.com.brilliance.risk.ext.interfaces;

import java.util.List;
import java.util.Map;

/**
 * @author pony
 * 
 */
public interface DataManageController {

	public List queryForList(String sql);

	public Map queryForMap(String sql);

	public void delete(String sql);

	public int update(String sql);
	
	public void execute(String sql);

}
