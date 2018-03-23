package cn.easybuy.service.product;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.dao.product.ProductDaoImpl;
import cn.easybuy.entity.Product;
import cn.easybuy.param.ProductParam;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.Pager;
import cn.easybuy.utils.Params;

/**
 * 商品的业务类
 */
public class ProductServiceImpl implements ProductService {
    /**
     * 查询商品全部的分类
     *
     * @return
     */
    @Override
    public int getProductRowCount(ProductParam params) {
        Connection connection = null;
        int count = 0;
        try {
            connection = DataSourceUtil.openConnection();
            ProductDao productDao = new ProductDaoImpl(connection);
            count = productDao.queryProductCount(params);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	DataSourceUtil.closeConnection(connection);
        }
        return count;
    }

    @Override
    public List<Product> queryProductsList(ProductParam params) {
        Connection connection = null;
        List<Product> rtn = new ArrayList<Product>();
        try {
            connection = DataSourceUtil.openConnection();
            ProductDao productDao = new ProductDaoImpl(connection);
            //设置查询参数
            rtn = productDao.queryProductList(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeConnection(connection);
        }
        return rtn;
    }

    @Override
    public void deleteById(Integer id) {
        Connection connection = null;
        try {
            connection = DataSourceUtil.openConnection();
            ProductDao productDao = new ProductDaoImpl(connection);
            //设置查询参数
            productDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeConnection(connection);
        }
    }

    /**
     * 根据商品分类查询商品列表
     *
     * @param categoryId
     * @param level
     * @param pager
     * @return
     */
    public List<Product> getProductsByCategory(Integer categoryId, int level, Pager pager,String keyWord) {//根据分类查询商品
        Connection connection = null;
        List<Product> rtn = new ArrayList<Product>();
        try {
            connection = DataSourceUtil.openConnection();
            ProductDao productDao = new ProductDaoImpl(connection);
            //设置查询参数
            ProductParam params = new ProductParam();
            params.openPage((pager.getCurrentPage() - 1) * pager.getRowPerPage(), pager.getRowPerPage());
            params.setCategoryId(categoryId==0?null:categoryId);
            if(!EmptyUtils.isEmpty(keyWord)){
            	params.setKeyword(keyWord);
            }
            rtn = productDao.queryProductList(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeConnection(connection);
        }
        return rtn;
    }

    /**
     * 根据分类id查询商品数目
     *
     * @param categoryId
     * @param level
     * @return
     */

    public int getProductRowCount(String categoryId, int level,String keyWord) {//查询商品记录数
        Connection connection = null;
        int rtn = 0;
        try {
            connection = DataSourceUtil.openConnection();
            ProductDao productDao = new ProductDaoImpl(connection);
            ProductParam params = new ProductParam();
            Long id = null;
            if (EmptyUtils.isNotEmpty(categoryId)) {
                id = Long.parseLong(categoryId);
                params.setCategoryId(id==0L?null:id.intValue());
            }
            if(!EmptyUtils.isEmpty(keyWord)){
            	params.setKeyword(keyWord);
            }
            rtn = productDao.queryProductCount(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeConnection(connection);
        }
        return rtn;
    }

    public Integer saveOrUpdate(Product product) {//保存一款商品
        Connection connection = null;
        try {
            connection = DataSourceUtil.openConnection();
            ProductDao productDao = new ProductDaoImpl(connection);
            ProductParam params = new ProductParam();
            if(EmptyUtils.isEmpty(product.getId())){
                productDao.save(product);
            } else {
                productDao.update(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeConnection(connection);
        }
        return null;
    }
    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    public Product findById(String id) {//根据ID查询商品
        Connection connection = null;
        Product product = null;
        try {
            connection = DataSourceUtil.openConnection();
            ProductDao productDao = new ProductDaoImpl(connection);
            product = productDao.getProductById(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeConnection(connection);
        }
        return product;
    }
    /**
     * 根据分类查询数目
     */
	@Override
	public int getProductCountBycategory(Integer categoryId) {
		Connection connection = null;
        int count = 0;
        try {
            connection = DataSourceUtil.openConnection();
            ProductDao productDao = new ProductDaoImpl(connection);
            ProductParam param=new ProductParam();
            param.setCategoryLevel1Id(categoryId);
            count = productDao.queryProductCount(param);
            if(count>0) return count;
            param.setCategoryLevel2Id(categoryId);
            count = productDao.queryProductCount(param);
            if(count>0) return count;
            param.setCategoryLevel3Id(categoryId);
            count = productDao.queryProductCount(param);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeConnection(connection);
        }
		return count;
	}
}
