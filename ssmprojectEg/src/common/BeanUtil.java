package common;

import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zj.entities.User;
/*
 * 结果集转换为封装好的PageResult类
 * 借助PageHelper的page类实现
 * 本质上在controller中已经可以通过pageInfo转化为封装类
 * 只是把工作量转移过来
 */
public class BeanUtil {
	private BeanUtil() {
		// 工具类构造函数私有化
	}
	@SuppressWarnings("unchecked")
	public static <T> PagedResult<T> toPagedResult(List<T> datas,PageInfo<User> userList) {
        PagedResult<T> result = new PagedResult<T>();
        if (datas instanceof Page) {
            @SuppressWarnings("rawtypes")
			Page page = (Page) datas;
            result.setPageNo(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setDataList(page.getResult());
            result.setTotal(page.getTotal());
            result.setPages(page.getPages());
            //进一步完善封装类
            result.setFirstPage(userList.getFirstPage());
            result.setLastPage(userList.getLastPage());
            result.setNextPage(page.getPageNum()+1);
            result.setPrePage(page.getPageNum()-1);
            result.setNavigatepageNums(userList.getNavigatepageNums());
        }
        else {
            result.setPageNo(1);
            result.setPageSize(datas.size());
            result.setDataList(datas);
            result.setTotal(datas.size());
        }

        return result;
    }

	
}
