/**
 * 
 */
package cn.com.brilliance.begen.common.webapp.action;

import java.io.Serializable;

import javax.faces.model.DataModel;

/**
 * @author IBM
 * 
 */
public abstract class BasePagedBackingBean {

	protected static final int COMMON_PAGE_SIZE = 50;

	protected DataModel dataModel;

	/**
	 * @return the dataModel
	 */
	public DataModel getDataModel() {
		return dataModel;
	}

	/**
	 * @param dataModel
	 *            the dataModel to set
	 */
	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	/**
	 * 
	 * @param startRow
	 *            开始行数
	 * @param pageSize
	 *            每页多少行
	 * @return
	 */
	protected abstract DataPage getDataPage(int startRow, int pageSize);

	protected DataModel getDataModel(int pageSize) {
		if (dataModel == null) {
			dataModel = new LocalDataModel(pageSize);
		}
		return dataModel;
	}

	protected class LocalDataModel extends PagedListDataModel implements
			Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -7576981369710658406L;

		public LocalDataModel(int pageSize) {
			super(pageSize);
		}

		public DataPage fetchPage(int startRow, int pageSize) {
			// call enclosing managed bean method to fetch the data
			return getDataPage(startRow, pageSize);
		}
	}
}
