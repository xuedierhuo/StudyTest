import java.util.List;

/**
 * //将结果转换成json数据，并响应
 * 		//需要将查询结果封装成datagrid需要的格式
 * 		DatagridBean<Category> dataGridBean = new DatagridBean<>();
 * 		dataGridBean.setRows(list);
 * 		dataGridBean.setTotal(list.size());
 *
 * 		String jsonStr = MyJsonUtils.getJsonString(dataGridBean);
 *
 * @param <T>
 */
public class DatagridBean<T> {
	
	private Integer total;
	private List<T> rows;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
}
