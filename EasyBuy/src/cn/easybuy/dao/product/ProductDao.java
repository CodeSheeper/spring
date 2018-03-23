package cn.easybuy.dao.product;

import java.util.List;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Product;
import cn.easybuy.param.NewsParams;
import cn.easybuy.param.ProductParam;

/**
 * 商品查询Dao
 *
 * deleteById(Integer id)
 * getById(Integer id)
 * getRowCount(params)
 * getRowList(params)
 *
 */
public interface ProductDao extends IBaseDao {

	void updateStock(Integer id, Integer quantity) throws Exception;
	
	public void save(Product product) throws Exception;

	public void update(Product product) throws Exception;
	
	public void deleteById(Integer id) throws Exception;
	
	public Product getProductById(Integer id)throws Exception; 
	
	public List<Product> queryProductList(ProductParam params)throws Exception; 
	
	public Integer queryProductCount(ProductParam params)throws Exception; 
}
